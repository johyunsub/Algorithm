import heapq
import sys

input = sys.stdin.readline
inf = int(1e9)

V, E = map(int, input().split())
start = int(input())
grp = [[] for _ in range(V+1)]
for _ in range(E):
    u, v, w = map(int, input().split())
    grp[u].append([v, w])

distances = [inf]*(V+1)    # 시작점에서 index까지 오는 데 걸린 가중치 값
distances[start] = 0
q = []
heapq.heappush(q, [distances[start], start])    # 최소힙에는 [가중치값, index]로 저장

while q:
    cur_dist, cur_destin = heapq.heappop(q)
    if distances[cur_destin] < cur_dist:    # 기존에 있는 거리보다 길다면, 볼 필요도 없음
        continue
    for new_destin, new_dist in grp[cur_destin]:
        distance = cur_dist + new_dist      # 해당 노드를 거쳐 갈 때 거리
        if distance < distances[new_destin]:       # 알고 있는 거리 보다 작으면 갱신
            distances[new_destin] = distance
            heapq.heappush(q, [distance, new_destin])      # 다음 인접 거리를 계산 하기 위해 큐에 삽입

for i in range(1, V+1):
    dist = distances[i]
    if dist < inf:
        print(dist)
    else:
        print('INF')
