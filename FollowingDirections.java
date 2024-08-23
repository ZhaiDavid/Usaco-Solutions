import java.io.*;
import java.util.*;

public class FollowingDirections {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;
	static int inf = (int)1e9;
	// lol 15 second runtime



	public static void main(String[] args) throws IOException {
		// looks like just graph
		int n = shit();
		int[][] cost = new int[n+1][n+1];
		char[][] map = new char[n][n];
		int tot = 0;
		for (int i = 0; i < n; i++){
			map[i]=next().toCharArray();
			cost[i][n]=shit();
		}

		for (int i = 0; i < n; i++) {cost[n][i]=shit(); }

		Queue<Pair> q = new LinkedList<Pair>();
		for (int i = 0; i < n; i++) {
			q.add(new Pair(i, n));
			q.add(new Pair (n, i));
		}
		

		while (!q.isEmpty()) {
				Pair p = q.poll();
				int curX = p.a, curY = p.b;
				if (curX-1 >= 0 && curY < n && map[curX-1][curY]=='D' ) {
					cost[curX-1][curY]=cost[curX][curY];
					tot+=cost[curX][curY];
					q.add(new Pair(curX-1, curY));
				
				} if (curY-1>=0 && curX < n && map[curX][curY-1]=='R' ) {
					cost[curX][curY-1]=cost[curX][curY];
					tot+=cost[curX][curY];
						q.add(new Pair(curX,curY-1));
				
				}
		
		}

		
		System.out.println(tot);

		int query = shit();
		while (query-->0) {
			int x = shit()-1, y = shit()-1;
			if (map[x][y]=='D') map[x][y]='R';
			else map[x][y]='D';

			
			

			q.add(new Pair(x+1, y));
			q.add(new Pair (x, y+1));
			while (!q.isEmpty()) {
				Pair p = q.poll();
				x=p.a; y = p.b;
			
				if(x-1 >= 0 && y < n && map[x-1][y]=='D') {
					tot+=cost[x][y]-cost[x-1][y];
					cost[x-1][y]=cost[x][y];
					q.add(new Pair(x-1, y));
				
				} if (y-1>=0 && x < n && map[x][y-1]=='R') {
					tot += cost[x][y]-cost[x][y-1];
					cost[x][y-1]=cost[x][y];
					q.add(new Pair(x, y-1));
				}
				
				
			}
			
			System.out.println(tot);
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
  int b;

  Pair(int a, int b) {
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
