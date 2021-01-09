function solution(s) {
    var answer = [];
    let str = s.substring(1, s.length - 1);
    let isOpen = false;
    let number = "";
    const arr = [[]];
    for (let i = 0; i < str.length; ++i) {
        const c = str[i];
        if (c === "{") {
            isOpen = true;
        } else if (c === "}") {
            arr[arr.length - 1].push(parseInt(number));
            number = "";
            isOpen = false;
        } else {
            if (c === ",") {
                if (isOpen) {
                    arr[arr.length - 1].push(parseInt(number));
                    number = "";
                } else {
                    arr.push([]);
                }
            } else {
                number += c;
            }
        }
    }
    const set = new Set();
    arr.sort((a, b) => a.length - b.length).forEach((row) => {
        row.forEach((num) => {
            if (!set.has(num)) {
                set.add(num);
                answer.push(num);
            }
        });
    });
    return answer;
}

console.log(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"));
