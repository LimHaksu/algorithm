from collections import deque
class Node:
    def __init__(self, num, amount):
        self.num = num
        self.amount = amount
        self.parent = None
        self.children = []
        self.level = None
    def __lt__(self, other):
        return self.level > other.level
def solution(a, edges):
    adj_list = [[] for i in range(len(a))]
    nodes = []
    for i in range(len(a)):
        amount = a[i]
        nodes.append(Node(i, amount))
    for edge in edges:
        f, t = edge
        adj_list[f].append(t)
        adj_list[t].append(f)
    visited = [False for i in range(len(a))]
    root_node = nodes[0]
    visited[0] = True
    root_node.level = 0
    make_tree(root_node, adj_list, nodes, visited)
    count = calc(nodes)
    return count if root_node.amount == 0 else -1

def calc(nodes):
    nodes.sort()
    count = 0
    for node in nodes:
        if node.parent is not None:
            if node.amount != 0:
                node.parent.amount += node.amount
                count += abs(node.amount)
    return count

def make_tree(node, adj_list, nodes, visited):
    q = deque([node.num])
    while len(q) > 0:
        num = q.popleft()
        node = nodes[num]
        for next_num in adj_list[num]:
            if visited[next_num] == False:
                visited[next_num] = True
                node.children.append(nodes[next_num])
                nodes[next_num].parent = node
                nodes[next_num].level = node.level + 1
                q.append(next_num)