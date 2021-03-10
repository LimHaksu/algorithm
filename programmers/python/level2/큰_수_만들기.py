from collections import deque
def solution(number, k):
    st = deque()
    for num in number:
        n = int(num)
        if len(st) == 0:
            st.append(n)
        else:
            while len(st) > 0 and st[-1] < n and k > 0:
                st.pop()
                k -= 1
            st.append(n)
    while k > 0:
        st.pop()
        k -= 1
    return ''.join(map(str,st))

print(solution('1924', 2))