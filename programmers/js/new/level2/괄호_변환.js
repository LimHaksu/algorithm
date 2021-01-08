function solution(p) {
    var answer = "";

    // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
    if (p === "") {
        return "";
    }
    // 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
    const [u, v] = splitUV(p);
    // 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
    //   3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
    if (isRight(u)) {
        return u + solution(v);
    }
    // 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
    //   4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
    let temp = "(";
    //   4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
    temp += solution(v);
    //   4-3. ')'를 다시 붙입니다.
    temp += ")";
    //   4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
    temp += deleteSideAndReverse(u);
    //   4-5. 생성된 문자열을 반환합니다.
    return temp;
}

function deleteSideAndReverse(str) {
    let result = "";
    for (let i = 1; i < str.length - 1; ++i) {
        result += str[i] === ")" ? "(" : ")";
    }
    return result;
}

function isRight(str) {
    let top = -1;
    for (let i = 0; i < str.length; ++i) {
        if (str[i] === "(") {
            top++;
        } else {
            if (top < 0) {
                return false;
            }
            top--;
        }
    }
    return top === -1;
}

function splitUV(str) {
    const count = {
        "(": 0,
        ")": 0,
    };
    for (let i = 0; i < str.length; ++i) {
        count[str[i]]++;
        if (count["("] === count[")"]) {
            let left = "";
            let right = "";
            for (let j = 0; j <= i; ++j) {
                left += str[j];
            }
            for (let j = i + 1; j < str.length; ++j) {
                right += str[j];
            }
            return [left, right];
        }
    }
}

console.log("(()())()");
