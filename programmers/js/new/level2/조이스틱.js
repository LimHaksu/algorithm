function solution(name) {
    return dfs(name, "A".repeat(name.length), 0, 0);
}

function dfs(name, currentStr, currentIdx, count) {
    const a = name.charAt(currentIdx);
    const b = currentStr.charAt(currentIdx);
    currentStr = currentStr.substring(0, currentIdx) + a + currentStr.substring(currentIdx + 1);
    const diff = getDiff(a, b);
    count += diff;
    if (name === currentStr) {
        return count;
    }
    const [leftIdx, lCount] = findleftNotEqualIdx(name, currentStr, currentIdx);
    let lMin = dfs(name, currentStr, leftIdx, count + lCount);
    const [rightIdx, rCount] = findRightNotEqualIdx(name, currentStr, currentIdx);
    let rMin = dfs(name, currentStr, rightIdx, count + rCount);
    return lMin < rMin ? lMin : rMin;
}

function getDiff(a, b) {
    let asciiA = a.charCodeAt(0);
    let asciiB = b.charCodeAt(0);
    if (asciiA > asciiB) {
        const temp = asciiA;
        asciiA = asciiB;
        asciiB = temp;
    }
    const diff1 = asciiB - asciiA;
    const diff2 = asciiA + 26 - asciiB;
    return diff1 < diff2 ? diff1 : diff2;
}

function findleftNotEqualIdx(name, currentStr, currentIdx) {
    currentIdx--;
    if (currentIdx < 0) {
        currentIdx += name.length;
    }
    let count = 1;
    while (currentStr.charAt(currentIdx) === name.charAt(currentIdx)) {
        currentIdx--;
        count++;
        if (currentIdx < 0) {
            currentIdx += name.length;
        }
    }
    return [currentIdx, count];
}

function findRightNotEqualIdx(name, currentStr, currentIdx) {
    currentIdx++;
    if (currentIdx >= name.length) {
        currentIdx -= name.length;
    }
    let count = 1;
    while (currentStr.charAt(currentIdx) === name.charAt(currentIdx)) {
        currentIdx++;
        count++;
        if (currentIdx >= name.length) {
            currentIdx -= name.length;
        }
    }
    return [currentIdx, count];
}
