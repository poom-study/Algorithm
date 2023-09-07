from heapq import heappush, heappop

def solution(n, works):
    answer = 0
    if (sum(works) <= n):
        return 0
    heap = []
    for work in works:
        heappush(heap, -work)
        
    for _ in range(n):
        heappush(heap, heappop(heap) + 1)

    for _ in range(len(heap)):
        answer += (-heappop(heap)) ** 2
    return answer