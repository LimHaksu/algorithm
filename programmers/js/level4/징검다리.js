function solution(distance, rocks, n) {
    var answer = 0;
    rocks.sort((a, b) => {
        return a - b;
    })
    rocks.push(distance);
    let dist = [];
    dist.push(rocks[0]);
    for (let i = 1; i < rocks.length; ++i) {
        dist.push(rocks[i] - rocks[i - 1]);
    }
    console.log(dist);
    let left = 1;
    let right = 1000000000;
    console.log(rocks);
    while (left <= right) {
        let mid = Math.floor((left + right) / 2);
        console.log(mid);
        if (check(mid, rocks, n)) {
            answer = mid;
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return answer;
}
function check(mid, rocks, n) {
    let min = rocks[n];
    for (let i = n + 1; i < rocks.length; ++i) {
        if ((rocks[i] - rocks[i - n - 1]) < min) {
            min = rocks[i] - rocks[i - n - 1];
        }
    }
    console.log(min);
    return min <= mid;
}