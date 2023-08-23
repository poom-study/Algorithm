//package ShortestRoute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Wall implements Comparable<Wall>{
        int x, y, dist;
        Wall(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Wall w) {
            return this.dist-w.dist;
        }
    }
    static int N, M, startX, startY, endX, endY;
    static char[][] map;
    static int[][] distance;
    static int[][] wallCheck;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());//행
        M = Integer.parseInt(st.nextToken());//열

        map = new char[N][M];
        distance = new int[N][M];
        wallCheck = new int[N][M];

        for(int i=0; i<N; i++){
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = s.charAt(j);

                if(map[i][j] == '#') check(i, j);
                if(map[i][j] == 'S') {
                    startX = i;
                    startY = j;
                }
                if(map[i][j] == 'E'){
                    endX = i;
                    endY = j;
                }
            }
        }   //입력완료


        bfs(startX, startY);
        System.out.println(distance[endX][endY]);
    }

    private static void check(int r, int c) {

        wallCheck[r][c] = -1;

        for(int k=0; k<4; k++){
            int nx = r + dx[k];
            int ny = c + dy[k];

            if(nx >=0 && ny >= 0 && nx < N && ny < M && map[nx][ny] != '#'){
                wallCheck[nx][ny] = 1;
            }
        }

    }

    private static void bfs(int startX, int startY) {
        PriorityQueue<Wall> q = new PriorityQueue<>();

        q.add(new Wall(startX, startY, 0));

        while (!q.isEmpty()){
            Wall cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int d = cur.dist;

            if(distance[x][y] < d) continue;

            if(x == endX && y == endY) {
                return;
            }

            for(int k=0; k<4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if(wallCheck[nx][ny] != -1){
                    if(wallCheck[x][y] == 1 && wallCheck[nx][ny] == 1){
                        if(distance[nx][ny] > d){
                            distance[nx][ny] = d;
                            q.add(new Wall(nx, ny, d));
                        }
                    }
                    else {
                        if(distance[nx][ny] > d+1){
                            distance[nx][ny] = d+1;
                            q.add(new Wall(nx, ny, d+1));
                        }
                    }
                }

            }
        }
    }
}
