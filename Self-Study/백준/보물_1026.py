n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))

a = sorted(a)
b = sorted(b, reverse=True)
sum_ = 0
for i in range(len(a)):
    sum_ += a[i] * b[i]

print(sum_)