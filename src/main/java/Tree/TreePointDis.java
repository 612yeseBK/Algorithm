package Tree;

import org.junit.Test;

/**
 * 完成求二叉树中节点间最大距离的代码。
 * 两个节点间的距离为包括的节点的个数，
 * 路径上的每个节点只能被包含一次。
 */
public class TreePointDis {
    public Result GetMaximumDistance(MyTree myTree) {
        Result lhs;
        Result rhs;
        Result result1 = new Result();
        result1.nMaxDepth = 0;
        result1.nMaxDistance = 0;
        if(myTree.data == null){
            return result1;
        }
        lhs = (myTree.left == null)?result1:GetMaximumDistance(myTree.left);
        rhs = (myTree.right == null)?result1:GetMaximumDistance(myTree.right);

        Result result = new Result();
        // 这里记录的nMaxDepth是指最深路径上的节点的个数(包括他自己），不是实际意义上的树的高度
        result.nMaxDepth = Math.max(lhs.nMaxDepth + 1, rhs.nMaxDepth + 1);
        // 这里记录的nMaxDistance是指以该节点为根节点的子树里面的任意节点之间的最大距离（以节点数计算）
        // lhs.nMaxDepth + rhs.nMaxDepth + 1是指，左子树最深路径上的节点数与右子树最深路径的节点数之和加上根节点所形成的最长路径
        // lhs.nMaxDistance, rhs.nMaxDistance分别是左右子树内部各自的最长路径
        result.nMaxDistance = Math.max(Math.max(lhs.nMaxDistance, rhs.nMaxDistance), lhs.nMaxDepth + rhs.nMaxDepth + 1);
        return result;
    }

    @Test
    public void testGetMaximumDistance(){
        TreePointDis treeMaxDis = new TreePointDis();
        MyTree myTree = new MyTree();
        myTree.data=0;
        myTree.left=RandomMyTree.getRandomTree();
        myTree.left.left=RandomMyTree.getRandomTree();
        myTree.left.left.left=RandomMyTree.getRandomTree();
        myTree.left.left.right=RandomMyTree.getRandomTree();
        myTree.left.right=RandomMyTree.getRandomTree();
        myTree.left.right.right=RandomMyTree.getRandomTree();
        myTree.left.right.right.right=RandomMyTree.getRandomTree();
        myTree.left.right.right.right.right=RandomMyTree.getRandomTree();
        myTree.right=RandomMyTree.getRandomTree();
        myTree.right.right=RandomMyTree.getRandomTree();
        myTree.right.left=RandomMyTree.getRandomTree();
        Result finalResult = treeMaxDis.GetMaximumDistance(myTree);
        System.out.println(finalResult);
    }
}
