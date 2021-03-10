from collections import deque
def solution(bridge_length, weight, truck_weights):
    time = 1
    total_weight = 0
    count = 0
    trucks_on_bridge = deque()
    index = 0
    while count < len(truck_weights):
        # 타고
        while len(trucks_on_bridge) < bridge_length and index < len(truck_weights) and total_weight + truck_weights[index] <= weight:
            trucks_on_bridge.append({'time': time, 'weight': truck_weights[index]})
            total_weight += truck_weights[index]
            time += 1 
            index += 1
        # 내리고(한대만)
        truck = trucks_on_bridge.popleft()
        time = max(truck['time'] + bridge_length, time)
        total_weight -= truck['weight']
        count += 1
    return time

print(solution(5, 5, [2,2,2,2,1,1,1,1,1]))