def dfs(r,  queens):    #prams: 행과 퀸의 위치를 저장할 배열
    global nqueen   #가능한 경우
    if r == N-1:
        nqueen += 1
        return

    for i in range(N):      #한 열씩 탐색
        for q in queens:    #뽑았던 퀸들을 꺼냄
            if i == q[1]:   #퀸이 있는 열은 불가
                break
            if r + 1 - q[0] == abs(i - q[1]):   #이미 있는 퀸의 대각선도 불가
                break
        else:
            dfs(r + 1, queens + [[r + 1, i]])   #다음행과 퀸의 위치를 넣고 dfs태움


N = int(input())
nqueen = 0
for i in range(N):
    dfs(0, [[0, i]])
print(nqueen)

