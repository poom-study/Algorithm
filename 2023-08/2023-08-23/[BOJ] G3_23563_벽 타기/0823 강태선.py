import sys
from heapq import heappop, heappush

INF = sys.maxsize
def make_board():
    global start, end
    for i in range(N):
        for j in range(M):
            if input_board[i][j] == "#":
                board[i][j] = -1
                for k in range(4):
                    nx = i + delta[k][0]
                    ny = j + delta[k][1]
                    if 0 <= nx < N and 0 <= ny < M and input_board[nx][ny] != "#":
                        board[nx][ny] = 1
            if input_board[i][j] == "S":
                start = (i, j)
            if input_board[i][j] == "E":
                end = (i, j)

def dijkstra():
    heap = []
    heappush(heap, (0, start[0], start[1]))
    while heap:
        cost, x, y = heappop(heap)

        if distance[x][y] < cost:
            continue
        if x == end[0] and y == end[1]:
            break

        for i in range(4):
            nx = x + delta[i][0]
            ny = y + delta[i][1]
            if 0 <= nx < N and 0 <= ny < M and board[nx][ny] != -1:
                if board[x][y] and board[nx][ny]:
                    if distance[nx][ny] > cost:
                        distance[nx][ny] = cost
                        heappush(heap, (cost, nx, ny))
                else:
                    if distance[nx][ny] > cost+1:
                        distance[nx][ny] = cost+1
                        heappush(heap, (cost+1, nx, ny))



if __name__ == "__main__":
    N, M = map(int, sys.stdin.readline().split())
    input_board = [list(sys.stdin.readline()) for _ in range(N)]
    board = [[0] * M for _ in range(N)]
    distance = [[INF] * M for _ in range(N)]
    delta = [[-1, 0], [0, 1], [1, 0], [0, -1]]
    start, end = (0, 0), (0, 0)
    make_board()
    dijkstra()
    
    print(distance[end[0]][end[1]])