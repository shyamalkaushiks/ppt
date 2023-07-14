import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q3_Cafeteria {
    public static int countStudentsUnableToEat(int[] students, int[] sandwiches) {
        Queue<Integer> studentQueue = new LinkedList<>();
        Stack<Integer> sandwichStack = new Stack<>();

        for (int student : students) {
            studentQueue.offer(student);
        }

        for (int sandwich : sandwiches) {
            sandwichStack.push(sandwich);
        }

        while (!studentQueue.isEmpty() && !sandwichStack.isEmpty()) {
            int preference = studentQueue.peek();
            int sandwich = sandwichStack.peek();

            if (preference == sandwich) {
                studentQueue.poll();
                sandwichStack.pop();
            } else {
                studentQueue.offer(studentQueue.poll());
            }
        }

        return studentQueue.size();
    }

    public static void main(String[] args) {
        int[] students = {1, 1, 0, 0};
        int[] sandwiches = {0, 1, 0, 1};
        int unableToEat = countStudentsUnableToEat(students, sandwiches);
        System.out.println("Number of Students Unable to Eat: " + unableToEat);
    }
}
