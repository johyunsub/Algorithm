n, m ,k = map(int, input().split())
map_ = [[0]*m for _ in range(n)]
food = []
for _ in range(k):
    r, c = map(int, input().split())
    food.append([r-1, c-1])
    map_[r-1][c-1] = 1
v = [[False]*m for _ in range(n)]


def bfs(loc, map_, v):
    q = [[loc[0], loc[1]]]
    v[loc[0]][loc[1]] = True
    cnt = 1
    while q:
        cur = q.pop()
        r, c = cur[0], cur[1]
        for nr, nc in [(r+1, c), (r, c+1), (r-1, c), (r, c-1)]:
            if nr >= n or nc >= m or nr < 0 or nc < 0 or v[nr][nc] or map_[nr][nc] == 0:
                continue
            q.append([nr, nc])
            v[nr][nc] = True
            cnt += 1
    return cnt


max_ = 0
for f in food:
    if not v[f[0]][f[1]]:
        max_ = max(max_, bfs(f, map_, v))
print(max_)