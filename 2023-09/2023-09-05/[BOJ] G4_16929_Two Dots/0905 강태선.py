import sys

def dfs(x, y, count, start_x, start_y, color):
    global result

    if result:
        return

    for i in range(4):
        nx = x + delta[i][0]
        ny = y + delta[i][1]

        if count > 3 and start_x == nx and start_y == ny:
            result = True
            return

        if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny] and color == board[nx][ny]:
            visited[nx][ny] = True
            dfs(nx, ny, count+1, start_x, start_y, color)
            visited[nx][ny] = False

if __name__ == "__main__":
    N, M = map(int, sys.stdin.readline().split())
    board = [list(sys.stdin.readline().rstrip()) for _ in range(N)]
    visited = [[False]* M for _ in range(N)]
    result = False
    delta = [[-1, 0], [0, 1], [1, 0], [0, -1]]
    for i in range(N):
        for j in range(M):
            visited[i][j] = True
            dfs(i, j, 1, i, j, board[i][j])
            visited[i][j] = False

    if result:
        print("Yes")
    else:
        print("No")