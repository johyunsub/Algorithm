tc = int(input())
for _ in range(tc):
    n, m = map(int, input().split())
    weights = list(map(int, input().split()))
    printerq = list(zip(list(range(n)), weights))   # 인덱스와 중요도를 묶은 프린터큐
    weights.sort(reverse=True)      # 중요도순으로 뽑기위해 내림차순 정렬
    i = 0   # 현재까지 뽑은 개수
    while True:
        idx, w = printerq.pop(0)
        if weights[0] == w:         # 하나씩 뽑았을 때 중요도가 현재 프린터큐에서 가장 크고
            weights.pop(0)
            i += 1
            if idx == m:            # 찾고 있는 문서일 경우 현재까지 뽑은 개수 출력
                print(i)
                break
            continue                # 찾고 있는 문서가 아니면 프린터큐에 다시 넣지 않음
        printerq.append((idx, w))
