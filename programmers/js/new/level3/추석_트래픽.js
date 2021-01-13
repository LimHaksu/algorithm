function solution(lines) {
    var answer = 0;
    const arr = lines.map((row) => {
        const [day, time, duration] = row.split(" ");
        const endTime = timeToInteger(time);
        const startTime = getStartTime(endTime, duration);
        return { startTime, endTime };
    });
    arr.sort((a, b) => {
        if (a.endTime < b.endTime) {
            return -1;
        } else if (a.endTime > b.endTime) {
            return 1;
        }
        return a.startTime - b.startTime;
    });
    for (let i = 0; i < arr.length; ++i) {
        let count = 1;
        for (let j = i + 1; j < arr.length; ++j) {
            if (arr[j].startTime < arr[i].endTime + 1000) {
                count++;
            }
        }
        if (count > answer) {
            answer = count;
        }
    }
    return answer;
}

function timeToInteger(time) {
    const [hour, minute, second] = time.split(":");
    let result = 0;
    result += parseInt(hour) * 60 * 60 * 1000;
    result += parseInt(minute) * 60 * 1000;
    result += parseInt(parseFloat(second) * 1000);
    return result;
}

function getStartTime(endTime, duration) {
    duration = parseInt(parseFloat(duration.substring(0, duration.length - 1)) * 1000) - 1;
    return endTime - duration;
}

console.log(solution(["2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"]));
