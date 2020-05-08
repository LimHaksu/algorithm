function solution(genres, plays) {
    var answer = [];
    let arr = [];
    let count = new Map();
    let remain = new Map();
    for (let i = 0; i < genres.length; ++i) {
        if (!count.has(genres[i])) {
            count.set(genres[i], 0);
            remain.set(genres[i], 2);
        }
        count.set(genres[i], count.get(genres[i]) + plays[i]);
    }
    for (let i = 0; i < genres.length; ++i) {
        arr.push({
            idx: i,
            genre: genres[i],
            play: plays[i],
            count: count.get(genres[i])
        })
    }
    arr.sort((a, b, ) => {
        if (a.count > b.count) {
            return -1;
        } else if (a.count < b.count) {
            return 1;
        } else {
            if (a.play > b.play) {
                return -1;
            } else if (a.play < b.play) {
                return 1;
            } else {
                return a.idx - b.idx;
            }
        }
    });
    arr.forEach(e => {
        if (remain.get(e.genre) > 0) {
            answer.push(e.idx);
            remain.set(e.genre, remain.get(e.genre) - 1);
        }
    })
    return answer;
}

console.log(solution(["classic", "pop", "classic", "classic", "pop"],
    [500, 600, 150, 800, 2500]
))