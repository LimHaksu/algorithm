function solution(s) {
    var answer = [];
    let countZero = 0;
    let countRepeat = 0;
    while (s !== "1") {
        countRepeat++;
        let temp = "";
        for (let i = 0; i < s.length; ++i) {
            if (s[i] === "0") {
                countZero++;
            } else {
                temp += s[i];
            }
        }
        s = temp.length.toString(2);
    }
    return [countRepeat, countZero];
}
