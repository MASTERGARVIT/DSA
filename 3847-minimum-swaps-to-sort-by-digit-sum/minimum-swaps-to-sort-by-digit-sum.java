import java.util.*;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = digitSum(nums[i]);
            arr[i][1] = nums[i];
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        HashMap<Integer, Integer> position = new HashMap<>();

        for (int i = 0; i < n; i++) {
            position.put(nums[i], i);
        }

        int swaps = 0;
        int[] target = new int[n];

        for (int i = 0; i < n; i++) {
            target[i] = arr[i][1];
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != target[i]) {
                swaps++;

                int j = position.get(target[i]);

                position.put(nums[i], j);
                position.put(target[i], i);

                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        return swaps;
    }

    int digitSum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}