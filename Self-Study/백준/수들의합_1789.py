sum_ = int(input())
n = int(sum_**0.5) #근사값에서 시작
while n*(n+1)/2 <= sum_:  #n까지의 합이 sum보다 클경우 n-1개를 선택하여 sum을 만들 수 있다.
    n += 1
if sum_ == 1:
    print(1)
else:
    print(n-1)