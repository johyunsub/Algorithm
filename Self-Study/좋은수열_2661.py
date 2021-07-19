def dfs(seq, depth):
    if depth > 0 and not isGoodPerm(seq, depth):    #좋은 수열이 아니면 False를 반환시켜 1,2,3 중 다음에 올 수를 dfs에 태움
        return False
    if depth == N:  #좋은 수열이고 N만큼 뽑으면 수열출력 후 끝까지 탐색 안하도록 True를 리턴시켜 dfs를 종료시키도록 함
        print(seq)
        return True

    if dfs(seq + '1', depth + 1):
        return True
    if dfs(seq + '2', depth + 1):
        return True
    if dfs(seq + '3', depth + 1):
        return True


def isGoodPerm(seq, d):
    for i in range(1, d//2 + 1):
        if seq[-2 * i:-1 * i] == seq[-1 * i:]:  #문자열 끝에서부터 1:1, 2:2, 3:3 ... d/2:d/2 씩 짝으로 같은지 비교
            return False    #나쁜 수열
    return True     #좋은 수열


N = int(input())
dfs('', 0)
