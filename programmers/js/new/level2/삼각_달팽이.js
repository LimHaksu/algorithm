function solution(n) {
    var answer = [];
    const arr = Array.from(Array(n), () => Array(n));
    for (let i = 0; i < n; ++i) {
        arr[i][0] = i + 1;
    }
    let i = n - 1,
        j = 0;
    let size = n - 1;
    let num = n + 1;
    let dir = 1;
    while (size > 0) {
        for (let k = 0; k < size; ++k) {
            switch (dir) {
                case 0:
                    i++;
                    break;
                case 1:
                    j++;
                    break;
                case 2:
                    i--;
                    j--;
                    break;
            }
            arr[i][j] = num++;
        }
        dir = (dir + 1) % 3;
        size--;
    }
    return arr.flat();
}
