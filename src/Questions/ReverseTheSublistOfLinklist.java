package Questions;

public class ReverseTheSublistOfLinklist {
    static Node head;
    static class Node{

        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static void addNode(Node newNode){
        if(head==null){
            head=newNode;
        }else{
            Node temp=head;
            while(temp.next !=null){
                temp=temp.next;
            }
            temp.next=newNode;
        }

    }
    public static void main(String[] args){
        int arr[]={10,20,30,40,50,60,70};
        int m=3,n=6;
     //   Node head=new Node(arr[0]);
      //  Node currNode=head;
        for(int i=0;i<arr.length;i++){
            Node newNode=new Node(arr[i]);
            addNode(newNode);
        }

        printLinklist(head);
        reverseSublistOfLinklist(head,m,n);
        System.out.println("Reversed->");
        printLinklist(head);

    }

    private static void reverseSublistOfLinklist(Node head, int m, int n) {
        Node prev=null;
        Node curr=head;
        int i;
        for(i=1;i<m;i++){
            prev=curr;
            curr=curr.next;
        }
       Node rtail=curr;
        Node rhead=null;
        while(i<=n){
            Node next=curr.next;
            curr.next=rhead;
            rhead=curr;
            curr=next;
            i++;
        }
        if(prev!=null)
            prev.next=rhead;
        else
            head=rhead;

        rtail.next=curr;

    }

    private static void printLinklist(Node head) {
        Node currNode;
        //printing
        currNode= head;
        while(currNode!=null){
            System.out.println(currNode.data+"-->");
            currNode=currNode.next;
        }
    }
}
