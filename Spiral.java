package Puzzles;

import java.util.Arrays;

public class Spiral {

    private enum Direction {
        //     m,  n
        RIGHT( 0,  1),
        DOWN ( 1,  0),
        LEFT ( 0, -1),
        UP   (-1,  0),
        ;
        final int m;
        final int n;

        Direction(int m, int n) {
            this.m = m;
            this.n = n;
        }
        Direction rotate() {
            int o = this.ordinal() + 1;
            if (o >= Direction.values().length) o = 0;
            return Direction.values()[o];
        }
        @Override
        public String toString() {
            return super.toString() + " [m=" + m + ", n=" + n + "]";
        }
    }

    private static class Coordinate {
        int m;
        int n;

        private void move(Direction direction) {
            m += direction.m;
            n += direction.n;
        }
        @Override
        public String toString() {
            return "[m=" + m + ", n=" + n + "]";
        }
    }

    private static class Bounds {
        int right;
        int down;
        int left;
        int up;

        Bounds(int right, int down) {
            this.right = right;
            this.down = down;
        }
        int width() {
            return right + 1 - left;
        }
        int height() {
            return down + 1 - up;
        }
        private void reduce(Direction direction) {
            switch (direction) {
                case RIGHT: left += 1; break;
                case DOWN: up += 1; break;
                case LEFT: right -= 1; break;
                case UP: down -= 1; break;
            }
        }
        @Override
        public String toString() {
            return "[right=" + right + ", down=" + down + ", left=" + left + ", up=" + up + "]";
        }
    }

    public static void main(String[] args) {
        final int[][] a = {
                {5, 2, 7, 1, 4},
                {3, 9, 4, 6, 0},
                {5, 1, 1, 8, 7},
                {3, 2, 6, 9, 0},
        };

        go(a);
    }

    private static void go(int[][] a) {
        Coordinate position = new Coordinate();
        Bounds bounds = new Bounds(a[0].length - 1, a.length - 1);
        Direction direction = Direction.RIGHT;

        int[] b = new int[bounds.width() * bounds.height()];

        int i = 0;
        do {
            b[i++] = a[position.m][position.n];

            if (Direction.RIGHT.equals(direction) && position.n == bounds.right ||
                    Direction.DOWN.equals(direction) && position.m == bounds.down ||
                    Direction.LEFT.equals(direction) && position.n == bounds.left ||
                    Direction.UP.equals(direction) && position.m == bounds.up) {
                direction = direction.rotate();
                bounds.reduce(direction);
            }

            position.move(direction);
        } while (bounds.width() != 0 && bounds.height() != 0);

        System.out.println(Arrays.toString(b));
    }

}
