//package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] list;
    static int result;
    static int max = Integer.MIN_VALUE;
    static ArrayList<Integer> posNum; //양수 배열
    static ArrayList<Integer> negNum; //음수 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new int[N];
        result = 0;
        posNum = new ArrayList<>();
        negNum = new ArrayList<>();


        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());

            if(max < Math.abs(num)){
                max = Math.abs(num);
            }
            if(num < 0) negNum.add(Math.abs(num));
            else posNum.add(num);
        }

        Collections.sort(negNum, Collections.reverseOrder());   //음수는 내림차순
        Collections.sort(posNum, Collections.reverseOrder());   //양수는 내림차순

        for(int i=0; i<posNum.size(); i++){
            if(max == posNum.get(i) && i%M == 0) result += max;

            else if(i%M == 0) result += (posNum.get(i)*2);
        }

        for(int i=0; i<negNum.size(); i++){
            if(max == negNum.get(i) && i%M == 0) result += max;
            else if(i%M == 0) result += (negNum.get(i)*2);
        }

        System.out.println(result);
    }
}
