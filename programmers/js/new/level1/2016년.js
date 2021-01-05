function solution(a, b) {
    a--;
    let days = 0;
    const daysInMonth = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
    for (let i = 0; i < a; ++i) {
        days += daysInMonth[i];
    }
    days += b;
    const weekDays = ["THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"];
    return weekDays[days % 7];
}
