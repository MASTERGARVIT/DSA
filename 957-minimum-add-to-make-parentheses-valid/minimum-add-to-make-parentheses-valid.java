class Solution {
    public int minAddToMakeValid(String s) {
        int o = 0;
        int add = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                o++;
            } else {
                if (o > 0) {
                    o--;
                } else {
                    add++;
                }
            }
        }
        return add + o;
    }
}
