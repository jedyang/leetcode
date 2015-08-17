# encoding:utf-8
class Solution:
    # @param {string} s
    # @return {string}

    def longestPalindrome(self, s):
        '''
        朴素解法，算法复杂度O（n^2）
        '''
        result = ''
        for i in range(len(s)):
            temp = s[i]
            for j in range(1, len(s)-i):
                if(i - j > 0 and i+j < len(s) and s[i+j] == s[i-j]):
                    temp = s[i-j]+temp + s[i+j]
            if(len(result) < len(temp)):
                result = temp

            temp = s[i]
            for j in range(1, len(s)-i):
                if(i - j+1 > 0 and i+j < len(s) and s[i-j+1] == s[i+j]):
                    if j == 1:
                        temp = temp + s[i+j]
                    else:
                        temp = s[i-j+1]+temp + s[i+j]
            if(len(result) < len(temp)):
                result = temp

        return result

    def manacher(self, s):
        '''
        （题干也没说字符串不包括特殊字符。。所以开始没打算用manacher算法）
        Manacher算法,算法复杂度可以达到O(n)
        1, 在原字符每个字符的前后加上一个特殊字符。如#，这样可以将奇偶统一化
        2，引入一个标记每个字符对应的回文字符串长度的数组，p
        3，根据对称，有这样的结论：如果i和j关于m对称，i在左，j在右。如果m+p[m] >= j + p[i],
        即j的对称范围在m的对称范围内，那么p[j] == p[i],也就是说不用for循环j了。
        另一种情况是m+p[m] < j + p[i],即j的对称范围已经超出m的对称范围内，
        不能保证p[j] == p[i],我们只能取能保证的范围即m+p[m]-j
         '''
        s = self.changeS(s)
        #print(s)
        p = [0] * len(s)
        # 对称点
        m = 0
        # 最大对称范围即m+p[m]
        mx = 0
        for x in range(1, len(s)-1):
            if mx >= (x + p[2 * m - x]):
                p[x] = p[2 * m - x]
            elif mx > x:
                p[x] = mx - x
            else:
                p[x] = 1
            # print(str(x)+"  "+str(p[x]))
            while x+p[x] < len(s) and s[x+p[x]] == s[x-p[x]]:
                p[x] += 1

            if x+p[x] > mx:
                mx = x + p[x]
                m = x
        # print(p)
        m = p.index(max(p))
        return s[m-p[m]+1: m+p[m]].replace('#', '').replace('$', '')

    def changeS(self, s):
        result = ''
        for x in s:
            result = result + '#' + x
        result = result + '#'
        # 为防止数组越界，在两侧加特殊字符
        return '$'+result+'$'

if __name__ == '__main__':
    # print(Solution().longestPalindrome("vbpgvehmsdocuqfnpzsqqsjbjkvzpqsubqbpjhzojdtkjcambviauhsxqvejgehzrhhvrgulubmirbppvbkftvazscxifsxtoarrdeyuihzcenqendvnthfdpotgpegdlaildigloesnfxkjichsxygazrvgbecuzkcdrgextmysxqerrueecpneynciasevytmatvqgleipwlaxwgajijkuceezmbtiigc"))
    # print(Solution().manacher("abba"))
    # print(Solution().manacher("ababa"))
    print(Solution().manacher("ccd"))
    print(Solution().manacher("a"))
    # print(Solution().manacher("abaab"))
    # print(Solution().manacher("vbpgvehmsdocuqfnpzsqqsjbjkvzpqsubqbpjhzojdtkjcambviauhsxqvejgehzrhhvrgulubmirbppvbkftvazscxifsxtoarrdeyuihzcenqendvnthfdpotgpegdlaildigloesnfxkjichsxygazrvgbecuzkcdrgextmysxqerrueecpneynciasevytmatvqgleipwlaxwgajijkuceezmbtiigc"))
