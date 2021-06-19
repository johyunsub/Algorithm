text_ = input()
ref_ = []
l = len(text_)
i = 0
while i < l:
    if text_[i] == '[':
        while text_[i] != ']':
            words = ""
            i += 2
            while text_[i] != ',' and text_[i] != ']':
                words += text_[i]
                text_[i].replace(text_[i], '')
                i += 1
            ref_.append(words)
    i += 1

print(text_)
print(ref_)