/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function (nums, target) {
    nums = nums.map((e, i) => ({ num: e, index: i }));
    nums.sort((a, b) => a.num - b.num);
    for (let i = 0; i < nums.length; ++i) {
        const foundIndex = findNum(target - nums[i].num, nums);
        if (foundIndex >= 0 && foundIndex !== nums[i].index) {
            return [foundIndex, nums[i].index];
        }
    }
};

const findNum = function (target, nums) {
    let left = 0;
    let right = nums.length - 1;
    while (left <= right) {
        const mid = parseInt((left + right) / 2);
        if (nums[mid].num === target) {
            return nums[mid].index;
        } else if (nums[mid].num < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return -1;
};
