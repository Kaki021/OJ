package sort;

public class SortCollections {

    public static void main(String[] args) {
        SortCollections sortCollections = new SortCollections();
        int[] nums = {19, 18, 16, 14, 17, 20, 15, 13};

        sortCollections.bubbleSort(nums);
    }
    public void bubbleSort(int[] nums) {
        int n = nums.length;
        int compare = 0;
        int swap = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1 ; j++) {
                compare++;
                if (nums[i] > nums[i + 1]) {
                    swap(nums[i], nums[i + 1]);
                    swap++;
                }
            }
        }
        System.out.println("comparisons:" + compare);
        System.out.println("swaps:" + swap);
    }

    public void selectionSort(int[] nums) {
        int n = nums.length;
        int compare = 0;
        int swap = 0;
        for (int i = 0; i < n - 1; i++) {
            int curMin = i;
            for (int j = i + 1; j < n; j++) {
                compare++;
                if (nums[j] > nums[curMin]) {
                    curMin = j;
                }
            }
            swap(nums[i], nums[i + 1]);
            swap++;
        }
        System.out.println(compare);
    }

    private void swap(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
    }
}
