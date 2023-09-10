import sys

sys.stdin = open('../input.txt')

if __name__=="__main__":
    D, N, M = map(int, sys.stdin.readline().split())
    arr = list(int(sys.stdin.readline()) for _ in range(N)) + [D]
    answer = 0

    arr.sort()
    left, right = 0, arr[-1]

    while left <= right:
        count, current = 0, 0
        mid = (left+right) // 2

        for num in arr:
            if num - current < mid:
                count += 1
            else:
                current = num

        if count <= M:
            left = mid+1
            answer = mid
        else:
            right = mid - 1

    print(answer)