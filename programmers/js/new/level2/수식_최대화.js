let max = 0;
function solution(expression) {
    const numbers = [];
    const ops = [];
    let number = "";
    for (let i = 0; i < expression.length; ++i) {
        const c = expression[i];
        switch (c) {
            case "+":
            case "-":
            case "*":
                numbers.push(parseInt(number));
                number = "";
                ops.push(c);
                break;
            default:
                number += c;
        }
    }
    numbers.push(parseInt(number));
    const opSample = ["+", "-", "*"];
    dfs([], opSample, numbers, ops, Array(3).fill(false));
    return max;
}

function dfs(stack, opSample, numbers, ops, checked) {
    if (stack.length === 3) {
        const opPriority = [];
        for (let i = 0; i < stack.length; ++i) {
            opPriority.push(opSample[stack[i]]);
        }
        const [p1, p2, p3] = opPriority;
        let tempNumbers = [numbers[0]];
        let tempOps = [];
        // 1순위
        for (let i = 0; i < ops.length; ++i) {
            if (ops[i] === p1) {
                const top = tempNumbers.pop();
                tempNumbers.push(operator(top, numbers[i + 1], p1));
            } else {
                tempOps.push(ops[i]);
                tempNumbers.push(numbers[i + 1]);
            }
        }
        // 2순위
        let tempNumbers2 = [tempNumbers[0]];
        let tempOps2 = [];
        for (let i = 0; i < tempOps.length; ++i) {
            if (tempOps[i] === p2) {
                const top = tempNumbers2.pop();
                tempNumbers2.push(operator(top, tempNumbers[i + 1], p2));
            } else {
                tempNumbers2.push(tempNumbers[i + 1]);
                tempOps2.push(tempOps[i]);
            }
        }
        // 3순위
        let result = tempNumbers2[0];
        for (let i = 0; i < tempOps2.length; ++i) {
            result = operator(result, tempNumbers2[i + 1], tempOps2[i]);
        }
        result = Math.abs(result);
        if (result > max) {
            max = result;
        }
        return;
    }
    for (let i = 0; i < 3; ++i) {
        if (!checked[i]) {
            checked[i] = true;
            stack.push(i);
            dfs(stack, opSample, numbers, ops, checked);
            stack.pop();
            checked[i] = false;
        }
    }
}

function operator(num1, num2, op) {
    switch (op) {
        case "+":
            return num1 + num2;
        case "-":
            return num1 - num2;
        case "*":
            return num1 * num2;
    }
}

console.log(solution("100-200*300-500+20"));
