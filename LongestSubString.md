### 版本1.0。效率太差，用例超时"hvghvgiokykkkuycnymvwydagicanorwladiilxsmhfwedytenocltcsdfusvnognrrvfoqrxv"
      package leetcode;
      
      import java.util.regex.Matcher;
      import java.util.regex.Pattern;
      
      /**
       *
       * 求最短子串
       * Given a string, find the length of the longest substring without repeating characters.
       * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
       * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
       *
       * @author  yunsheng
       * @version  1.0
       */
      public class Solution3
      {
          // tcp的滑动窗口
          public int lengthOfLongestSubstring(String s)
          {
              int result = 1;
      
              // 窗口大小
              int window = s.length();
      
              String subStr = "";
              while (window > 1)
              {
                  for (int i = 0; i + window < s.length(); i++)
                  {
                      subStr = s.substring(i, i + window);
                      boolean noReduplicate = checkStr(subStr);
                      if(noReduplicate)
                      {
                          return window;
                      }
                  }
                  window--;
              }
      
              return result;
          }
      
          // 检查是否有重复的字符
          // 没有返回true
          private boolean checkStr(String subStr)
          {
              for(char c : subStr.toCharArray())
              {
                  int repeatTimes = getRepeatTimes(subStr,String.valueOf(c));
                  if(repeatTimes > 1)
                  {
                      return false;
                  }
      
              }
              return true;
          }
      
          // 获取源字符串中某字符串的重复次数
          private int getRepeatTimes(String srcStr, String value)
          {
              int count = 0;
              Pattern pattern = Pattern.compile(value);
              Matcher matcher = pattern.matcher(srcStr);
              while(matcher.find())
              {
                  count++;
              }
              return count;
          }
      }
### 版本2.0。剪掉了一个for循环，执行效率提升一个数量级。但是仍有用例超时。
 
      public class Solution3
      {
          // tcp的滑动窗口
          public int lengthOfLongestSubstring(String s)
          {
              int result = 1;
      
              // 窗口大小
              int window = s.length();
      
              String subStr = "";
              while (window > 1)
              {
                  for (int i = 0; i + window < s.length(); i++)
                  {
                      subStr = s.substring(i, i + window);
                      boolean noReduplicate = checkStr(subStr);
                      if (noReduplicate)
                      {
                          return window;
                      }
                  }
                  window--;
              }
      
              return result;
          }
      
          // 检查是否有重复的字符
          // 没有返回true
          private boolean checkStr(String subStr)
          {
              for (char c : subStr.toCharArray())
              {
      
                  int first = subStr.indexOf(c);
                  int last = subStr.lastIndexOf(c);
                  if (first != last)
                  {
                      return false;
                  }
      
              }
              return true;
          }
      }
### 版本3.0。这个复杂度应该是O(n)了吧，居然还是超时。。。。。  

    public int lengthOfLongestSubstring(String s)
    {
        String max = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
        {

            String temp = String.valueOf(s.charAt(i));
            if (-1 != sb.indexOf(temp))
            {
                sb.delete(0, sb.indexOf(temp) + 1);
            }
            sb.append(temp);
            if (max.length() < sb.length())
            {
                max = sb.toString();
            }
        }
        return max.length();
    }
### 最后证明，版本3没问题。再提交一遍通过。可能第一次提交时，恰好服务器压力太大吧
