import sys

d, n, m = map(int, sys.stdin.readline().split())
distance = list(int(sys.stdin.readline()) for _ in range(n))+[d]

distance.sort()

left = 0
right = d
answer = 0

while left<=right:
    mid = (left+right)//2

    cnt = 0
    res = d
    total = 0
    for dist in distance:
        if dist-total<mid:
            cnt+=1
        else:
            total = dist

    if cnt>m:
        right = mid-1
    else:
        left = mid+1
        answer = mid


print(answer)
