def solution(s, n):
    alphabet_lower = [chr(i) for i in range(ord('a'), ord('z')+1)]
    alphabet_upper = [chr(i) for i in range(ord('A'), ord('Z')+1)]
    rotated_lower = alphabet_lower[n::] + alphabet_lower[:n:]
    rotated_upper = alphabet_upper[n::] + alphabet_upper[:n:]
    def find_char(c):
        if c in alphabet_lower:
            return rotated_lower[alphabet_lower.index(c)]
        elif c in alphabet_upper:
            return rotated_upper[alphabet_upper.index(c)]
        return c
    return ''.join(list(map(lambda c: find_char(c), s)))

print(solution("a B z", 4))