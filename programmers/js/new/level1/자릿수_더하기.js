function solution(n) {
    let answer = 0;
    const str = n.toString();
    for (let i = 0; i < str.length; ++i) {
        answer += parseInt(str.charAt(i));
    }
    return answer;
}
