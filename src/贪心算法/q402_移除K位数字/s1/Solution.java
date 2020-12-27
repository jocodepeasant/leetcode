package 贪心算法.q402_移除K位数字.s1;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 贪心+单调递增栈：
 * 对于两个相同长度的数字序列，如：1axxxx和1bxxxx，决定这两个数大小的为a和b的取值，
 * 基于此，若要使得数字最小，必须要使得最左边的数字尽可能小。
 * 因此，创建一个单调递增栈，对于每个数字，如果该数字小于栈顶元素，我们就不断地弹出栈顶元素，
 * 直到：
 * ·栈为空
 * ·或者新的栈顶元素不大于当前数字
 * ·或者我们已经删除k位数字
 */
class Solution {
    public String removeKdigits(String num, int k) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            if (k == 0) {
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty()) {
                    sb.insert(0, stack.pop());
                }
                sb.append(num.substring(i));
                return sb.toString();
            }
            int n = num.charAt(i) - '0';
            //当前数小于栈顶数，弹出栈顶数
            while (k > 0 && !stack.isEmpty() && stack.getFirst() > n) {
                stack.pop();
                k--;
            }
            //前导数不为0
            if (!(n == 0 && stack.isEmpty())) {
                stack.push(n);
            }
        }
        //还未删除完成，从栈顶删除剩下数
        for (; k > 0; k--) {
            if (stack.isEmpty()) {
                break;
            }
            stack.pop();
        }
        StringBuilder res = new StringBuilder();
        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()) {
            res.insert(0, iterator.next());
        }
        return res.length() == 0 ? "0" : res.toString();
    }

    //简洁写法
    public String removeKdigits1(String num, int k) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            int n = num.charAt(i) - '0';
            if (k > 0) {
                while (!stack.isEmpty() && stack.peek() > n && k > 0) {
                    stack.pop();
                    k--;
                }
            }
            stack.push(n);
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        while (!stack.isEmpty() && stack.peekLast() == 0) {
            stack.pollLast();
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}