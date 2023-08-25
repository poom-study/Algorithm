//package DFSBFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    static class Word{
        String str;
        int cnt;
        Word(String str, int cnt){
            this.str = str;
            this.cnt = cnt;
        }
    }
    static boolean[] visited;

    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        visited = new boolean[words.length];

        answer = bfs(begin, target, words);
        return answer;
    }

    private static int bfs(String begin, String target, String[] words) {
        Queue<Word> q = new ArrayDeque<>();

        q.add(new Word(begin, 0));

        while (!q.isEmpty()){
            Word cur = q.poll();

            if(cur.str.equals(target)){
                return cur.cnt;
            }

            for(int i=0; i< words.length; i++){
                if(visited[i]) continue;
                int tmp = 0;

                for(int j = 0; j<words[i].length(); j++){
                    if(cur.str.charAt(j) != words[i].charAt(j)) tmp++;
                }

                //다른 글자 하나 발견했을 때
                if(tmp == 1){
                    visited[i] = true;
                    q.add(new Word(words[i], cur.cnt+1));
                }
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        String start = "hit";
        String tar = "cog";
        String[] word = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(solution(start, tar, word));
    }
}
