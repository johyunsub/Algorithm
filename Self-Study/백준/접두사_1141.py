n = int(input())
words = [input() for _ in range(n)]
words.sort()
words = sorted(words, key=lambda x: len(x))
l = len(words)
cnt = 0
for i in range(l-1):
    for j in range(i+1, l):
        if words[i] == words[j][:len(words[i])]:
            cnt += 1
            break

print(l-cnt)
