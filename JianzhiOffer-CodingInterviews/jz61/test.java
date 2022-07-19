class Solution {
public boolean isStraight(int[] nums) {
    Arrays.sort(nums);
    int i=0;
    for(; i<nums.length; i++){
	if (nums[i]!=0)
	    break;
    }
    int zeros = i;
    if (zeros == nums.length || zeros == nums.length-1)
	return true;
    ArrayList<Integer> l = new ArrayList<Integer>();
    for (int j = i; j<nums.length; j++){
	l.add(nums[j]);
    }
    Set<Integer> set = new HashSet<Integer>(l);
    l = new ArrayList<Integer>(set);
    if (l.size() != nums.length-zeros)
	return false;
    int minval = l.get(0);
    int maxval = l.get(l.size()-1);
    if (l.size()-1+zeros >= maxval-minval)
	return true;
    return false;
}
}
