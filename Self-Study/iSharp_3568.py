def reverse_(fromStr):
    toStr = ''
    idx = 0
    for i in range(len(fromStr)):
        if fromStr[i] in ('[', ']', '*', '&'):
            idx = i
            break
        toStr += fromStr[i]
    else:
        return ' ' + fromStr[:-1]
    toStr = ' ' + toStr
    for s in fromStr[idx:-1]:
        if s == '[':
            continue
        elif s == ']':
            toStr = '[]' + toStr
        else:
            toStr = s + toStr
    return toStr


in_ = input().split()
for i in range(1, len(in_)):
    print(in_[0] + reverse_(in_[i]) + ';')