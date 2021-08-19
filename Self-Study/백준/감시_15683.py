import copy


def watch_cnt(dr, dc, r, c, grp_c):     # 해당 방향으로 감시되는 영역 계산 (벽이면 종료, 감시되는 영역: 9)
    cnt = 0
    for i in range(1, 8):
        nr, nc = r + dr * i, c + dc * i
        if not (0 <= nr < n and 0 <= nc < m):
            break
        if grp_c[nr][nc] == 6:
            break
        if grp_c[nr][nc] != 0:
            continue
        grp_c[nr][nc] = 9
        cnt += 1
    return cnt


def go(candi, grp_c):       # 1-5번 cctv에 따라 감시영역 계산
    tot_watch = 0
    for i in range(R):
        d = direction[cctv[i][0] - 1][candi[i]]     # cctv[i]: i번째 cctv종류,  candi[i]: i번째 cctv의 감시방향
        if cctv[i][0] == 1:
            tot_watch += watch_cnt(d[0], d[1], cctv[i][1], cctv[i][2], grp_c)
        elif cctv[i][0] == 2:
            tot_watch += watch_cnt(d[0], d[1], cctv[i][1], cctv[i][2], grp_c)
            tot_watch += watch_cnt(-d[0], -d[1], cctv[i][1], cctv[i][2], grp_c)
        elif cctv[i][0] == 3:
            tot_watch += watch_cnt(d[0], 0, cctv[i][1], cctv[i][2], grp_c)
            tot_watch += watch_cnt(0, d[1], cctv[i][1], cctv[i][2], grp_c)
        elif cctv[i][0] == 4:
            tot_watch += watch_cnt(-d[0], -d[1], cctv[i][1], cctv[i][2], grp_c)
            tot_watch += watch_cnt(-d[1], -d[0], cctv[i][1], cctv[i][2], grp_c)
            tot_watch += watch_cnt(d[1], d[0], cctv[i][1], cctv[i][2], grp_c)
        else:
            tot_watch += watch_cnt(-1, 0, cctv[i][1], cctv[i][2], grp_c)
            tot_watch += watch_cnt( 0, 1, cctv[i][1], cctv[i][2], grp_c)
            tot_watch += watch_cnt( 1, 0, cctv[i][1], cctv[i][2], grp_c)
            tot_watch += watch_cnt( 0,-1, cctv[i][1], cctv[i][2], grp_c)
    return n*m - (R + wall + tot_watch)   # 사각지대 = 전체 영역 - (cctv개수, 벽갯수, 감시영역)


def dfs(cnt, candi):    # cctv 방향에 따른 case들의 사각지대 계산
    global blind_spot
    if cnt == R:
        blind_spot = min(blind_spot, go(candi, copy.deepcopy(grp)))
        return
    if cctv[cnt][0] in (1, 3, 4):
        for d in range(4):
            dfs(cnt + 1, candi + [d])
    elif cctv[cnt][0] == 2:
        dfs(cnt + 1, candi + [0])
        dfs(cnt + 1, candi + [1])
    else:
        dfs(cnt + 1, candi + [0])


n, m = map(int, input().split())
grp = [list(map(int, input().split())) for _ in range(n)]
cctv = []           # cctv
R, wall = 0, 0      # cctv갯수, 벽갯수
blind_spot = 64     # 사각지대
for i in range(n):
    for j in range(m):
        if 1 <= grp[i][j] <= 5:
            cctv.append((grp[i][j], i, j))
            R += 1
        if grp[i][j] == 6:
            wall += 1

direction = [[(-1, 0), (0, 1), (1, 0), (0, -1)],        # 1번 cctv 감시방향
             [(1, 0), (0, 1)],                          # 2번 cctv 감시방향
             [(-1, 1), (1, 1), (1, -1), (-1, -1)],      # 3번 cctv 감시방향
             [(-1, 0), (0, 1), (1, 0), (0, -1)],        # 4번 cctv 감시방향
             [(0, 0)]]                                  # 5번 cctv 감시방향
dfs(0, [])
print(blind_spot)