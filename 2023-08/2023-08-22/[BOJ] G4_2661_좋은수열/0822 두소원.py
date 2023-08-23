import sys

def check(num, length):

    for i in range(1, length//2+1):
        if num[-i:] == num[-(i*2):-i]:
            return
    if length==N:
        print(num)
        exit(0)

    check(num+"1", length+1)
    check(num+"2", length+1)
    check(num+"3", length+1)


N = int(sys.stdin.readline())

check("", 0)
