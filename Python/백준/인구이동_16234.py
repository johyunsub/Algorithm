import collections


def bfs(r, c, sum_, cnt, v):        # 연합국 내에서 탐색, 인구이동할 나라들과 이동 후 인구수 반환
    land = []
    q = collections.deque()
    q.append((r, c, grp[r][c]))
    v[r][c] = True
    while q:
        r, c, people = q.popleft()
        land.append((r, c))
        sum_ += people
        cnt += 1
        for nr, nc in [(r+1, c), (r-1, c), (r, c+1), (r, c-1)]:
            if not (0 <= nr < n and 0 <= nc < n):
                continue
            if not (L <= abs(grp[nr][nc] - people) <= R):
                continue
            if v[nr][nc]:
                continue
            q.append((nr, nc, grp[nr][nc]))
            v[nr][nc] = True
    return {'land': land, 'population': sum_//cnt}


n, L, R = map(int, input().split())
grp = [list(map(int, input().split())) for _ in range(n)]
days = 0
while True:
    v = [[False]*n for _ in range(n)]
    dicts = []
    for i in range(n):
        for j in range(n):
            if v[i][j]:
                continue
            dicts.append(bfs(i, j, 0, 0, v))

    tot_move_cnt = 0    # 인구이동하는 나라의 갯수의 최대값
    for d in dicts:
        move_cnt = -1
        p = d['population']
        for loc in d['land']:   # 인구이동으로 인구수 조정
            grp[loc[0]][loc[1]] = p
            move_cnt += 1
        tot_move_cnt = max(tot_move_cnt, move_cnt)
    if tot_move_cnt == 0:       # 더이상 인구이동이 없다면 break
        break
    days += 1

print(days)
