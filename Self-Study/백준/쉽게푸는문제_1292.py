import sys
a, b = map(int, sys.stdin.readline().rstrip().split())
li = []
for i in range(1,b+1):
    li += [i]*i
print(sum(li[a-1:b]))