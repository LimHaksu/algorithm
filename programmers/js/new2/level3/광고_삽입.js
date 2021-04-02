function solution(play_time, adv_time, logs) {
    var answer = "00:00:00";
    const starts = [];
    const ends = [];
    logs.forEach((l) => {
        const [s, e] = l.split("-").map((v) => timeToInt(v));
        starts.push(s);
        ends.push(e);
    });
    starts.sort((a, b) => a - b);
    ends.sort((a, b) => a - b);
    let si = 0;
    let ei = 0;
    let count = 0;
    const countBySecond = Array(timeToInt(play_time)).fill(0);
    for (let time = 0; time < countBySecond.length; ++time) {
        while (si < starts.length && starts[si] === time) {
            count++;
            si++;
        }
        while (ei < ends.length && ends[ei] === time) {
            count--;
            ei++;
        }
        countBySecond[time] = count;
    }
    let left = 0;
    let right = 0;
    const advLength = timeToInt(adv_time);
    let tempSum = 0;
    let ans = 0;
    for (; right < advLength; ++right) {
        tempSum += countBySecond[right];
    }
    ans = tempSum;
    while (right < countBySecond.length) {
        tempSum -= countBySecond[left];
        tempSum += countBySecond[right];
        left++;
        right++;
        if (ans < tempSum) {
            ans = tempSum;
            answer = intToTime(left);
        }
    }
    return answer;
}

function intToTime(int) {
    const hour = addLeadingZero(parseInt(int / 3600));
    const minute = addLeadingZero(parseInt(int / 60) % 60);
    const second = addLeadingZero(int % 60);
    return `${hour}:${minute}:${second}`;
}

function addLeadingZero(num) {
    return num < 10 ? "0" + num : num;
}

function timeToInt(time) {
    const [hour, minute, second] = time.split(":");
    return (+hour * 60 + +minute) * 60 + +second;
}

console.log(solution("00:00:10", "00:00:03", ["00:00:01-00:00:02", "00:00:02-00:00:03", "00:00:01-00:00:03"]));
