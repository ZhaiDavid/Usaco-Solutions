import java.io.*;
import java.util.*;

// i think i guessed this

public class USOpen2022SilverP2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;

	public static void main(String[] args) throws IOException {
		char[] s = next().toCharArray();
		char[] t = next().toCharArray();

		boolean[][] ok = new boolean['r'+1]['r'+1];
		for (int i = 'a'; i <= 'r'; i++) {
			for (int j = 'a'; j <= 'r'; j++) {
				StringBuilder a = new StringBuilder("");
				StringBuilder b = new StringBuilder("");
				for (int k = 0; k< s.length; k++) {
					if (s[k]==i || s[k]==j)a.append(s[k]);
					
				}
				for (int k = 0; k< t.length; k++) {
					if (t[k]==i || t[k]==j)b.append(t[k]);
					
				}
				
				ok[i][j]=a.toString().equals(b.toString());
			}
		}
		
		int q = shit();
		StringBuilder out = new StringBuilder("");
		while (q-->0) {
			char[] a = next().toCharArray();
			int x = a.length;
			boolean same = true;
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < x; j++) {
					if (!ok[a[i]][a[j]]) 
						same = false;
					
					
				}
			}
			
			if (same) out.append("Y");
			else out.append("N");
		}
		System.out.println(out);



		
		








	
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
	  return a+"";
  }



  

}
