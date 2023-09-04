import sys

if __name__ == "__main__":
    N, M, L = map(int, sys.stdin.readline().split())
    arr = list(map(int, sys.stdin.readline().split()))
    arr.insert(0, 0)
    arr.append(L)
    arr.sort()

    left, right = 1, L-1
    answer = 0

    while left <= right:
        count = 0
        mid = (left+right) // 2

        for i in range(1, len(arr)):
            tmp = arr[i] - arr[i-1]
            # print(arr[i], arr[i-1])
            if tmp > mid:
                count += (tmp-1) // mid

        if count > M:
            left = mid + 1
        else:
            right = mid - 1
            answer = mid
            
    print(answer)
