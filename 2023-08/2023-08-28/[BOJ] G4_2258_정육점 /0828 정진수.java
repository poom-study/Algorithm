//package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Meat implements Comparable<Meat>{
        int weight, price;
        Meat(int weight, int price){
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Meat o) {
            if(this.price == o.price) return o.weight-this.weight;  //무게 내림차순
            return this.price-o.price;  // 가격 오름차순
        }
    }

    static int N, M;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        PriorityQueue<Meat> pq = new PriorityQueue<>();
        result = Integer.MAX_VALUE;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());   //무게
            int p = Integer.parseInt(st.nextToken());   //가격

            pq.add(new Meat(w, p));
        }   //입력 완료

        boolean flag = false;
        int totalPrice = 0;
        int totalWeight = 0;

        int beforePrice = -1;
        int tmp = 0;

        while (!pq.isEmpty()){
            Meat cur = pq.poll();

            int weight = cur.weight;
            int price = cur.price;

            if(beforePrice != price){
                beforePrice = price;
                tmp = 0;
            } else{
                tmp += price;
            }

            totalWeight += weight;
            totalPrice = price;

            if(totalWeight >= M){
                flag = true;
                result = Math.min(result, totalPrice + tmp);
            }
        }

        if(flag) System.out.println(result);
        else System.out.println(-1);
    }
}
