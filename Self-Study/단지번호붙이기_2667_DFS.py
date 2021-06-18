def dfs(r, c, count, n):
    v[r][c] = True
    for d in range(4):
        nr = r + dr[d]
        nc = c + dc[d]
        if nr >= n or nc >= n or nr < 0 or nc < 0 or v[nr][nc] or map_[nr][nc] == 0:
            continue
        count = dfs(nr, nc, count, n)
    return count + 1    #사방위 탐색후 돌아가면서 cnt++


N = int(input())
map_ = [[int(x) for x in input()] for i in range(N)]
v = [[False] * N for i in range(N)]
dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]

size_ = []
for i in range(N):
    for j in range(N):
        if map_[i][j] == 0 or v[i][j]:
            continue
        size_.append(dfs(i, j, 0, N))

print(len(size_))
print("\n".join(map(str, sorted(size_))))
