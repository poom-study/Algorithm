import sys

if __name__ == "__main__":
    S = list(sys.stdin.readline().rstrip())
    lk = []
    rk = []
    answer = 0

    cnt = 0
    for i in S:
        if i == 'K':
            cnt += 1
        else:
            lk.append(cnt)

    cnt = 0
    for i in S[::-1]:
        if i == 'K':
            cnt += 1
        else:
            rk.append(cnt)

    rk.reverse()

    left, right = 0, len(lk)-1

    while left <= right:
        answer = max(answer, right-left + 1 + 2 * min(lk[left], rk[right]))
        if lk[left] < rk[right]:
            left += 1
        else:
            right -= 1

    print(answer)