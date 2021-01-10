function solution(s) {
    return s
        .split(" ")
        .map((word) => {
            let temp = word.split("");
            if (temp.length > 0) {
                temp[0] = temp[0].toUpperCase();
                for (let i = 1; i < temp.length; ++i) {
                    temp[i] = temp[i].toLowerCase();
                }
                return temp.join("");
            }
        })
        .join(" ");
}
