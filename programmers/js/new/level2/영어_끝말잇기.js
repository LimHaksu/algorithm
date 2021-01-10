function solution(n, words) {
    const countTurn = Array(n + 1).fill(0);
    const set = new Set();
    if (words[0].length <= 1) {
        return [1, 1];
    }
    set.add(words[0]);
    countTurn[1]++;
    for (let i = 1; i < words.length; ++i) {
        const word = words[i];
        const pNum = (i % n) + 1;
        countTurn[pNum]++;
        if (set.has(word) || words[i - 1][words[i - 1].length - 1] !== word[0]) {
            return [pNum, countTurn[pNum]];
        }
        set.add(word);
    }
    return [0, 0];
}
