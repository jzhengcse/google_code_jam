
import java.math.*;
import java.util.*;
import java.io.*;

public class g2014{
	public static Scanner input=new Scanner(System.in);
	public static int T,n,i,j,k;

	public static void qr1() {
	int A[][]=new int[4][4];
	int B[][]=new int[4][4];
	T=input.nextInt();
	//System.out.printf("%d\n",T);
	for(n=0;n<T;n++) {
		int a=input.nextInt();
		for(i=0;i<4;i++) {
			for(j=0;j<4;j++) {
				A[i][j]=input.nextInt();
				//System.out.printf("%d",A[i][j]);
			}
				//System.out.println();
			}
			int b=input.nextInt();
			for(i=0;i<4;i++) {
				for(j=0;j<4;j++) {
					B[i][j]=input.nextInt();
					//System.out.printf("%d",B[i][j]);
				}
				//System.out.println();
			}

			int count=0;
			int result=0;
			for(j=0;j<4;j++) {
				for(k=0;k<4;k++) {
					if(B[b-1][k]==A[a-1][j]) {
						count++;
						result=B[b-1][k];
					}
				}
			}
			System.out.printf("Case #%d: ",n+1);
			if(count==0) {
				System.out.println("Volunteer cheated!");
			} else if(count==1) {
				System.out.printf("%d\n",result);
			} else {
				System.out.println("Bad magician!");
			}
			//System.out.println();

		}
		
	}
	public static void qr2() {
		T=input.nextInt();
		for(n=0;n<T;n++) {
			double C=input.nextDouble();
			double F=input.nextDouble();
			double X=input.nextDouble();
			//System.out.printf("%f %f %f\n",C,F,X);
			double x=0;
			double f=2;
			double t=0;
			while(x<X) {
				if(x>=C) {
					if((X-x+C)/(f+F)<(X-x)/f) {
						x=x-C;
						f=f+F;
					}
				}
				x+=C;
				t+=C/f;
				//System.out.printf("%f %.7f\n",x,t);
			}
			t=t-1+(X-(x-f))/f;
			System.out.printf("Case #%d: %.7f\n",n+1,t);
		}
	}
	public static void display(int R, int C, int M) {
			for(i=0;i<R-2;i++) {
				for(j=0;j<C;j++) {
					if(M!=0) {
						System.out.printf("*");
					}else {
						System.out.printf(".");
					}
					if(M>0) 
						M--;
				}
				System.out.println();
			}
			char A[][]=new char[50][2];
			for(j=0;j<C;j++) {
				for(i=0;i<2;i++) {
					if(M!=0) {
						A[j][i]='*';
					}else {
						if(i==1 && j==C-1) {
							A[j][i]='c';
							//System.out.printf("C");
						} else {
							A[j][i]='.';
							//System.out.printf(".");
						}
					}
					if(M>0)
						M--;
				}
					
			}

			for(i=0;i<=1;i++) {
				for(j=0;j<C;j++) {
					System.out.printf("%c",A[j][i]);
				}
				System.out.println();
			}


		
	}
	public static void qr3() {
		T=input.nextInt();
		for(n=0;n<T;n++) {
			int R=input.nextInt();
			int C=input.nextInt();
			int M=input.nextInt();
			int req;

			System.out.printf("Case #%d:\n",n+1);
			if(R==1||C==1){
				if(R==1) {
					for(i=0;i<M;i++) 
						System.out.printf("*");
					for(i=0;i<C-M-1;i++)
						System.out.printf(".");
					
					System.out.println("c");
				} else {
					for(i=0;i<M;i++) 
						System.out.println("*");
					for(i=0;i<R-M-1;i++)
						System.out.println(".");
					System.out.println("c");
				}
			} else {
				int max=R>C ? R:C;
				if(M<(R-2)*(C-2)) {
					//System.out.println("Possible");
					display(R,C,M);
				} else if(R*C-M<4) {
					if(R*C-M==1) {
						//System.out.println("Possible");
						display(R,C,M);
					} else {
						System.out.println("Impossible");
					}
				} else {
					if((R*C-M)%2==0) {
						//System.out.println("Possible");
						display(R,C,M);
					}else {
						System.out.println("Impossible");
					
					}
				}

						
			}

		}
	}
	public static void qr4() {
		T=input.nextInt();
		for(n=0;n<T;n++) {
			ArrayList A=new ArrayList(0);
			ArrayList B=new ArrayList(0);
			int N=input.nextInt();
			int count=0;
			int count2=0;
			for(i=0;i<N;i++){
				A.add(input.nextDouble());	
			}
			Collections.sort(A,Collections.reverseOrder());
			for(i=0;i<N;i++){
				B.add(input.nextDouble());	
			}
			Collections.sort(B,Collections.reverseOrder());
			ArrayList A2=new ArrayList(A);
			ArrayList B2=new ArrayList(B);
			//for(i=0;i<N;i++) {
			//	System.out.printf("%f",A.get(i));
			//}
			//System.out.printf("\n");

			//for(i=0;i<N;i++) {
			//	System.out.printf("%f",B.get(i));
			//}
			//System.out.printf("\n");


			while(A.size()!=0) {
				double a=(double)A.get(0);
				A.remove(0);
				if((double)B.get(0)<a) {
					count++;
					B.remove(B.size()-1);
				} else {
					i=1;
					while(i<B.size() && (double)B.get(i)>a) {
						i++;
					}
					B.remove(i-1);
				}
			}

			
			while(A2.size()!=0) {
				double a=(double)A2.get(A2.size()-1);
				if(a>(double)B2.get(B2.size()-1)) {
					A2.remove(A2.size()-1);
					B2.remove(B2.size()-1);
					count2++;
					
				} else {
					A2.remove(A2.size()-1);
					B2.remove(0);
				}
			}



			System.out.printf("Case #%d: %d %d\n",n+1,count2,count);
		}

	}
	public static void main(String[] args) {
		//qr1();
		//qr2();
		qr3();
		//qr4();

	}
}
