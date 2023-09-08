from collections import deque

def solution(begin, target, words):
    answer = 0
    q = deque()
    if (target not in words):
        return 0
    q.append([begin, 0])
    while(q):
        select, L = q.popleft()
        print(select, L)
        if (select == target):
            return L
        for i in range(len(words)):
            count = 0
            word = words[i]
            for j in range(len(select)):
                if (select[j] != word[j]):
                    count += 1
            else:
                if (count == 1):
                    q.append([word, L + 1])
                    
    
    