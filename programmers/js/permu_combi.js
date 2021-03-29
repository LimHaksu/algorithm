function permutation(arr, size) {
    if (typeof arr === "undefined") {
        throw Error("첫번째 파라미터 배열을 입력하세요");
    }
    if (typeof size === "undefined") {
        size = arr.length;
    }

    const result = [];
    const selected = Array.from(Array(arr.length), () => false);
    const stack = [];

    dfs(size, arr, selected, stack);

    function dfs(size, arr, selected, stack) {
        if (stack.length === size) {
            result.push([...stack]);
            return;
        }

        for (let i = 0; i < selected.length; ++i) {
            if (!selected[i]) {
                selected[i] = true;
                stack.push(arr[i]);
                dfs(size, arr, selected, stack);
                stack.pop();
                selected[i] = false;
            }
        }
    }

    return result;
}

function combinations(arr, size) {
    if (typeof arr === "undefined") {
        throw Error("첫번째 파라미터 배열을 입력하세요");
    }
    if (typeof size === "undefined") {
        throw Error("두번째 파라미터 size 를 입력하세요.");
    }
    const result = [];
    const selected = Array.from(Array(arr.length), () => false);

    dfs(size, arr, selected, 0, 0);

    function dfs(size, arr, selected, index, count) {
        if (count === size) {
            const temp = [];
            for (let i = 0; i < selected.length; ++i) {
                if (selected[i]) {
                    temp.push(arr[i]);
                }
            }
            result.push(temp);
            return;
        }
        if (index === arr.length) {
            return;
        }
        selected[index] = true;
        dfs(size, arr, selected, index + 1, count + 1);
        selected[index] = false;
        dfs(size, arr, selected, index + 1, count);
    }

    return result;
}
