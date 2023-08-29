//package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Lecture{
        int cost, day;
        Lecture(int cost, int day){
            this.cost = cost;
            this.day = day;
        }
    }
    static int N;
    static int result;
    static int[] d = new int[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        PriorityQueue<Lecture> pq = new PriorityQueue<>(new Comparator<Lecture>() {
            @Override
            public int compare(Lecture o1, Lecture o2) {
                return o2.cost - o1.cost;
            }
        });

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());   //강연료
            int d = Integer.parseInt(st.nextToken());   //일

            pq.add(new Lecture(p, d));
        }   //입력 완료

        while (!pq.isEmpty()){
            Lecture cur = pq.poll();

            int c = cur.cost;
            int da = cur.day;

            for(int i=da; i >= 1; i--){
                if(d[i] < c){
                    d[i] = c;
                    break;
                }
            }
        }

        for(int i=1; i<10001; i++){
            result += d[i];
        }

        System.out.println(result);
    }
}
