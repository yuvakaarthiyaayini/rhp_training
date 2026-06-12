class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int a[]=new int[n];
        int b[]=new int[n];
        int max1=0;
        for(int i=0;i<n;i++){
             if(height[i]>max1){
                max1=height[i];
                a[i]=max1;
             }
             else{
                a[i]=max1;
             }

        }
        int max2=0;
        for(int j=n-1;j>=0;j--){
             if(height[j]>max2){
                max2=height[j];
                b[j]=max2;
             }
             else{
                b[j]=max2;
             }

        }
        int sum=0;
        for(int i=0;i<n;i++){
            if(a[i]>b[i]){
                sum+=b[i]-height[i];
            }
            else{
                sum+=a[i]-height[i];
            }
        }
        return sum;
    }
}
