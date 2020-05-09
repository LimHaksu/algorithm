const MAX_SIZE = 100000;
let heap = Array(MAX_SIZE);
let heapSize = 0;

function heapInit() {
    heapSize = 0;
}

function heapPush(value) {
    if (heapSize + 1 > MAX_SIZE) {
        return 0;
    }

    heap[heapSize] = value;

    let current = heapSize;
    while (current > 0 && heap[current] < heap[(current - 1) / 2]) {
        let temp = heap[(current - 1) / 2];
        heap[(current - 1) / 2] = heap[current];
        heap[current] = temp;
        current = (current - 1) / 2;
    }

    heapSize = heapSize + 1;

    return 1;
}

function heapPop() {
    if (heapSize <= 0) {
        return -1;
    }

    let value = heap[0];
    heapSize = heapSize - 1;

    heap[0] = heap[heapSize];

    let current = 0;
    while (current * 2 + 1 < heapSize) {
        let child;
        if (current * 2 + 2 == heapSize) {
            child = current * 2 + 1;
        }
        else {
            child = heap[current * 2 + 1] < heap[current * 2 + 2] ? current * 2 + 1 : current * 2 + 2;
        }

        if (heap[current] < heap[child]) {
            break;
        }

        let temp = heap[current];
        heap[current] = heap[child];
        heap[child] = temp;

        current = child;
    }
    return value;
}

let T, N;

T = 1;

for (let test_case = 1; test_case <= T; test_case++) {
    N = 3;
    heapInit();
    let arr = [3, 1, 2];
    for (let i = 0; i < N; i++) {
        let value = arr[i];
        heapPush(value);
    }

    console.log(`#${test_case}`)

    for (let i = 0; i < N; i++) {
        let value = heapPop();
        console.log(value);
    };
}
return 0;