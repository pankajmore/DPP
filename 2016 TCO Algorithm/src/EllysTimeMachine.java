public class EllysTimeMachine {

    public String getTime(String time) {
        int a = Integer.valueOf(time.substring(0, 2));
        int b = Integer.valueOf(time.substring(3, 5));
        int HH = b == 0 ? 12 : b / 5, MM = a == 12 ? 0 : a * 5;
        StringBuilder sb = new StringBuilder();
        if (HH < 10) sb.append(0);
        sb.append(HH);
        sb.append(":");
        if (MM < 10) sb.append(0);
        sb.append(MM);
        return sb.toString();
    }
}
