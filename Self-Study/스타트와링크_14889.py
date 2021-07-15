n = int(input())
grp = [list(map(int, input().split())) for _ in range(n)]
indexs = range(n)
res = []
v = [False]*n
min_ = 9999999
sta, lin = 0, 0
    
def combi(cnt, depth, v, N, R):
    global min_
    if cnt == R:
        if v[0]:
            min_ = min(min_, teams(v, N))
    for i in range(depth, N):
        if v[i]:
            continue
        v[i] = True
        combi(cnt + 1, i+1, v, N, R)
        v[i] = False

def perm(t, output, cnt, v, N, R, f):
    global sta, lin
    if cnt == R:
        if f:
            sta += grp[output[0]][output[1]]
        else:
            lin += grp[output[0]][output[1]]
    for i in range(N):
        if v[i]:
          continue
        v[i] = True
        perm(t, output + [t[i]], cnt + 1, v, N, R, f)
        v[i] = False

def teams(v, N):
    global sta, lin
    start_ = []
    link_ = []
    visit = [False]*N
    output = []
    for i in range(N):
        if v[i]:
            start_.append(i)
        else:
            link_.append(i)
    sta, lin = 0, 0
    perm(start_, output, 0, visit, N//2, 2, True)
    perm(link_, output, 0, visit, N//2, 2, False)
    return abs(sta - lin)



combi(0, 0, v, n, n/2)
print(min_)

