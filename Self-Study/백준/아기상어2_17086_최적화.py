import collections
n, m = map(int, input().split())
sea = [list(map(int, input().split())) for _ in range(n)]
v = [[False]*m for _ in range(n)]

def bfs(v, sea, res):   #각각의 상어들의 주변을 물결파처럼 퍼져가며 가장 거리가 먼 값 체크
    q = collections.deque()
    for i in range(n):
        for j in range(m):
            if sea[i][j]:
                q.append([i, j, 1])
                v[i][j] = True

    while q:
        r, c, cnt = q.popleft()
        for nr, nc in [(r+1, c), (r-1, c), (r, c+1), (r, c-1), (r+1, c+1), (r+1, c-1), (r-1, c-1), (r-1, c+1)]:
            if not (0 <= nr < n and 0 <= nc < m):
                continue
            if v[nr][nc]:
                continue
            q.append([nr, nc, cnt+1])
            v[nr][nc] = True
            res = cnt
    return res

print(bfs(v, sea, 0))