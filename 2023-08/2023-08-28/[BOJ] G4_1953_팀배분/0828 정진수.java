//package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    static ArrayList<Integer>[] team;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        team = new ArrayList[2];
        visited = new boolean[N+1];

        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<2; i++){
            team[i] = new ArrayList<>();
        }

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());

            int cnt = Integer.parseInt(st.nextToken());

            for(int j=0; j<cnt; j++){
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }   //입력완료

        for(int i=1; i<=N; i++){
            dfs(i, 0);
        }

        Collections.sort(team[0]);
        Collections.sort(team[1]);

        System.out.println(team[0].size());
        for(int i=0; i<team[0].size(); i++){
            System.out.print(team[0].get(i)+" ");
        }
        System.out.println();

        System.out.println(team[1].size());
        for(int i=0; i<team[1].size(); i++){
            System.out.print(team[1].get(i)+" ");
        }
    }

    private static void dfs(int start, int cnt) {
        if(!visited[start]){
            visited[start] = true;
            team[cnt%2].add(start);
            for(Integer hate : list[start]){
                dfs(hate, cnt+1);
            }
        }

    }
}
