package leetcode;

import java.util.Arrays;

/**
 *
 * 核心思想：
 * 1，如果数组a的第k个数小于数组b的第k个数，那么合并数组ab的大数组的第2k个数一定是在数组a的k往后，数组b的k往前
 * 2，两个数组截掉同样的长度，中位数不变。
 * 注意，本题要求的中位数，如果是偶数，求的结果是中间两个数的平均值
 * 所以，在截取的时候，对于偶数长度的数组，下中位数和上中位数都不能丢！！！
 * @author  yunsheng
 * @version
 */
public class Solution4
{
    // 核心思想，两个数组截掉同样的长度，中位数不变。
    public double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        double result = 0;
        // 终止条件 ：至少一个数组长度<=2
        if (nums1.length <= 2 || nums2.length <= 2)
        {
            result = getFinish(nums1, nums2);
        }
        else
        {
            double m1 = nums1[nums1.length / 2];
            double m2 = nums2[nums2.length / 2];

            // 要被截掉的长度
            int cutlen = 0;

            if (m1 >= m2)
            {
                //  m1 > m2，那么中位数一定在数组1的前半部分和数组2的后半部分,所以截掉剩余的部分，不能把m1m2截掉
                // 注意,对于偶数长度的数组，下中位数和上中位数都不能丢！！！
                int cutl1 = nums1.length - nums1.length / 2 - 1;
                int cutl2 = nums2.length % 2 == 0 ? (nums2.length / 2 - 1)
                        : (nums2.length / 2);
                // 两个数组每次截掉的长度必须一样，也就是==短的数组截掉的长度
                cutlen = cutl1 <= cutl2 ? cutl1 : cutl2;
                int[] inNums1 = new int[nums1.length - cutlen];
                int[] inNums2 = new int[nums2.length - cutlen];
                System.arraycopy(nums1, 0, inNums1, 0, nums1.length - cutlen);
                System.arraycopy(nums2, cutlen, inNums2, 0, nums2.length
                        - cutlen);
                result = findMedianSortedArrays(inNums1, inNums2);
            }
            else
            {
                //  m1 < m2，那么中位数一定在数组1的后半部分和数组2的前半部分
                // 两个数组每次截掉的长度必须一样，也就是==短的数组截掉的长度
                // 注意,对于偶数长度的数组，下中位数和上中位数都不能丢！！！
                // 取后半段，可能丢掉下中位数，要往后减一位
                int cutl1 = nums1.length % 2 == 0 ? (nums1.length / 2 - 1)
                        : nums1.length / 2;
                // 取前半段时，已经是上中位数了，不需要再往后减一位
                int cutl2 = nums2.length - nums2.length / 2 - 1;
                // 两个数组每次截掉的长度必须一样，也就是==短的数组截掉的长度
                cutlen = cutl1 <= cutl2 ? cutl1 : cutl2;
                int[] inNums1 = new int[nums1.length - cutlen];
                // 不论原数组是奇数还是偶数都成立
                int[] inNums2 = new int[nums2.length - cutlen];
                System.arraycopy(nums1, cutlen, inNums1, 0, nums1.length
                        - cutlen);
                System.arraycopy(nums2, 0, inNums2, 0, nums2.length - cutlen);
                result = findMedianSortedArrays(inNums1, inNums2);
            }
        }
        return result;
    }

    private double getFinish(int[] nums1, int[] nums2)
    {
        int[] results = new int[nums1.length + nums2.length];
        if (nums1.length <= nums2.length)
        {
            System.arraycopy(nums2, 0, results, 0, nums2.length);
            for (int i = 0; i < nums1.length; i++)
            {
                results[nums2.length + i] = nums1[i];
            }
        }
        else
        {
            System.arraycopy(nums1, 0, results, 0, nums1.length);
            for (int i = 0; i < nums2.length; i++)
            {
                results[nums1.length + i] = nums2[i];
            }
        }
        Arrays.sort(results);

        return results.length % 2 == 0 ? (results[results.length / 2] + results[results.length / 2 - 1]) / 2.0
                : results[results.length / 2];
    }
}
