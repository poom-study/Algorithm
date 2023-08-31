def solution(triangle):
    answer = 0
    triangle = [[0] + x + [0] for x in triangle]
    for i in range(1, len(triangle)):
        for j in range(1, i+2):
            triangle[i][j] += max(triangle[i-1][j-1], triangle[i-1][j])
            
    return max(triangle[-1])