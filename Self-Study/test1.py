n = int(input())
check = [n]
flag = False    #True: happy

arabNumbers = list(str(n))
while True:
    sum_ = 0
    for i in arabNumbers:
        sum_ += int(i)**2
    if sum_ == 1:
        flag = True
        break
    if sum_ in check:
        break
    check.append(sum_)
    arabNumbers = list(str(sum_))

if flag:
    print(n, "is Happy Number.")
else:
    print(n, "is Unhappy Number.")