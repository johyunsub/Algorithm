def bs(arr, target, length):
    s, e, m = 0, length-1, length//2
    while s <= e:
        if target < arr[m]:     #중간 값보다 작을경우
            e = m - 1
            m = (s + e)//2
        elif target > arr[m]:   #중간 값보다 클경우
            s = m + 1
            m = (s + e)//2
        else:       #중간값이면 True
            return True
    return False    #범위에 해당되지 않으면면 False


N = int(input())
nums = sorted(list(map(int, input().split())))
M = int(input())
find_num = list(map(int, input().split()))

for f in find_num:
    if bs(nums, f, N):
        print(1)
    else:
        print(0)
