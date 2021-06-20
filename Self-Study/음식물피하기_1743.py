n, m ,k = map(int, input().split())
map_ = [[0]*m for _ in range(n)]
food = []
for _ in range(k):
    r, c = map(int, input().split())
    food.append([r-1, c-1])
    map_[r-1][c-1] = 1
v = [[False]*m for _ in range(n)]
dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]


def bfs(loc, map_, v):
    q = []
    q.append([loc[0], loc[1]])
    v[loc[0]][loc[1]] = True
    cnt = 1
    while q:
        cur = q.pop()
        for d in range(4):
            nr = cur[0] + dr[d]
            nc = cur[1] + dc[d]
            if nr >= n or nc >= m or nr < 0 or nc < 0:
                continue
            if v[nr][nc]:
                continue
            if map_[nr][nc] == 0:
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