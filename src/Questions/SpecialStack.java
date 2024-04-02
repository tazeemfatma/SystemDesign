package Questions;

import java.util.Stack;

public class SpecialStack extends Stack<Integer> {
    Stack<Integer> min=new Stack<>();

    public void push(int x) {
        super.push(x);
        if (min.isEmpty()){
            System.out.println("pushed"+x);
            min.push(x);
        } else{
          int y=min.peek();
            if(x<y){
                System.out.println("pushed"+x);
                min.push(x);
            }else{
                System.out.println("pushed"+x);
                min.push(y);
            }
        }
    }

    public Integer pop() {
        if (super.isEmpty()){
            System.out.println("stack empty");
            return -1;
    }
        int x=super.pop();
        min.pop();
        System.out.println("popped"+x);
        return x;
    }

    public Integer getMin() {
        if (!min.isEmpty()){
            int x=min.peek();
            System.out.println("min"+x);
            return x;
        }
        System.out.println("min empty");
        return -1;
    }
    public static void main(String[] args){
        SpecialStack s=new SpecialStack();
       /* s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.getMin());
        s.push(5);
        System.out.println(s.getMin());*/
        int[] arr = { 3, 2, 6, 1, 8, 5, 5, 5, 5 };

        for (int i = 0; i < arr.length; i++) {
            s.push(arr[i]);
            s.getMin();
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            s.pop();
            s.getMin();
        }
    }
}
