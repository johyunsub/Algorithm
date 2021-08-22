n = int(input())
dp = [0]*(n+1)
for f in range(1, n+1): #위에서 한줄씩 체크
    li = list(map(int, input().split()))
    tmp = [0]*f
    for i in range(f):
        if i == 0:
            tmp[i] = dp[i] + li[i]
            continue
        tmp[i] = max(dp[i-1] + li[i], dp[i]+li[i])  #다음 줄에 대해 지나온 수와 합해 큰 값을 삽입
    for i in range(f):
        dp[i] = tmp[i]
print(max(dp))