function solution(people, limit) {
    var answer = 0;
    people.sort();
    let bigIdx = people.length - 1;
    let smallIdx = 0;
    while (smallIdx < bigIdx) {
        if (people[bigIdx] + people[smallIdx] <= limit) {
            smallIdx++;
        }
        bigIdx--;
        answer++;
    }
    if (smallIdx === bigIdx) {
        answer++;
    }
    return answer;
}
