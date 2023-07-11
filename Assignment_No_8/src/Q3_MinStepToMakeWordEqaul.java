public class Q3_MinStepToMakeWordEqaul {
    public static int minSteps(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int lcsLength = dp[m][n];
        int steps = (m + n) - (2 * lcsLength);

        return steps;
    }

    public static void main(String[] args) {
        String word1 = "sea";
        String word2 = "eat";
        int minSteps = minSteps(word1, word2);
        System.out.println(minSteps);
    }
}
