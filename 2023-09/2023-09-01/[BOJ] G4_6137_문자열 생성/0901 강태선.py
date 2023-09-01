import sys


if __name__ == "__main__":
    N = int(sys.stdin.readline())
    S = list(sys.stdin.readline().rstrip() for _ in range(N))
    left, right = 0, len(S)-1
    count = 0
    answer = ''

    while left <= right:
        if S[left] < S[right]:
            answer += S[left]
            left += 1
        elif S[right] < S[left]:
            answer += S[right]
            right -= 1
        else:
            next_left, next_right = left+1, right-1
            check = False
            while next_left <= next_right:
                if S[next_left] < S[next_right]:
                    answer += S[left]
                    left += 1
                    check = True
                    break
                elif S[next_right] < S[next_left]:
                    answer += S[right]
                    right -= 1
                    check = True
                    break
                else:
                    next_left += 1
                    next_right -= 1
            if not check:
                answer += S[left]
                left += 1

        count += 1
        if count % 80 == 0:
            answer += '\n'

    print(answer)