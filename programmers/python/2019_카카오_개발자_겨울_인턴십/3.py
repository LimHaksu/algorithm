from itertools import permutations
def solution(user_id, banned_id):
    ans_set = set()
    for permu in permutations(user_id, len(banned_id)):
        if is_valid(permu, banned_id):
            ans_set.add(','.join(sorted(permu)))
    return len(ans_set)

def is_valid(user_id_permu, banned_id):
    for i in range(len(banned_id)):
        if id_validation(user_id_permu[i], banned_id[i]) == False:
            return False
    return True

def id_validation(user_id, banned_id):
    if len(user_id) != len(banned_id):
        return False
    for i in range(len(banned_id)):
        b = banned_id[i]
        u = user_id[i]
        if b == '*':
            continue
        if b != u:
            return False
    return True

print(solution(["frodo", "fradi", "crodo", "abc123", "frodoc"], ["fr*d*", "*rodo", "******", "******"]))