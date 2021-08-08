R, C = map(int, input().split())
grp = [list(map(lambda x: ord(x) - 65, input())) for _ in range(R)]
visit = set()
max_ = 0


def dfs(r, c, dep):
    global max_
    visit.add(grp[r][c])
    for nr, nc in [(r + 1, c), (r - 1, c), (r, c - 1), (r, c + 1)]:
        if not (0 <= nr < R and 0 <= nc < C):
            continue
        if grp[nr][nc] in visit:
            continue
        dfs(nr, nc, dep + 1)
        visit.remove(grp[nr][nc])
    max_ = max(max_, dep)


dfs(0, 0, 1)
print(max_)
