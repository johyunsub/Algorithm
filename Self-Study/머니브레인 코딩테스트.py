

def substringCalculator(s):
    # Write your code here
    set_ = set()
    for i in range(len(s)): #0-9
        tmp = s[i:]
        for j in range(len(tmp), 0, -1): #9-0
            if tmp[:j] not in set_:
                set_.add(tmp[:j])
    return len(set_)


ans = substringCalculator("kincenvizh")
print(ans)