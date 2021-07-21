n, m = map(int, input().split())
map_ = [[int(i) for i in list(input())] for _ in range(n)]
state_ = [[0 for i in range(m)] for j in range(n)]
v = [[[False]*m for j in range(n)], [[False]*m for j in range(n)]]

def bfs(r, c, cnt, brk):
    q = [[r, c, cnt, brk]]
    v[0][r][c] = True
    while q:
        cur = q.pop(0)
        r, c, cnt, brk = cur[0], cur[1], cur[2], cur[3]
        if r == n-1 and c == m-1:
            return cnt
        for nr, nc in [(r+1, c), (r, c+1), (r-1, c), (r, c-1)]:
            if not (0 <= nr < n and 0 <= nc < m):
                continue
            if brk == 0: #벽부수고 온 놈
                if v[1][nr][nc]:
                    continue
                if map_[nr][nc] == 1:
                    continue
                else:
                    v[1][nr][nc] = True
                    q.append([nr, nc, cnt+1, 0])
            else:   #안부수고 온 놈
                if v[0][nr][nc]:
                    continue
                if map_[nr][nc] == 1:
                    v[1][nr][nc] = True
                    q.append([nr, nc, cnt+1, 0])
                    continue
                v[0][nr][nc] = True
                q.append([nr, nc, cnt+1, 1])

    return -1


print(bfs(0, 0, 1, 1))


