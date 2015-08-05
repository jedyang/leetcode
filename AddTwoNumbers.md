You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

    //我的解，v1.0.待改进点：代码丑陋，有重复代码
    public class Solution2
    {
      public ListNode addTwoNumbers(ListNode l1, ListNode l2)
      {
          int carry = 0;
  
          int value1 = l1.val;
          int value2 = l2.val;
          int value3 = value1 + value2 + carry;
          // 进位
          carry = value3 / 10;
          value3 = value3 % 10;
          ListNode nodeResult = new ListNode(value3);
  
          l1 = l1.next;
          l2 = l2.next;
  
          ListNode temp = nodeResult;
          while (null != l1 || null != l2)
          {
              value1 = null != l1?l1.val:0;
              value2 = null != l2?l2.val:0;
              value3 = value1 + value2 + carry;
              // 进位
              carry = value3 / 10;
              value3 = value3 % 10;
  
              ListNode l3 = new ListNode(value3);
  
  
              temp.next = l3;
              temp = temp.next;
  
              l1 = null == l1 ? null : l1.next;
              l2 = null == l2 ? null : l2.next;
          }
  
          if(carry == 1)
          {
              temp.next = new ListNode(1);
          }
          return nodeResult;
      }
  }
