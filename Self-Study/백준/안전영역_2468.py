import collections
import copy
n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]
max_rain = max([max(i) for i in graph]) #Graph에서 가장 큰 값

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
            if graph[nr][nc] == lvl:    #잠긴 수면이면 방문체크
                v[nr][nc] = True
                continue
            if vc[nr][nc]:
                continue
            q.append([nr, nc])
            vc[nr][nc] = True

res = 1
v = [[False]*n for _ in range(n)]
for r in range(1, max_rain):
    cnt = 0
    vc = copy.deepcopy(v)   #임시 방문체크 행렬
    for i in range(n):
        for j in range(n):
            if graph[i][j] == r:
                v[i][j] = True
                continue
            if not vc[i][j]:
                bfs(i, j, vc, r, graph)
                cnt += 1
    res = max(res, cnt)
print(res)