import itertools


def combi(cnt, depth, v, N, R):
    global min_
    if cnt == R:
        min_ = min(min_, cal_score(v, N))
    for i in range(depth, N):
        if v[i]:
            continue
        v[i] = True
        combi(cnt + 1, i + 1, v, N, R)
        v[i] = False


def cal_score(v, N):
    start_ = []
    link_ = []
    for i in range(N):
        if v[i]:
            start_.append(i)
        else:
            link_.append(i)
    start_score = 0
    link_score = 0
    for t in itertools.permutations(start_, 2):
        start_score += grp[t[0]][t[1]]
    for t in itertools.permutations(link_, 2):
        link_score += grp[t[0]][t[1]]
    return abs(start_score - link_score)


n = int(input())
grp = [list(map(int, input().split())) for _ in range(n)]
indexs = range(n)
res = []
v = [False] * n
min_ = 9999999
combi(0, 1, v, n, n / 2)
print(min_)
