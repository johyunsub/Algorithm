import collections
from itertools import combinations as cb


def bfs(case_):
    tot_distance = 0
    v = [[False]*n for _ in range(n)]
    q = collections.deque()
    for c in case_:
        q.append(c)
        v[c[0]][c[1]] = True
    while q:
        r, c, dist = q.popleft()
        for nr, nc in [(r+1, c), (r-1, c), (r, c+1), (r, c-1)]:
            if not (0 <= nr < n and 0 <= nc < n):
                continue
            elif v[nr][nc]:
                continue
            elif grp[nr][nc] == 1:
                tot_distance += dist
            q.append([nr, nc, dist+1])
            v[nr][nc] = True
    return tot_distance


n, m = map(int, input().split())
grp = [[0]*n for _ in range(n)]
store = []
for i in range(n):
    tmp = list(map(int, input().split()))
    for j in range(n):
        if tmp[j] == 1:
            grp[i][j] = 1
        elif tmp[j] == 2:
            store.append([i, j, 1])
            grp[i][j] = 2
min_ = 99999
for case_ in cb(store, m):
    min_ = min(min_, bfs(case_))
print(min_)


