import java.util.*;

class Solution {
    public String getHappyString(int n, int k) {
        List<String> res = new ArrayList<>();
        backtrack(n, "", res);
        return res.size() >= k ? res.get(k - 1) : "";
    }

    private void backtrack(int n, String cur, List<String> res) {
        if (cur.length() == n) {
            res.add(cur);
            return;
        }

        for (char ch : new char[]{'a', 'b', 'c'}) {
            if (cur.isEmpty() || cur.charAt(cur.length() - 1) != ch) {
                backtrack(n, cur + ch, res);
            }
        }
    }
}
