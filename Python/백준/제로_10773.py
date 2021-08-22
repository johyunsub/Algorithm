from sys import stdin
input()
s = []
for n in map(int, stdin):
    if n != 0:
        s.append(n)
        continue
    s.pop(-1)

print(sum(s))