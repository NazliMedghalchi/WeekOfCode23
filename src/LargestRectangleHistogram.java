import java.util.Stack;

/**
 * Created by Nazli on 2017-05-04.
 */
/*
* Quesiton source: http://www.lintcode.com/en/problem/largest-rectangle-in-histogram/
* Solution source:
*
* */
public class LargestRectangleHistogram {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        // write your code here

        if (height == null || height.length == 0) return 0;

        Stack<Integer> stackAreas = new Stack<Integer>();
        int maxArea = 0;

        for (int i = 0; i <= height.length; i++){
            int curr = (i == height.length ? -1 : height[i]);
            while (!stackAreas.isEmpty() && curr < height[stackAreas.peek()]){
                int index = stackAreas.pop();
                int h = height[index];
                int width = stackAreas.isEmpty() ? i : i-stackAreas.peek() - 1;
                maxArea = Math.max(maxArea, h * width);

            }
            stackAreas.push(i);

        }


        return maxArea;
    }
}
