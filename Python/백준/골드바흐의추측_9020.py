import sys
input = sys.stdin.readline

is_prime = [False, False] + [True]*(10001)  #에라토스테네스 체
prime = []  #소수
for i in range(2, 10001):
    if is_prime[i]:         #아직 탐색 안했으면 소수
        prime.append(i)
        for j in range(i+i, 10001, i):  #에라토스테네스 알고리즘
            is_prime[j] = False

tc = int(input())
for _ in range(tc):
    n = int(input())
    res = []    #n/2까지의 수중 소수만 저장될 배열
    for i in prime:     #소수들을 하나씩 꺼내어
        if i <= n - i and is_prime[n - i]:  #범위안에서 n의 끝에서부터 i번째의 수가 소수이면 i와 n-i 둘다 소수
            res.append(i)
    print(max(res), n - max(res))
