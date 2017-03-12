/**
 * Created by Nazli on 2016-10-13.
 */
/**
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether
 * the kth code version is bad or not.
 */
/**
 * @param n: An integers.
 * @return: An integer which is the first bad version.
 */
public class FirstBadVerison {

    public static class SVNRepo{
        public SVNRepo(){
            // placeholder for class SVNRepo
        }
        public static boolean isBadVersion(int k) {
          // this part is implemented by lintcode and it's hidden so there's no
            // correct implementation and criteria of what should be implemented
            // here this is like placeholder
            return true;
        }
    }

    public int findFirstBadVersion(int n) {
        // write your code here

        int start = 1;
        int end = n;
        if (n==1 || n==0)
            return n;
        while (start + 1 < end){
            int mid = start + (end - start)/2;
            if (SVNRepo.isBadVersion(mid) == true)
                end = mid;
            else
                start = mid;
        }
        if (SVNRepo.isBadVersion(start) == true)
            return start;
        return end;

    }


}
