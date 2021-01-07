function solution(progresses, speeds) {
    var answer = [];
    const needs = [];
    for (let i = 0; i < progresses.length; ++i) {
        needs.push(Math.ceil((100 - progresses[i]) / speeds[i]));
    }
    let stack = [];
    let sMax = 0;
    needs.forEach((e) => {
        if (stack.length === 0) {
            stack.push(e);
            sMax = e;
        } else {
            const top = stack[stack.length - 1];
            if (e <= sMax) {
                stack.push(e);
            } else {
                answer.push(stack.length);
                stack = [e];
                sMax = e;
            }
        }
    });
    answer.push(stack.length);
    return answer;
}
