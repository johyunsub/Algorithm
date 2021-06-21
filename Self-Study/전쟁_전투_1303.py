n, m = map(int, input().split())
map_ = [list(input()) for _ in range(m)]
v = [[False]*n for i in range(m)]
def bfs(r, c, color):
    q = [[r, c]]
    v[r][c] = True
    cnt = 1
    while q:
        cur = q.pop()
        r = cur[0]
        c = cur[1]
        for nr, nc in [(r+1, c), (r, c+1), (r-1, c), (r, c-1)]:
            if 0 <= nr < m and 0 <= nc < n and not v[nr][nc] and map_[nr][nc] == color:
                q.append([nr, nc])
                v[nr][nc] = True
                cnt += 1
    return cnt
w, b = 0, 0
for i in range(m):
    for j in range(n):
        if not v[i][j]:
            if map_[i][j] == 'W':
                w += bfs(i, j, 'W')**2
            else:
                b += bfs(i, j, 'B')**2
print(w, b)