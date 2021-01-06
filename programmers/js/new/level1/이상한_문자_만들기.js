function solution(s) {
    var answer = "";
    s.split(" ").forEach((word) => {
        for (let i = 0; i < word.length; ++i) {
            if (i % 2 === 0) {
                answer += word.charAt(i).toUpperCase();
            } else {
                answer += word.charAt(i).toLowerCase();
            }
        }
        answer += " ";
    });
    return answer.slice(0, -1);
    // return answer.substring(0, answer.length-1);
}
