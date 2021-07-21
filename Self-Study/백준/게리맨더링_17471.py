import sys

class Node:
    def __init__(self, item, link):
        self.item = item
        self.link = link

input = sys.stdin.readline
n = int(input())
people = list(map(int, input().split()))
grp = []
for i in range(1, n + 1):
    tmp = list(map(int, input().split()))
    grp.append(Node(item=i, link=tmp[1:]))

v = [False]*n
def combi(cnt,  d, N, R):
    if cnt == R:
        print(v)
        return
    for i in range(d, N):
        if v[i]:
            continue
        v[i] = True
        combi(cnt + 1, i+1, N, R)
        v[i] = False

combi(0, 1, n, n//2)

grp_v = [False]*n
def dfs(node, V, depth):
    grp_v = True
    link = node.link
    for i in link:
        dfs(node.link, V, depth + 1)



'''
6
5 2 3 4 1 2
2 2 4
4 1 3 6 5
2 4 2
2 1 3
1 2
1 2
'''