import java.util.LinkedList;
import java.util.Queue;

class DataStream {
    private Queue<Integer> stream;
    private int value;
    private int k;

    public DataStream(int value, int k) {
        this.stream = new LinkedList<>();
        this.value = value;
        this.k = k;
    }

    public boolean consec(int num) {
        stream.offer(num);
        if (stream.size() < k) {
            return false;
        } else if (stream.size() > k) {
            stream.poll();
        }
        return checkConsecutive();
    }

    private boolean checkConsecutive() {
        for (int num : stream) {
            if (num != value) {
                return false;
            }
        }
        return true;
    }
}

public class Q8_DataStream {
    public static void main(String[] args) {
        DataStream dataStream = new DataStream(4, 3);
        System.out.println(dataStream.consec(4)); // Output: false
        System.out.println(dataStream.consec(4)); // Output: false
        System.out.println(dataStream.consec(4)); // Output: true
        System.out.println(dataStream.consec(3)); // Output: false
    }
}
