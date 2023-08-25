//package BackTracking;

import java.util.Scanner;

public class Main {
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        backTracking("");
    }

    private static void backTracking(String s) {

        if(s.length() == N){
            System.out.println(s);
            System.exit(0);
        }
        else {
            for(int i=1; i<=3; i++){
                if(check(s + i)){
                    backTracking(s + i);
                }
            }
        }


    }

    private static boolean check(String s) {
        int len = s.length() / 2;

        for(int i=1; i<=len; i++){
            if(s.substring(s.length() - i).equals(s.substring(s.length()-2*i, s.length()-i))) return false;
        }

        return true;
    }
}
