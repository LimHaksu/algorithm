def solution(n, words):
    word_set = set()
    last_word = words[0][0]
    for i, word in enumerate(words):
        if word in word_set or last_word[-1] != word[0]:
            turn = i // n + 1
            person = i % n + 1
            return [person, turn]
        else:
            last_word = word
            word_set.add(word)
    return [0,0]