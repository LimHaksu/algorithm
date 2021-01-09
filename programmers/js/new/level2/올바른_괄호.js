function solution(s) {
    let top = -1;
    const arr = s.split("");
    for (let i = 0; i < arr.length; ++i) {
        const c = arr[i];
        if (c === "(") {
            top++;
        } else {
            if (top < 0) {
                return false;
            } else {
                top--;
            }
        }
    }
    return top === -1;
}
