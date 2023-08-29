import sys

N, M = map(int, sys.stdin.readline().split())
meat = []
for _ in range(N):
    meat.append(tuple(map(int, sys.stdin.readline().split())))

meat.sort(key=lambda x:(x[1], -x[0]))

answer = sys.maxsize
res = 0
acm_cost = 0
for i in range(N):

    weight, cost = meat[i]
    res+=weight
    if i>0 and cost==meat[i-1][1]: # 이전과 가격이 같으면
        acm_cost += cost # 가격 더하기
    else: # 가격 다르면
        acm_cost = cost

    if res>=M:
        answer = min(answer, acm_cost)
if answer ==sys.maxsize:
    print(-1)
else:
    print(answer)
