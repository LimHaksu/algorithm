function solution(x) {
    return (
        x %
            x
                .toString()
                .split("")
                .reduce((acc, current) => acc + parseInt(current), 0) ===
        0
    );
}
