import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MarupekeTest {

    Marupeke test;
    int y  = 2;
    int x = 4;

    @Before
    public void setUp() {
        test = new Marupeke(5);
    }

    @Test
    public void setSolidTest() {
        test.setSolid(y, x);
        char[][] grid = test.getGrid();
        Assert.assertEquals(grid[y][x], '#');
    }

    @Test
    public void setSolidTest2() {
        test.setSolid(y, x);
        Assert.assertEquals(false, test.getEditable()[y][x]);
    }

    @Test
    public void setX() {
        test.setX(y, x, false);
        char[][] grid = test.getGrid();
        Assert.assertEquals(grid[y][x], 'X');
    }

    @Test
    public void setO() {
        test.setO(y, x, false);
        char[][] grid = test.getGrid();
        Assert.assertEquals(grid[y][x], 'O');
    }

    @Test
    public void setX2() {
        test.setX(y, x, false);
        Assert.assertEquals(false, test.getEditable()[y][x]);
    }

    @Test
    public void setO2() {
        test.setO(y, x, true);
        Assert.assertEquals(true, test.getEditable()[y][x]);
    }

}