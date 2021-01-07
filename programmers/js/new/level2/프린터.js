function solution(priorities, location) {
    var answer = 0;
    const arr = priorities.map((e, i) => {
        return { i, p: e };
    });
    while (arr.length > 0) {
        const { p, i } = arr.shift();
        if (isExistHigherPriority(p, arr)) {
            arr.push({ p, i });
        } else {
            answer++;
            if (i === location) {
                break;
            }
        }
    }
    return answer;
}

const isExistHigherPriority = (p, arr) => {
    for (let i = 0; i < arr.length; ++i) {
        if (arr[i].p > p) {
            return true;
        }
    }
    return false;
};
