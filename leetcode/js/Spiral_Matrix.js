/**
 * @param {number[][]} matrix
 * @return {number[]}
 */
const dr = [-1, 0, 1, 0];
const dc = [0, 1, 0, -1];
var spiralOrder = function (matrix) {
    const rSize = matrix.length;
    const cSize = matrix[0].length;
    const visited = Array.from(Array(rSize), () => Array(cSize).fill(false));

    let direction = 1;
    const answer = [];
    let cr = 0;
    let cc = 0;
    let count = 0;
    while (count < rSize * cSize) {
        answer.push(matrix[cr][cc]);
        visited[cr][cc] = true;
        count++;
        if (!bdCheck(visited, cr, cc, direction)) {
            direction = rotate(direction);
        }
        cr += dr[direction];
        cc += dc[direction];
    }
    return answer;
};

function rotate(direction) {
    return (direction + 1) % 4;
}

function bdCheck(matrix, cr, cc, direction) {
    const nr = cr + dr[direction];
    const nc = cc + dc[direction];
    return nr >= 0 && nr < matrix.length && nc >= 0 && nc < matrix[0].length && !matrix[nr][nc];
}
