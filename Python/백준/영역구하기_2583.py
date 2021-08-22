dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]
n, m, k = map(int, input().split())
map_ = [[False for i in range(n)] for j in range(m)]
for _ in range(k):
    i, j, r, c = map(int, input().split())
    for x in range(i, r):
        for y in range(j, c):
            map_[x][y] = True


# def dfs(r, c, cnt):
#     for d in range(4):
#         nr = r + dr[d]
#         nc = c + dc[d]
#         if nr >= m or nc >= n or nr < 0 or nc < 0:
#             continue
#         if map_[nr][nc]:
#             continue
#         map_[nr][nc] = True
#         cnt = dfs(nr, nc, cnt)
#     return cnt + 1

def bfs(node):
    q = [[node[0], node[1]]]
    map_[node[0]][node[1]] = True
    cnt = 1
    while q:
        tmp = q.pop()
        for d in range(4):
            nr = tmp[0] + dr[d]
            nc = tmp[1] + dc[d]
            if nr >= m or nc >= n or nr < 0 or nc < 0:
                continue
            if map_[nr][nc]:
                continue
            map_[nr][nc] = True
            q.append([nr, nc])
            cnt += 1
    return cnt

areas = []
for i in range(m):
    for j in range(n):
        if not map_[i][j]:
            areas.append(bfs([i, j]))
print(len(areas))
print(*sorted(areas))