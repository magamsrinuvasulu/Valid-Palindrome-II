class ThreeSum {
    public static void twoPointer(int[] nums, int b, int c, int target,
                                  List<List<Integer>> list) {
        while (b < c) {
            if (nums[b] + nums[c] == target) {
                List<Integer> temp = new ArrayList<>();
                temp.add(-target);
                temp.add(nums[b]);
                temp.add(nums[c]);
                list.add(temp);
                b++;
                c--;
                while (b < c && nums[b] == nums[b - 1]) {
                    b++;
                }
                while (b < c && nums[c] == nums[c + 1]) {
                    c--;
                }
            } else if (nums[b] + nums[c] > target) {
                c--;
            } else {
                b++;
            }
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            twoPointer(nums, i + 1, nums.length - 1, -nums[i], list);
        }

        return list;
    }
}
