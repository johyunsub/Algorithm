import math
n1, n2 = map(int, input().split())
gcd = math.gcd(n1, n2)
print(gcd, n1*n2//gcd)