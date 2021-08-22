def rotate_gears(g, d):     # 돌려야 할 각 톱니바퀴들을 bfs로 탐색하여 spin에 삽입
    spin = []
    q = [(g, d)]
    v = [False]*4
    v[g] = True
    while q:
        g, d = q.pop(0)
        spin.append((g, d))
        if g-1 >= 0 and gear[g-1][2] ^ gear[g][6] and not v[g-1]:   # 좌측 톱니바퀴와 톱니가 다르고 방문x
            v[g-1] = True
            q.append((g-1, -d))
        if g+1 < 4 and gear[g+1][6] ^ gear[g][2] and not v[g+1]:    # 우측 톱니바퀴와 톱니가 다르고 방문x
            v[g+1] = True
            q.append((g+1, -d))
    while spin:
        g, d = spin.pop(0)
        spin_one_gear(g, d)     # 톱니바퀴 회전


def spin_one_gear(g, d):    # 톱니바퀴 회전
    if d == 1:
        gear[g] = [gear[g][-1]] + gear[g][0:-1]
    else:
        gear[g] = gear[g][1::] + [gear[g][0]]


gear = [list(map(int, list(input()))) for _ in range(4)]
k = int(input())
for _ in range(k):
    g, d = map(int, input().split())
    rotate_gears(g-1, d)
print(sum([gear[i][0] * (2 ** i) for i in range(4)]))
