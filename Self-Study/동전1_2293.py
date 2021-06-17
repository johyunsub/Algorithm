n, k = map(int, input().split())
coin = [int(input()) for i in range(n)]
dp = [0]*(k+1)
dp[0] = 1
for c in coin:
    for i in range(k+1):
        if i>=c:
            dp[i] += dp[i-c]
print(dp[k])