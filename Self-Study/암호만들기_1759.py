l, c = map(int, input().split())
chars = sorted(list(map(str, input().split())))
v = [False]*c


def perm(depth, res, mo, ja, ans):
    if depth == l and mo >= 1 and ja >= 2:  #뽑은 수가 l개이고 모음이 1개이상 자음이 2개이상
        ans += ''.join(res) + '\n'
        return ans  #ans에 암호문 추가로 얹기
    for i in range(c):
        ch = chars[i]
        if v[i] or len(res) > 0 and ch < res[-1]:   #방문체크 & 추가하려는 문자가 res의 마지막 문자보다 사전상으로 앞서면 pass
            continue
        v[i] = True
        if ch in "aeiou":
            ans = perm(depth + 1, res + [ch], mo + 1, ja, ans)   #ans에 리턴값 ans 대입
        else:
            ans = perm(depth + 1, res + [ch], mo, ja + 1, ans)
        v[i] = False
    return ans


ans_ = ''
ans_ = perm(0, [], 0, 0, ans_)
print(ans_)