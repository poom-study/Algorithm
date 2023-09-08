import sys
from heapq import heappush, heappop

def checked(x, y, d, count):
    if 0 > x or x >= N or 0 > y or y >= N or visited[x][y][d] < count or board[x][y] == '*':
        return False
    return True

def bfs(x, y):
    global answer
    heap = []
    heappush(heap, (0, x, y, 0))
    heappush(heap, (0, x, y, 1))
    heappush(heap, (0, x, y, 2))
    heappush(heap, (0, x, y, 3))

    while heap:
        count, cx, cy, d = heappop(heap)
        nx = cx + delta[d][0]
        ny = cy + delta[d][1]

        if checked(nx, ny, d, count):
            visited[nx][ny][d] = count
            heappush(heap, (count, nx, ny, d))

        if board[cx][cy] == '!':
            for i in range(4):
                if d < 2 and i < 2:
                    continue
                if d > 1 and i > 1:
                    break
                nx = cx + delta[i][0]
                ny = cy + delta[i][1]
                if checked(nx, ny, i, count+1):
                    visited[nx][ny][i] = count+1
                    heappush(heap, (count+1, nx, ny, i))




if __name__ == "__main__":
    N = int(sys.stdin.readline())
    board = [list(sys.stdin.readline().rstrip()) for _ in range(N)]
    INF = sys.maxsize
    answer = sys.maxsize
    visited = [[[INF] * 4 for _ in range(N)] for _ in range(N)]
    delta = [[-1, 0], [1, 0], [0, -1], [0, 1] ]
    doors = []

    for i in range(N):
        for j in range(N):
            if board[i][j] == '#':
                doors.append((i, j))
    sx, sy = doors[0][0], doors[0][1]
    ex, ey = doors[1][0], doors[1][1]
    bfs(sx, sy)
    print(min(visited[ex][ey]))