n = int(input())
tower = [100000000] + list(map(int, input().split()))   #맨 앞에는 가장 큰 탑이 있다고 가정
s = [[0, 100000000]]
ans = []
for i in range(1, n+1):
    while True:    #스택에는 큰 탑 값만을 가짐
        if s[-1][1] >= tower[i]:    #가장 최근 지어진 탑보다 작으면 스택에 추가
            ans.append(s[-1][0])
            s.append([i, tower[i]])
            break
        s.pop(-1)   #그렇지 않으면 최근 지어진 탑은 지으려는 탑에 가려지고 필요없으므로 제거

print(*ans)
