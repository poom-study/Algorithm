import sys
from heapq import heappop, heappush


def bfs():
    global answer
    heap = []
    heappush(heap, (0, 0, 0))

    while heap:
        cost, x, y = heappop(heap)

        if x == N - 1 and y == M - 1:
            answer = cost
            break

        if cost > answer:
            break

        for i in range(4):
            nx = x + delta[i][0]
            ny = y + delta[i][1]

            if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny]:
                if board[nx][ny] == '1':
                    heappush(heap, (cost + 1, nx, ny))
                else:
                    heappush(heap, (cost, nx, ny))
                visited[nx][ny] = True


if __name__ == "__main__":
    M, N = map(int, sys.stdin.readline().split())
    board = [list(map(str, sys.stdin.readline().rstrip())) for _ in range(N)]
    visited = [[False] * M for _ in range(N)]
    delta = [[-1, 0], [0, 1], [1, 0], [0, -1]]
    answer = sys.maxsize
    bfs()

    print(answer)