public class Q5_GameWinner {
    static class Node {
        int friendNumber;
        Node next;

        Node(int friendNumber) {
            this.friendNumber = friendNumber;
            this.next = null;
        }
    }

    public static int findGameWinner(int n, int k) {
        Node head = new Node(1);
        Node current = head;
        for (int i = 2; i <= n; i++) {
            current.next = new Node(i);
            current = current.next;
        }
        current.next = head; 

        Node prev = current;
        current = head;
        int counter = 1;
        while (current.next != current) {
            if (counter == k) {
                prev.next = current.next;
                current = current.next;
                counter = 1;
            } else {
                prev = current;
                current = current.next;
                counter++;
            }
        }

        return current.friendNumber;
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 2;
        int winner = findGameWinner(n, k);
        System.out.println("Winner of the game: " + winner);
    }
}
