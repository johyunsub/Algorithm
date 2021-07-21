li = [0, 1]
idx1 = 0
idx2 = 1
n = int(input())
for _ in range(n-1):
    li.append(li[idx1] + li[idx2])
    idx1 += 1
    idx2 += 1
print(li[n])
