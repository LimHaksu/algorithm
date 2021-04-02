function solution(info, query) {
    var answer = [];
    const language = ["cpp", "java", "python", "-"];
    const position = ["backend", "frontend", "-"];
    const career = ["junior", "senior", "-"];
    const food = ["chicken", "pizza", "-"];
    const map = new Map();
    language.forEach((l) => {
        position.forEach((p) => {
            career.forEach((c) => {
                food.forEach((f) => {
                    const key = `${l},${p},${c},${f}`;
                    map.set(key, []);
                });
            });
        });
    });
    info.forEach((i) => {
        const splited = i.split(" ");
        const indexList = [0, 1, 2, 3];
        for (let i = 0; i <= 4; ++i) {
            const combinationList = combination(indexList, i);
            combinationList.forEach((combi) => {
                const keyList = [];
                for (let i = 0; i < 4; ++i) {
                    if (combi.includes(i)) {
                        keyList.push("-");
                    } else {
                        keyList.push(splited[i]);
                    }
                }
                const tempKey = keyList.join(",");
                map.get(tempKey).push(+splited[4]);
            });
        }
    });
    map.forEach((v) => {
        v.sort((a, b) => a - b);
    });
    query.forEach((q) => {
        const splited = q.split(" ").filter((v, i) => ![1, 3, 5].includes(i));
        const key = splited.filter((v, i) => i < 4).join(",");
        const arr = map.get(key);
        const lb = findLowerBound(arr, parseInt(splited[4]));
        answer.push(arr.length - lb);
    });
    return answer;
}

function findLowerBound(arr, value) {
    let left = 0;
    let right = arr.length - 1;
    let ans = arr.length;
    while (left <= right) {
        const mid = parseInt((left + right) / 2);
        if (arr[mid] >= value) {
            ans = mid;
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    return ans;
}

function combination(arr, size) {
    const result = [];
    const checked = Array.from(Array(arr.length), () => false);
    dfs(arr, checked, 0, size, 0);
    function dfs(arr, checked, index, size, count) {
        if (count === size) {
            result.push(arr.filter((v, i) => checked[i]));
            return;
        }
        if (index === arr.length) {
            return;
        }
        checked[index] = true;
        dfs(arr, checked, index + 1, size, count + 1);
        checked[index] = false;
        dfs(arr, checked, index + 1, size, count);
    }
    return result;
}

console.log(
    solution(
        [
            "java backend junior pizza 150",
            "python frontend senior chicken 210",
            "python frontend senior chicken 150",
            "cpp backend senior pizza 260",
            "java backend junior chicken 80",
            "python backend senior chicken 50",
        ],
        [
            "java and backend and junior and pizza 100",
            "python and frontend and senior and chicken 200",
            "cpp and - and senior and pizza 250",
            "- and backend and senior and - 150",
            "- and - and - and chicken 100",
            "- and - and - and - 150",
        ]
    )
);
