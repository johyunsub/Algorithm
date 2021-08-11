import sys
input = sys.stdin.readline
n = int(input())
check = [0]*8001
nums = []
sum_ = 0
max_ = -4001
min_ = 4001
for i in range(n):
    num = int(input())
    sum_ += num
    check[num + 4000] += 1
    if num < min_:
        min_ = num
    if num > max_:
        max_ = num
    nums.append(num)

nums.sort()
print(round(sum_/n))
print(nums[n//2])
a = [0, 0]
flag = False
for i in range(8001):
    if not flag and a[1] == check[i]:
        flag = True
        a[0] = i
    if a[1] < check[i]:
        flag = False
        a[0] = i
        a[1] = check[i]
print(a[0] - 4000)
print(abs(max_ - min_))