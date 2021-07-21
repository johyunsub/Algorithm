n = int(input())
cnt = 0
for i in range(1, n+1):
    litteral = list(str(i))
    if len(litteral) > 1:
        diff = int(litteral[1]) - int(litteral[0])
    flag = False
    for j in range(1, len(litteral)):
        if diff == int(litteral[j]) - int(litteral[j-1]):
            continue
        flag = True
    if not flag:
        cnt += 1

print(cnt)