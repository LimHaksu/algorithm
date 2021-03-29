// function solution(tickets) {
//     let answer = "Z".repeat(tickets.length * 5);
//     const used = Array(tickets.length).fill(false);
//     const stack = [];
//     for (let i = 0; i < used.length; ++i) {
//         const current = tickets[i][0];
//         if (current === "ICN") {
//             stack.push(current);
//             answer = dfs(0, tickets, current, used, stack, answer);
//             stack.pop();
//         }
//     }
//     return answer.split(',');
// }

// function dfs(count, tickets, current, used, stack, answer) {
//     if (count === tickets.length) {
//         const tempStr = stack.join(",");
//         if (tempStr < answer) {
//             return tempStr;
//         }
//         return answer;
//     }
//     for (let i = 0; i < used.length; ++i) {
//         if (!used[i] && tickets[i][0] === current) {
//             used[i] = true;
//             const next = tickets[i][1];
//             stack.push(next);
//             answer = dfs(count + 1, tickets, next, used, stack, answer);
//             stack.pop();
//             used[i] = false;
//         }
//     }
//     return answer;
// }

console.log(
    solution([
        ["ICN", "SFO"],
        ["ICN", "BCD"],
        ["ICN", "ABC"],
        ["ICN", "DEF"],
        ["DEF", "ICN"],
        ["BCD", "ICN"],
        ["ABC", "ICN"],
    ])
);

function solution(tickets) {
    const visited = {};
    const adjList = {};
    tickets.forEach((ticket) => {
        const s = ticket[0];
        const d = ticket[1];
        visited[d] = visited[d] ? visited[d] + 1 : 1;
        if (adjList[s]) {
            adjList[s].push(d);
        } else {
            adjList[s] = [d];
        }
    });
    var answer = [];
    console.log(adjList);
    Object.keys(adjList).forEach((key) => adjList[key].sort());
    console.log(adjList);
    let res = [];
    let flag = true;

    function dfs(n, currentPos) {
        if (n === 0) {
            res = [...answer];
            flag = false;
            return;
        }
        if (adjList[currentPos] && flag) {
            adjList[currentPos].forEach((key) => {
                if (visited[key]) {
                    visited[key] -= 1;
                    answer.push(key);
                    dfs(n - 1, key);
                    answer.pop();
                    visited[key] += 1;
                }
            });
        }
    }
    answer.push("ICN");
    dfs(tickets.length, "ICN");
    return res;
}
