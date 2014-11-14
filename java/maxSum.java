import java.util.*;
class maxSum  {
	public static void main(String[] args) {
		int N;
		Scanner in =new Scanner(System.in);
		N=in.nextInt();
		int[] A=new int[N];
		for(int i=0;i<N;++i){
			int a=in.nextInt();
			A[i]=a;
		}
		int max=0,index=0,index2=0;
		int[] M=new int[N];
		char[] D=new char[N];
		M[0]=A[0];
		for (int i=1;i<N;++i) {
			if (A[i]>M[i-1]+A[i]) {
							M[i]=A[i];
							D[i]='+';
						}			
			else{
				M[i]=A[i]+M[i-1];
				D[i]='-';
		}

	}

	for (int i=0;i<N ;++i ) {
		if (max<M[i]) {
			max=M[i];
			index=i;
		}
	}
	System.out.println(max);
	//printing the array wuth the max sum
	for (int i=index;i>=0 ;--i ) {
		if (D[i]=='+') {
			index2=i;
			break;
		}
	}
	for (int i=index2;i<=index ;++i ) {
		System.out.print(A[i]+" ");
	}
}
}
