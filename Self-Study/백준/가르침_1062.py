n, k = map(int, input().split())
words = []
w = k - 5
for _ in range(n):
    str_ = input()[4:-4]
    # antatica 인 경우 cnt++
    for i in ['a', 'c', 'i', 'n', 't']:
        if i in str_:
            str_ = str_.replace(i, '')
    words.append(str_)
# v = [False] * len(words)
max_ = 0
def dfs(s, w, words, selected):
    global max_
    if w <= 0 or s == len(words):
        # 단어 카운팅이 가장 큰 값
        cnt = 0
        for c in words:
            if c == '':
                cnt += 1
        max_ = max(max_, cnt)
        return
    for i in range(s, len(words)):
        tmp = []
        l = 0
        for j in list(words[i]):
            if j not in selected and j not in tmp:
                tmp.append(j)
                l += 1
        if l <= w:
            wc = words.copy()
            for t in tmp:
                for k in range(len(wc)):
                    if t in wc[k]:
                        wc[k] = wc[k].replace(t, '')
            dfs(i + 1, w - l, wc, selected + tmp)
        else:
            continue
dfs(0, k - 5, words, [])
print(max_)