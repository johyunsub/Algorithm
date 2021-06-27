from collections import deque


def bfs(r, c, cnt):
    q = deque()
    q.append([r, c, cnt])
    v[r][c] = True
    while q:
        r, c, cnt = q.popleft()
        if r == e1 and c == e2:
            return cnt
        for nr, nc in [(r-2, c+1), (r-1, c+2), (r+1, c+2), (r+2, c+1), (r+2, c-1), (r+1, c-2), (r-1, c-2), (r-2, c-1)]:
            if not (0 <= nr < N and 0 <= nc < N):
                continue
            if v[nr][nc]:
                continue
            q.append([nr, nc, cnt+1])
            v[nr][nc] = True
    return cnt


tc = int(input())
for _ in range(tc):
    N = int(input())
    s1, s2 = map(int, input().split())
    e1, e2 = map(int, input().split())
    v = [[False]*N for _ in range(N)]
    print(bfs(s1, s2, 0))