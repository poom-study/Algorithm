import sys
import heapq
m,n = map(int, sys.stdin.readline().split())

maze = [list(map(int, sys.stdin.readline().strip())) for _ in range(n)]

dx = [-1,1,0,0]
dy=[0,0,-1,1]
def bfs():
    res = 10001
    queue = []
    heapq.heappush(queue, (0,0,0))

    visited=[[False]*m for _ in range(n)]
    visited[0][0]=True
    while queue:
        v, x, y = heapq.heappop(queue)
        if v>res:
            continue
        if x==n-1 and y==m-1:
            res=min(res, v)

        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]

            if 0<=nx<n and 0<=ny<m and not visited[nx][ny]:
                if maze[nx][ny]==1:
                    visited[nx][ny]=True
                    heapq.heappush(queue, (v+1, nx, ny))
                elif maze[nx][ny]==0:
                    visited[nx][ny]=True
                    heapq.heappush(queue, (v, nx, ny))
    return res


print(bfs())

