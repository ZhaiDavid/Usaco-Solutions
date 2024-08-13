import java.io.*;
import java.util.*;
/*
Binary search is king!
 */
 
public class Bakery {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;
  
	static int MOD = (int)1e9+7;
	static int n;
	static long c, m;
	static Pair[]a;
	static long[] diff;


	public static void main(String[] args) throws IOException {
		int t = shit();
		while (t-->0) {
			n = shit();
			c = ll();
			m = ll();
			a = new Pair[n];
			for (int i = 0; i < n; i++ ) {
				a[i]=new Pair(ll(), ll(), ll());
			}
			diff = new long[n];
			for (int i = 0; i < n; i++){
				diff[i]=c*a[i].a+m*a[i].b-a[i].c;
			}
			
			// binary search on number of coins spent
			// problem: how do you check if it is possible to satisfy everyone
			// with m coins?
			long l =0, r = 1l*c+m-2;
			long ans = r;
		
			while (l<=r) {
				long mid = (l+r)/2;
				if (check(mid)) {
					r=mid-1;
					ans = Math.min(mid, ans);
				}
				else l= mid+1;
			}
			
		
			System.out.println(ans);
			
			
		
			
		}
	}
	static boolean check (long num)  {
		long lo = 0L, hi = Math.min(c-1, num);
	
		long l = 0, r = 0;
		for (int i = 0; i < n; i++) {
			if (a[i].a == a[i].b) {
				// for lowest, maximize amount of b taken away
				long max = Math.min(m-1, num);
			
				if (max*a[i].b+(num-max)*a[i].a < diff[i]) {return false; }
				lo = Math.max(num-max, lo);

				
			} else if (a[i].a > a[i].b) {
				// for  lowest, find maximum amount of b that can be taken away, let's bin search
				l = 0; r = Math.min(m-1, num);
				long find = (long)1e9;
				boolean ok = false;
				while (l<=r) {
					long mid = (l+r)/2;
					long idk = num-mid;
					
					if (mid*a[i].b+idk*a[i].a < diff[i]) r=mid-1;
					else {
						l = mid+1;
						find = Math.min(find, idk);
						ok = true;
					}
				}
				
			
				if (!ok) {return false;}
				lo = Math.max(find, lo);

				// highest doesn't get affected, since in the case you will want to take away as much from a anyway



			} else {
				// maximize b to find lowest 
				long max = Math.min(m-1, num);
				if (max*a[i].b+(num-max)*a[i].a < diff[i]) return false;
			
				lo = Math.max(num-max, lo);

				// minimize b to find highest
				l = 0;r = Math.min(m-1, num);
				long find = 0;
				boolean ok = false;
				while (l<=r) {
					long mid = (l+r)/2;
					long idk = num-mid;
					
					if (mid*a[i].b+idk*a[i].a < diff[i]) l = mid+1;
					else {
						r = mid-1;
						find = Math.max(find, idk);
						ok = true;
					}

				}
				if (!ok) return false;
				hi = Math.min(find, hi);


			}
		}
		
		return lo<=hi;
		
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
