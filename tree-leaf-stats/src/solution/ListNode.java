package solution;



public class ListNode {
    private TreeNode node;
    private int intItem;
    ListNode next;

    ListNode(TreeNode item){
        this.node = item;
    }
    ListNode(int intItem){
        this.intItem = intItem;
    }

    public TreeNode getNode(){
        return node;
    }
    public void setNode(TreeNode newItem){
        node = newItem;
    }
    public int getIntItem(){
        return intItem;
    }
    public void setIntItem(int item){
        intItem = item;
    }

}
