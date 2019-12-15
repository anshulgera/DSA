class EvalTree {
    public int evalTree(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return Integer.parseInt(root.data);
        }
        String op = root.data;
        int left = evalTree(root.left);
        int right = evalTree(root.right);

        if (op.equals("+")) {
            return left + right;
        } else if (op.equals("-")) {
            return left - right;
        } else if (op.equals("*")) {
            return left * right;
        } else
            return left / right;

    }
}