class Node:
    def __init__(self, c):
        self.c = c
        self.next = {}
        self.length_count = {}

def solution(words, queries):
    answer = []
    root_front = Node('')
    root_back = Node('')
    # words로 trie 만들기 앞에서부터
    for word in words:
        word_length = len(word)
        current_node = root_front
        if word_length not in current_node.length_count:
            current_node.length_count[word_length] = 1
        else:
            current_node.length_count[word_length] += 1
        for c in word:
            if c not in current_node.next:
                current_node.next[c] = Node(c)
            current_node = current_node.next[c]
            if word_length not in current_node.length_count:
                current_node.length_count[word_length] = 1
            else:
                current_node.length_count[word_length] += 1
        # 뒤에서부터    
        current_node = root_back
        if word_length not in current_node.length_count:
            current_node.length_count[word_length] = 1
        else:
            current_node.length_count[word_length] += 1
        for c in word[::-1]:
            if c not in current_node.next:
                current_node.next[c] = Node(c)
            current_node = current_node.next[c]
            if word_length not in current_node.length_count:
                current_node.length_count[word_length] = 1
            else:
                current_node.length_count[word_length] += 1

    # queries
    for query in queries:
        count = 0 
        word_length = len(query)
        if query[-1] == '?':
            current_node = root_front
        else:
            current_node = root_back
            query = query[::-1]
        for c in query:
            if c == '?':
                if word_length not in current_node.length_count:
                    count = 0
                    break
                count = current_node.length_count[word_length]
                break
            if c in current_node.next:
                current_node = current_node.next[c]
                if word_length not in current_node.length_count:
                    count = 0
                    break
                count = current_node.length_count[word_length]
            else:
                count = 0
                break
        answer.append(count)
    return answer

print(solution(["frodo", "front", "frost", "frozen", "frame", "kakao", "a"], ["froo??"]))