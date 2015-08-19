package leetcode;

public class Solution9
{
    /**
     *
     * <一句话功能简述>
     * 1,可以用上一题反转比较，只是注意一下反转可能越界，越界肯定不是回文数。
     * 2,本题解法，两端逼近比较
     *
     * 注意：通过用例来看负数不算
     * 如果负数算的话，请注意Integer.MIN_VALUE，-2147483648,
     * 取绝对值的时候，取反2147483648已经越界了，根据二进制表示,-2147483648还是-2147483648
     * @author yunsheng
     */
    public boolean isPalindrome(int x)
    {
        //        if(x == Integer.MIN_VALUE)
        //        {
        //            return false;
        //        }
        //        x = Math.abs(x);
        if (x < 0)
        {
            return false;
        }
        // 得到入参的位数
        int div = 1;
        while (x / div > 9)
        {
            div *= 10;
        }

        int vid = 10;
        while (div >= vid)
        {
            int a = (x % vid) / (vid / 10); //最低位
            int b = (x / div) % 10; //最高位
            if (a != b)
            {
                return false;
            }
            else
            {
                // 每次循环，减一下
                vid *= 10;
                div /= 10;
            }
        }
        return true;
    }
}
