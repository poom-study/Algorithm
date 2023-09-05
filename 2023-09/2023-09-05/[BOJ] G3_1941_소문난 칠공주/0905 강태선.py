import sys


def dfs(x, y, L, s_count, y_count, arr):
    global result
    if y_count > 3:
        return
    if L == 7:
        arr.sort()
        result.add(tuple(arr))
        return
    for i in range(4):
        for j in range(len(arr)):
            nx = arr[j][0] + delta[i][0]
            ny = arr[j][1] + delta[i][1]
            if 0 <= nx < 5 and 0 <= ny < 5 and (nx, ny) not in arr:
                if board[nx][ny] == 'Y':
                    dfs(nx, ny, L+1, s_count, y_count + 1, arr+[(nx, ny)])
                else:
                    dfs(nx, ny, L + 1, s_count + 1, y_count, arr + [(nx, ny)])


if __name__ == "__main__":
    board = [list(sys.stdin.readline().rstrip()) for _ in range(5)]
    delta = [[-1, 0], [0, 1], [1, 0], [0, -1]]
    result = set()

    for i in range(5):
        for j in range(5):
            if board[i][j] == 'S':
                dfs(i, j, 1, 1, 0, [(i, j)])
    print(len(result))