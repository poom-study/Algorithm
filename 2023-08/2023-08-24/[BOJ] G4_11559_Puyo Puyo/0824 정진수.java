//package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Main {
    static class Puyo{
        int x, y;
        char color;
        Puyo(int x, int y, char color){
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }
    static char[][] map;

    static boolean flag;
    static int result;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[12][6];
        result = 0;
        for(int i=0; i<12; i++){
            String s = br.readLine();
            for(int j=0; j<6; j++){
                map[i][j] = s.charAt(j);
            }
        }   //입력완료

        while (true){
            flag = false;

            bfs();  //Puyo 4개 탐색
            floor(); //뿌신거 아래로 이동

            if(!flag) break;

            result++;
        }

        System.out.println(result);
    }

    private static void bfs() {
        Queue<Puyo> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[12][6];

        for(int i=0; i<12; i++){
            for(int j=0; j<6; j++){
                if(map[i][j] != '.' && !visited[i][j]){
                    ArrayList<int[]> list = new ArrayList<>();
                    q.add(new Puyo(i, j, map[i][j]));
                    list.add(new int[]{i, j});
                    visited[i][j] = true;

                    while (!q.isEmpty()){
                        Puyo cur = q.poll();
                        int x = cur.x;
                        int y = cur.y;
                        char c = cur.color;

                        for(int k=0; k<4; k++){
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if(nx < 0 || ny < 0 || nx >= 12 || ny >= 6) continue;

                            if(!visited[nx][ny] && map[nx][ny] == c){
                                q.add(new Puyo(nx, ny, c));
                                list.add(new int[]{nx, ny});
                                visited[nx][ny] = true;
                            }
                        }
                    }

                    //상하좌우 4개 이상인지 판별
                    if(list.size() >= 4){

                        for(int k=0; k<list.size(); k++){
                            int x = list.get(k)[0];
                            int y = list.get(k)[1];

                            map[x][y] = '.';

                            flag = true;
                        }
                    }
                }
            }
        }
    }


    private static void floor() {
        for(int j=0; j<6; j++){ //열별로 탐색
            down(j);
        }
    }

    private static void down(int j) {
        Queue<Puyo> q = new ArrayDeque<>();
        int tmp = 11;

        for(int k=11; k>=0; k--){   //가장 아래 행부터 지워지므로 아래행부터 탐색

            if(map[k][j] != '.'){
                q.add(new Puyo(k, j, map[k][j]));
                map[k][j] = '.';
            }
        }

        while (!q.isEmpty()){
            Puyo cur = q.poll();

            char c = cur.color;

            map[tmp][j] = c;

            tmp--;

        }
    }


}
