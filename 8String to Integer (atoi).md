
题目很简单，但是要考虑全面。如超过最大最小值
用例也很变态，  

        assertEquals(0,  s8.myAtoi("q12ww3"));
        assertEquals(-12,  s8.myAtoi("  -0012a42"));
        assertEquals(2147483647,  s8.myAtoi("2147483648"));
        assertEquals(0,  s8.myAtoi("   - 321"));
        assertEquals(-2147483648,  s8.myAtoi("      -11919730356x"));

代码：

    public class Solution {
        public int myAtoi(String str) {
            
            if (null == str)
            {
                return 0;
            }
    
            String s = str.trim();
            String flag = "";
            if (s.startsWith("-") || s.startsWith("+"))
            {
                flag = s.substring(0, 1);
                s = s.substring(1);
            }
    
            if ("".equals(s))
            {
                return 0;
            }
            s = s.replaceFirst("\\D", "#");
            if(s.indexOf("#") != -1)
            {
                s = s.substring(0, s.indexOf("#"));
            }
    
            if ("".equals(s))
            {
                return 0;
            }
            if(s.length() > 10)
            {
                return "-".equals(flag)?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
    
            if("-".equals(flag))
            {
                s = "-"+s;
            }
             if(Long.parseLong(s) > Integer.MAX_VALUE)
            {
                return Integer.MAX_VALUE;
            }
  
          if(Long.parseLong(s) < Integer.MIN_VALUE)
          {
              return Integer.MIN_VALUE;
          }
          return Integer.parseInt(s);
      }
  }
