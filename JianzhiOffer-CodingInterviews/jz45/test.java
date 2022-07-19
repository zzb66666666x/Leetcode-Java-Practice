class Solution {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i=0; i<nums.length; i++){
            strs[i] = Integer.toString(nums[i]);
        }
        qsort(strs, 0, strs.length-1);
        return String.join("", strs);
    }

    private void qsort(String[] nums, int start, int end){
        if (start>=end)
            return;
        int pivot = partition(nums, start, end);
        System.out.println(pivot);
        qsort(nums, start, pivot-1);
        qsort(nums, pivot+1, end);
    }

    private int partition(String[] nums, int start, int end){
        String pivot = nums[end];
        int j=start;
        int i=start;
        for (; cmp(nums[i], pivot) == 1; i++, j++){}
        for (; j<end; j++){
            if (cmp(nums[j], pivot)==1){
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, end);
        return i;
    }  

    private void swap(String[] nums, int a, int b){
        String tmp = nums[b];
        nums[b] = nums[a];
        nums[a] = tmp;
    } 

    private int cmp(String a, String b){
        return ((a+b).compareTo(b+a) < 0)? 1 : -1; 
    }
}

// if using java lambda and built-in feature of arraylistobj.sort
// class Solution {
//     public String minNumber(int[] nums) {
//         List<String> list = new ArrayList<>();
//         for (int num : nums) {
//             list.add(String.valueOf(num));
//         }
//         list.sort((o1, o2) -> (o1 + o2).compareTo(o2 + o1));
//         return String.join("", list);
//     }
// }
