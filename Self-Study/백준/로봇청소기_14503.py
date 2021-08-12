def robot(r, c, d, clean, turn_cnt):
    v[r][c] = True
    while True:
        nr, nc = r + dirct[go_left[d]][0], c + dirct[go_left[d]][1]     # 현방향에서의 왼쪽 좌표
        if turn_cnt == 4:       # 사방향을 돌았을 경우
            nr, nc = r + dirct[(d+2)%4][0], c + dirct[(d+2)%4][1]       # 현방향에서의 후진할 좌표
            if grp[nr][nc] == 1:
                return clean
            turn_cnt = 0
            r, c = nr, nc   # 후진할 다음 좌표로 이동
            continue
        elif 0 <= nr < n and 0 <= nc < m and grp[nr][nc] == 0 and not v[nr][nc]:
                d = go_left[d]      # 왼쪽으로 turn
                r, c = nr, nc       # 다음 좌표로 이동
                v[r][c] = True      # 청소 표시
                clean += 1          # 청소구역++
                turn_cnt = 0
                continue
        else:       #갈 수 없는 구역이거나 청소가 되어 있으면 왼쪽으로 turn
            d = go_left[d]
            turn_cnt += 1


n, m = map(int, input().split())
R, C, D = map(int, input().split())
grp = [list(map(int, input().split())) for _ in range(n)]
v = [[False]*m for _ in range(n)]
dirct = [(-1, 0), (0, 1), (1, 0), (0, -1)]
go_left = [3, 0, 1, 2]
print(robot(R, C, D, 1, 0))