n, m = map(int, input().split())
sieve = [True]*(m+1)
sieve[0] = False
sieve[1] = False
k = int((m+1) ** 0.5)
for i in range(2, k+1):
    if sieve[i]:
        for j in range(i+i, m+1, i):
            sieve[j] = False

for i in range(n, m+1):
    if sieve[i]:
        print(i, end=' ')