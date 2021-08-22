n = int(input())
stair = [0]*n
for i in range(n):
    stair[i] = int(input())

dp = [0]*n
dp[0] = stair[0]
if n > 1:
    dp[1] = stair[0] + stair[1]
    for i in range(2, n):
        dp[i] = max(stair[i] + stair[i-1] + dp[i-3], stair[i] + dp[i-2])

print(dp[-1])