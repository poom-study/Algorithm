import sys

N, M, L = map(int, sys.stdin.readline().split())
locations = [0]+list(map(int, sys.stdin.readline().split()))+[L]

locations.sort()

start = 1
end = L-1
answer = 0
while start<=end:

    cnt = 0
    mid = (start+end)//2

    for i in range(1, N+2):
        if locations[i]-locations[i-1]>mid:
            cnt+=(locations[i]-locations[i-1]-1)//mid

    if cnt>M:
        start = mid+1
    else:
        end = mid-1
        answer = mid

print(answer)
