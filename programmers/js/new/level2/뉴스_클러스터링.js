function solution(str1, str2) {
    str1 = str1.toLowerCase();
    str2 = str2.toLowerCase();
    const map1 = new Map();
    for (let i = 0; i < str1.length; ++i) {
        const tStr = str1.substring(i, i + 2);
        // 정규식으로 해보기
        if (
            ((tStr[0] >= "a" && tStr[0] <= "z") || (tStr[0] >= "A" && tStr[0] <= "Z")) &&
            ((tStr[1] >= "a" && tStr[1] <= "z") || (tStr[1] >= "A" && tStr[1] <= "Z"))
        ) {
            if (map1.has(tStr)) {
                map1.set(tStr, map1.get(tStr) + 1);
            } else {
                map1.set(tStr, 1);
            }
        }
    }
    const map2 = new Map();
    for (let i = 0; i < str2.length; ++i) {
        const tStr = str2.substring(i, i + 2);
        // 정규식으로 해보기
        if (
            ((tStr[0] >= "a" && tStr[0] <= "z") || (tStr[0] >= "A" && tStr[0] <= "Z")) &&
            ((tStr[1] >= "a" && tStr[1] <= "z") || (tStr[1] >= "A" && tStr[1] <= "Z"))
        ) {
            if (map2.has(tStr)) {
                map2.set(tStr, map2.get(tStr) + 1);
            } else {
                map2.set(tStr, 1);
            }
        }
    }
    return parseInt((65536 * intersect(map1, map2)) / union(map1, map2));
}

function intersect(map1, map2) {
    if (map1.size === 0 && map2.size === 0) {
        return 1;
    }
    let count = 0;
    map1.forEach((v, k) => {
        if (map2.has(k)) {
            const v2 = map2.get(k);
            count += Math.min(v, v2);
        }
    });
    return count;
}

function union(map1, map2) {
    if (map1.size === 0 && map2.size === 0) {
        return 1;
    }
    let count = 0;
    map1.forEach((v, k) => {
        if (map2.has(k)) {
            const v2 = map2.get(k);
            count += Math.max(v, v2);
        } else {
            count += v;
        }
    });
    map2.forEach((v, k) => {
        if (!map1.has(k)) {
            count += v;
        }
    });
    return count;
}

console.log(solution("E=M*C^2", "e=m*c^2"));
