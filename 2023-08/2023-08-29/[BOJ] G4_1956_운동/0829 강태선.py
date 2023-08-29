import sys
INF = sys.maxsize

if __name__ == "__main__":
    N, M = map(int, sys.stdin.readline().split())
    graph = [[INF] * (N+1) for _ in range(N+1)]

    for _ in range(M):
        a, b, c = map(int, sys.stdin.readline().split())
        graph[a][b] = c

    for k in range(1, N+1):
        for i in range(1 , N+1):
            for j in range(1, N+1):
                graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

    answer = INF
    for i in range(1, N+1):
        answer = min(answer, graph[i][i])

    if answer == INF:
        print(-1)
    else:
        print(answer)