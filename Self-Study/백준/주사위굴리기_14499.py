def roll_dice(r, c, d):     # 다음 칸값에 따른 주사위 상태 설정
    tmp = dice[5]
    if d == 1:      # 우
        dice[5] = dice[2]
        dice[2] = dice[0]
        dice[0] = dice[3]
        dice[3] = tmp
    elif d == 2:    # 좌
        dice[5] = dice[3]
        dice[3] = dice[0]
        dice[0] = dice[2]
        dice[2] = tmp
    elif d == 3:    # 상
        dice[5] = dice[1]
        dice[1] = dice[0]
        dice[0] = dice[4]
        dice[4] = tmp
    else:           # 하
        dice[5] = dice[4]
        dice[4] = dice[0]
        dice[0] = dice[1]
        dice[1] = tmp
    if grp[r][c] == 0:  # 다음 칸이 0일 경우
        grp[r][c] = dice[5]
    else:
        dice[5] = grp[r][c]
        grp[r][c] = 0
    return dice[0]


n, m, x, y, k = map(int, input().split())
grp = [list(map(int, input().split())) for _ in range(n)]
operations = list(map(int, input().split()))
dice = [0]*6
direction = [0, (0, 1), (0, -1), (-1, 0), (1, 0)]
for op in operations:
    nx, ny = x + direction[op][0], y + direction[op][1]
    if not (0 <= nx < n and 0 <= ny < m):
        continue
    x, y = nx, ny
    print(roll_dice(x, y, op))
