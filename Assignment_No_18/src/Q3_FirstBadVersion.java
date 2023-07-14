 class Solution1 {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean isBadVersion(int version) {
        return version >= 4;
    }
}

public class Q3_FirstBadVersion {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int n = 5;
        int firstBadVersion = solution.firstBadVersion(n);
        System.out.println("The first bad version is: " + firstBadVersion);
    }
}
