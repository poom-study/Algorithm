//package ShortestRoute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int V, E;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         V = Integer.parseInt(st.nextToken());
         E = Integer.parseInt(st.nextToken());

        dist = new int[V+1][V+1];

        for(int i=0; i<=V; i++){
            Arrays.fill(dist[i], 1000000000);
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dist[x][y] = c;
        }   //입력완료

        for(int k=1; k<=V; k++){
            for(int i=1; i<=V; i++){
                for(int j=1; j<=V; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int result = 1000000000;

        for(int i=1; i<=V; i++){
            for(int j=1; j<=V; j++){
                if(i != j && dist[i][j] != Integer.MAX_VALUE && dist[j][i] != Integer.MAX_VALUE){
                    result = Math.min(dist[i][j] + dist[j][i], result);
                }
            }
        }

        if(result != 1000000000) System.out.println(result);
        else System.out.println(-1);
    }
}
