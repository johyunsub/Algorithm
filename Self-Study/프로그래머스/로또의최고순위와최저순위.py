def solution(lottos, win_nums):
    score, zero_cnt, win_lotto = 0, 0, [False] * 46
    for w in win_nums:
        win_lotto[w] = True

    for lnum in lottos:
        if win_lotto[lnum]:
            score += 1
        if lnum == 0:
            zero_cnt += 1

    rank = [6, 6, 5, 4, 3, 2, 1]

    return [rank[score + zero_cnt], rank[score]]