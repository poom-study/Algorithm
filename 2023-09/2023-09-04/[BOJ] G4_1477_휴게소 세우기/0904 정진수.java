//package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, L;
    static int[] rest;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        rest = new int[N+2];
        st = new StringTokenizer(br.readLine());

        rest[0] = 0;
        rest[N+1] = L;
        for(int i=1; i<=N; i++){
            rest[i] = Integer.parseInt(st.nextToken());
        }

        int start = 1, end = L+1;
        //오름차순 정렬
        Arrays.sort(rest);

        while (start <= end){
            int mid = (start + end) / 2;
            int sum = 0;

            for(int i=1; i<rest.length; i++){
                sum += (rest[i] - rest[i-1] - 1) / mid;
            }

            if(sum > M) start = mid + 1;
            else end = mid - 1;

        }

        System.out.println(start);


    }
}
