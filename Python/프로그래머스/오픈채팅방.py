def solution(record):
    answer = []
    _rec = []
    _dict = dict()
    for r in record:
        rec = r.split()
        _rec.append(rec)
        if not rec[0] == "Leave":
            _dict[rec[1]] = rec[2]

    for r in _rec:
        if r[0] == "Enter":
            answer.append(_dict[r[1]] + "님이 들어왔습니다.")
        elif r[0] == "Leave":
            answer.append(_dict[r[1]] + "님이 나갔습니다.")

    return answer