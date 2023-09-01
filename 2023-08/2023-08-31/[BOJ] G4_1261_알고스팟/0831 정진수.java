//package ShortestRoute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Algo{
        int x, y, cnt;
        Algo(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static int N, M, result;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); //가로
        N = Integer.parseInt(st.nextToken()); //세로

        //초기화
        map = new int[N][M];
        visited = new boolean[N][M];
        result = 0;

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(s.substring(j, j+1));
            }
        }

        PriorityQueue<Algo> pq = new PriorityQueue<>(new Comparator<Algo>() {
            @Override
            public int compare(Algo o1, Algo o2) {
                return o1.cnt - o2.cnt;
            }
        });

        pq.add(new Algo(0, 0, 0));
        visited[0][0] = true;

        while (!pq.isEmpty()){
            Algo cur = pq.poll();

            int cx = cur.x;
            int cy = cur.y;
            int cnt = cur.cnt;

            //목적지 도달 시 로직 종료
            if(cx == N-1 && cy == M-1) {
                result = cnt;
                break;
            }

            for(int k=0; k<4; k++){
                int nx = cx + dx[k];
                int ny = cy + dy[k];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if(!visited[nx][ny]){
                    if(map[nx][ny] == 1){
                        visited[nx][ny] = true;
                        pq.add(new Algo(nx, ny, cnt+1));
                    }
                    else{
                        visited[nx][ny] = true;
                        pq.add(new Algo(nx, ny, cnt));
                    }
                }
            }
        }

        //정답 출력
        System.out.println(result);
    }
}
