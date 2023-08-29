import sys

INF = sys.maxsize
V, E = map(int, sys.stdin.readline().split())
distance = [[INF]*(V+1) for _ in range(V+1)]
for _ in range(E):
    a, b, c = map(int, sys.stdin.readline().split())
    distance[a][b] = c

for i in range(1, V+1):
    for x in range(1, V+1):
        for y in range(1, V+1):
            distance[x][y] = min(distance[x][y], distance[x][i]+distance[i][y])

answer = INF
for i in range(1, V+1):
    answer = min(answer, distance[i][i])

if answer==INF:
    print(-1)
else:
    print(answer)
