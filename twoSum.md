
## 题目
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

## 解1,最简单粗暴的解法。
    public int[] twoSum(int[] nums, int target)
    {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++)
        {
            int j = i + 1;
            for (; j < nums.length; j++)
            {
                if (target == nums[i] + nums[j])
                {
                    result[0] = i + 1;
                    result[1] = j + 1;
                }
            }
        }
        return result;
    }
}
