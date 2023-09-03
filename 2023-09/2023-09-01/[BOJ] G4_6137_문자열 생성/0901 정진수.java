//package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[] list;
    static String tmp;
    static StringBuilder result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         N = Integer.parseInt(br.readLine());

         list = new char[N];
         tmp = "";
         result = new StringBuilder();

         for(int i=0; i<N; i++){
            String s = br.readLine();
            list[i] = s.charAt(0);
         }

         int start = 0, end = N-1;

         while(start <= end){

             if(list[start] < list[end]){
                 tmp += list[start++];
             }
             else if(list[start] > list[end]){
                 tmp += list[end--];
             }
             else{
                int f = start, b = end;
                boolean flag = false;

                while(list[f] == list[b]){
                    if(f < N-1) f++;
                    if(b > 0) b--;

                    if(list[f] < list[b]) flag = true;
                    else flag = false;
                }

                if(flag) tmp += list[start++];
                else tmp += list[end--];
             }

             if(tmp.length() == 80) {
                 result.append(tmp);
                 result.append("\n");
                 tmp = "";
             }
         }
         result.append(tmp);
         System.out.println(result);
    }
}
