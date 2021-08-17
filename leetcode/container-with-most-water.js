const findBiggerLeftIndex = (arr, ci) => {
    const cn = arr[ci];
    ci++;
    while (ci < arr.length) {
        if (arr[ci] > cn) {
            return ci;
        } else {
            ci++;
        }
    }
    return ci;
};

const findBiggerRightIndex = (arr, ci) => {
    const cn = arr[ci];
    ci--;
    while (ci >= 0) {
        if (arr[ci] > cn) {
            return ci;
        } else {
            ci--;
        }
    }
    return ci;
};

/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function (height) {
    let left = 0;
    let right = height.length - 1;
    let hl = height[left];
    let hr = height[right];
    let max = (right - left) * Math.min(hl, hr);
    while (true) {
        if (hl < hr) {
            left = findBiggerLeftIndex(height, left);
        } else {
            right = findBiggerRightIndex(height, right);
        }
        if (left >= right) {
            break;
        }
        hl = height[left];
        hr = height[right];
        max = Math.max(max, (right - left) * Math.min(hl, hr));
    }
    return max;
};
