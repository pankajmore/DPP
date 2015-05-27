/**
 * Created by pankajm on 5/26/15.
 */
public class MaxDifference {
    public int max_difference(int [] A){
        int min_so_far = A[0];
        int max_so_far = 0;
        for(int x : A){
            if(x - min_so_far > max_so_far)
                max_so_far = x - min_so_far;
            if(x < min_so_far)
                min_so_far = x;
        }
        return max_so_far;
    }
}
