n = int(input())
li = []
ans = []
for _ in range(n):
    li.append(list(map(int, input().split())))

for i in range(n):
    cnt = 1
    for j in range(n):
        if li[i][0] < li[j][0] and li[i][1] < li[j][1]:
           cnt += 1
    ans.append(cnt)
print(*ans)