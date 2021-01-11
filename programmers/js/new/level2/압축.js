function solution(msg) {
    var answer = [];
    const map = new Map();
    for (let i = 1; i <= 26; ++i) {
        map.set(String.fromCharCode("A".charCodeAt(0) + i - 1), i);
    }
    console.log(map);
    let lastIdx = 27;
    for (let i = 0; i < msg.length; ) {
        let str = "";
        let lastStr = "";
        let j = i;
        do {
            lastStr = str;
            str += msg[j++];
        } while (map.has(str));
        console.log(lastStr);
        answer.push(map.get(lastStr));
        map.set(str, lastIdx++);
        i = --j;
    }
    return answer;
}

console.log(solution("KAKAO"));
