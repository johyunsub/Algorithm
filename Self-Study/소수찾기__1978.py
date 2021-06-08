era = []
n = int(input())
li = list(map(int, input().split()))
for i in li:
    if i == 1:
        continue
    for j in range(2, i):
        if i%j == 0:
            break
    else:
        era.append(i)

print(len(era))