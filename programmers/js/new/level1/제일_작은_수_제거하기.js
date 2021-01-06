function solution(arr) {
    let min = Number.MAX_VALUE;
    let minIdx = -1;
    arr.forEach((num, idx) => {
        if (num < min) {
            min = num;
            minIdx = idx;
        }
    });
    arr.splice(minIdx, 1);

    if (arr.length === 0) {
        arr.push(-1);
    }
    return arr;
}
