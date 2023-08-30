import sys

N = int(sys.stdin.readline())
cat = sys.stdin.readline().rstrip()

left = 0
right = 0

translate = {cat[0]:1} # 번역할 문자열의 알파벳 개수

answer = 0

while left <= right < len(cat):
    length = len(translate) # 알파벳 종류

    if length>N: # 종류가 N개보다 많으면 left+1
        cat_left = cat[left]
        translate[cat_left]-=1

        if translate[cat_left]==0:
            del(translate[cat_left])
        left+=1
    else: # 종류가 N개 이하면 right+1
        answer = max(answer, right-left+1)

        right+=1
        if right>=len(cat):
            break
        cat_right = cat[right]
        if cat_right not in translate:
            translate[cat_right] = 1
        else:
            translate[cat_right]+=1


print(answer)
