function solution(s, n) {
    let answer = "";
    for (let i = 0; i < s.length; ++i) {
        let ascii = s.charCodeAt(i);
        if (ascii >= "A".charCodeAt(0) && ascii <= "Z".charCodeAt(0)) {
            ascii = "A".charCodeAt(0) + ((ascii - "A".charCodeAt(0) + n) % 26);
        } else if (ascii >= "a".charCodeAt(0) && ascii <= "z".charCodeAt(0)) {
            ascii = "a".charCodeAt(0) + ((ascii - "a".charCodeAt(0) + n) % 26);
        }
        answer += String.fromCharCode(ascii);
    }
    return answer;
}
