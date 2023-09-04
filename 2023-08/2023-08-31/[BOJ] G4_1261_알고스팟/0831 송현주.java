import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Room {
        int x, y;
        int wallCount;

        public Room(int x, int y, int wallCount) {
            this.x = x;
            this.y = y;
            this.wallCount = wallCount;
        }
    }

    static int N, M, answer;
    static int[][] map;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answer = Integer.MAX_VALUE;
        visited = new boolean[M][N];
        map = new int[M][N];

        for (int i = 0; i < M; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = line[j] - '0';
            }
        }


        bfs(new Room(0, 0, 0));
        System.out.println(answer);
    }

    private static void bfs(Room start) {

        Deque<Room> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {

            Room current = queue.poll();

            if (current.x == M - 1 && current.y == N - 1) {
                answer = Math.min(answer, current.wallCount);
                if(answer == 0) break;
            }

            for (int i = 0; i < 4; i++) {

                int nx = current.x + dirs[i][0];
                int ny = current.y + dirs[i][1];

                if (!isIn(nx, ny) || visited[nx][ny]) continue;


                // 벽이 없는 경우를 먼저 고려해주기 위해 addFirst
                if (map[nx][ny] == 0) {
                    queue.addFirst(new Room(nx, ny, current.wallCount));
                } else {
                    queue.addLast(new Room(nx, ny, current.wallCount + 1));
                }
                visited[nx][ny] = true;
            }

        }
    }

    private static boolean isIn(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < M && ny < N;
    }
}
