def bfs(node, N):
    q = [[node[0], node[1]]]
    v[node[0]][node[1]] = True
    cnt = 0
    while q:
        tmp = q.pop()
        cnt += 1
        for d in range(4):
            nr = tmp[0] + dr[d]
            nc = tmp[1] + dc[d]
            if nr >= N or nc >= N or nr < 0 or nc < 0:
                continue
            elif v[nr][nc]:
                continue
            elif map_[nr][nc] == 0:
                continue
            else:
                q.append([nr, nc])
                v[nr][nc] = True
    return cnt


n = int(input())
map_ = [[int(x) for x in input()] for i in range(n)]
v = [[False] * n for i in range(n)]
dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]

size_ = []
for i in range(n):
    for j in range(n):
        if map_[i][j] == 0 or v[i][j]:
            continue
        size_.append(bfs([i, j], n))

print(len(size_))
print("\n".join(map(str, sorted(size_))))
