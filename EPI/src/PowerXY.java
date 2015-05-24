/**
 * Created by pankajm on 5/6/15.
 */
public class PowerXY {
    public double recPow(double x, long y){
        if(y%2 == 0){
            return recPow(x*x, y/2);
        }
        else{
            return x*recPow(x*x, y/2);
        }
    }
    public double iterPow(double x, long y){
        double res = 1;
        while(y>1){
            res *= x*x;
            y /= 2;
            if(y%2 == 1)
                res *= x;
        }
        res *= x;
        return res;
    }
}
