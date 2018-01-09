package Tree;

import org.junit.Test;

public class TreeMaxDis {
    public Result GetMaximumDistance(MyTree myTree) {
        Result lhs;
        Result rhs;
        Result result1 = new Result();
        result1.nMaxDepth = -1;
        result1.nMaxDistance = 0;
        if(myTree.data == null){
            return result1;
        }
        lhs = (myTree.left == null)?result1:GetMaximumDistance(myTree.left);
        rhs = (myTree.right == null)?result1:GetMaximumDistance(myTree.right);

        Result result = new Result();
        result.nMaxDepth = Math.max(lhs.nMaxDepth + 1, rhs.nMaxDepth + 1);
        result.nMaxDistance = Math.max(Math.max(lhs.nMaxDistance, rhs.nMaxDistance), lhs.nMaxDepth + rhs.nMaxDepth + 2);
        return result;
    }

    @Test
    public void testGetMaximumDistance(){
        TreeMaxDis treeMaxDis = new TreeMaxDis();
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
