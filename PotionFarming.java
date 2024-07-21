import java.io.*;
import java.util.*;
 
public class PotionFarming {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;
	public static void main(String[] args) throws IOException {
		int n = shit();
		int[] arr = new int[n];
		int[] occs = new int[n+1];
		for (int i = 0; i < n; i++) {
			arr[i]=shit();
		}
		ArrayList<Integer>[] adj = new ArrayList[n+1];
		for (int i = 0; i <=n; i++) adj[i]=new ArrayList<Integer>();
		for (int i = 0; i < n-1; i++) {
			int a = shit(), b = shit();
			adj[a].add(b);
			adj[b].add(a);
		}
		int[] ans = new int[n+1];
		int[] ans2 = new int[n+1];
		int sz = 0;
		for (int i = 2; i < n+1; i++) {
			if(adj[i].size()==1)sz++;
		}
		for (int i = 0; i < sz; i++) {
  			occs[arr[i]]++;
		}
		dfs(0, 1, adj, ans, occs);
		dfs2(0, 1, adj, ans2, ans, occs);
				//System.out.println(Arrays.toString(ans));

		//System.out.println(Arrays.toString(ans2));
		System.out.println(ans2[1]);




		
		




 
 
 
 
 
	
	}
	
	static int dfs (int prev, int cur, ArrayList<Integer>[] adj, int[] ans, int[]occs ) {
		int cnt = 0;
		for (int i: adj[cur]) {
			if (i!=prev){
				ans[cur]+= dfs(cur, i, adj, ans, occs);
				cnt++;
			}
		}
		if (cnt==0) return 1;
		return ans[cur];

	}
	static int dfs2(int prev, int cur, ArrayList<Integer>[] adj, int[] ans2, int[] ans,int[]occs){
		int inc = 0;
		int cnt = 0;
		for (int i: adj[cur]){
			if(i!=prev){
				inc += dfs2(cur, i, adj, ans2, ans, occs);
				cnt++;
			}
		}
		
		ans2[cur]=Math.min(ans[cur], occs[cur]+inc);
		if (cnt==0) ans2[cur]=Math.min(occs[cur], 1);
		return ans2[cur];
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
