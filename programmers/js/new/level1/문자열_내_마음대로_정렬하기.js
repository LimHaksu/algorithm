function solution(strings, n) {
    for (let i = 0; i < strings.length; ++i) {
        strings[i] = strings[i].charAt(n) + strings[i];
    }
    strings.sort();
    for (let i = 0; i < strings.length; ++i) {
        strings[i] = strings[i].substring(1);
    }
    return strings;
}
