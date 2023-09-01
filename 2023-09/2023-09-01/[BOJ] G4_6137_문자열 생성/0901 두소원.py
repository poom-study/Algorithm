import sys

N = int(sys.stdin.readline())
S = ""

for _ in range(N):
    S+=sys.stdin.readline().rstrip()

T = ""
left = 0
right = N-1
cnt = 0
while left<=right:

    if S[left]<S[right]:
        T+=S[left]
        left+=1
    elif S[left]>S[right]:
        T+=S[right]
        right -=1
    else:
        start = left+1
        end = right-1
        flag = False
        while start<=end:
            if S[start]<S[end]:
                flag = True
                break
            elif S[start]>S[end]:
                break
            else:
                start+=1
                end-=1
        if flag:
            T+=S[left]
            left+=1
        else:
            T+=S[right]
            right-=1

    cnt+=1
    if cnt%80==0:
        T+="\n"


print(T)
