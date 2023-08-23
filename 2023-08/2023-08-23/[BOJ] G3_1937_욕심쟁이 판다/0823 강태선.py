import sys
sys.setrecursionlimit(10**6)

def dfs(x, y):
    if dp[x][y]:
        return dp[x][y]
    dp[x][y] = 1

    for i in range(4):
        nx = x + delta[i][0]
        ny = y + delta[i][1]
        if 0 <= nx < N and 0 <= ny < N and arr[x][y] < arr[nx][ny]:
            dp[x][y] = max(dp[x][y], dfs(nx, ny) + 1)

    return dp[x][y]


if __name__ == "__main__":
    N = int(sys.stdin.readline())
    arr = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
    dp = [[0] * N for _ in range(N)]
    delta = [[-1, 0], [0, 1], [1, 0], [0, -1]]
    answer = 0

    for i in range(N):
        for j in range(N):
            answer = max(answer, dfs(i, j))

    print(answer)