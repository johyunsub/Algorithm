n, s = map(int, input().split())
nums = list(map(int, input().split()))


def dfs(idx, res):  #부분집합
    global cnt
    if idx == n:
        if res == s:
            cnt += 1
        return
    dfs(idx + 1, res)
    dfs(idx + 1, res + nums[idx])


cnt = 0
dfs(0, 0)
if s:
    print(cnt)
else:   #합이 0인 경우에, 하나도 안뽑을 때 초기값 0 그대로 빠져 나오므로 이 경우를 cnt에서 뺌
    print(cnt - 1)