w, h = map(int, input().split())
N = int(input())
loc = [list(map(int, input().split())) for _ in range(N+1)]

for i in range(N+1):    #북동남서 방향으로 일자로 폄
    d = loc[i][0]
    if d == 1:
        continue
    elif d == 2:
        loc[i][1] = 2*w + h - loc[i][1]
    elif d == 3:
        loc[i][1] = 2*w + 2*h - loc[i][1]
    elif d == 4:
        loc[i][1] = w + loc[i][1]

sum_ = 0
x = loc[N][1]
for i in range(N):
    diff1 = abs(x - loc[i][1])      #시계방향
    diff2 = 2 * (w + h) - diff1     #시계반대방향
    sum_ += diff1 if diff1 < diff2 else diff2

print(sum_)