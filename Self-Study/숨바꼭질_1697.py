from collections import deque
N, K = map(int, input().split())
v = set()


def bfs(num, cnt):
    q = deque()
    q.append([num, cnt])
    v.add(num)
    while q:
        num, cnt = q.popleft()
        if num == K:
            return cnt
        for next_ in [(num-1), (num+1), (num*2)]:
            if not (0 <= next_ < 100001):
                continue
            if next_ in v:
                continue
            q.append([next_, cnt+1])
            v.add(next_)


print(bfs(N, 0))