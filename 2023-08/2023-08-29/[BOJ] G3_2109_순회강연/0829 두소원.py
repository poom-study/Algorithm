import sys, heapq

n = int(sys.stdin.readline())
lecture = []

for _ in range(n):
    lecture.append(tuple(map(int, sys.stdin.readline().split())))

lecture.sort(key=lambda x:(x[1], -x[0]))


price = []

for p, d in lecture:
    heapq.heappush(price, p)
    if len(price)>d:
        heapq.heappop(price)

print(sum(price))
