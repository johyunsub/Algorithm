def isMedian(li):   #중앙값찾기
    li = sorted(li)
    len_ = len(li)
    if len_ % 2 == 0:  # 배열의 길이가 짝수일 경우 가운데 두값중 작은값 반환
        return min(li[len_ // 2], li[len_ // 2 - 1])
    return li[len_ // 2]


n, a, b = map(int, input().split())
nums = [1983]
sum_ = 1983

for i in range(1, n):
    nums.append((nums[i - 1] * (a + b)) % 20090711)
    sum_ += isMedian(nums)

print(sum_ % 20090711)
