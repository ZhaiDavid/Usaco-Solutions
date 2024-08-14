import java.io.*;
import java.util.*;
 
public class IncompleteFieldDay {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;
  
	static int MOD = (int)1e9+7;



	public static void main(String[] args) throws IOException {
		
			
		// well the first few subtasks are generous

		int c = shit(), n = shit();
		HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

		int[] out = new int[n];

		for (int i = 0; i <n; i++) {
			String s = next();
			map.putIfAbsent(s, new ArrayList<Integer>());
			map.get(s).add(i);
		}
		if (c<=10) {
			for (String s: map.keySet()) {
				int max = 0;
				for (String s2: map.keySet()) {
					max = Math.max(max, diff(s, s2));

				}
				for (int i: map.get(s)) out[i]=max;
			}
		


		} else {
		
			l:
			for (String s: map.keySet()) {
				if (map.get(generate(-1, s)) != null) {
					for (int i: map.get(s)) out[i]=c;
					continue;
				} 

				for (int i = 0; i < c; i++) {
					if (map.get(generate(i, s)) != null) {
						for (int k: map.get(s)) out[k]=c-1;
						continue l;
					}
					

				}
				for (int i = 0; i < c; i++) {
					for (int j = i+1; j < c; j++) {
						
						if (map.get(generate2(i,j, s))!=null) {
							for (int k: map.get(s)) out[k]=c-2;
							continue l;
						}

					}

				}
				for (int i: map.get(s)) out[i]=c-3;

			}


		}
		StringBuilder ans = new StringBuilder();
		for (int i: out) ans.append(i+"\n");
		System.out.print(ans);
		
			
			
		
			
		
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
