li = []
sum = 0
for _ in range(9):
    n = int(input())
    li.append(n)
    sum += n

breaker = False
for i in range(8):
    for j in range(i+1,9):
        if sum - (li[i] + li[j]) == 100:
            a = li[i]
            b = li[j]
            li.remove(a)
            li.remove(b)
            breaker = True
            break
    if breaker:
        break

print(*sorted(li))
