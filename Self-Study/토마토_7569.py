from collections import deque

m, n, h = map(int, input().split())
farm = [[list(map(int, input().split())) for i in range(n)] for j in range(h)]
v = [[[False]*m for i in range(n)] for j in range(h)]
flag = 1
days = 0
q = deque()
for i in range(h):
    for j in range(n):
        for k in range(m):
            if farm[i][j][k] == 1:
                q.append([i, j, k, days])
                v[i][j][k] = True
if not q:
    flag = -1
while q:
    f, r, c, cnt = q.popleft()
    days = cnt
    for nr, nc, nf in [(r-1, c, f), (r, c-1, f), (r+1, c, f), (r, c+1, f), (r, c, f-1), (r, c, f+1)]:
        if not (0 <= nr < n and 0 <= nc < m and 0 <= nf < h):
            continue
        if v[nf][nr][nc]:
            continue
        if farm[nf][nr][nc] == -1 or farm[nf][nr][nc] == 1:
            continue
        if farm[nf][nr][nc] == 0:
            farm[nf][nr][nc] = 1
            q.append([nf, nr, nc, cnt+1])
            v[nf][nr][nc] = True


for i in range(h):
    for j in range(n):
        for k in range(m):
            if farm[i][j][k] == 0:
                flag = -1
                break


if flag <= 0:
    print(flag)
else:
    print(days)
