class Solution {
    public int findKRotation(List<Integer> arr) {
        // Code here
        // same question as findind minimum in rotated sorted array
        // u have to return idx of min ele
        int start=0;
        int end=arr.size()-1;
        int idx=0;
        while(start<end){
            int mid=start+(end-start)/2;
            if(arr.get(mid)>arr.get(end)){
                // gadbaad 
                // min right mai hi lie karta hai
                start=mid+1; // consider mid +1 coz mid bada hai definitely wo to answer nhi
            }else{
                end=mid; // now mid chota hai to mid bhi answer ho sakta hai n .
            }
        }
        return start; // here u can return any idx of start or end dono same place oe hi honge
    }
}
