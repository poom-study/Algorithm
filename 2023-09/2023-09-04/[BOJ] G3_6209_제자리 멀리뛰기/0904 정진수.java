//package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int d, n, m, answer;
    static int[] stoneIsland;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        d = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        stoneIsland = new int[n+2];

        stoneIsland[0] = 0;
        stoneIsland[n+1] = d;
        answer = 0;

        for(int i=1; i<=n; i++){
            int num = Integer.parseInt(br.readLine());
            stoneIsland[i] = num;
        }   //입력완료

        Arrays.sort(stoneIsland);

        int start = 0, end = d;

        while (start <= end){

            int mid = (start+end) / 2;
            int sum = 0;
            int idx = 0;

            for(int i=1; i<stoneIsland.length; i++){
                if(stoneIsland[i]-stoneIsland[idx] < mid) sum++;
                else idx = i;
            }

            if(sum > m) end = mid-1;
            else {
                answer = mid;
                start = mid+1;
            }
        }

        System.out.println(answer);
    }
}
