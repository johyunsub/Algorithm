n = int(input())
nums = list(map(int, input().split()))
op = list(map(int, input().split()))
min_, max_ = 1e9, -1e9

def perm(cnt, op, res):
    global max_, min_
    if cnt == n - 1:
        max_ = max(max_, res)
        min_ = min(min_, res)
        return

    if op[0]:
        op[0] -= 1
        perm(cnt + 1, op, res + nums[cnt + 1])
        op[0] += 1
    if op[1]:
        op[1] -= 1
        perm(cnt + 1, op, res - nums[cnt + 1])
        op[1] += 1
    if op[2]:
        op[2] -= 1
        perm(cnt + 1, op, res * nums[cnt + 1])
        op[2] += 1
    if op[3]:
        op[3] -= 1
        perm(cnt + 1, op, int(res/nums[cnt + 1]))
        op[3] += 1

perm(0, op, nums[0])
print(max_)
print(min_)
