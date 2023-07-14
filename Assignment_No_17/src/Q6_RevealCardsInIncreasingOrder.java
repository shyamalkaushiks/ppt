import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q6_RevealCardsInIncreasingOrder {
    public static int[] revealCardsInIncreasingOrder(int[] deck) {
        Arrays.sort(deck); // Sort the deck array in ascending order
        Queue<Integer> revealedDeck = new LinkedList<>();

        for (int card : deck) {
            if (!revealedDeck.isEmpty()) {
                revealedDeck.add(revealedDeck.poll());
            }
            revealedDeck.add(card);
        }

        int[] orderedDeck = new int[deck.length];
        for (int i = deck.length - 1; i >= 0; i--) {
            orderedDeck[i] = revealedDeck.poll();
        }

        return orderedDeck;
    }

    public static void main(String[] args) {
        int[] deck = {17, 13, 11, 2, 3, 5, 7};
        int[] orderedDeck = revealCardsInIncreasingOrder(deck);
        System.out.println(Arrays.toString(orderedDeck));
    }
}
