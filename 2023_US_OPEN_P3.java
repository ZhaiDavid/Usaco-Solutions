import java.io.*;
import java.util.*;
 
public class 2023_US_OPEN_P3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;
  
	static int MOD = (int)1e9+7;



	public static void main(String[] args) throws IOException {
		char[] c = next().toCharArray();
		int n = c.length;
	
		long ans = 0;

		long[] waiting = new long[6];
		for (int i = 0; i < n; i++) {
			waiting[0]++;
			if (c[i]=='b'){
				waiting[1]+=waiting[0];
				waiting[0]=0;
			} if (c[i]=='e') {
				waiting[2]+=waiting[1];
				waiting[1]=0;

				ans += (n-i)*waiting[5];
				waiting[0]+=waiting[5];
				waiting[5]=0;
			} if (c[i]=='s') {
				waiting[4]+=waiting[3];
				waiting[3]=0;

				waiting[3]+=waiting[2];
				waiting[2]=0;
			} if (c[i]=='i') {
				waiting[5]+=waiting[4];
				waiting[4]=0;
			}
		} 
		System.out.println(ans);


		
			
			
		
			
		
	}
	static final Random random=new Random();
	
	static void sort(int[] a) {
		int n=a.length;//shuffle, then sort 
		for (int i=0; i<n; i++) {
			int oi=random.nextInt(n), temp=a[oi];
			a[oi]=a[i]; a[i]=temp;
		}
		Arrays.sort(a);
	}
	static int diff (String a, String b) {
		int cnt = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i)!=b.charAt(i))cnt++;
		}
		return cnt;
	}
	static String xor (char c) {
		if (c=='G') return "H";
		return "G";
	}
	static String generate (int c, String a) {
		StringBuilder b  = new StringBuilder();
		for (int i = 0; i < a.length(); i++) {
			if (i==c) b.append(a.charAt(i));
			else b.append(xor(a.charAt(i)));
		}
		return b.toString();
		
	}

	static String generate2 (int c, int d, String a) {
		StringBuilder b  = new StringBuilder();
		for (int i = 0; i < a.length(); i++) {
			if (i==c||i==d) b.append(a.charAt(i));
			else b.append(xor(a.charAt(i)));
		}
		return b.toString();
		
	}
	
	


 
 
 
	
 
	static String next() throws IOException {
		while (in==null||!in.hasMoreTokens()) {
			in = new StringTokenizer(br.readLine());
		}
		return in.nextToken();
	}
	static int shit() throws IOException {
		return Integer.parseInt(next());
	}
	static long ll() throws IOException {
		return Long.parseLong(next());
	}
}
 
 
class Pair implements Comparable<Pair> {
  long a;
  long b;
  long c;
 
  Pair(long a, long b, long c) {
	this.a=a;
	this.b=b;
	this.c=c;
  }
 
  @Override
  public int compareTo(Pair other) {
	  if (c> other.c) return 1;
	  if (c < other.c) return -1;
	  return 0;
  }
 
  public String toString() {
	  return a + " " + b;
  }
 
 
  
 
}
