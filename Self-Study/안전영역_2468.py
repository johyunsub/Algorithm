import collections
n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]
max_rain = max([max(i) for i in graph])

def bfs(r, c, vc, lvl, graph):
    global v
    q = collections.deque()
    q.append([r, c])
    vc[r][c] = True
    while q:
        r, c = q.popleft()
        for nr, nc in [(r+1, c), (r-1, c), (r, c+1), (r, c-1)]:
            if not (0 <= nr < n and 0 <= nc < n):
                continue
            if vc[nr][nc]:
                continue
            if graph[nr][nc] == lvl:
                v[nr][nc] = True
                continue
            q.append([nr, nc])
            vc[nr][nc] = True

res = 0
v = [[False]*n for _ in range(n)]

for r in range(1, max_rain):
    cnt = 0
    vc = v.copy()
    for i in range(n):
        for j in range(n):
            if graph[i][j] == r:
                v[i][j] = True
            if graph[i][j] > r and not vc[i][j]:
                bfs(i, j, vc, r, graph)
                cnt += 1
    res = max(res, cnt)
print(res)
