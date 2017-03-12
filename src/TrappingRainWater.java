/**
 * Created by Nazli on 2016-09-26.
 */
/**
 * @param heights: an array of integers
 * @return: a integer
 */
public class TrappingRainWater {


    public int trapRainWater(int[] heights) {
        // write your code here
        if (heights.length < 3) return 0;
        int area = 0;

        //left counter
        int i=0;
        // right counter
        int j=heights.length-1;
        int maxL = heights[0];
        int maxR = heights[heights.length-1];
        while (i<j){
            // move shorter heights toward the other one
            if (maxL <= maxR) {
                i++;
                if (heights[i] <= maxL) {
                    area += (maxL - heights[i]);
                }
                else
                    maxL = heights[i];
            }
            else {
                j--;
                if (heights[j] < maxR) {
                    area += (maxR - heights[j]);
                }
                else
                    maxR = heights[j];
            }
        }
        return area;
    }

}
