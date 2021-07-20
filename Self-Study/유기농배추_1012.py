import collections


def bfs(r, c):
    q = collections.deque()
    q.append([r, c])
    v[r][c] = True
    while q:
        r, c = q.popleft()
        for nr, nc in [(r+1, c), (r-1, c), (r, c+1), (r, c-1)]:
            if not (0 <= nr < N and 0 <= nc < M):
                continue
            if v[nr][nc]:
                continue
            if not grp[nr][nc]:
                continue
            v[nr][nc] = True
            q.append([nr, nc])


tc = int(input())
for t in range(tc):
    M, N, K = map(int, input().split())
    grp = [[0]*M for _ in range(N)]
    for k in range(K):
        C, R = map(int, input().split())
        grp[R][C] = 1

    v = [[False]*M for _ in range(N)]
    ans = 0
    for i in range(N):
        for j in range(M):
            if not v[i][j] and grp[i][j] == 1:
                bfs(i, j)
                ans += 1
    print(ans)
