import java.io.*;
import java.util.*;
 
public class MooRoutes {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;
  
	static int MOD = (int)1e9+7;
 
	public static void main(String[] args) throws IOException {
		int n = shit();
		int[]a = new int[n];
		StringBuilder s = new StringBuilder("");
		long sum =0;
		for (int i = 0; i < n; i++) {
		a[i]=shit();
		sum+=1L*a[i];
		}

		int cur = 0;
		int prev = 0;


		
		while (sum > 0) {
		
			if (cur==0) {
				s.append("R");
				a[cur++]--;
				prev = 1;
			} else if (cur==n) {
				s.append("L");
				a[--cur]--;
				prev = -1;
			} else {
				if (prev == 1) {
					if (a[cur] != 0) {
						s.append("R");
						a[cur++]--;
						prev=1;
					} else {
						s.append("L");
						a[--cur]--;
						prev = -1;
					}
				} else {
					if (a[cur] > 0 && a[cur-1]==1) {
						s.append("R");
						a[cur++]--;
						prev=1;

					} else {
						s.append("L");
						a[--cur]--;
						prev = -1;
					}
				}


			}
			sum--;
		}
		System.out.println(s);
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
  int b;
 
  Pair(int a, int b) {
	this.a=a;
	this.b=b;
  }
 
  @Override
  public int compareTo(Pair other) {
	  if (a> other.a) return 1;
	  if (a < other.a) return -1;
	  return 0;
  }
 
  public String toString() {
	  return a + " " + b;
  }
 
 
  
 
}
