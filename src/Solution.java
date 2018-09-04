
 class Solution {
	public double findMedianSortedArrays(int[] A,int[] B) {
		int a=A.length;
		int b=B.length;
		if(a>b) {
			int[] temp=A;A=B;B=temp;
			int temp1=a;a=b;b=temp1;
		}
		int min=0,max=a;
		int halflen = (a+b+1)/2;
		while(min<=max) {
			int i=(min+max)/2;
			int j=halflen-i;
			if(i<max&&B[j-1]>A[i]) {
				min=i+1;
			}
			else if(i>min&&A[i-i]>B[j]) {
				max=i-1;
			}
			else {
				int maxleft=0;
				if(i==0) {
					maxleft=B[j-1];
				}
				else if(j==0) {
					maxleft=A[i-1];
				}
				else {
					maxleft=Math.min(A[i-1], B[j-1]);
				}
				if((a+b)%2==1){
					return maxleft;
				}
				int minright=0;
				if(i==a) {
					minright=B[j];
				}
				else if(j==b) {
					minright=A[i];
				}
				else {minright=Math.min(B[j], A[i]);}
				return(maxleft+minright)/2.0;
			}
		}
		return 0.0;
		
	}
 public static void main(String[] args) {}}
