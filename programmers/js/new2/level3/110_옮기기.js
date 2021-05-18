function solution(s) {
    var answer = [];
    s.forEach((string) => {
        const arr = string.split("");
        const stack = [];
        const temp110 = [];
        let tempAns = [];
        arr.forEach((c) => {
            if (c === "0") {
                if (stack.length >= 2) {
                    temp110.push(stack.pop());
                    temp110.push(stack.pop());
                    temp110.push(c);
                } else if (stack.length === 1) {
                    tempAns.push(stack.pop());
                    tempAns.push(c);
                } else {
                    tempAns.push(c);
                }
            } else {
                stack.push(c);
            }
        });
        tempAns = tempAns.concat(temp110);
        tempAns = tempAns.concat(stack);
        answer.push(tempAns.join(""));
    });
    return answer;
}
