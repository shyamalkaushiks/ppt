import java.util.*;

public class Q5_UglyNumbers {
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordCount = new HashMap<>();

        // Count the frequency of each word
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Custom comparator to sort words based on frequency and lexicographical order
        Comparator<String> comparator = (a, b) -> {
            int freqA = wordCount.get(a);
            int freqB = wordCount.get(b);

            // If frequencies are equal, sort lexicographically
            if (freqA == freqB) {
                return a.compareTo(b);
            }

            // Sort by frequency in descending order
            return freqB - freqA;
        };

        // Create a priority queue to store the top k frequent words
        PriorityQueue<String> pq = new PriorityQueue<>(comparator);

        // Add words to the priority queue
        for (String word : wordCount.keySet()) {
            pq.offer(word);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Create a list to store the result in the correct order
        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        // Reverse the list to get the highest frequency words first
        Collections.reverse(result);

        return result;
    }

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        List<String> topKFrequentWords = topKFrequent(words, k);
        System.out.println("Output: " + topKFrequentWords);
    }
}
