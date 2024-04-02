package Questions;

import java.util.Arrays;
import java.util.Stack;

public class checkSinglyLinkListPallindrome {

    static Node head=null;
    static class Node{
        String data;
        Node next;

        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }
    public static void addNode(String data){

        Node newNode=new Node(data);
        if(head==null)
            head=newNode;
        else{
            Node currNode=head;
            while(currNode.next != null){
                currNode=currNode.next;
            }
            currNode.next=newNode;
        }
    }
    public static boolean checkPallindrome(Node head){
        Stack<String> stack=new Stack<>();
        Node currNode=head;
        if(head==null)
            return false;
        while(currNode !=null){
            stack.push(currNode.data);
            currNode=currNode.next;
        }
        currNode=head;
        while(currNode !=null){
            if(!currNode.data.equals(stack.pop())){
                return false;
            }
            currNode=currNode.next;
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
    public static void printLinklist(Node head){
        Node currNode=head;
        while(currNode!=null){
            System.out.println(currNode.data+"->");
            currNode=currNode.next;
        }

    }


    public static void main(String[] args) {
        String str[]={"A","B","C","B","A"};
        Arrays.stream(str).forEach(word->addNode(word));
        printLinklist(head);
        boolean pallindrome=checkPallindrome(head);
        System.out.println("1st "+pallindrome);

        Node rtail=findMiddleNode(head);
        Node rhead=reverseLinklist(rtail);

        System.out.println("print first half");
        printLinklist(head);
        System.out.println("print second half");
        printLinklist(rhead);

        boolean pall=isPallindrome(head,rhead);
        System.out.println("second="+pall);
    }

    private static boolean isPallindrome(Node head, Node rhead) {
        Node node=head;
        Node rnode=rhead;
        while(rnode!=null){
            if(!node.data.equals(rnode.data))
                return false;
            node=node.next;
            rnode=rnode.next;
        }
        return true;
    }

    private static Node findMiddleNode(Node head) {
        Node slowPointer=head,fastPointer=head;
        while(fastPointer!=null && fastPointer.next!=null){
            slowPointer=slowPointer.next;
            fastPointer=fastPointer.next.next;
        }
        if(fastPointer==null)
            return slowPointer;
        else
            return slowPointer.next;
    }

    private static Node reverseLinklist(Node head) {
        //1-> 2->3->4->5->6->7->8->9
        //5->4->3->2->1
        Node rtail=head;
        Node rhead=null;
        Node currNode=head;
        while(currNode!=null){
            Node x=currNode.next;
            currNode.next=rhead;
            rhead=currNode;
            currNode=x;
        }
      //  System.out.print("Original");
      //  printLinklist(head);
       // System.out.print("reverse");
      //  printLinklist(rhead);
      return rhead;
    }
}
