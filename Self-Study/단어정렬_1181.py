n = int(input())
word = set()
for i in range(n):
    word.add(input())

word = sorted(word)
word = sorted(word, key=lambda x: len(x))
print("\n".join(word))
