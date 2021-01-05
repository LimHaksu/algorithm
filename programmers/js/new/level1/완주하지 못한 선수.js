function solution(participant, completion) {
    var answer = "";
    const completionMap = new Map();
    completion.forEach((comp) => {
        if (completionMap.has(comp)) {
            completionMap.set(comp, completionMap.get(comp) + 1);
        } else {
            completionMap.set(comp, 1);
        }
    });
    for (let i = 0; i < participant.length; ++i) {
        const part = participant[i];
        if (completionMap.has(part)) {
            completionMap.set(part, completionMap.get(part) - 1);
            if (completionMap.get(part) === 0) {
                completionMap.delete(part);
            }
        } else {
            answer = part;
            break;
        }
    }
    return answer;
}
