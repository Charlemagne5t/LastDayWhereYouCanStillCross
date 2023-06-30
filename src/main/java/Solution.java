public class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int first = 0;
        int last = cells.length - 1;
        int mid;

        while (first <= last) {
            mid = first + (last - first) / 2;
            int[][] grid = new int[row][col];

            for (int k = 0; k <= mid; k++) {
                int i = cells[k][0] - 1;
                int j = cells[k][1] - 1;
                grid[i][j] = 1;
            }

            if (hasPathFromAnyColumn(grid, new boolean[row][col])) {
                if (mid + 1 >= cells.length || !hasPathFromAnyColumn(getGrid(cells, mid + 1, row, col), new boolean[row][col])) {
                    return mid + 1;
                }
                first = mid + 1;
            } else {
                if (mid - 1 >= 0 && hasPathFromAnyColumn(getGrid(cells, mid - 1, row, col), new boolean[row][col])) {
                    return mid;
                }
                last = mid - 1;
            }
        }

        return -1;
    }

    private int[][] getGrid(int[][] cells, int index, int row, int col) {
        int[][] grid = new int[row][col];
        for (int k = 0; k <= index; k++) {
            int i = cells[k][0] - 1;
            int j = cells[k][1] - 1;
            grid[i][j] = 1;
        }
        return grid;
    }

    public boolean hasPathFromAnyColumn(int[][] grid, boolean[][] visited) {
        for (int j = 0; j < grid[0].length; j++) {
            if (hasPathBFS(grid, 0, j, visited)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasPathBFS(int[][] grid, int i, int j, boolean[][] visited) {
        if (i == grid.length - 1) {
            return true;
        }
        boolean result = false;
        boolean nResult = false;
        boolean eResult = false;
        boolean sResult = false;
        boolean wResult = false;
        if (grid[i][j] == 1) return false;
        visited[i][j] = true;
        // NORH
        if (i > 0 && !visited[i - 1][j] && grid[i - 1][j] != 1) {
            nResult = hasPathBFS(grid, i - 1, j, visited);
        }
        //EAST
        if (j < grid[i].length - 1 && !visited[i][j + 1] && grid[i][j + 1] != 1) {
            eResult = hasPathBFS(grid, i, j + 1, visited);
        }
        //SOUTH
        if (i < grid.length - 1 && !visited[i + 1][j] && grid[i + 1][j] != 1) {
            sResult = hasPathBFS(grid, i + 1, j, visited);
        }
        //WEST
        if (j > 0 && !visited[i][j - 1] && grid[i][j - 1] != 1) {
            wResult = hasPathBFS(grid, i, j - 1, visited);
        }

        result = nResult || eResult || sResult || wResult;

        return result;
    }
}
