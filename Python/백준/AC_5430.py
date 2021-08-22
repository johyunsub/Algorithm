tc = int(input())
for t in range(tc):
    p = list(input())
    n = int(input())
    item = []
    tmp = input()[1:-1]
    if tmp:
        item = tmp.split(',')
    flag = False
    revs = False
    for op in p:
        if op == 'R':
            revs = not revs
        else:
            if item:
                if revs:
                    item.pop(-1)
                else:
                    item.pop(0)
            else:
                flag = True
    if revs:
        item = item[::-1]

    if flag:
        print("error", end='\n')
    else:
        print('[' + ','.join(item) + ']', end='\n')


