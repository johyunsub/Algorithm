n = int(input())
li = list(map(int, input().split()))
sieve = [True] * 1001
sieve[0] = False
sieve[1] = False
m = int(1001 ** 0.5)
for i in range(2, m + 1):
    if sieve[i]:
        for j in range(i + i, 1001, i):
            sieve[j] = False

cnt = 0
for i in li:
    if sieve[i]:
        cnt += 1
print(cnt)
