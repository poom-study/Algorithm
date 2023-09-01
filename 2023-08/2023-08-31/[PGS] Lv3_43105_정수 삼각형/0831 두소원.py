def solution(triangle):
    answer = 0

    dp = [[0] * (len(triangle[i]) + 2) for i in range(len(triangle))]
    dp[0][1] = triangle[0][0]

    for i in range(1, len(triangle)):
        for j in range(1, len(triangle[i]) + 1):
            dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j - 1]

    answer = max(dp[len(triangle) - 1])

    return answer
