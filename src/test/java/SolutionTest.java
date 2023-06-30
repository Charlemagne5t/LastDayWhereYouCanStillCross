import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void latestDayToCrossTest1() {
        int row = 2;
        int col = 2;
        int[][] cells = {
                {1, 1},
                {2, 1},
                {1, 2},
                {2, 2}
        };
        int expected = 2;
        int actual = new Solution().latestDayToCross(row, col, cells);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void latestDayToCrossTest2() {
        int row = 2;
        int col = 2;
        int[][] cells = {
                {1, 1},
                {1, 2},
                {2, 1},
                {2, 2}
        };
        int expected = 1;
        int actual = new Solution().latestDayToCross(row, col, cells);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void latestDayToCrossTest3() {
        int row = 3;
        int col = 3;
        int[][] cells = {
                {1, 1},
                {2, 1},
                {3, 3},
                {2, 2},
                {1, 1},
                {1, 3},
                {2, 3},
                {3, 2},
                {3, 1}

        };
        int expected = 3;
        int actual = new Solution().latestDayToCross(row, col, cells);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void hasPathFromAnyColumnTestFalse() {
        int[][] grid = {
                {1, 1},
                {0, 0}
        };
        boolean[][] visited = new boolean[2][2];
        Assert.assertFalse(new Solution().hasPathFromAnyColumn(grid, visited));
    }

    @Test
    public void hasPathFromAnyColumnTestTrue(){
        int[][] grid = {
                {1, 0, 1},
                {1, 0, 1},
                {1, 0, 1}
        };
        boolean[][] visited = new boolean[3][3];
        Assert.assertTrue(new Solution().hasPathFromAnyColumn(grid, visited));
    }
}
