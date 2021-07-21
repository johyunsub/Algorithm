import sys
t = int(input())
for _ in range(t):
    li = list(map(int, sys.stdin.readline().split()))
    li.sort(reverse=True)
    print(li[2])