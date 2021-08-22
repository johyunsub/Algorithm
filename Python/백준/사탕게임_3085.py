def pang(r,c):
    global n, cndy, dr, dc
    clr = cndy[r][c]
    cnt = 1
    for d in range(4):
        if d%2 == 0:        #4방향에서 01은 세로, 23은 가로로 탐색
            count = cnt     #세로탐색이 끝나면 최종값 count 대입 후 cnt 초기화
            cnt = 1
        nr = r + dr[d]
        nc = c + dc[d]
        for _ in range(n):
            if nr >= n or nc >= n or nr < 0 or nc < 0:
                break
            elif clr == cndy[nr][nc]:   #같은 색깔일때, 다음위치 = 현재위치 + 진행방향
                nr += dr[d]
                nc += dc[d]
                cnt += 1
            else:
                break
    return max(count, cnt)


n = int(input())
cndy = [list(input()) for i in range(n)]
dr = [0, 0, 1, -1]
dc = [-1, 1, 0, 0]
totcnt = 0
for i in range(n):  #가로방향으로 한쌍씩 탐색
    for j in range(n-1):
        totcnt = max(totcnt, pang(i,j))     #1. 처음자리 확인
        cndy[i][j], cndy[i][j+1] = cndy[i][j+1], cndy[i][j]
        totcnt = max(totcnt, max(pang(i,j), pang(i, j+1)))  #2. 교환후 한쌍 확인
        cndy[i][j], cndy[i][j + 1] = cndy[i][j + 1], cndy[i][j]
    max(totcnt, pang(i,j+1))    #3. 행의 마지막자리 확인

for i in range(n-1):    #세로방향으로 한쌍씩 탐색
    for j in range(n):
        totcnt = max(totcnt, pang(i, j))
        cndy[i][j], cndy[i+1][j] = cndy[i+1][j], cndy[i][j]
        totcnt = max(totcnt, max(pang(i, j), pang(i+1, j)))
        cndy[i][j], cndy[i+1][j] = cndy[i+1][j], cndy[i][j]
    max(totcnt, pang(i+1, j))

print(totcnt)