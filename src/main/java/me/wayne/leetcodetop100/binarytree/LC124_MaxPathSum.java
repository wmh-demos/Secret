package me.wayne.leetcodetop100.binarytree;

import me.wayne.leetcodetop100.TreeNode;

/**
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。
 * 该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * <p>
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * <p>
 * 题解：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/solution/javadi-gui-zi-ding
 * -xiang-xia-bang-zhu-ji-8bmv/
 * 站在根节点的角度思考，有四种结果：
 * 1.我自己就是一条路径
 * 2.只跟左子节点合并成一条路径
 * 3.只跟右子节点合并成一条路径
 * 4.以自己为桥梁，跟左、右子节点合并成一条路径
 * <p>
 * 当节点以自己为桥梁连接两边形成一条路径时，根据路径定义，其祖先节点不再可能加入到这条路径中。
 * 也就是说这种情况下，它是解的一种可能，但不符合我们递归返回值的定义。
 */
public class LC124_MaxPathSum {

    int pathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return pathSum;
    }

    // dfs 返回以该节点为端点的最大路径和
    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);
        // 当前节点有四个选择：
        // 1）独立成线，直接返回自己的值
        // 2）跟左子节点合成一条路径
        // 3）跟右子节点合成一条路径
        int ret = Math.max(node.val, node.val + Math.max(left, right));
        // 4）以自己为桥梁，跟左、右子节点合并成一条路径
        pathSum = Math.max(pathSum, Math.max(ret, node.val + left + right));
        return ret;
    }
}
