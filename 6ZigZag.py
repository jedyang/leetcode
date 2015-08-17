class Solution:
    # @param {string} s
    # @param {integer} numRows
    # @return {string}
    # 这叫锯齿形的数据
    ```
    A     G     M
    B   F H   L N
    C E   I K   O
    D     J     P
    ```
    # 主要思路是用字典存储行与该行的数据，然后判断每个字符属于哪行，加入对应的字典中
    def convert(self, s, numRows):
        resultDict = {}
        step = 2 * numRows - 2
        if step == 0:
            return s
        for index in range(0, len(s)):
            tempInt = index % step
            if tempInt >= numRows:
                tempInt = numRows - 1 - (tempInt - numRows + 1)
            if not (tempInt in resultDict):
                resultDict[tempInt] = []
            tempList = resultDict.get(tempInt)
            tempList.append(s[index])
        values = resultDict.values()
        result = []
        for tempList in values:
            result.extend(tempList)
        return ''.join(result)
