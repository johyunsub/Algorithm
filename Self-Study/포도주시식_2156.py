n = int(input())
wine = [0]*n
for i in range(n):
    wine[i] = int(input())

dp = [0]*10001
dp[0] = wine[0]
if n > 1:
    dp[1] = wine[0] + wine[1]
    for i in range(2, n):   #( 이전까지 계산된 값 vs 전전값 + 현재 포도주양 vs 전전전값 + 현재와 이전 포도주양 ) 중 가장 큰 값을 현재까지의 계산된 값으로 정함
        dp[i] = max(dp[i-1], wine[i] + dp[i-2], wine[i] + wine[i-1] + dp[i-3])

print(dp[n-1])