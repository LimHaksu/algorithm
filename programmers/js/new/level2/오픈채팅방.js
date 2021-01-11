function solution(record) {
    const log = [];
    const userNicknameMap = new Map();
    record.forEach((r) => {
        const [action, uid, nickname] = r.split(" ");
        switch (action) {
            case "Enter":
                userNicknameMap.set(uid, nickname);
                log.push([uid, "enter"]);
                break;
            case "Leave":
                log.push([uid, "leave"]);
                break;
            case "Change":
                userNicknameMap.set(uid, nickname);
                break;
        }
    });
    const answer = log.map((l) => {
        const [uid, action] = l;
        let str = userNicknameMap.get(uid) + "님이 ";
        if (action === "enter") {
            str += "들어왔습니다.";
        } else {
            str += "나갔습니다.";
        }
        return str;
    });
    return answer;
}
