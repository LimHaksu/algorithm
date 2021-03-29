function solution(routes) {
    var answer = 1;
    routes.sort((a, b) => {
        if (a[1] < b[1]) {
            return -1;
        } else if (a[1] > b[1]) {
            return 1;
        }
        return a[0] - b[0];
    });
    let arr = [routes[0]];
    for (let i = 1; i < routes.length; ++i) {
        const current = routes[i];
        if (arr.length > 0 && current[0] > arr[0][1]) {
            arr = [];
            answer++;
        }
        arr.push(current);
    }
    return answer;
}

console.log(
    solution([
        [-15, -14],
        [-14, 1],
        [2, 3],
    ])
);
