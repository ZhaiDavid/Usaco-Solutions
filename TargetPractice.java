import java.io.*;
import java.util.*;

// very implementy instead of hard
public class TargetPractice {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;
	public static void main(String[] args) throws IOException {
		int t = shit(), c = shit();
		Set<Integer> targets = new HashSet<Integer>();
		HashMap<Integer, Integer> ok = new HashMap<Integer, Integer>();
		for (int i = 0; i < t; i++) {
			int a = shit();
			targets.add(a);
		}
		
		char[] commands = next().toCharArray();

		int[] pos = new int[c];
		int p = 0;
		for (int i = 0; i < c; i++) {
			if (commands[i]=='L')p--;
			else if (commands[i]=='R') p++;
			else if (targets.contains(p)) {
				ok.putIfAbsent(p, 0);
				ok.put(p, ok.get(p)+1);
			}
			
			pos[i]=p;
			

		}
		//System.out.println(sum);
	
		int[] arr = new int[6];
		arr[0]= f(-1, pos, ok, c, targets, commands, 'R');
		arr[1]= f(1, pos, ok, c, targets, commands, 'L');
	    arr[2]= f2(-2, pos, ok, c, targets, commands, 'R');
	    arr[3]= f2(2, pos, ok, c, targets, commands, 'L');
		arr[4]=f3(-1, pos, ok, c, targets, commands, 'F');
		arr[5]=f3(1, pos, ok, c, targets, commands, 'F');
		//System.out.println(Arrays.toString(arr));
		
		Arrays.sort(arr);
		System.out.println(Math.max(arr[5], ok.size()));


	}

	// L or R turn into F
	static int f (int change, int[] pos, HashMap<Integer, Integer> map, int c, Set<Integer> targets, char[]commands, char ch) {
		HashMap<Integer,Integer> copy = new HashMap<Integer, Integer>();
		int ans = 0;
		for (int i: map.keySet()) copy.put(i, map.get(i));
		for (int i = c-1; i>=0; i--) {
			if (commands[i]=='F'){
				if (targets.contains(pos[i])) {
					copy.put(pos[i], copy.get(pos[i])-1);
					if (copy.get(pos[i])==0) copy.remove(pos[i]);
				}
				if(targets.contains(pos[i]+change)) {
					copy.putIfAbsent(pos[i]+change, 0);
					copy.put(pos[i]+change, copy.get(pos[i]+change)+1);
				}
			}
			if (commands[i]==ch) {
				int inc = 0;
				if(targets.contains(pos[i]+change)){
					if (copy.get(pos[i]+change)==null) inc=1;
				}
				ans = Math.max(ans, copy.size()+inc);
			}

		}
		return ans;


	}

	// L turn into R and vice versa
	static int f2 (int change, int[] pos, HashMap<Integer, Integer> map, int c, Set<Integer> targets, char[]commands, char ch) {
		HashMap<Integer,Integer> copy = new HashMap<Integer, Integer>();
		int ans = 0;
		for (int i: map.keySet()) copy.put(i, map.get(i));
		for (int i = c-1; i>=0; i--) {
			if (commands[i]=='F'){
				if(targets.contains(pos[i])) {
					copy.put(pos[i], copy.get(pos[i])-1);
					if (copy.get(pos[i])==0) copy.remove(pos[i]);
				}
				if(targets.contains(pos[i]+change)){
					copy.putIfAbsent(pos[i]+change, 0);
					copy.put(pos[i]+change, copy.get(pos[i]+change)+1);
				}
			}
			if (commands[i]==ch) {
				ans = Math.max(ans, copy.size());
			}

		}
		return ans;


	}

	// f turn into L or R
	static int f3 (int change, int[] pos, HashMap<Integer, Integer> map, int c, Set<Integer> targets, char[]commands, char ch) {
		HashMap<Integer,Integer> copy = new HashMap<Integer, Integer>();
		int ans = 0;
		for (int i: map.keySet()) copy.put(i, map.get(i));
		for (int i = c-1; i>=0; i--) {
			if (commands[i]=='F'){
				if(targets.contains(pos[i])) {
					copy.put(pos[i], copy.get(pos[i])-1);
					if (copy.get(pos[i])==0) copy.remove(pos[i]);
					
				}
				ans = Math.max(ans, copy.size());
				//System.out.println(change + " " + copy);
				if(targets.contains(pos[i]+change)) {
					copy.putIfAbsent(pos[i]+change, 0);
					copy.put(pos[i]+change, copy.get(pos[i]+change)+1);
				}
			}
			
			
				
			

		}
		return ans;


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
