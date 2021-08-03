N = int(input())
shark_traveled = 0
shark_size = 2
shark_eaten = 0
shark_location = [0, 0]
Map = [list(map(int, input().split())) for _ in range(N)]
for i in range(N):
    for j in range(N):
        if Map[i][j] == 9:
            shark_location = [i, j]
            break


def bfs(r, c, cnt):
    global shark_eaten, shark_size, shark_traveled, shark_location
    v = [[False]*N for _ in range(N)]
    q = [[r, c, cnt]]
    v[r][c] = True
    flag = 0
    while q:
        if q[0][2] != flag:
            q = sorted(q)
            flag = q[0][2]
        r, c, cnt = q.pop(0)

        if 0 < Map[r][c] < shark_size:
            shark_eaten += 1
            Map[shark_location[0]][shark_location[1]] = 0
            Map[r][c] = 9
            shark_location = [r, c]
            if shark_eaten >= shark_size:
                shark_size += 1
                shark_eaten = 0
            shark_traveled += cnt
            return False
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
    return True


while True:
    if bfs(shark_location[0], shark_location[1], 0):
        break

print(shark_traveled)
