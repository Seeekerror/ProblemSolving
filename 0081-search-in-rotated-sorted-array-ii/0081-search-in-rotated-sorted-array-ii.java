class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length - 1;
        return binary(nums, target, 0, n);
    }

    boolean binary(int[] nums, int tar, int l, int r) {
        if (l > r)
            return false;
        int mid = l + (r - l) / 2;
        if (nums[mid] == tar)
            return true;
        if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
            return binary(nums, tar, l + 1, r)
                    || binary(nums, tar, l, r - 1);
        }
        if (nums[mid] < nums[r]) {
            if (nums[mid] < tar && tar <= nums[r]) {
                return binary(nums, tar, mid + 1, r);
            } else {
                return binary(nums, tar, l, mid - 1);
            }
        } else {
            if (nums[l] <= tar && tar < nums[mid]) {
                return binary(nums, tar, l, mid - 1);
            } else {
                return binary(nums, tar, mid + 1, r);
            }
        }
    }
}