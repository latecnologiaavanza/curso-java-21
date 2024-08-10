public class RecordPatterns2 {

    record Point(int x, int y) {

    }

    public static int beforeRecordPattern(Object obj) {
        int sum = 0;
        if(obj instanceof Point p) {
            int x = p.x();
            int y = p.y();
            sum = x+y;
        }
        return sum;
    }

    public static int afterRecordPattern(Object obj) {
        if(obj instanceof Point(int x, int y)) {
            return x+y;
        }
        return 0;
    }

}
