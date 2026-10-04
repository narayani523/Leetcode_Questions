class Solution {
    public boolean checkValidString(String s) {

        int low = 0;   // minimum possible '('
        int high = 0;  // maximum possible '('

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                low++;
                high++;
            }

            else if (ch == ')') {
                low--;
                high--;
            }

            else { // '*'
                low--;   // assume * = ')'
                high++;  // assume * = '('
            }

            // We can never have negative minimum opens
            if (low < 0) {
                low = 0;
            }

            // Even maximum possible opens became negative
            if (high < 0) {
                return false;
            }
        }

        return low == 0;
    }
}