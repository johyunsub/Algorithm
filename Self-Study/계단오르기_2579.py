n = int(input())
stair = [0]*n
for i in range(n):
    stair[i] = int(input())

dp = [0]*301
dp[n-1] = stair[n-1]
dp[n - 2] = stair[n - 1] + stair[n - 2]
if n == 3:
    dp[n - 3] = max(stair[n-1] + stair[n-2], stair[n - 1] + stair[n - 3])
if n > 3:
    for i in range(n-4, -1, -1):
        max_ = max(stair[i] + stair[i+1] + dp[i+3], stair[i] + dp[i+2])
        if dp[i+1] <= max_:
            dp[i] = max_

print(dp[0])