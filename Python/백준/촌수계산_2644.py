import collections
n = int(input())
start_, end_ = map(int, input().split())
adj = [[False]*(n+1) for _ in range(n+1)]   #인접행렬
for _ in range(int(input())):
    p, c = map(int, input().split())
    adj[c][p] = adj[p][c] = True
v = [False]*(n+1)


def bfs(s, e, cnt, v, adj):
    q = collections.deque()
    q.append([s, cnt])
    v[s] = True
    while q:
        s, cnt = q.popleft()
        if s == e:
            return cnt
        for i in range(1, n+1): #인접행렬에서 직계관계만 push
            if not adj[s][i]:
                continue
            if v[i]:
                continue
            q.append([i, cnt+1])
            v[i] = True
    return -1


print(bfs(start_, end_, 0, v, adj))