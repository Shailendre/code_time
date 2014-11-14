import java.util.*;
import java.io.*;
class time{
	int t;
	char c;
}
class hotel {
	public static int retMax(int A[]){
		int max=A[0];
		for(int i=0;i<A.length;i++)
			if(max<A[i])
				max=A[i];
		return max;
	}
	public static int calc(time[] A){
		int[] repArr=new int[A.length];
		int i;
		for(i=0;i<A.length;i++) {
			if(A[i].c=='A')
				repArr[i]=1;
			else
				repArr[i]=-1;
		}
		i=1;
		for(;i<A.length;i++)
			repArr[i]=repArr[i-1]+repArr[i];

		return retMax(repArr);
	}
	public static int mergeArr(int A[],int D[]){
		int merge[]=new int [2*A.length];
		time[] T=new time[2*A.length];//array of objects
		int i,j;
		for(i=0;i<A.length;i++){
			T[i]=new time();
			T[i].t=A[i];
			T[i].c='A';
		}
		for(j=0;j<A.length;j++){
			T[j+i]=new time();
			T[j+i].t=D[j];
			T[j+i].c='D';
		}
		//bubbleSort of the obj
		for(i=0;i<T.length;i++){
			for(j=i+1;j<T.length;j++){
				if(T[i].t>T[j].t){
					time tmp=new time();
					tmp=T[i];
					T[i]=T[j];
					T[j]=tmp;
				}
			}
		}
		return calc(T);
	}
	public static int roomObj() {
		Scanner in =new Scanner(System.in);
		int N=in.nextInt();
		int[] A=new int[N];
		int[] D=new int[N];
		int i;
		for(i=0;i<N;i++) 
			A[i]=in.nextInt();
		for(i=0;i<N;i++) 
			D[i]=in.nextInt();
		return mergeArr(A,D);
	}
}
class rooms {
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		int T=in.nextInt();
		while(T--!=0){
			int min=hotel.roomObj();
			System.out.println(min);
		}
	}
}
