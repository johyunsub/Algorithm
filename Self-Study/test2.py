tc = int(input())
for _ in range(tc):
    L = int(input())
    uid = [input().split('-') for i in range(3)]
    cnt = 0
    for i in range(L):
        low  = bin(int(uid[0][i]))[2:].zfill(8) #저온에서 255-128-3 값을  => 11111111, 10000000, 00000011으로 변환
        hi   = bin(int(uid[1][i]))[2:].zfill(8)
        comm = bin(int(uid[2][i]))[2:].zfill(8)
        for j in range(8):
            sum_ = low[j] + hi[j] + comm[j]
            if sum_ != '000' and sum_ != '111': #불안정한 비트이므로 cnt++
                cnt += 1
    print(cnt)

