import sys
from collections import defaultdict

if __name__ == "__main__":
    N = int(sys.stdin.readline())
    alpha = list(map(str, sys.stdin.readline()))
    answer = 1
    left, right = 0, 0
    dic = defaultdict(int)
    dic[alpha[left]] = 1

    while right < len(alpha)-1 and left <= right:

        if len(dic) <= N:
            answer = max(answer, right - left+1)
            right += 1
            dic[alpha[right]] += 1
        else:
            dic[alpha[left]] -= 1
            if dic[alpha[left]] == 0:
                dic.pop(alpha[left])
            left += 1
    print(answer)