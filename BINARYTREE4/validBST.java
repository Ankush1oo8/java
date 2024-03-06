package BINARYTREE4;

import java.util.ArrayList;

public class validBST {
    
static class node{
    int data;
    node left;
    node right;
    node(int data){
        this.data=data;
    }
}
public static node insert(node root, int val){
    if(root==null){
        root=new node(val);
        return root;
    }
    if(root.data>val){
        root.left=insert(root.left,val);
    }else{
        root.right=insert(root.right, val);
    }
    return root;
}
public static boolean isValid(node root, node min, node max){
    if(root==null){
        return true;
    }
    if(min!=null && root.data<=min.data){
        return false;
        }else if(max!=null && root.data>=max.data){
            return false;
    }
    return isValid(root.left, min, root) && isValid(root.right, root, max);
}

    public static void main(String[] args) {
           int values[]={8,5,3,6,10,11,14};
        node root=null;
        for(int i=0;i<values.length;i++){
            root=insert(root, values[i]);
        }
        
        System.out.println(isValid(root, null, null));
    
    
    }
}

