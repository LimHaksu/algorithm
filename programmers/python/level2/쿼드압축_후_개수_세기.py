def solution(arr):
    check_list = [[True for j in range(len(arr))] for i in range(len(arr))]
    compress(arr, 0, 0, len(arr), check_list)
    count = [0,0]
    for i in range(len(check_list)):
        for j in range(len(check_list)):
            if check_list[i][j]:
                count[arr[i][j]] += 1
    return count

def compress(arr, r,c,l, check_list):
    if is_all_equal(arr, r, c, l):
        check_false(check_list, r, c, l)
    else:
        m = l // 2
        # 1사분면
        compress(arr, r, c+m, m, check_list)
        # 2사분면
        compress(arr, r,c,m, check_list)
        # 3사분면
        compress(arr, r+m, c, m, check_list)
        # 4사분면
        compress(arr, r+m, c+m, m, check_list)

def check_false(check_list, r, c, l):
    for i in range(r, r+l):
        for j in range(c, c+l):
            check_list[i][j] = False
    check_list[i][j] = True

def is_all_equal(arr, r,c,l):
    val = arr[r][c]
    for i in range(r, r+l):
        for j in range(c, c+l):
            if val != arr[i][j]:
                return False
    return True

print(solution([[1,1,0,0],[1,0,0,0],[1,0,0,1],[1,1,1,1]]))