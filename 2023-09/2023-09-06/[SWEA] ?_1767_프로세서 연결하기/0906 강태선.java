import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int lexi_count;
	static int N;
	static int min_line;
	static int max_connect;
	static ArrayList<Point> location;
	static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			lexi_count = 0;
			min_line = Integer.MAX_VALUE;
			max_connect = Integer.MIN_VALUE;
			location = new ArrayList<>();
			
			int[][] board = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 1; i < N-1; i++) {
				for (int j = 1; j < N-1; j++) {
					if (board[i][j] == 1) {
						lexi_count++;
						location.add(new Point(i, j));
					}
				}
			}
			
			subSet(0, 0, 0, board);
			sb.append("#" + tc + " " + min_line + "\n");
			//System.out.println(Arrays.deepToString(board));
		}
		System.out.println(sb.toString());
	}
	
	public static void subSet(int depth, int connect_count, int line, int[][] board) {
		if (max_connect > connect_count + (lexi_count - depth)) {
			return;
		}
		if (depth == lexi_count) {
			if (connect_count >= max_connect) {
				if (max_connect == connect_count) {
					if (min_line > line) {
						min_line = line;
					}
				} else {
					min_line = line;
				}
				max_connect = connect_count;
			}
			return;
		}
		int[][] copy_board = new int[N][N];
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < N; k++) {
				copy_board[j][k] = board[j][k];
			}
		}
		check(location.get(depth), copy_board, depth, connect_count, line);
	}
	
	public static void check(Point location, int[][] board, int depth, int connect_count, int line) {
		for (int i = 0; i < 4; i++) {
			boolean check = true;
			int[][] copy_board = new int[N][N];
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					copy_board[j][k] = board[j][k];
				}
			}
			int nx = location.x;
			int ny = location.y;
			int len_line = 0;
			while (true) {
				nx += delta[i][0];
				ny += delta[i][1];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if (copy_board[nx][ny] != 0) {
						check = false;
						break;
					}
					copy_board[nx][ny] = 2;
					len_line++;
				} else {
					break;
				}
			}
			if (check) {
				subSet(depth+1, connect_count + 1, line + len_line, copy_board);
			} else {
				subSet(depth+1, connect_count, line, board);
			}
		}
		
	}

}
