function solution(m, musicinfos) {
    var answer = "";
    m = replaceStr(m);
    let maxLength = 0;
    musicinfos.forEach((row) => {
        let [start, end, title, code] = row.split(",");
        code = replaceStr(code);
        const length = getLength(start, end);
        let realCode = "";
        for (let i = 0; i < length; ++i) {
            realCode += code[i % code.length];
        }
        if (realCode.includes(m)) {
            if (length > maxLength) {
                maxLength = length;
                answer = title;
            }
        }
    });
    return answer === "" ? "(None)" : answer;
}

function replaceStr(str) {
    str = str.replace(/A#/g, "H");
    str = str.replace(/C#/g, "I");
    str = str.replace(/D#/g, "J");
    str = str.replace(/F#/g, "K");
    return str.replace(/G#/g, "L");
}

function getLength(start, end) {
    const sArr = start.split(":");
    const eArr = end.split(":");
    const s = parseInt(sArr[0]) * 60 + parseInt(sArr[1]);
    const e = parseInt(eArr[0]) * 60 + parseInt(eArr[1]);
    return e - s;
}

// console.log(solution("ABCDEFG", ["12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"]));
console.log(solution("CC#BCC#BCC#BCC#B", ["03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"]));
// console.log(solution("ABC", ["12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"]));
