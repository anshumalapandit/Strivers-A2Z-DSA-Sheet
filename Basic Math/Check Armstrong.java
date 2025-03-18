import java.util.*;
public class Main {
	public static int helper(int ld,int count){
		 return (int)Math.pow(ld,count);
		
	}
	public static int countFxn(int temp){
		int count=0;
          while(temp>0){
			count++;
			temp=temp/10;
		}
		return count;
	}
	public static boolean checkArmstrong(int n){
		int orgN=n;
		int sum=0;
		int count=countFxn(orgN);
		while(orgN>0){
			int ld=orgN%10;
            sum+=helper(ld,count);
			orgN=orgN/10;
		}
		if(sum==n){
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		// Write your code here
       Scanner sc=new Scanner(System.in);
	   int n=sc.nextInt();
	   System.out.println(checkArmstrong(n));
	}
}
