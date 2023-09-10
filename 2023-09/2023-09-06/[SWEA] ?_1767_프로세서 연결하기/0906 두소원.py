import sys

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

def isConnected(core, dir):
    x = core[0] + dx[dir]
    y = core[1] + dy[dir]

    while 0 <= x < N and 0 <= y < N:
        if board[x][y]!=0:
            return False
        x+=dx[dir]
        y+=dy[dir]

    return True

def fill(core, dir, val):
    cnt = 0

    x = core[0]+dx[dir]
    y = core[1]+dy[dir]

    while 0 <= x < N and 0 <= y < N:
        board[x][y] = val
        cnt+=1
        x+=dx[dir]
        y+=dy[dir]
    return cnt

def dfs(idx, cnt, length):
    global core_cnt, answer
    if idx == len(cores):
        if core_cnt<cnt:
            core_cnt = cnt
            answer = length
        elif core_cnt==cnt:
            if length<answer:
                answer = length

        return

    for i in range(4):
        if isConnected(cores[idx], i):
            l = fill(cores[idx], i, 2)
            dfs(idx+1, cnt+1, length+l)
            fill(cores[idx], i, 0)

    dfs(idx+1, cnt, length) # 선택 안함



T = int(input())

for t in range(1, T+1):
    N = int(input())
    board = list(list(map(int, input.split())) for _ in range(N))

    cores = []
    for i in range(1, N-1):
        for j in range(1, N-1):
            if board[i][j] ==1:
                cores.append((i, j))

    core_cnt = 0
    answer = 144

    dfs(0, 0, 0)
    print(f'#{t} {answer}')
