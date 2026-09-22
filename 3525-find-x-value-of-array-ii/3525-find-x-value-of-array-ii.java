class Solution {

    class Node {
        int product;
        int[] count;

        Node(int k) {
            count = new int[k];
            product = 1 % k;
        }
    }

    int k;
    Node merge(Node left, Node right) {
        Node result = new Node(k);

        result.product = (left.product * right.product) % k;
        for (int r = 0; r < k; r++) {
            result.count[r] = left.count[r];
        }
        for (int r = 0; r < k; r++) {
            int newRemainder = (left.product * r) % k;
            result.count[newRemainder] += right.count[r];
        }
        return result;
    }
    Node[] tree;
    void build(int node, int start, int end, int[] nums) {
        if (start == end) {
            tree[node] = new Node(k);
            int value = nums[start] % k;
            tree[node].product = value;
            tree[node].count[value] = 1;
               return;
        }
        int mid = (start + end) / 2;
        build(2 * node, start, mid, nums);
        build(2 * node + 1, mid + 1, end, nums);
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }
    void update(int node, int start, int end, int index, int value) {
        if (start == end) {
            tree[node] = new Node(k);
            value %= k;
            tree[node].product = value;
            tree[node].count[value] = 1;
            return;
        }
        int mid = (start + end) / 2;
        if (index <= mid) {
            update(2 * node, start, mid, index, value);
        } else {
            update(2 * node + 1, mid + 1, end, index, value);
        }
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }
    Node query(int node, int start, int end, int left, int right) {
        if (left <= start && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        if (right <= mid) {
            return query(2 * node, start, mid, left, right);
        }
        if (left > mid) {
            return query(2 * node + 1, mid + 1, end, left, right);
        }
        Node leftNode = query(2 * node, start, mid, left, right);
        Node rightNode = query(2 * node + 1, mid + 1, end, left, right);
        return merge(leftNode, rightNode);
    }
    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.k = k;
        int n = nums.length;
        tree = new Node[4 * n];
        build(1, 0, n - 1, nums);
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];
            update(1, 0, n - 1, index, value);
            Node result = query(1, 0, n - 1, start, n - 1);
            answer[i] = result.count[x];
        }
        return answer;
    }
}