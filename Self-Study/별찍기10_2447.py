n = int(input())
matrix = [['']*n for _ in range(n)]

def dfs(r, c, cnt, f):
    if cnt == 1:
        if not f:
            matrix[r][c] = " "
            return
        matrix[r][c] = "*"
        return
    d = cnt//3
    dfs(r,       c,       d, f)
    dfs(r,       c + d,   d, f)
    dfs(r,       c + 2*d, d, f)
    dfs(r + d,   c,       d, f)
    dfs(r + d,   c + d,   d, False)
    dfs(r + d,   c + 2*d, d, f)
    dfs(r + 2*d, c,       d, f)
    dfs(r + 2*d, c + d,   d, f)
    dfs(r + 2*d, c + 2*d, d, f)


dfs(0, 0, n, True)
for row_ in matrix:
    for i in range(n):
        print(row_[i], end='')
    print()
