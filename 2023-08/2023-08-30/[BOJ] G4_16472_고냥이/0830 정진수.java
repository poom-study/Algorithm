//package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, result;
    static String s;
    static int[] alpha = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        s = br.readLine();

        alpha[s.charAt(0)-'a']++;

        int start = 0, end = 0 , cnt = 1;
        result = 0;

        while (end < s.length()-1){
            end++;
            int tmp = s.charAt(end) - 'a';

            alpha[tmp]++;

            if(alpha[tmp] == 1) cnt++;

            while (cnt > N){
                int temp = s.charAt(start) - 'a';
                alpha[temp]--;

                if(alpha[temp] == 0) cnt--;

                start++;
            }

            result = Math.max(result, end-start+1);
        }
        System.out.println(result);
    }
}
