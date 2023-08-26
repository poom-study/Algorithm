import sys
from collections import deque


def remove(res):
    for x, y in res:
        board[x][y]=='.'

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

def bfs(a, b):

    queue = deque([(a, b)])
    visited[a][b] = True

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]

            if 0<=nx<12 and 0<=ny<6 and board[nx][ny]==board[a][b] and not visited[nx][ny]:
                visited[nx][ny] = True
                res.append((nx, ny))
                queue.append((nx, ny))



def move(res):
    res.sort()
    # print(res)
    for x, y in res:
        for i in range(x, 0, -1):
            # print(i, y)
            board[i][y]=board[i-1][y]
            board[i-1][y] = '.'


board = list(list(sys.stdin.readline().rstrip()) for _ in range(12))

answer = 0
while True:

    cnt = 0

    flag = False
    visited = [[False]*6 for _ in range(12)]
    to_move = []
    for i in range(12):
        for j in range(6):
            if board[i][j]!='.' and not visited[i][j]:
                res =[(i, j)]
                bfs(i, j)
                if len(res)>=4:
                    remove(res)
                    to_move+=res
                    flag = True
    if not flag:
        break
    else:
        move(to_move)
        answer+=1

print(answer)

