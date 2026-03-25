package week7.L07_Recursion;
import java.util.*;

public class MatrixPathFinding {

        static int ROW = 7;
        static int COL = 5;

        static int[][] grid = new int[ROW][COL];
        static boolean[][] visited = new boolean[ROW][COL];

        static int[] dx = {-1, 1, 0, 0};
        static int[] dy = {0, 0, -1, 1};

        static int totalPaths = 0;

        public static void main(String[] args) {

                int[][] blocks = {
                        {3,0}, {3,1}, {3,2},
                        {5,1},
                        {1,3}, {2,3}, {3,3}, {4,3}, {5,3}
                };

                for (int[] b : blocks) {
                        grid[b[0]][b[1]] = 1;
                }

                List<String> path = new ArrayList<>();
                dfs(0, 0, 6, 4, path);

                System.out.println("Tổng số đường đi: " + totalPaths);
        }

        public static void dfs(int x, int y, int endX, int endY, List<String> path) {

                if (x < 0 || x >= ROW || y < 0 || y >= COL ||
                        grid[x][y] == 1 || visited[x][y]) {
                        return;
                }

                path.add("(" + x + "," + y + ")");
                visited[x][y] = true;

                if (x == endX && y == endY) {
                        totalPaths++;
                        System.out.println("Đường đi " + totalPaths + ": " + path);
                } else {
                        for (int i = 0; i < 4; i++) {
                                dfs(x + dx[i], y + dy[i], endX, endY, path);
                        }
                }

                visited[x][y] = false;
                path.remove(path.size() - 1);
        }
}