import heapq


def solution(n, works):
    answer = 0

    works = [-work for work in works]
    heapq.heapify(works)

    while n > 0:
        if works[0] == 0:
            break
        work = heapq.heappop(works)
        heapq.heappush(works, work + 1)
        n -= 1

    for work in works:
        answer += work ** 2

    return answer
