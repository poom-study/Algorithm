import sys

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

def check(x, y, px, py):

    if visited[x][y]:
        print("Yes")
        exit(0)
    visited[x][y] = True

    for i in range(4):
        nx = x+dx[i]
        ny = y+dy[i]
        if 0<=nx<N and 0<=ny<M and board[nx][ny]==board[x][y]:

            if (nx, ny)!=(px, py):
                check(nx, ny, x, y)

N, M = map(int, sys.stdin.readline().split())
board = list(sys.stdin.readline().rstrip() for _ in range(N))

visited = [[False]*M for _ in range(N)]

for i in range(N):
    for j in range(M):
        if board[i][j].isupper():
            # visited[i][j] = True
            if not visited[i][j]:
                check(i, j, -1, -1)


print("No")
