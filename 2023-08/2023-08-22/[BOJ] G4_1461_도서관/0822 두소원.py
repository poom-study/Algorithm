import sys

N, M = map(int, sys.stdin.readline().split())
books = list(map(int, sys.stdin.readline().split()))

ans = 0
minus = [] # 음수
plus = [] # 양수

max_book = 0 # 최대값

for i in range(N):
    max_book = max(max_book, abs(books[i]))

    if books[i]<0:
        minus.append(abs(books[i]))
    else:
        plus.append(books[i])
minus.sort()
plus.sort()

# M개씩 둘 때 가장 먼곳을 기준으로 거리를 더해준다
for i in range(len(minus)-1,-1,-M):
    ans+=minus[i]
for i in range(len(plus)-1,-1,-M):
    ans+=plus[i]

# 왕복하고 가장 먼 곳 한번만 가기
print(ans*2 - max_book)

