class Solution {
    Set<String> ans = new HashSet<>();
    String s;
    int n;

    public List<String> removeInvalidParentheses(String s) {
        this.s = s;
        this.n = s.length();

        int leftRemove = 0;
        int rightRemove = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftRemove++;
            } 
            else if (c == ')') {
                if (leftRemove > 0) {
                    leftRemove--;
                } 
                else {
                    rightRemove++;
                }
            }
        }

        dfs(0, leftRemove, rightRemove, 0, 0, "");

        return new ArrayList<>(ans);
    }

    void dfs(int i, int leftRemove, int rightRemove,
             int leftCount, int rightCount, String curr) {

        if (i == n) {
            if (leftRemove == 0 && rightRemove == 0) {
                ans.add(curr);
            }
            return;
        }

        if (leftCount < rightCount) {
            return;
        }

        char c = s.charAt(i);

        // Remove current character
        if (c == '(' && leftRemove > 0) {
            dfs(i + 1, leftRemove - 1, rightRemove,
                leftCount, rightCount, curr);
        }

        if (c == ')' && rightRemove > 0) {
            dfs(i + 1, leftRemove, rightRemove - 1,
                leftCount, rightCount, curr);
        }

        // Keep current character
        if (c == '(') {
            dfs(i + 1, leftRemove, rightRemove,
                leftCount + 1, rightCount, curr + c);
        } 
        else if (c == ')') {
            if (leftCount > rightCount) {
                dfs(i + 1, leftRemove, rightRemove,
                    leftCount, rightCount + 1, curr + c);
            }
        } 
        else {
            dfs(i + 1, leftRemove, rightRemove,
                leftCount, rightCount, curr + c);
        }
    }
}