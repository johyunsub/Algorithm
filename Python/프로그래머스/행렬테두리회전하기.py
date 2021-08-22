def rotate(grp, quer):
    r1, c1, r2, c2 = [q - 1 for q in quer]
    min_ = 9999
    tmp = grp[r1][c1]
    min_ = grp[r1][c1] if min_ > grp[r1][c1] else min_
    for i in range(r2 - r1):
        grp[r1 + i][c1] = grp[r1 + 1 + i][c1]
        min_ = grp[r1 + i][c1] if min_ > grp[r1 + i][c1] else min_
    for i in range(c2 - c1):
        grp[r2][c1 + i] = grp[r2][c1 + 1 + i]
        min_ = grp[r2][c1 + i] if min_ > grp[r2][c1 + i] else min_
    for i in range(r2 - r1):
        grp[r2 - i][c2] = grp[r2 - 1 - i][c2]
        min_ = grp[r2 - i][c2] if min_ > grp[r2 - i][c2] else min_
    for i in range(c2 - c1 - 1):
        grp[r1][c2 - i] = grp[r1][c2 - 1 - i]
        min_ = grp[r1][c2 - i] if min_ > grp[r1][c2 - i] else min_
    grp[r1][c1 + 1] = tmp

    return min_


def solution(rows, columns, queries):
    answer = []
    grp = [[0] * columns for _ in range(rows)]
    a = 1
    for i in range(rows):
        for j in range(columns):
            grp[i][j] = a
            a += 1
    for i in range(len(queries)):
        answer.append(rotate(grp, queries[i]))
    return answer