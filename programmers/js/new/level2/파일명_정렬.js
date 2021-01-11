function solution(files) {
    var answer = [];
    const arr = files.map((file) => {
        let head = "";
        let j = -1;
        for (let i = 0; i < file.length; ++i) {
            const c = file[i];
            if (!(c >= "0" && c <= "9")) {
                head += c;
            } else {
                j = i;
                break;
            }
        }
        let number = "";
        let k = -1;
        for (; j < file.length; ++j) {
            const c = file[j];
            if (c >= "0" && c <= "9") {
                number += c;
            } else {
                k = j;
                break;
            }
        }
        const tail = j === file.length ? "" : file.substring(k);
        return { head, number, tail };
    });
    arr.sort((a, b) => {
        const ah = a.head.toLowerCase();
        const bh = b.head.toLowerCase();
        if (ah < bh) {
            return -1;
        } else if (ah > bh) {
            return 1;
        }
        return parseInt(a.number) - parseInt(b.number);
    });
    return arr.map((e) => `${e.head}${e.number}${e.tail}`);
}

// console.log(solution(["img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"]));
console.log(solution(["muzi1.png", "MUZI01"]));
