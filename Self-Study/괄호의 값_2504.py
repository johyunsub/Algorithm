str_ = list(input())
s = []
flag = False    #반례에 해당될 때: True
for i in str_:
    if i == '(':    # (, [ 는 단순 삽입
        s.append('(')
    elif i == '[':
        s.append('[')
    elif i == ')':
        if not s:   # 닫힌 괄호만 들어오는 반례 제거
            break
        top_ = s[len(s) - 1]
        if top_ == '(':     # () 로 바로 닫히는 경우: 2 삽입
            s.pop()
            s.append(2)
        elif top_ in (')', ']', '['):   #반례 제거
            flag = True
            break
        else:   # 괄호 안 숫자가 있는 경우 ex) (2), [3]
            j = len(s)-1
            sum_ = 0
            while j >= 0:   # 괄호 안 숫자 정리 ex) ( 2  9 ) => ( 11 )
                if s[j] in (']', '[', '(', ')'):
                    break
                sum_ += int(s.pop(j))
                j -= 1
            if s:
                if s.pop() != '(':  # ()) 반례 제거
                    flag = True
                    break
                s.append(sum_ * 2)
    elif i == ']':
        if not s:
            break
        top_ = s[len(s) - 1]
        if top_ == '[':
            s.pop()
            s.append(3)
        elif top_ in (']', '(', ')'):
            flag = True
            break
        else:
            j = len(s)-1
            sum_ = 0
            while j >= 0:
                if s[j] in (']', '[', '(', ')'):
                    break
                sum_ += int(s.pop(j))
                j -= 1
            if s:
                if s.pop() != '[':
                    flag = True
                    break
                s.append(sum_ * 3)

if flag or not s or '(' in s or ')' in s or '[' in s or ']' in s:
    print(0)
else:
    print(sum(s))