import java.util.*;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int INF = n + 1;

        int[] best = new int[n + 1];
        Arrays.fill(best, INF);

        int left = 0;
        int sum = 0;
        int ans = INF;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            if (sum == target) {
                int len = right - left + 1;

                if (left > 0 && best[left] != INF) {
                    ans = Math.min(ans, len + best[left]);
                }

                best[right + 1] = Math.min(best[right], len);
            } else {
                best[right + 1] = best[right];
            }
        }

        return ans == INF ? -1 : ans;
    }
}