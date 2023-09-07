def solution(m, n, puddles):
    board = [[0] * (m+1) for _ in range(n+1)]
    for puddle in puddles:
        board[puddle[1]][puddle[0]] = -1
    for i in range(1, n+1):
        for j in range(1, m+1):
            if (i == 1 and j == 1):
                board[i][j] = 1
            elif (board[i][j] == -1):
                board[i][j] = 0
            else:
                board[i][j] = (board[i-1][j] + board[i][j-1]) % 1000000007
    return board[n][m]