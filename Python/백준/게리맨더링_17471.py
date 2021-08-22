class Node:
    def __init__(self, item, link):
        self.item = item
        self.link = link


def dfs(node, V, depth, grp_v):     #같은 선거구로 연결된 도시들을 탐색
    part = V[node.item - 1]         #True선거구 or False선거구
    grp_v[node.item - 1] = True     #도시 방문체크
    link = node.link                #도시의 연결된 다른 지역들
    for i in link:
        if grp_v[i - 1]:            #방문하지 않았고
            continue
        if V[i - 1] ^ part:         #같은 선거구이면
            continue
        dfs(grp[i - 1], V, depth + 1, grp_v)    #다음 선거구로 태워보냄


def subset(cnt, V, N, R):   #부분집합 V[True인 선거구와 False인 선거구]
    global ans
    if cnt == N:    #N개까지 뽑는 경우: 부분집합 생성
        grp_v = [False] * n     #부분집합 중에서 방문체크 배열
        partition = 0
        for j in range(n):
            if not grp_v[j]:
                dfs(grp[j], v, 0, grp_v)
                partition += 1

        if partition == 2:  #연결된 시의 갯수가 2인 경우만
            sum = 0
            for i in range(n):
                if v[i]:    #True인 선거구의 인구수만 더함
                    sum += people[i]
                else:       #False인 선거구의 인구수만 더함
                    sum -= people[i]
            ans = min(ans, abs(sum))
        return

    V[cnt] = True
    subset(cnt + 1, V, N, R)    #하나씩 뽑을 경우와
    V[cnt] = False
    subset(cnt + 1, V, N, R)    #안뽑을 경우


n = int(input())
people = list(map(int, input().split()))
grp = []
for i in range(1, n + 1):
    tmp = list(map(int, input().split()))
    grp.append(Node(item=i, link=tmp[1:]))

v = [False] * n
ans = 999999
subset(1, v, n, n // 2)

if ans == 999999:
    print(-1)
else:
    print(ans)
