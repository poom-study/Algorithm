import sys

if __name__=="__main__":
    n = int(sys.stdin.readline())
    numbers = list(map(int, sys.stdin.readline().split()))
    numbers.sort()
    left = 0
    right = len(numbers) - 1
    answer = []
    min_value = 2147000000

    while (left < right):
        tmp = numbers[left] + numbers[right]

        if (abs(tmp) < min_value):
            min_value = abs(tmp)
            answer = [numbers[left], numbers[right]]

        if tmp < 0:
            left += 1
        else:
            right -= 1
    print(answer[0], answer[1])