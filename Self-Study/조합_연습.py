nums = [1, 2, 3, 4]
output = []
v = [False]*len(nums)
def combi(nums, output, cnt, depth, N, R):
    if cnt == R:
        print(output)
    for i in range(depth,N):
        if v[i]:
            continue
        v[i] = True
        combi(nums, output + [nums[i]], cnt + 1, i+1, N, R)
        v[i] = False

combi(nums, output, 0, 0, 4, 3)