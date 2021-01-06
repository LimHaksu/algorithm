function solution(numbers, hand) {
    let answer = "";
    const position = {
        1: [0, 0],
        2: [0, 1],
        3: [0, 2],
        4: [1, 0],
        5: [1, 1],
        6: [1, 2],
        7: [2, 0],
        8: [2, 1],
        9: [2, 2],
        "*": [3, 0],
        0: [3, 1],
        "#": [3, 2],
    };
    let leftNum = "*";
    let rightNum = "#";
    numbers.forEach((number) => {
        switch (number) {
            case 1:
            case 4:
            case 7:
                answer += "L";
                leftNum = number;
                break;
            case 3:
            case 6:
            case 9:
                answer += "R";
                rightNum = number;
                break;
            default:
                const leftDist = getDistance(position, number, leftNum);
                const rightDist = getDistance(position, number, rightNum);
                if (leftDist < rightDist) {
                    answer += "L";
                    leftNum = number;
                } else if (leftDist > rightDist) {
                    answer += "R";
                    rightNum = number;
                } else {
                    if (hand === "left") {
                        answer += "L";
                        leftNum = number;
                    } else {
                        answer += "R";
                        rightNum = number;
                    }
                }
        }
    });
    return answer;
}

function getDistance(position, num1, num2) {
    const num1Pos = position[num1];
    const num2Pos = position[num2];
    return Math.abs(num1Pos[0] - num2Pos[0]) + Math.abs(num1Pos[1] - num2Pos[1]);
}
