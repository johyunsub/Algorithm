def solution(board, moves):
    answer = 0
    s = []
    n = len(board)
    while moves:
        loc = moves.pop(0)-1
        for i in range(0, n):
            if board[i][loc] > 0:
                s.append(board[i][loc])
                board[i][loc] = 0
                if len(s) > 1 and s[-1] == s[-2]:
                    s.pop()
                    s.pop()
                    answer += 2
                break

    return answer

board1= [[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]
moves1 = [1,5,3,5,1,2,1,4]
print(solution(board1, moves1))


