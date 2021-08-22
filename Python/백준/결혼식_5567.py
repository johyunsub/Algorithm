n = int(input())
m = int(input())
adj = [[False]*(n+1) for _ in range(n+1)]
for i in range(m):      # 동기와의 관계(인접행렬)
    a, b = map(int, input().split())
    adj[a][b] = adj[b][a] = True
ans = -1
q = [(1, 0)]
v = [False]*(n+1)
v[1] = True
while q:
    cur, depth = q.pop(0)
    ans += 1
    if depth > 2:       # 친구의 친구의 친구 (즉, 세다리) 이상부터 탐색 종료
        ans -= 1
        break
    for i in range(1, n+1):         # 동기의 친구들에 대해 탐색
        if adj[cur][i] and not v[i]:
            v[i] = True
            q.append((i, depth+1))
print(ans)
