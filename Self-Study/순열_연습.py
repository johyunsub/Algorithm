nums = [1, 5, 3, 4]
output = []
v= [False]*len(nums)
def perm(nums, output, cnt, v, N, R):
    if cnt == R:
        print(output)
    for i in range(N):
        if v[i]:
          continue
        v[i] = True
        perm(nums, output + [nums[i]], cnt + 1, v, N, R)
        v[i] = False
perm(nums, output, 0, v, 4, 3)
