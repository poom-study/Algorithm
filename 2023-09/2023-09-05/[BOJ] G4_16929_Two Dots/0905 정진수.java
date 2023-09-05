//package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int startX, startY;
    static char[][] map;
    static boolean[][] visited;
    static boolean flag;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //행
        M = Integer.parseInt(st.nextToken()); //열

        //초기화
        map = new char[N][M];

        flag = false;

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = s.charAt(j);
            }
        } //입력완료

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                visited = new boolean[N][M];

                //사이클이면 자기 자신으로 돌아와야하기 때문에 현재 좌표값을 저장
                startX = i;
                startY = j;

                if(dfs(i, j, 1)) {
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");
    }

    private static boolean dfs(int r, int c, int cnt) {
        visited[r][c] = true;

        for(int k=0; k<4; k++){
            int nx = r + dx[k];
            int ny = c + dy[k];
            if(nx >= 0 && ny >= 0 && nx < N && ny < M && map[r][c] == map[nx][ny]){
                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    if(dfs(nx, ny, cnt+1)) return true;
                } else{
                    if(cnt >= 4 && startX == nx && startY == ny) return true;
                }
            }
        }
        return false;
    }
}
