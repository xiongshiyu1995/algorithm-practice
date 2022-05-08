package week.three;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XiongShiyu
 * @description ConstructBinaryTree
 * @date 2022/5/8 22:38
 */
public class ConstructBinaryTree {

    public class TreeNode {
        int val;TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int[] inorder;

    private int[] postorder;

    private Map<Integer, Integer> map = new HashMap();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode tree = tryFind(0, inorder.length - 1, 0, postorder.length - 1);
        return tree;
    }

    public TreeNode tryFind(int istart, int iend, int start, int end) {
        if(start > end || istart > iend) {
            return null;
        }
        TreeNode tree = new TreeNode();
        tree.val = this.postorder[end];
        Integer index = map.get(this.postorder[end]);
        tree.left = tryFind(istart, index - 1, start, start - istart + index - 1);
        tree.right = tryFind(index + 1, iend, start - istart + index, end - 1);
        return tree;
    }
}
