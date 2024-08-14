import java.io.*;
import java.util.*;
 
public class Moorbles {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;
  
	static int MOD = (int)1e9+7;
	static int n;
	static long c, m;
	static Pair[]a;
	static long[] diff;


	public static void main(String[] args) throws IOException {
		int t = shit();
		l:
		while (t-->0) {
			int n = shit(), m = shit(), k = shit();
			int[][] a = new int[m+1][k];
			for (int i = 1; i <= m; i++) {
				for (int j = 0; j < k; j++) a[i][j]=shit();
			}
			int[] psa = new int[m+1];
			int[][] nums = new int[m+1][2];
			int[] max = new int[m+2];
			Arrays.fill(max, -(int)(1e9));
		
			for (int i = 1; i <=m; i++) {
				ArrayList<Integer>[] eo = new ArrayList[2];
				for (int j = 0; j < 2; j++) eo [j]= new ArrayList<Integer>();
				for (int j=0; j < k; j++) {
					int cur = a[i][j];
					eo[cur%2].add(cur);
				}
				Collections.sort(eo[0]); Collections.sort(eo[1]);
				if (eo[0].size()==0) { // no even
					nums[i][1]= -eo[1].get(0);
					nums[i][0]= eo[1].get(eo[1].size()-1);
				} else if (eo[1].size()==0) { // no odd
					nums[i][0]= -eo[0].get(0);
					nums[i][1]= eo[0].get(eo[0].size()-1);
				} else {
					for (int j = 0; j < 2; j++) {
						nums[i][j]=eo[j^1].get(eo[j^1].size()-1);
					}
				}
				psa[i]=psa[i-1]+Math.min(nums[i][0], nums[i][1]);
				if (psa[i]>= n) {
					System.out.println(-1);
					continue l;
				}
				
				

			}
			for (int i = m; i>=1; i--) {
				max[i] = Math.max(max[i+1], psa[i]);
			}

		
			
			int cur = 0;
			//System.out.println(Arrays.deepToString(nums));
			//System.out.println(Arrays.toString(psa));
	
		

			

		
		
			StringBuilder out = new StringBuilder("");
			for (int i = 1; i<= m; i++) {
				if (cur + max[i]-psa[i]+nums[i][0] < n && cur+nums[i][0] < n){
					out.append("Even");
					cur += nums[i][0];
				} else {
					out.append("Odd");
					cur += nums[i][1];
				}

				if (i!=m) out.append(" ");
 			}		
			System.out.println(out);
			
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
