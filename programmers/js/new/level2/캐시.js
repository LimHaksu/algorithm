function solution(cacheSize, cities) {
    var answer = 0;
    const cache = [];
    for (let i = 0; i < cities.length; ++i) {
        const city = cities[i].toLowerCase();
        if (findInCache(cache, cacheSize, city)) {
            answer++;
        } else {
            answer += 5;
            insertInCache(cache, cacheSize, city);
        }
    }
    return answer;
}

function findInCache(cache, cacheSize, city) {
    let findIdx = -1;
    for (let i = 0; i < cacheSize; ++i) {
        if (cache[i] === city) {
            findIdx = i;
            break;
        }
    }
    if (findIdx >= 0) {
        cache.splice(findIdx, 1);
        cache.unshift(city);
        return true;
    }
    return false;
}

function insertInCache(cache, cacheSize, city) {
    if (cache.length < cacheSize) {
        cache.unshift(city);
    } else {
        cache.pop();
        cache.unshift(city);
    }
}

console.log(solution(2, ["Jeju", "Pangyo", "NewYork", "newyork"]));
