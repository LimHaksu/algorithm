function solution(bridge_length, weight, truck_weights) {
    var answer = 0;
    const queue = [];
    let remainWeight = weight;
    let remainLength = bridge_length;
    let inTime = 0;
    let outTime = 0;
    truck_weights.forEach((truckWeight) => {
        if (truckWeight <= remainWeight && remainLength > 0) {
            queue.push([++inTime, truckWeight]);
            remainWeight -= truckWeight;
            remainLength--;
        } else {
            while (truckWeight > remainWeight) {
                const [time, weight] = queue.shift();
                outTime = time + bridge_length;
                inTime = outTime - 1;
                remainWeight += weight;
                remainLength++;
            }
        }
    });
    while (queue.length > 0) {
        const [time] = queue.shift();
        outTime = time + bridge_length;
    }
    return currentTime;
}
