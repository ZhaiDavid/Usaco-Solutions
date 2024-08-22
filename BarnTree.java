import java.io.*;
import java.util.*;

public class BarnTree {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;
	static int[] arr;
	static ArrayList<Integer>[] adj;
	static int[] subtreeSize;
	static long[] subtreeSum;
	static long div;
	static StringBuilder s = new StringBuilder("");
	static int size = 0;

	public static void main(String[] args) throws IOException {
		int n = shit();
		adj = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) adj[i]=new ArrayList<Integer>();
		arr = new int[n+1];
		for (int i = 0; i < n; i++) arr[i+1]=shit();
		subtreeSize = new int[n+1];
		Arrays.fill(subtreeSize, 1);
		subtreeSum = new long[n+1];

		for (int i = 0; i < n-1; i++) {
			int a = shit(), b = shit();
			adj[a].add(b);
			adj[b].add(a);
		}
		size(1, 0);
		sum(1, 0);
		
	
	
		div = subtreeSum[1]/n;
		dfs(1, 0);
		dfs2(1, 0);
		System.out.println(size);
		System.out.print(s);

		
	
		








	
	}
	static int size (int cur, int prev) {
		for (int i: adj[cur]) {
			if (i != prev)
				subtreeSize[cur]+=size(i, cur);
		}
		return subtreeSize[cur];
	}
	static long sum (int cur, int prev) {
		subtreeSum[cur]=1L*arr[cur];
		for (int i: adj[cur]) {
			if (i!=prev) {
				subtreeSum[cur]+=sum(i, cur);
			}
		}
		return subtreeSum[cur];
	}
	static void dfs (int cur, int prev) { // taking from subtrees with more than what they need
		for (int i: adj[cur]) {
			if (i!=prev) {
				dfs(i, cur);
			}
		}
		long diff = subtreeSum[cur]-1L*subtreeSize[cur]*div;
		if (prev != 0 && diff > 0) {
			s.append(cur + " " + prev + " " + diff +"\n");
			size++;
		}
	}
	static void dfs2(int cur, int prev) { // giving to subtrees with less than what they need
		for (int i: adj[cur]) {
			if (i!=prev) {
				long diff = 1L*subtreeSize[i]*div-subtreeSum[i];
				if (diff > 0) {
					s.append(cur +" " + i + " " + diff+"\n");
					size++;
				}
				dfs2(i, cur); 
			}
			
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
