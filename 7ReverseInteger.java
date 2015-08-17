public class Solution7
{
    /**
     * 这道题充分体现了java统一基本类型位数的方便。用python简直没法搞。
     * 主要思路：循环取余，乘以10作为输出的进位
     * @author yunsheng
     */
    public int reverse(int x)
    {
        long m = 0;
        while (x != 0)
        {
            m = m * 10;

            m += x % 10;
            x = x / 10;

            if (m > Integer.MAX_VALUE || m < Integer.MIN_VALUE)
            {
                return 0;
            }
        }
        m += x;
        if (m > Integer.MAX_VALUE || m < Integer.MIN_VALUE)
        {
            m = 0;
        }
        return (int) m;
    }
}
