/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function (nums) {
    let ci = 0;
    let lastNum = nums[ci++];
    for (let i = 1; i < nums.length; ++i) {
        if (nums[i] !== lastNum) {
            lastNum = nums[i];
            nums[ci++] = nums[i];
        }
    }
    return ci;
};
