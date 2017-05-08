import java.util.Stack;

/**
 * Created by Nazli on 2017-04-16.
 */
/*
* Question source: http://www.lintcode.com/en/problem/implement-queue-by-two-stacks/
* Solution source: http://www.jiuzhang.com/solutions/implement-queue-by-two-stacks/
*
* */
public class QueueWithStacks {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public QueueWithStacks() {
            // do initialization if necessary
            this.stack1 = new Stack<Integer>();
            this.stack2 = new Stack<Integer>();
        }

        public void push(int element) {
            // write your code here
            stack1.push(element);
        }

        public int pop() {
            // write your code here
            if (stack2.empty() == true){
                this.exhcangestacks();
            }
            return stack2.pop();
        }

        public int top() {
            // write your code here
            if (stack2.empty() == true) {
                this.exhcangestacks();
            }
            return stack2.peek();
        }

        public void exhcangestacks(){
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
}
