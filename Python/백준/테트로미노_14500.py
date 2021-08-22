def tetris(r, c):
    return [[(r, c), (r, c + 1), (r, c + 2), (r, c + 3)],
            [(r, c), (r + 1, c), (r + 2, c), (r + 3, c)],
            [(r, c), (r + 1, c), (r, c + 1), (r, c + 2)],
            [(r, c), (r, c + 1), (r + 1, c), (r + 2, c)],
            [(r, c), (r + 1, c), (r + 1, c + 1), (r + 2, c)],
            [(r, c), (r, c + 1), (r + 1, c + 1), (r, c + 2)],
            [(r, c), (r + 1, c), (r + 1, c - 1), (r + 2, c)],
            [(r, c), (r, c + 1), (r - 1, c + 1), (r, c + 2)],
            [(r, c), (r + 1, c), (r + 2, c), (r + 2, c + 1)],
            [(r, c), (r, c + 1), (r, c + 2), (r - 1, c + 2)],
            [(r, c), (r, c + 1), (r, c + 2), (r + 1, c + 2)],
            [(r, c), (r + 1, c), (r, c + 1), (r + 1, c + 1)],
            [(r, c), (r, c + 1), (r + 1, c + 1), (r + 2, c + 1)],
            [(r, c), (r, c + 1), (r - 1, c + 1), (r - 2, c + 1)],
            [(r, c), (r + 1, c), (r + 1, c + 1), (r + 1, c + 2)],
            [(r, c), (r, c + 1), (r + 1, c + 1), (r + 1, c + 2)],
            [(r, c), (r, c + 1), (r - 1, c + 1), (r - 1, c + 2)],
            [(r, c), (r + 1, c), (r + 1, c - 1), (r + 2, c - 1)],
            [(r, c), (r + 1, c), (r + 1, c + 1), (r + 2, c + 1)]]


n, m = map(int, input().split())
grp = [list(map(int, input().split())) for _ in range(n)]
max_ = 0
for i in range(n):
    for j in range(m):
        tetromino = tetris(i, j)
        for tet in tetromino:
            sum_ = 0
            for tr, tc in tet:
                if not (0 <= tr < n and 0 <= tc < m):
                    break
                sum_ += grp[tr][tc]
            max_ = max(max_, sum_)
print(max_)

