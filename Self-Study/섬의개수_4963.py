import collections
while True:
    w, h = map(int, input().split())
    if w == 0 and h == 0:
        break
    map_ = [list(map(int, input().split())) for _ in range(h)]
    v = [[False]*w for _ in range(h)]

    def bfs(r, c, map_, v):
        q = collections.deque()
        q.append([r, c])
        v[r][c] = True
        while q:
            r, c = q.popleft()
            for nr, nc in [(r+1, c), (r, c-1), (r-1, c), (r, c+1), (r+1, c+1), (r-1, c-1), (r+1, c-1), (r-1, c+1)]:
                if not (0 <= nr < h and 0 <= nc < w):
                    continue
                if v[nr][nc]:
                    continue
                if map_[nr][nc] == 1:
                    q.append([nr, nc])
                    v[nr][nc] = True

    cnt = 0
    for i in range(h):
        for j in range(w):
            if map_[i][j] == 1 and not v[i][j]:
                bfs(i, j, map_, v)
                cnt += 1
    print(cnt)



