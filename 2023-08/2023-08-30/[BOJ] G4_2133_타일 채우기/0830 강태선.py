import sys

if __name__ == "__main__":
    N = int(sys.stdin.readline())
    dp = [0] * 31
    dp[2] = 3

    for i in range(4, N+1):
        if i % 2 == 0:
            dp[i] = dp[i-2] * 3 + 2
            for j in range(2, i-2, 2):
                dp[i] += dp[j] * 2

    print(dp[N])