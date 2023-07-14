import java.util.LinkedList;
import java.util.Queue;

public class Q4_RecentCounter {
    private Queue<Integer> requests;

    public Q4_RecentCounter() {
        requests = new LinkedList<>();
    }

    public int ping(int t) {
        requests.offer(t);
        while (!requests.isEmpty() && requests.peek() < t - 3000) {
            requests.poll();
        }
        return requests.size();
    }

    public static void main(String[] args) {
        Q4_RecentCounter recentCounter = new Q4_RecentCounter();
        System.out.println(recentCounter.ping(1));   
        System.out.println(recentCounter.ping(100));  
        System.out.println(recentCounter.ping(3001)); 
        System.out.println(recentCounter.ping(3002)); 
    }
}
