n = int(input())
img = [list(input()) for _ in range(n)]


def dfs(r, c, d):
    if d == 1:
        return img[r][c]
    d //= 2
    a = ''  #깊이마다 문자열을 저장

    a += dfs(r, c, d)           #왼쪽위
    a += dfs(r, c + d, d)       #오른쪽위
    a += dfs(r + d, c, d)       #왼쪽아래
    a += dfs(r + d, c + d, d)   #오른쪽아래

    if a == '0000':
        return '0'
    elif a == '1111':
        return '1'
    else:
        return '(' + a + ')'


print(dfs(0, 0, n))
