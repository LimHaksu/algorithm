function solution(skill, skill_trees) {
    var answer = 0;
    const set = new Set();
    skill.split("").forEach((c) => {
        set.add(c);
    });
    skill_trees.forEach((st) => {
        if (check(set, skill, st)) {
            answer++;
        }
    });
    return answer;
}

const check = (set, skill, st) => {
    let skillIdx = 0;
    const arr = st.split("");
    for (let i = 0; i < arr.length; ++i) {
        const c = arr[i];
        if (set.has(c)) {
            if (skill.charAt(skillIdx) === c) {
                skillIdx++;
            } else {
                return false;
            }
        }
    }
    return true;
};
