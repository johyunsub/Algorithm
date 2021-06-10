m = int(input())
n = int(input())
prime = [True]*(n+1)
prime[1] = False
for i in range(2, int(n ** 0.5) + 1):
    for j in range(i+i, n+1, i):
        prime[j] = False
min_ = -1
sum_ = 0
for i in range(n, m-1, -1):
    if prime[i]:
        sum_ += i
        min_ = i
if sum_ != 0:
    print(sum_)
print(min_)