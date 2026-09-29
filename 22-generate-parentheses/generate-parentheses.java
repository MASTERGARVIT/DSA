import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        solve(n, 0, 0, "", ans);
        return ans;
    }
    void solve(int n, int open, int close,
               String temp, List<String> ans) {
        if (open == n && close == n) {
            ans.add(temp);
            return;
        }
        if (open < n) {
            solve(n, open + 1, close, temp + "(", ans);
        }
        if (close < open) {
            solve(n, open, close + 1, temp + ")", ans);
        }
    }
}