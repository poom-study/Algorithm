import sys


def check(num):
    for i in range(1, len(num)//2 + 1):
        if num[-i:] == num[-2 * i:-i]:
            return False
    return True


def back(num):
    if len(num) == N:
        print(num)
        exit()

    for i in range(1, 4):
        if check(num + str(i)):
            back(num + str(i))
    return


if __name__ == "__main__":
    N = int(sys.stdin.readline())
    back('1')