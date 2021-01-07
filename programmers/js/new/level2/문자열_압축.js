function solution(s) {
    var answer = 1000;
    for (let i = 1; i <= s.length; ++i) {
        const compress = shorten(s, i);
        if (compress.length < answer) {
            answer = compress.length;
        }
    }
    return answer;
}

function shorten(s, n) {
    let result = "";
    let current = "";
    let count = 1;
    for (let i = 0; i < n; ++i) {
        current += s.charAt(i);
    }
    for (let i = n; i < s.length; i += n) {
        let next = "";
        for (let j = i; j < i + n; ++j) {
            next += s.charAt(j);
        }
        if (current === next) {
            count++;
        } else {
            result += current + (count > 1 ? count : "");
            current = next;
            count = 1;
        }
    }
    result += current + (count > 1 ? count : "");
    return result;
}
