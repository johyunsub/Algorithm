import re
in_ = input()
nums = list(map(int, re.split('[-+]', in_)))
op = re.split('[0-9]+', in_)
for i in range(len(op)):
    if op[i] == '-':
        break
print(sum(nums[:i]) - sum(nums[i::]))

