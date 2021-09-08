package solution;

public class BinaryTree {
    TreeNode root;

    public int getMaxLeafDepth(TreeNode node, int depth){
        if(isNull(node.right) && isNull(node.left)){
            return depth;
        }

        int maxRightDepth = 0;
        int maxLeftDepth = 0;
        if(!isNull(node.right)){
            maxRightDepth = getMaxLeafDepth(node.right, depth+1);
        }
        if(!isNull(node.left)){
             maxLeftDepth =  getMaxLeafDepth(node.left, depth+1);
        }

        return Math.max(maxLeftDepth, maxRightDepth);

    }

    public int sumDepthsOfLeaves(TreeNode node, int depth){
        int depthSum = -1;
        if(isNull(node.right) && isNull(node.left)){
            depthSum = depth+1;
        }else{
            if(!isNull(node.left)){
                depthSum += sumDepthsOfLeaves(node.left, depth+1);
            }
            if(!isNull(node.right)){
                depthSum+= sumDepthsOfLeaves(node.right, depth+1);
            }
        }
        return depthSum;
    }

    public int leafCounter(TreeNode node){
        int leaves = 0;
        if(isNull(node.right) && isNull(node.left)){
            return 1; //this is a leaf
        }else{
            int leftLeaves;
            int rightLeaves;
            if(isNull(node.left)){
                leftLeaves = 0;
            }else{
                leftLeaves = leafCounter(node.left);
            }
            if(isNull(node.right)){
                rightLeaves = 0;
            }else {
                rightLeaves = leafCounter(node.right);
            }
            leaves = rightLeaves + leftLeaves;
            return leaves;
        }
    }

    public void insertRandomly (TreeNode newNode){
        if(root==null){
            root = newNode;
            return;
        }
        TreeNode runner = root;
        while (true){
            if(runner.right==null&&runner.left==null){
                if(Math.random()>.5){
                    runner.left=newNode;
                }else{
                    runner.right = newNode;
                }
                return;
            }

            else if (runner.right==null) {
                if (Math.random() > .5) {
                    runner.right = newNode;
                    return;
                } else {
                    runner = runner.left;
                }
            }

            else if (runner.left==null){
                if(Math.random()>.5){
                    runner.left = newNode;
                    return;
                }else{
                    runner = runner.right;
                }
            }
            else{
                if(Math.random()>.5){
                    runner = runner.right;
                }else{
                    runner = runner.left;
                }
            }
        }
    }

    public void insertSortedNode(double newNum){
        if(root==null){
            root = new TreeNode(newNum);
            return;
        }
        TreeNode runner = root;
        while (true) {
            if (newNum<runner.doubleItem) {
                if (runner.left == null ) {
                    runner.left =  new TreeNode(newNum);
                    return;
                }
                else
                    runner = runner.left;
            }
            else {
                if (runner.right == null ) {
                    runner.right =  new TreeNode(newNum);
                    return;
                }
                else
                    runner = runner.right;
            }
        }
    }

    public void insertSortedNode(TreeNode newNode){
        if(root==null){
            root = newNode;
            return;
        }
        TreeNode runner = root;
        while (true) {
            if (newNode.doubleItem<runner.doubleItem) {
                if ( runner.left == null ) {
                    runner.left = newNode;
                    return;
                }
                else
                    runner = runner.left;
            }
            else {
                if ( runner.right == null ) {
                    runner.right = newNode;
                    return;
                }
                else
                    runner = runner.right;
            }
        }
    }

    private boolean isNull(TreeNode node){
        if(node!=null){
            return false;
        }
        return true;
    }

    public void insertEvenly(int desiredLayers){
        BinaryTree originalTree = new BinaryTree();
        originalTree.root = new TreeNode(Math.random()*1000);

        BinaryTree copyTree = new BinaryTree();
        copyTree.root = new TreeNode(Math.random()*1000);

        BinaryTree newTree = makeEvenBranches(originalTree, copyTree);;

        int counter = 0;
        while (counter<desiredLayers-2){
            originalTree = newTree;
            copyTree.root = makeSimilarBranch(newTree.root, new TreeNode(Math.random()));
            newTree =  makeEvenBranches(originalTree, copyTree);
            counter++;
        }
        this.root = newTree.root;

        int test = 0;












    }

    private BinaryTree makeEvenBranches (BinaryTree binaryTree1, BinaryTree binaryTree2){
        BinaryTree branch = new BinaryTree();
        branch.root = new TreeNode(Math.random());
        branch.root.left = binaryTree1.root;
        branch.root.right = binaryTree2.root;

        return branch;
    }

    private TreeNode makeSimilarBranch(TreeNode originalBranchRoot, TreeNode newBranchRoot){
        if(isNull(originalBranchRoot)){
            throw new IllegalArgumentException("No branch to duplicate.");
        }else{
            if(isNull(newBranchRoot)){
                newBranchRoot = new TreeNode(Math.random());
            }
            TreeNode newRunner = newBranchRoot;


            if(isNull(originalBranchRoot.right)&&isNull(originalBranchRoot.left)){
               return newRunner;
            }

            if (!isNull(originalBranchRoot.left)){
                newRunner.left = new TreeNode(Math.random());
                makeSimilarBranch(originalBranchRoot.left, newRunner.left);
            }
            if(!isNull(originalBranchRoot.right)){
                newRunner.right = new TreeNode(Math.random());
                makeSimilarBranch(originalBranchRoot.right, newRunner.right);

            }

        }
        return newBranchRoot;
    }
}
