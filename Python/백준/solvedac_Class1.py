# 사칙연산_10869
a, b = map(int, input().split())
print(a+b, a-b, a*b, a//b, a%b)

# 아스키코드_11654
print(ord(input()))

# 별찍기_2438
n = int(input())
[print(''.join(['*'] * i)) for i in range(1, n+1)]

# 구구단_2739
n = int(input())
[print('{0} * {1} = {2}'.format(n, i, n*i)) for i in range(1, 10)]

# A+B-3_10950
[print(sum(map(int, input().split()))) for _ in range(int(input()))]

# A+B-4_10951
while True:
    try:
        print(sum(map(int, input().split())))
    except:
        break

# A+B-5_10952
while True:
    a, b = map(int, input().split())
    if a + b == 0:
        break
    print(a+b)

# 최댓값_2562
li = [int(input())for i in range(9)]
m = max(li)
print(m, li.index(m)+1)

# 문자열반복_2675
n = int(input())
for _ in range(n):
    r, st = input().split()
    print(''.join([s*int(r) for s in st]))
