def bfs(vertex):
    q = [vertex]
    v[vertex] = True
    while q:
        vertex = q.pop(0)
        for i in range(1, N+1):
            if grp[vertex][i] == 1 and not v[i]:
                q.append(i)
                v[i] = True


N, M = map(int, input().split())
grp = [[0]*(N+1) for _ in range(N+1)]
for _ in range(M):
    x, y = map(int, input().split())
    grp[x][y] = grp[y][x] = 1

v = [False]*(N+1)
cnt = 0
for i in range(1, N+1):
    if not v[i]:
        bfs(i)
        cnt += 1
print(cnt)
