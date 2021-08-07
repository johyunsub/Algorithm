n = int(input())
grp = [[False]*101 for _ in range(101)]
dr = [(0, 1), (-1, 0), (0, -1), (1, 0)]    # >, ^, <, v
for _ in range(n):
    x, y, d, g = map(int, input().split())
    s = [d]
    grp[y][x] = True
    x, y = x + dr[d][1], y + dr[d][0]       # 첫번째 방향으로 이동
    grp[y][x] = True
    for gen in range(g):
        tmp = [(i + 1) % 4 for i in s[::-1]]        # 스택에서 꺼내어 +1한 방향
        s += tmp
        for j in tmp:
            x, y = x + dr[j][1], y + dr[j][0]       # 해당 방향으로 다음 좌표 이동
            grp[y][x] = True

ans = 0
for i in range(100):
    for j in range(100):
        if grp[i][j] and grp[i+1][j] and grp[i][j+1] and grp[i+1][j+1]:     # 4쌍으로 탐색
            ans += 1
print(ans)
