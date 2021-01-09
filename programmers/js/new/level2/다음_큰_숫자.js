function solution(n) {
    let next = n + 1;
    const nCountOne = countOne(n.toString(2));
    while (true) {
        const nextCountOne = countOne(next.toString(2));
        if (nCountOne === nextCountOne) {
            return next;
        }
        next++;
    }
}

function countOne(str) {
    let count = 0;
    str.split("").forEach((c) => {
        if (c === "1") {
            count++;
        }
    });
    return count;
}

console.log(solution(78));
console.log(solution(15));
