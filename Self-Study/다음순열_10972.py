n = int(input())
nums = list(map(int, input().split()))
l = len(nums)
x = l - 2
y = l - 1
breaker = False
while x >= 0:   #뒤에서부터 한쌍씩 탐색
    if breaker:
        break
    if nums[x] < nums[y]:   #만약 뒤에 수가 더 클 경우
        y = l - 1   #y만 뒤에서부터 다시 탐색
        num = nums[x]
        while x < y:    #y를 x까지만 탐색
            if num < nums[y]:   #x자리 수 보다 y자리 수가 더 클경우 서로 swap
                nums[x], nums[y] = nums[y], nums[x]
                ans = nums[:x + 1]
                ans += sorted(nums[x+1 :])  #처음부터 x자리까지와 x자리부터 끝까지는 정렬한 수를 합침
                breaker = True
                break
            y -= 1
        break
    x -= 1
    y -= 1

if breaker:
    print(*ans)
else:
    print(-1)
