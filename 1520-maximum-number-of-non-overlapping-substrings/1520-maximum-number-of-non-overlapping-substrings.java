class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        for (int i = 0; i < 26; i++) {
            first[i] = n;
            last[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            first[index] = Math.min(first[index], i);
            last[index] = i;
        }
        List<String> result = new ArrayList<>();
        int previousEnd = -1;
        for (int i = 0; i < n; i++) {
            int charIndex = s.charAt(i) - 'a';
            if (i != first[charIndex]) {
                continue;
            }
            int left = i;
            int right = last[charIndex];
            boolean valid = true;
            for (int j = left; j <= right; j++) {
                int current = s.charAt(j) - 'a';
                if (first[current] < left) {
                    valid = false;
                    break;
                }
                right = Math.max(right, last[current]);
            }
            if (!valid) {
                continue;
            }
            if (left > previousEnd) {
                result.add(s.substring(left, right + 1));
                previousEnd = right;
            } 
            else {
                result.set(result.size() - 1, s.substring(left, right + 1));
                previousEnd = right;
            }
        }
        return result;
    }
}