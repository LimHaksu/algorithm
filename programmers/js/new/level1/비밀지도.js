function solution(n, arr1, arr2) {
    var answer = [];
    arr1.forEach((num, idx) => {
        let arr = Array(n).fill(" ");
        for (let i = n - 1; i >= 0; --i) {
            const d = num % 2;
            if (d === 1) {
                arr[i] = "#";
            }
            num = parseInt(num / 2);
        }
        answer.push(arr);
    });
    arr2.forEach((num, idx) => {
        for (let i = n - 1; i >= 0; --i) {
            const d = num % 2;
            if (d === 1) {
                answer[idx][i] = "#";
            }
            num = parseInt(num / 2);
        }
    });
    return answer.map((arr) => arr.join(""));
}
