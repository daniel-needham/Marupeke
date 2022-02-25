import java.util.Arrays;
import java.util.Random;

public class Marupeke {

    char[][] grid;
    boolean[][] editable;

    public Marupeke(int size) {
        if (size > 10) {
            size = 10;
        }
        if (3 > size) {
            size = 3;
        }

        grid = new char[size][size];
        editable = new boolean[size][size];
        for (boolean[] row : editable) {
            Arrays.fill(row, true);
        }

    }

    public static Marupeke randomPuzzle(int size, int numFill, int numX, int numO) {
        if ((numFill + numX + numO) > Math.pow(size, 2)) {
            return null;
        }
        Marupeke newGrid = new Marupeke(size);

        int iter = 0;
        while (iter < numFill) {
            Random rand = new Random();
            int y, x;
            x = rand.nextInt(size);
            y = rand.nextInt(size);
            if (newGrid.setSolid(y,x)) {
                iter++;
            }
        }
        iter = 0;

        while (iter < numX) {
            Random rand = new Random();
            int y, x;
            x = rand.nextInt(size);
            y = rand.nextInt(size);
            if (newGrid.setX(y,x, false)) {
                iter++;
            }
        }
        iter = 0;

        while (iter < numO) {
            Random rand = new Random();
            int y, x;
            x = rand.nextInt(size);
            y = rand.nextInt(size);
            if (newGrid.setO(y,x, false)) {
                iter++;
            }
        }

        return newGrid;
    }

    public String toString() {
        String grid = "";
        for (char[] row : getGrid()) {
            grid = grid + Arrays.toString(row);
            grid = grid + "\n";
        }
        return grid;
    }

    public boolean setSolid(int y, int x) {
        if (editable[y][x] == true) {
            grid[y][x] = '#';
            editable[y][x] = false;
            return true;
        } else {
            return false;
        }
    }

    public char[][] getGrid() {
        return grid;
    }

    public boolean[][] getEditable() {
        return editable;
    }

    public boolean setX(int y, int x, boolean canEdit) {
        if (editable[y][x] == true) {
            grid[y][x] = 'X';
            editable[y][x] = canEdit;
            return true;
        } else {
            return false;
        }
    }

    public boolean setO(int y, int x, boolean canEdit) {
        if (editable[y][x] == true) {
            grid[y][x] = 'O';
            editable[y][x] = canEdit;
            return true;
        } else {
            return false;
        }
    }
}


