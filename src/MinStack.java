import java.util.Stack;

/**
 * Created by Nazli on 2017-04-16.
 */

/*
* Question source: http://www.lintcode.com/en/problem/min-stack/
* Solution source: http://www.jiuzhang.com/solutions/min-stack/
* */
public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min;

    public MinStack() {
        // do initialize if necessary
        this.stack = new Stack<Integer>();
        this.min = new Stack<Integer>();
    }

    public void push(int number) {
        // write your code here
        stack.push(number);
        if (min.empty() == true){
            min.push(number);
        }
        else {
            min.push(Math.min(number, min.peek()));
        }
    }

    public int pop() {
        // write your code here
        min.pop();
        return stack.pop();
    }

    public int min() {
        // write your code here
        return min.peek();
    }
}
