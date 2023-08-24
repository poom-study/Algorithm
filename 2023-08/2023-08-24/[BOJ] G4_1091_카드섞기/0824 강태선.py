import sys


def check(arr):
    tmp = False
    for i in range(N):
        if arr[i] != i % 3:
            tmp = True

    return tmp


if __name__ == "__main__":
    N = int(sys.stdin.readline())
    P = list(map(int, sys.stdin.readline().split()))
    S = list(map(int, sys.stdin.readline().split()))
    state = []
    for x in P:
        state.append(x)
    answer = 0

    while check(state):
        copy = []
        for x in state:
            copy.append(x)
        for i in range(N):
            state[S[i]] = copy[i]
        answer += 1
        if state == P:
            answer = -1
            break

    print(answer)