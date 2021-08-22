N = int(input())
shark_traveled = 0      #상어 총 이동거리
shark_size = 2          #상어의 크기
shark_eaten = 0         #상어 먹은횟수
shark_location = [0, 0]     #현재 상어의 위치
Map = [list(map(int, input().split())) for _ in range(N)]
for i in range(N):
    for j in range(N):
        if Map[i][j] == 9:
            shark_location = [i, j]
            break


def bfs(r, c, cnt):     #상어의 현재위치에서 가장 가까운 물고기까지의 이동거리 계산
    global shark_eaten, shark_size, shark_traveled, shark_location
    v = [[False]*N for _ in range(N)]
    q = [[r, c, cnt]]
    v[r][c] = True
    flag = 0
    while q:
        if q[0][2] != flag:     #한껍질씩 뻗어갈 때마다 정렬(상좌우하 순으로 큐에서 꺼냄)
            q.sort()
            flag += 1
        r, c, cnt = q.pop(0)

        if 0 < Map[r][c] < shark_size:  #현재 위치가 물고기일 경우
            shark_eaten += 1
            Map[shark_location[0]][shark_location[1]] = 0   #원래의 상어의 위치 초기화
            Map[r][c] = 0                                   #물고기의 위치 초기화
            shark_location = [r, c]
            if shark_eaten >= shark_size:   #상어 몸집만큼 먹었을 때 상어 크기증가
                shark_size += 1
                shark_eaten = 0
            shark_traveled += cnt
            return True     #물고기를 만난 경우 종료
        for nr, nc in [(r-1, c), (r, c-1), (r, c+1), (r+1, c)]:
            if not (0 <= nr < N and 0 <= nc < N):
                continue
            if v[nr][nc]:
                continue
            if Map[nr][nc] > shark_size:
                v[nr][nc] = True
                continue
            q.append([nr, nc, cnt+1])
            v[nr][nc] = True
    return False    #엄마상어 부를 경우


while bfs(shark_location[0], shark_location[1], 0):
    pass

print(shark_traveled)
