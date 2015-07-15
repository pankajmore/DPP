package puzzles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Pankaj on 7/13/15.
 */
public class KClosestStars {
        public static List<Star> kClosestStars(List<Star> stars, int k){
        return kSmallest(stars, k);
    }

    public static <T extends Comparable<T>> List<T> kSmallest(List<T> ls, int k){
        if(k > ls.size()) throw new RuntimeException("Incorrect K passed!");
        if(k == 0) return new ArrayList<T>();
        PriorityQueue<T> q = new PriorityQueue<T>(11, Collections.reverseOrder());
        int i;
        for(i=0;i<k;i++) q.add(ls.get(i));
        for(i=k;i<ls.size();i++){
            if(ls.get(i).compareTo(q.peek()) == -1){
                q.remove();
                q.add(ls.get(i));
            }
        }
        List<T> ans = new ArrayList<T>();
        while(!q.isEmpty())
            ans.add(q.remove());
        Collections.sort(ans);
        return ans;
    }

    /**
     * Created by Pankaj on 7/13/15.
     */
    public static class Star implements Comparable<Star>{
        private final long _ID;
        private final double x;
        private final double y;
        private final double z;

        public Star(long id, double x, double y, double z) {
            this._ID = id;
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public double distance(){
            return Math.sqrt(x*x+y*y+z*z);
        }

        @Override
        public int compareTo(Star o) {
            return Double.compare(this.distance(), o.distance());
        }
    }
}
