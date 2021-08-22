import itertools, collections, copy


def bfs(q, grp_cp, cnt):    #바이러스 퍼진 면적 구하기
    while q:
        r, c = q.popleft()
        cnt += 1
        for nr, nc in [(r+1, c), (r-1, c), (r, c+1), (r, c-1)]:
            if not (0 <= nr < N and 0 <= nc < M):
                continue
            if grp_cp[nr][nc] >= 1:     #기존의 벽과 이미 퍼져있는 바이러스를 제외
                continue
            q.append([nr, nc])
            grp_cp[nr][nc] = 2      #바이러스 확산
    return cnt


N, M = map(int, input().split())
wall = 0
grp = []
for i in range(N):
    str_ = input()
    wall += str_.count('1')     #연구소 초기 벽의 개수
    grp.append(list(map(int, str_.split())))

min_ = 99999
que = collections.deque()
for i in range(N):      #바이러스 위치
    for j in range(M):
        if grp[i][j] == 2:
            que.append([i, j])

for t in itertools.combinations(range(N * M), 3):    #연구소에 3개의 벽을 세울 경우의 수
    grp_cp = copy.deepcopy(grp)
    new_wall = [[t[0] // M, t[0] % M],          #새로 세울 벽의 위치
                [t[1] // M, t[1] % M],
                [t[2] // M, t[2] % M]]
    grp_cp[new_wall[0][0]][new_wall[0][1]] = 1  #벽 세우기
    grp_cp[new_wall[1][0]][new_wall[1][1]] = 1
    grp_cp[new_wall[2][0]][new_wall[2][1]] = 1

    min_ = min(min_, bfs(copy.deepcopy(que), grp_cp, 0))    #바이러스 퍼져있는 면적 중 최소가 되는 경우

print(N*M - wall - 3 - min_)    #전체면적 - 기존 벽의 수 - 새로운 벽 - 바이러스가 퍼져있는 면적  == 안전영역
