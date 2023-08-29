import sys
from heapq import heappush, heappop

if __name__ == "__main__":
    N = int(sys.stdin.readline())
    cla = []
    heap = []
    for _ in range(N):
        a, b = map(int, sys.stdin.readline().split())
        cla.append((a, b))

    cla.sort(key = lambda x:x[1])
    for cost, day in cla:
        heappush(heap, cost)
        if len(heap) > day:
            heappop(heap)

    print(sum(heap))