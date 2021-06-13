h, w = map(int, input().split())
li = list(map(int, input().split()))
land = [[0 for i in range(w)] for i in range(h)]
k = 0
for i in li:
    for j in range(i):
        land[j][k] = 1
    k += 1
totWater = 0
for i in range(h):
    j = -1
    while j < w:
        j += 1
        water = 0
        if j+1 < w-1 and land[i][j] == 1 and land[i][j+1] == 0: #땅에서 물이 시작되는 부분
            for k in range(j+1, w):
                water += 1
                if k+1 < w and land[i][k+1] == 1:   #물에서 땅까지 길이 계산
                    totWater += water
                    j = k-1
                    break

print(totWater)




