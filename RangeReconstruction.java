import java.io.*;
import java.util.*;

public class RangeReconstruction {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;
	static int inf = (int)1e9+1;


	public static void main(String[] args) throws IOException {
		int n = shit();
		int[] arr = new int[n];


		ArrayList<Integer>[] range = new ArrayList[n];
		for (int i = 0; i < n; i++) range[i]=new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				range[i].add(shit());
			}
			
		}
		for (int i = n-2; i>=0; i--) {
			if (range[i].get(1)==0) {
				arr[i]=arr[i+1]; continue;
			}
			boolean minimize = true;
			int min = arr[i+1]-range[i].get(1);
			int max = arr[i+1]-range[i].get(1);
			
			for (int j =i+1; j < n; j++) {
				min = Math.min(min, arr[j]); max = Math.max(max,arr[j]);
				if (max-min != range[i].get(j-i)) minimize = false;
			}
			if (min < -(int)1e9) minimize = false;
			if (minimize) arr[i]=arr[i+1]-range[i].get(1);
			else arr[i]=arr[i+1]+range[i].get(1);
			
		}
		StringBuilder s = new StringBuilder("");
		s.append(arr[0]);
		for (int i = 1; i < n; i++) {
			s.append(" " + arr[i]);
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
