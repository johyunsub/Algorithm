import collections
n, m = map(int, input().split())
sea = [list(map(int, input().split())) for _ in range(n)]


def bfs(r, c, depth, sea):  #매개변수로 받은 지점으로부터 주변의 상어와의 거리를 계산
    v = [[False]*m for _ in range(n)]
    q = collections.deque()
    q.append([r, c, depth])
    v[r][c] = True
    while q:
        r, c, depth = q.popleft()
        for nr, nc in [(r+1, c), (r-1, c), (r, c+1), (r, c-1), (r+1, c+1), (r+1, c-1), (r-1, c-1), (r-1, c+1)]:
            if not (0 <= nr < n and 0 <= nc < m):
                continue
            if v[nr][nc]:
                continue
            if sea[nr][nc] == 1:
                return depth
            q.append([nr, nc, depth+1])
            v[nr][nc] = True


max_ = 0
for i in range(n):
    for j in range(m):
        if sea[i][j] == 1:
            continue
        max_ = max(max_, bfs(i, j, 1, sea)) #한 지점씩 주변의 상어와 거리를 체크하여 가장 큰 값 max_에 저장

print(max_)




