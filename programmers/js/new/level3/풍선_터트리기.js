function solution(a) {
    var answer = 0;
    let min = a[0];
    const leftMinExist = Array(a.length).fill(false);
    for (let i = 1; i < a.length; ++i) {
        const number = a[i];
        if (number > min) {
            leftMinExist[i] = true;
        }
        if (min > number) {
            min = number;
        }
    }
    const rightMinExist = Array(a.length).fill(false);
    min = a[a.length - 1];
    for (let i = a.length - 2; i >= 0; --i) {
        const number = a[i];
        if (number > min) {
            rightMinExist[i] = true;
        }
        if (min > number) {
            min = number;
        }
    }
    for (let i = 0; i < a.length; ++i) {
        if (!(leftMinExist[i] && rightMinExist[i])) {
            answer++;
        }
    }
    return answer;
}

console.log(solution([-16, 27, 65, -2, 58, -92, -71, -68, -61, -33]));
