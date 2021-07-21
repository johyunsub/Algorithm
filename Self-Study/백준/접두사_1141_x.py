n = int(input())
words = [input() for _ in range(n)]

def sub_(cnt, li):
    global max_
    if cnt == n:
        max_ = max(max_, jubdusa(sorted(li)))
        return
    sub_(cnt + 1, li + [words[cnt]])
    sub_(cnt + 1, li)

def jubdusa(arr):
    l = len(arr)
    if l <= 1:
        return l
    for i in range(l-1):
        for j in range(i+1, l):
            if arr[i] in arr[j]:
                return -1
    return l

max_ = 0
sub_(0, [])
print(max_)
