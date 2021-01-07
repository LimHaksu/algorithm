function solution(number, k) {
    var answer = "";
    const stack = [];
    number.split("").forEach((num) => {
        const n = parseInt(num);
        if (stack.length === 0) {
            stack.push(n);
        } else {
            let top = stack[stack.length - 1];
            while (top < n && k > 0) {
                stack.pop();
                top = stack[stack.length - 1];
                k--;
            }
            if (stack.length < number.length - k) {
                stack.push(n);
            }
        }
    });
    return stack.join("");
}
