def dfs(node1):
    global v, li
    v[node1] = True
    print(node1, end=" ")
    for i in range(1, n+1):
        if v[i]:
            continue
        if li[node1][i] == 1:
            dfs(i)


def bfs(node2):
    global v, li
    v[node2] = True
    q = [node2]

    while len(q) > 0:
        tmp = q.pop(0)
        print(tmp, end=" ")
        for i in range(1, n+1):
            if v[i]:
                continue
            if li[tmp][i] == 1:
                v[i] = True
                q.append(i)



n,m,s = map(int, input().split())
li = [[0 for i in range(n+1)] for j in range(n+1)]
v = [False for i in range(n+1)]
for _ in range(m):
    r,c = map(int, input().split())
    li[r][c] = 1
    li[c][r] = 1

dfs(s)
print()
v = [False for i in range(n+1)]
bfs(s)



