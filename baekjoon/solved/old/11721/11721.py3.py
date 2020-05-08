word = input()
i = 0
while i < len(word):
    print(word[i:min(i+10,len(word))])
    i += 10