import sys

def dfs(person, check):
    if check:
        blue.append(person)
    else:
        white.append(person)
    for ban in bans[person]:
        if ban in people:
            people.remove(ban)
            dfs(ban, not check)

if __name__ == "__main__":
    N = int(sys.stdin.readline())
    blue = []
    white = []
    bans = [[] for _ in range(N+1)]

    for i in range(1, N+1):
        bans[i] = list(map(int, sys.stdin.readline().split()))[1:]

    people = set(range(1, N + 1))

    while people:
        tmp = people.pop()
        dfs(tmp, True)

    blue.sort()
    white.sort()

    print(len(blue))
    print(*blue)
    print(len(white))
    print(*white)