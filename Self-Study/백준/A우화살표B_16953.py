def bfs(s, e):
    cnt = 1
    q = [[s, cnt]]
    while q:
        num, cnt = map(int, q.pop(0))
        if num == e:
            return cnt
        elif num > e:
            continue
        q.append([num*2, cnt + 1])
        q.append([num*10 + 1, cnt + 1])
    return -1

a, b = map(int, input().split())
print(bfs(a, b))