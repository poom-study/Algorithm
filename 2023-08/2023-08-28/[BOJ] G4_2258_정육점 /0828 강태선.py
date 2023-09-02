import sys

if __name__ == "__main__":
    N, M = map(int, sys.stdin.readline().split())
    meats = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
    answer = sys.maxsize
    check = False
    w, e = 0, 0
    meats.sort(key = lambda x:(x[1], -x[0]))

    for i in range(N):
        w += meats[i][0]
        if i >= 1 and meats[i][1] == meats[i-1][1]:
            e += meats[i][1]
        else:
            e = 0
        if w >= M:
            answer = min(answer, meats[i][1] + e)
            check = True

    if check:
        print(answer)
    else:
        print(-1)
