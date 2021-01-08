function solution(clothes) {
    var answer = 1;
    const map = new Map();
    clothes.forEach(([_, category]) => {
        if (map.has(category)) {
            map.set(category, map.get(category) + 1);
        } else {
            map.set(category, 2);
        }
    });
    map.forEach((v) => {
        answer *= v;
    });
    return answer - 1;
}

console.log(
    solution([
        ["yellow_hat", "headgear"],
        ["blue_sunglasses", "eyewear"],
        ["green_turban", "headgear"],
    ])
);
