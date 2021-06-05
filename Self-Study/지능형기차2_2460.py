pple = 0
max = 0
for i in range(10):
    out_, in_ = map(int, input().split())
    pple += in_
    pple -= out_
    if pple > max:
        max = pple

print(max)