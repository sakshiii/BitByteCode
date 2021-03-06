import java.util.ArrayDeque;

public class avltreeinsertanddelete {
static class Node{
    int data;
    Node left = null;
    Node right = null;
    int height = 0;
    int bal = 0;
    public Node(int dat){
        this.data = dat;
    }
}
public static void updateheightandbalance(Node node){
    int lh = -1, rh = -1;
    if(node.left!=null)
    lh = node.left.height;
    if(node.right!=null)
    rh = node.right.height;
    node.bal = lh - rh;
    node.height = Math.max(lh,rh)+1;
}
public static Node leftrotation(Node node){
    Node rightt = node.right;
    Node leftt = rightt.left;
    rightt.left = node;
    node.right = leftt;
    updateheightandbalance(node);
    updateheightandbalance(rightt);
    return rightt;
}
public static  Node rightrotation(Node node){
    Node leftt = node.left;
    Node rightt = leftt.right;
    leftt.right = node;
    node.left = rightt;
    updateheightandbalance(node);
    updateheightandbalance(leftt);
    return leftt;
}
public static Node rotation(Node node){
    updateheightandbalance(node);
    if(node.bal==2){
        if(node.left.bal==1){
           return rightrotation(node);
        }
        else{
            node.left = leftrotation(node.left);
            return rightrotation(node);
        }
    }
    else if(node.bal==-2){
        if(node.right.bal==-1){
            return leftrotation(node);
        }
        else{
            node.right = rightrotation(node.right);
            return leftrotation(node);
        }
    }
    else
        return node;
}
public static Node addData(int data,Node node){
    if(node==null)
        return new Node(data);
    else if(node.data>data){
        node.left = addData(data,node.left);
    }
    else
        node.right = addData(data,node.right);
    return rotation(node);
}
    public static void display(Node node){
    if(node==null)
        return;
    String str;
    str=node.left==null?".":node.left.data+"";
    str+=" <-" +node.data+" ->";
    str+=node.right==null?'.':node.right.data+"";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }
    public static Node findSuccessor(Node node){
        if(node.right==null)
            return node;
        return findSuccessor(node.right);
    }
    public static Node removeData(Node node,int data){
        if(node.data>data)
            node.left = removeData(node.left,data);
        else if(node.data<data)
            node.right = removeData(node.right,data);
        else{
            if(node.left==null||node.right==null){
                return node.left!=null?node.left:node.right;
            }
            else {
                Node successor = findSuccessor(node.left);
                node.data = successor.data;
                successor.data = data;
                node.left = removeData(node.left, data);
            }
        }
        return rotation(node);
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        Node root = null;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for(int i:arr)
            root = addData(i,root);
        display(root);
        System.out.println();
        removeData(root,4);
        display(root);

}
}
