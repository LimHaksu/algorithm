function solution(files) {
    files = files.map((f) => {
        const [_, head, number, tail] = /([^0-9]+)(\d{1,5})(.*)/.exec(f);
        return { head, number, tail };
    });
    files.sort((a, b) => {
        const aHead = a.head.toLowerCase();
        const bHead = b.head.toLowerCase();
        if (aHead < bHead) {
            return -1;
        } else if (aHead > bHead) {
            return 1;
        }
        return +a.number - +b.number;
    });
    return files.map((f) => `${f.head}${f.number}${f.tail}`);
}

console.log(solution(["img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"]));
