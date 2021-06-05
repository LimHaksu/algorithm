def solution(sticker):
    if len(sticker) == 1:
        return sticker[0]
    # 첫번째 선택
    dp1 = [[0 for i in range(len(sticker))] for j in range(2)]
    dp1[0][0] = sticker[0]
    dp1[1][1] = sticker[0]
    for i in range(2, len(sticker)):
        dp1[0][i] = max(dp1[1][i-1] + sticker[i], dp1[0][i-1])
        dp1[1][i] = max(dp1[0][i-1], dp1[1][i-1])

    # 첫번째 선택X
    dp2 = [[0 for i in range(len(sticker))] for j in range(2)]
    dp2[0][1] = sticker[1]
    for i in range(2, len(sticker)):
        dp2[0][i] = max(dp2[1][i-1] + sticker[i], dp2[0][i-1])
        dp2[1][i] = max(dp2[0][i-1], dp2[1][i-1])

    return max(dp1[1][len(sticker)-1], dp2[0][len(sticker)-1])