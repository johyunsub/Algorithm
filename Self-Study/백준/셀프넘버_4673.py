def sum_each_number(n):
    return n + sum(map(int, str(n)))


nums = [True]*10001
for i in range(1, 10001):
    if nums[i]:
        dc = sum_each_number(i)
        while dc <= 10000:
            nums[dc] = False
            dc = sum_each_number(dc)

for i in range(1, 10001):
    if nums[i]:
        print(i)