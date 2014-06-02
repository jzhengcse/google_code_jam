
import java.math.*;
import java.util.*;
import java.io.*;

public class g2013{
	public static Scanner input=new Scanner(System.in);
	public static int T,n,i,j,k;
	public static void display1(int A[][],int r,int c) {
		for(i=0;i<c;i++) {
			for(j=0;j<r;j++) {
				System.out.printf("%d",A[i][j]);
			}
			System.out.println();
		}
	}


	
	public static boolean  ifnot(char A[][],char c) {
		boolean win;
		for(i=0;i<4;i++) {
			win=true;	
			for(j=0;j<4;j++) {
				if(A[i][j]=='.'||A[i][j]==c) 
					win=false;
			}
			if(win)
				return win;
		}
		for(j=0;j<4;j++) {
			win=true;	
			for(i=0;i<4;i++) {
				if(A[i][j]=='.'||A[i][j]==c) 
					win=false;
			}
			if(win)
				return win;
		}
		win=true;
		for(i=0;i<4;i++) {
			if(A[i][i]=='.'||A[i][i]==c) 
				win=false;
		}
		if(win)
			return win;
		win=true;
		for(i=0;i<4;i++) {
			if(A[i][3-i]=='.'||A[i][3-i]==c) 
				win=false;
		}
		if(win)
			return win;
		return false;
	}
	public static boolean ifDraw(char A[][]) {
		for(i=0;i<4;i++) {
			for(j=0;j<4;j++) {
				if(A[i][j]=='.')
					return false;
			}
		}
		return true;
	}
	public static void qr1() {
		int T;
		T=input.nextInt();
		char A[][]=new char[4][4];
		//System.out.printf("%d\n",T);
		for(n=0;n<T;n++) {
			input.nextLine();
			for(i=0;i<4;i++) {
				String line=new String(input.nextLine());
				//System.out.printf("%s\n",line);
				for(j=0;j<4;j++) {
					A[i][j]=line.charAt(j);
					//System.out.printf("%c",A[i][j]);
				}
				//System.out.println();
			}

			System.out.printf("Case #%d: ",n+1);
			if(ifnot(A,'O')) {
				System.out.println("X won");
			} else if(ifnot(A,'X')) {
				System.out.println("O won");
			} else if(ifDraw(A)) {
				System.out.println("Draw");
			} else {
				System.out.println("Game has not completed");
			}
			//System.out.println();

		}
		
	}

	public static boolean ifsame(int A[][],int B[][], int N, int M) {
		for(i=0;i<N;i++) {
			for(j=0;j<M;j++) {
				if(A[i][j]!=B[i][j])
					return false;
			}
		}
		return true;
	}

	public static void qr2() {
		int A[][]=new int[100][100];
		int B[][]=new int[100][100];
		T=input.nextInt();
		for(n=0;n<T;n++) {
			int N=input.nextInt();
			int M=input.nextInt();
			for(i=0;i<N;i++) {
				int max=0;
				for(j=0;j<M;j++) {
					A[i][j]=input.nextInt();
					if(A[i][j]>max)
						max=A[i][j];
					B[i][j]=100;
				}
				for(j=0;j<M;j++) {
					if(B[i][j]>max) 
						B[i][j]=max;
				}
			}

			for(j=0;j<M;j++) {
				int max=0;
				for(i=0;i<N;i++) {
					if(A[i][j]>max) {
						max=A[i][j];
					}
				}
				for(i=0;i<N;i++) {
					if(B[i][j]>max)
						B[i][j]=max;
				}
			}

			
			System.out.printf("Case #%d: ",n+1);
			if(ifsame(A,B,N,M))
				System.out.println("YES");
			else
				System.out.println("NO");


		
		}
	}
	public static boolean ifpd(long A) {
		StringBuilder str1=new StringBuilder(String.valueOf(A));

		//System.out.printf("%s\n",str1.toString());
		StringBuilder str2=new StringBuilder(str1);
		str1.reverse();
		//System.out.printf("%s\n",str2.toString());
		return str1.toString().contentEquals(str2);
	}
	public static void qr3() {
		T=input.nextInt();
		ArrayList arr=new ArrayList(0);
		long i;
		for (i=1;i<=10000000;i++) {
			
			if(ifpd(i)&&ifpd((long)Math.pow(i,2.0))) {
				arr.add(i);

				//System.out.printf("%d\n",i);
			}
		}
		for(n=0;n<T;n++) {
			long A=(long)Math.ceil(Math.sqrt(input.nextLong()));
			long B=(long)Math.floor(Math.sqrt(input.nextLong()));
			int count=0;
				int a;	
				//System.out.printf("%d",i);
				j=0;
				while(j<arr.size() && A>(long)arr.get(j)) {
					j++;
				}
				k=0;
				while(k<arr.size() && B>=(long)arr.get(k)) { //alway over 1
					k++;
				}
				System.out.printf("Case #%d: %d\n",n+1,k-j);
		}
		
	}
	public static void main(String[] args) {
		//qr1();
		//qr2();
		//qr3();
	}
}
