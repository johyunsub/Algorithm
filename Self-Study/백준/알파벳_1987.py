R, C = map(int, input().split())
grp = [list(map(lambda x: ord(x) - 65, input())) for _ in range(R)]
V = [False] * 26
max_ = 0


def dfs(r, c, dep, v):
    global max_
    v[grp[r][c]] = True
    max_ = max(max_, dep)

    if r - 1 >= 0 and not v[grp[r - 1][c]]:
        dfs(r - 1, c, dep + 1, v)
        v[grp[r - 1][c]] = False
    if r + 1 < R and not v[grp[r + 1][c]]:
        dfs(r + 1, c, dep + 1, v)
        v[grp[r + 1][c]] = False
    if c - 1 >= 0 and not v[grp[r][c - 1]]:
        dfs(r, c - 1, dep + 1, v)
        v[grp[r][c - 1]] = False
    if c + 1 < C and not v[grp[r][c + 1]]:
        dfs(r, c + 1, dep + 1, v)
        v[grp[r][c + 1]] = False


dfs(0, 0, 1, V)
print(max_)
