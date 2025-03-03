class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0;
        int j=0;
        int idx=0;
        List<Integer> arr=new ArrayList<>();
        for(int id=0;id<m;id++){
                arr.add(nums1[id]);
        }
        while(i<arr.size() && j<n){
            if(arr.get(i)<nums2[j]){
                nums1[idx++]=arr.get(i);
                i++;
            }else{
                nums1[idx++]=nums2[j++];
            }
        }
    // add remaining ele of num1
    while(i<arr.size()){
        nums1[idx++]=arr.get(i);
        i++;
    }
    while(j<n){
        nums1[idx++]=nums2[j++];
    }
    }
}
