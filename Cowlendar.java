import java.io.*;
import java.util.*;
// really cool math problem; unfortunately i spent a good 30 minutes wa'ing cuz i put (int)4e9
public class Cowlender {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;
	public static void main(String[] args) throws IOException {
		int n = shit();
		Set<Long> set = new HashSet<Long>();
		long min = (long)4e9;
		for (int i = 0; i < n; i++){
			long a = ll();
			set.add(a);
			min = Math.min(min, a);
		}
		min/=4L;
		int idx = 0;
		ArrayList<Long> firstFour = new ArrayList<Long>();
		for (long i: set) {
			idx++;
			if (idx > 4) break;
			firstFour.add(i);
		}
		if (set.size()< 4) {
			
			System.out.println(min*(min+1)/2L);
			return;
		}

		Set<Long> factors = new HashSet<Long>();
		for (int i = 0; i < 4; i++){
			for (int j = i+1; j < 4; j++) {
				long diff = Math.abs(firstFour.get(i)-firstFour.get(j));
				
				for (long k = 1; k <= Math.sqrt(diff); k++) {
					if (diff%k==0) {factors.add(k); factors.add(diff/k);}
				}
			}
		}
		//System.out.println(factors);
		long sum = 0L;
		loop:
		for (long i: factors) {
			Set<Long> mods = new HashSet<Long>();
			for (long j: set) {
				mods.add(j%i);
				if (mods.size()>3) continue loop;
			}
			if (i <= min)sum += i;
		}
		System.out.println(sum);
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
