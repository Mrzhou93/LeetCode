package src;

import java.util.Stack;

/**
 * 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。
 * 例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 * 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
 * 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 * 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
 *
 *
 * 示例 1：
 *
 * 输入："(()())(())"
 * 输出："()()()"
 * 解释：
 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 * 示例 2：
 *
 * 输入："(()())(())(()(()))"
 * 输出："()()()()(())"
 * 解释：
 * 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
 * 删除每隔部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
 * 示例 3：
 *
 * 输入："()()"
 * 输出：""
 * 解释：
 * 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
 * 删除每个部分中的最外层括号后得到 "" + "" = ""。
 *
 *
 * 提示：
 *
 * S.length <= 10000
 * S[i] 为 "(" 或 ")"
 * S 是一个有效括号字符串
 * */

class N5016removeOuterParentheses {
    public String removeOuterParentheses(String S) {
        Stack<Character> stack = new Stack<>();
        int index[] = new int[S.length()];
        int k = 0;

        for (int i = 0; i < S.length(); i++){
            if (stack.size() == 0){
                index[k++] = i + 1;
            }
            if (S.charAt(i) == '('){
                stack.push(S.charAt(i));
            } else {
                stack.pop();
                if (stack.isEmpty()){
                    index[k++] = i;
                }
            }
        }

        String result = "";
        for (int i = 0, j = 1; i < k &&j < k; i += 2, j+=2){
            result += S.substring(index[i], index[j]);
        }

        return result;
    }

    public static void main(String [] args){
        String s0 = "(()())";
        String s1 = "(()())(())";
        String s2 = "(()())(())(()(()))";
        String s3 = "(()(()))";

        N5016removeOuterParentheses s = new N5016removeOuterParentheses();
        System.out.println(s.removeOuterParentheses(s2));
    }
}
