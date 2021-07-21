import collections
n, m = map(int, input().split())
ladder = [list(map(int, input().split())) for _ in range(n+m)]
v = [False]*101

def bfs(x, cnt, v):
    q = collections.deque()
    q.append([x, cnt])
    v[x] = True
    while q:
        x, cnt = q.popleft()
        if x == 100:
            return cnt
        for nx in [x+1, x+2, x+3, x+4, x+5, x+6]:
            if nx > 100 or v[nx]:
                continue
            for i in range(n+m):
                if ladder[i][0] == nx:
                    q.append([ladder[i][1], cnt + 1])
                    v[ladder[i][1]] = True
                    break
            else:
                q.append([nx, cnt + 1])
                v[nx] = True

print(bfs(1, 0, v))