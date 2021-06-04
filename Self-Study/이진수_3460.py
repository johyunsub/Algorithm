t = int(input())
for i in range(t):
    r = []
    n = int(input())
    while n > 0:
        r.append(n%2)
        n //= 2

    for j in range(len(r)):
        if r[j] == 1:
            print(j, end=" ")