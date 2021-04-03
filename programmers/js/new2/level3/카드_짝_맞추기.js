function solution(board, r, c) {
    var answer = Number.MAX_SAFE_INTEGER;
    const dict = {};
    board.forEach((row, i) => {
        row.forEach((num, j) => {
            if (num !== 0) {
                if (num in dict) {
                    dict[num].push([i, j]);
                } else {
                    dict[num] = [[i, j]];
                }
            }
        });
    });
    const keys = Object.keys(dict);
    const permutationList = permutation(keys, keys.length);
    const caseList = getCaseList(dict, permutationList);
    caseList.forEach((eachCase) => {
        let sum = 0;
        let current = [r, c];
        const list = [];
        const tempBoard = Array(board.length);
        board.forEach((row, i) => {
            tempBoard[i] = [...row];
        });
        eachCase.forEach((location) => {
            const dist = getDistance(tempBoard, current, location);
            list.push(dist);
            sum += dist;
            current = location;
            const [r, c] = location;
            tempBoard[r][c] = 0;
        });
        if (sum < answer) {
            answer = sum;
        }
    });
    return answer + keys.length * 2;
}

function getCaseList(dict, permutationList) {
    const result = [];
    const index = Array.from(Array(permutationList[0].length), (v, i) => i);
    permutationList.forEach((permu) => {
        for (let size = 0; size <= index.length; ++size) {
            const combi = combination(index, size);
            combi.forEach((c) => {
                const temp = [];
                for (let i = 0; i < permu.length; ++i) {
                    const key = permu[i];
                    if (c.includes(i)) {
                        temp.push(dict[key][1], dict[key][0]);
                    } else {
                        temp.push(dict[key][0], dict[key][1]);
                    }
                }
                result.push(temp);
            });
        }
    });
    return result;
}

const dr = [-1, 0, 1, 0];
const dc = [0, 1, 0, -1];

function bdCheck(map, r, c) {
    return r >= 0 && r < map.length && c >= 0 && c < map[0].length;
}
function getDistance(map, start, end) {
    let current = start;
    const q = [current];
    const visited = Array.from(Array(map.length), () => Array(map[0].length).fill(false));
    let count = -1;
    while (q.length > 0) {
        const qsize = q.length;
        count++;
        for (let i = 0; i < qsize; ++i) {
            const [cr, cc] = q.shift();
            if (cr === end[0] && cc === end[1]) {
                return count;
            }
            for (let j = 0; j < 4; ++j) {
                let nr = cr + dr[j];
                let nc = cc + dc[j];
                if (bdCheck(map, nr, nc) && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.push([nr, nc]);
                }
                while (bdCheck(map, nr + dr[j], nc + dc[j]) && map[nr][nc] === 0) {
                    nr = nr + dr[j];
                    nc = nc + dc[j];
                }
                if (bdCheck(map, nr, nc) && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.push([nr, nc]);
                }
            }
        }
    }
}

function combination(arr, size) {
    const result = [];
    const checked = Array(arr.length).fill(false);
    dfs(arr, checked, 0, 0, size);
    return result;
    function dfs(arr, checked, index, count, size) {
        if (count === size) {
            const temp = [];
            for (let i = 0; i < checked.length; ++i) {
                if (checked[i]) {
                    temp.push(arr[i]);
                }
            }
            result.push(temp);
            return;
        }
        if (index === arr.length) {
            return;
        }
        checked[index] = true;
        dfs(arr, checked, index + 1, count + 1, size);
        checked[index] = false;
        dfs(arr, checked, index + 1, count, size);
    }
}

function permutation(arr, size) {
    const result = [];
    const stack = [];
    const checked = Array(arr.length).fill(false);
    dfs(arr, stack, size, checked);
    return result;
    function dfs(arr, stack, size, checked) {
        if (stack.length === size) {
            result.push([...stack]);
            return;
        }
        for (let i = 0; i < checked.length; ++i) {
            if (!checked[i]) {
                checked[i] = true;
                stack.push(arr[i]);
                dfs(arr, stack, size, checked);
                stack.pop();
                checked[i] = false;
            }
        }
    }
}

console.log(
    solution(
        [
            [1, 0, 0, 3],
            [2, 0, 0, 0],
            [0, 0, 0, 2],
            [3, 0, 1, 0],
        ],
        1,
        0
    )
);
