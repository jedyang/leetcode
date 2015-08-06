  我写的二分查找算法，log（n）      
  
        public static int search(int[] src, int target)
            {
                int temp = src.length / 2;
                int left = 0;
                int right = src.length-1;
        
                while (!(src[temp] == target))
                {
                    if (left == right)
                    {
                        return -1;
                    }
        
                    if (src[temp] > target)
                    {
                        right = temp - 1;
                    }
                    else
                    {
                        left = temp + 1;
                    }
                    temp = left + (right - left) / 2;
                }
        
                return temp;
            }
