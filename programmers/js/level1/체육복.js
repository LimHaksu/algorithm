function solution(n, lost, reserve) {
    var answer = 0;
    let student = [];
    for (let i = 0; i <= n; ++i) {
        student.push(1);
    }
    lost.forEach(e => {
        student[e]--;
    });
    reserve.forEach(e => {
        student[e]++;
    })
    if (student[1] == 0) {
        if (student[2] > 1) {
            student[2]--;
            answer++;
        }
    } else if (student[1] > 0) {
        answer++;
    }
    for (let i = 2; i < n; ++i) {
        if (student[i] == 0) {
            if (student[i - 1] > 1) {
                student[i - 1]--;
                student[i]++;
                answer++;
            } else if (student[i + 1] > 1) {
                student[i + 1]--;
                student[i]++;
                answer++;
            }
        } else if (student[i] > 0) {
            answer++;
        }
    }
    if (student[n] == 0) {
        if (student[n - 1] > 1) {
            answer++;
        }
    } else if (student[n] > 0) {
        answer++;
    }
    return answer;
}

console.log(solution(5, [2, 4], [1, 3, 5]));