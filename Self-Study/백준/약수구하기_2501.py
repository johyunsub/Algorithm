n, k = map(int, input().split())
li = [i for i in range(1, n+1) if n%i == 0]
if k > len(li):
    print(0)
else:
    print(li[k - 1])
