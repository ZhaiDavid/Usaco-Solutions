import java.io.*;
import java.util.*;

public class CircularBarn {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;
	static int inf = (int)1e9;
	/*
	this problem is beautiful
	*/


	public static void main(String[] args) throws IOException {
		// goal for each player is to always make the remaining # composite or 0
		// if the number is prime, a wins
		// test for composite numbers:
		// 4 --> a loses in all cases
		// 6 --> a must pick 2, b then loses in all cases
		// 8 --> a must pick 2, b then must pick 2, a loses in all cases
		// 9 --> a can pick 1, 3 or 5 (in other words, make rem 8, 6, or 4) --> should make it 4, then b loses
		// 10 --> a can make rem 9 or 8 --> should make it 8 --> a wins
		// 12 --> a can make rem 10 or 9 --> a takes the l
		// 14 --> a can make the rem 12 or 9 --> a wins
		// 15 --> a can make rem 14 or 12 or 10 or 8 or 4 or 2 --> a wins
		// 16 --> a can make rem 15 or 14 or 9 --> a loses

		// it looks like multiple of 4 is losing
		/*
		this makes sense because if farmer john starts at a multiple of 4, he can't make it 
		a multiple of 4 for farmer nhoj since he has to take a {multiple of 4} amount, which isn't prime
		after this, farmer nhoj can just choose to take 1, 2, or 3 cows to make farmer john be at a multiple
		of 4 again
		*/
	

		String a = "Farmer John";
		String b = "Farmer Nhoj";
		int max = (int)5e6+1;
		boolean[] prime = new boolean[max]; Arrays.fill(prime, true);
		for (int i = 2; i*i < max; i++) {
			if (prime[i]) {
				for (int j = i*i; j < max; j+=i) prime[j]=false;
			}
		}
		TreeSet<Integer>[] primes = new TreeSet[4];
		for (int i = 0; i < 4; i++) primes[i]=new TreeSet<Integer>();
		for (int i = 1; i < max; i++) {
			if (prime[i]) primes[i%4].add(i);
		}

		int t = shit();
		while (t-->0) {
			int maxLose = inf;
			int minWin = inf;
			int loseIdx = inf;
			int winIdx = inf;

			int n = shit();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				int x = shit();
				
			
				if (x%4==0) { // john prolongs loss
					if (x/2 < maxLose) {
						maxLose=x/2;
						loseIdx=i;
					}
				} else {
					x -= primes[x%4].floor(x);
					if (x/2+1 < minWin) {
						minWin =x/2+1;
						winIdx=i;
					}
				}
			}
			if (minWin/2 < maxLose/2) System.out.println(a);
			else if (minWin/2 > maxLose/2) System.out.println(b);
			else if (loseIdx < winIdx) System.out.println(b);
			else System.out.println(a);


			
		}





		

		
		
	
		








	
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
  int a;
  long b;

  Pair(int a, long b) {
	this.a=a;
	this.b=b;
  }

  @Override
  public int compareTo(Pair other) {
	  if (b > other.b) return 1;
	  if (b < other.b) return -1;
	  return 0;
  }

  public String toString() {
	  return"";
  }



  

}
