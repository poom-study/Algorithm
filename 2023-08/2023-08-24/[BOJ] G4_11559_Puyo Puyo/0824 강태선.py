import sys
from collections import deque

def down():
    for i in range(6):
        for j in range(10, -1, -1):
            for k in range(11, j, -1):
                if board[j][i] != 0 and board[k][i] == 0:
                    board[k][i] = board[j][i]
                    board[j][i] = 0
                    break

def break_puyo(num):
    for x, y in coor:
        board[x][y] = 0

def bfs(x, y, color):
    queue = deque()
    queue.append((x, y))
    dic[color] += 1
    visited[x][y] = False
    coor.append((x, y))
    while queue:
        tmp = queue.popleft()
        for i in range(4):
            nx = tmp[0] + delta[i][0]
            ny = tmp[1] + delta[i][1]

            if 0 <= nx < 12 and 0 <= ny < 6 and visited[nx][ny] and board[nx][ny] == color:
                dic[color] += 1
                coor.append((nx, ny))
                visited[nx][ny] = False
                queue.append((nx, ny))

if __name__ == "__main__":
    board = [list(sys.stdin.readline().rstrip()) for _ in range(12)]
    delta = [[-1, 0], [0, 1], [1, 0], [0, -1]]
    for i in range(12):
        for j in range(6):
            if board[i][j] == '.':
                board[i][j] = 0
            elif board[i][j] == 'R':
                board[i][j] = 1
            elif board[i][j] == 'G':
                board[i][j] = 2
            elif board[i][j] == 'B':
                board[i][j] = 3
            elif board[i][j] == 'P':
                board[i][j] = 4
            elif board[i][j] == 'Y':
                board[i][j] = 5

    count = 0

    while True:
        visited = [[True]*6 for _ in range(12)]
        dic = {1: 0, 2: 0, 3: 0, 4: 0, 5: 0}
        check = True
        for i in range(12):
            for j in range(6):
                if board[i][j] != 0 and visited[i][j]:
                    color = board[i][j]
                    dic = {1: 0, 2: 0, 3: 0, 4: 0, 5: 0}
                    coor = []
                    bfs(i, j, color)
                    if dic[color] > 3:
                        break_puyo(color)
                        check = False
        down()
        if check:
            break
        count += 1
        
    print(count)