function solution(places) {
    return places.map((place) => (checkForPlace(place) ? 1 : 0));
}

function checkForPlace(place) {
    const n = place.length;
    const placeArr = place.map((row) => row.split(""));
    for (let i = 0; i < n; ++i) {
        for (let j = 0; j < n; ++j) {
            if (placeArr[i][j] === "P") {
                if (!checkForLocation(i, j, placeArr)) {
                    return false;
                }
            }
        }
    }
    return true;
}

function checkForLocation(r, c, place) {
    const dr = [-1, 0, 1, 0];
    const dc = [0, 1, 0, -1];
    const n = place.length;
    const visited = Array.from(Array(n), () => Array(n).fill(false));
    visited[r][c] = true;
    let currentCr = [r, c];
    const q = [currentCr];
    let dist = -1;
    while (q.length > 0) {
        const qsize = q.length;
        dist++;
        if (dist > 1) {
            break;
        }
        for (let i = 0; i < qsize; ++i) {
            const [cr, cc] = q.shift();
            for (let j = 0; j < 4; ++j) {
                const nr = cr + dr[j];
                const nc = cc + dc[j];
                if (bdCheck(nr, nc, place) && !visited[nr][nc] && place[nr][nc] !== "X") {
                    if (place[nr][nc] === "P") {
                        return false;
                    }
                    visited[nr][nc] = true;
                    q.push([nr, nc]);
                }
            }
        }
    }
    return true;
}

function bdCheck(r, c, arr) {
    return r >= 0 && r < arr.length && c >= 0 && c < arr.length;
}
