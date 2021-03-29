function solution(orders, course) {
    var answer = [];
    const countMap = new Map();
    const courseMap = new Map();
    orders.forEach((order) => {
        for (let i = 2; i <= order.length; ++i) {
            if (course.includes(i)) {
                const arr = order.split("");
                arr.sort();
                for (const combi of combinations(arr, i)) {
                    const course = combi.join("");
                    if (courseMap.has(course)) {
                        courseMap.set(course, courseMap.get(course) + 1);
                    } else {
                        courseMap.set(course, 1);
                    }
                }
            }
        }
    });
    for (const [course, count] of courseMap.entries()) {
        if (count >= 2) {
            const size = course.length;
            if (countMap.has(size)) {
                if (countMap.get(size)[0].count < count) {
                    countMap.set(size, [{ course, count }]);
                } else if (countMap.get(size)[0].count === count) {
                    countMap.get(size).push({ course, count });
                }
            } else {
                countMap.set(size, [{ course, count }]);
            }
        }
    }
    for (const arr of countMap.values()) {
        for (const v of arr) {
            answer.push(v.course);
        }
    }
    answer.sort();
    return answer;
}

function combinations(arr, size) {
    if (typeof arr === "undefined") {
        throw Error("첫번째 파라미터 배열을 입력하세요");
    }
    if (typeof size === "undefined") {
        throw Error("두번째 파라미터 size 를 입력하세요.");
    }
    const result = [];
    const selected = Array.from(Array(arr.length), () => false);

    dfs(size, arr, selected, 0, 0);

    function dfs(size, arr, selected, index, count) {
        if (count === size) {
            const temp = [];
            for (let i = 0; i < selected.length; ++i) {
                if (selected[i]) {
                    temp.push(arr[i]);
                }
            }
            result.push(temp);
            return;
        }
        if (index === arr.length) {
            return;
        }
        selected[index] = true;
        dfs(size, arr, selected, index + 1, count + 1);
        selected[index] = false;
        dfs(size, arr, selected, index + 1, count);
    }

    return result;
}

console.log(solution(["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"], [2, 3, 4]));
