function solution(numbers) {
    var answer = [];
    numbers.forEach((num) => {
        answer.push(find_next_num(num));
    });
    return answer;
}

function num_to_binary(numbers) {
    const arr = [];
    while (numbers > 0) {
        arr.push(numbers % 2);
        numbers = Math.floor(numbers / 2);
    }
    if (arr.length === 0) {
        arr.push("0");
    }
    return arr.reverse().join("");
}

function binary_to_num(bi) {
    let result = 0;
    let current = 1;
    for (let i = bi.length - 1; i >= 0; --i) {
        result += parseInt(bi[i]) * current;
        current *= 2;
    }
    return result;
}

function find_next_num(num) {
    let bi = num_to_binary(num);
    let zero_index = find_zero_index(bi);
    if (zero_index === -1) {
        const next_num = "10" + bi.substring(1, bi.length);
        return binary_to_num(next_num);
    }
    bi = bi.substring(0, zero_index) + "1" + bi.substring(zero_index + 1, bi.length);
    zero_index++;
    for (; zero_index < bi.length; ++zero_index) {
        if (bi[zero_index] === "1") {
            bi = bi.substring(0, zero_index) + "0" + bi.substring(zero_index + 1, bi.length);
            break;
        }
    }
    return binary_to_num(bi);
}

function find_zero_index(bi) {
    let zero_index = -1;
    for (let i = bi.length - 1; i >= 0; --i) {
        if (bi[i] === "0") {
            zero_index = i;
            break;
        }
    }
    return zero_index;
}
