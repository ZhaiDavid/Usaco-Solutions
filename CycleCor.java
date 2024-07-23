import java.io.*;
import java.util.*;
 
public class CycleCor {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;
	public static void main(String[] args) throws IOException {
		int n = shit(), k = shit();
		// something with rlative positions i reckon
		int[] a = new int[k];
		int[] b = new int[k];
		int[] occsA = new int[n+1];
		Arrays.fill(occsA, -1);
		
		int[] occsB = new int[n+1];
		Arrays.fill(occsB,-1);
		for (int i = 0; i < k; i++) {
			a[i]=shit();
			occsA[a[i]]=i;
		}
		for (int i = 0; i < k; i++) {
			b[i]=shit();
			occsB[b[i]]=i;
		}
		int[]c1 = new int[k];
		int[] c2= new int[k];

		for (int i = 0; i < k;i++) {
			int pos2 = occsB[a[i]];
			if (pos2==-1) continue;
			if (i < pos2) {
				c1[k+i-pos2]++;
			} else {
				c1[i-pos2]++;
			}

		}
		
		for (int i = 0; i < k;i++) {
			int pos1 = k-1-i;
			int pos2 = occsB[a[i]];
			if (pos2==-1) continue;
			if (pos1 < pos2) {
				c2[k+pos1-pos2]++;
			} else {
				c2[pos1-pos2]++;
			}
		}
		Arrays.sort(c1);
		Arrays.sort(c2);
		int align = Math.max(c1[k-1], c2[k-1]);


		int diff = 0;
		for (int i = 0; i < k; i++) {
			if (occsB[a[i]]==-1) diff++;
		}
		int inv = diff*2;
		int same = (2*k-inv)/2;
		inv += same-align;
	

		System.out.println(n-inv);
		


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
