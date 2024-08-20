
import java.io.*;
import java.util.*;
 
public class 2023_US_OPEN_P2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;
  
	static int MOD = (int)1e9+7;
	static int inf = (int)1e9;

	/* ideas learned

		can think of bit flips as edges
		multisource bfs is useful

	*/

	public static void main(String[] args) throws IOException {
		
			
		// well the first few subtasks are generous

		int c = shit(), n = shit();
		int[]a=new int[n];
		boolean[] exists = new boolean[1<<c];
		for (int i = 0; i < n; i++) {
			a[i]=toBin(next());
			exists[a[i]]=true;
		}
		int[][] adj = new int[1<<c][c];
		for (int i = 0; i < 1<<c; i++) {
			for (int j = 0; j < c; j++) {
				adj[i][j]=i^(1<<j);
			}
		}
	

		int[] dis = new int[1<<c];
		Arrays.fill(dis, inf);
		
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i: a) {
			dis[i]=0;
			q.add(i);
		}

		while (!q.isEmpty()) {
			int node = q.poll();
			for (int i: adj[node]) {
				if (dis[i]==inf) {
					q.add(i);
					dis[i]=dis[node]+1;
				}
			}
		}
		for (int i: a) {
			int cur = ((1<<c)-1)^i;
	
			if (exists[cur]) System.out.println(c);
			else System.out.println(c-dis[cur]);
			
		}
		

	

			
			
		
			
		
	}
	static int toBin(String s) {
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			int cur = s.length()-i-1;
			if (s.charAt(i)=='G') sum += 1 << cur;
		}
		return sum;
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
  int node;
  int from;
 
  Pair(int node, int from) {
	this.node=node;
	this.from=from;
  }
 
  @Override
  public int compareTo(Pair other) {
	  return 0;
  }
 
  public String toString() {
	  return node + " " + from;
  }
 
 
  
 
}
