/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function (nums) {
    let maxIndex = 0;
    nums.forEach((num, index) => {
        if (maxIndex >= index) {
            maxIndex = Math.max(maxIndex, index + num);
        }
    });
    return maxIndex >= nums.length - 1;
};
