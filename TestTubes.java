import java.io.*;
import java.util.*;
// should have realized that you only need to use the beaker at most once
// the fact you have to compress is pretty intuitive
/* strategy:
  we will fill tube 1 with its first character. Ex. if tube 1 is "1222", our goal is to make it filled with 1s
  do this until tube 1 is just one character or (tube 1 is two characters long and the last character is the same as tube 2's last character)  {
      if character being poured is the same as the last character of tube 2: pour it into tube 2
      else: pour it into the beaker
    }

    do this until tube 2 is empty or (tube 2 is 1 character and that character is the opposite of what tube 1 should be filled with) {
       if character being poured is the same as last character of tube 1: pour it into tube 1
       else pour it into the beaker
    }

    now pour from the beaker to the appropriate tube (or don't if it wasn't used)
    now pour from tube 1 to tube 2 (if tube 1 consists of two characters --> the character it's supposed to be filled with and the last character of the original tube 2)

    

*/


public class TestTubes {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in;
	public static void main(String[] args) throws IOException {
			int t = shit();
			
		while (t-->0){
			int n = shit(), p = shit();
			char[] aa = (next()+"0").toCharArray();
			char[] bb=(next()+"0").toCharArray();
			int[]a = new int[n+1];
			int[] b = new int[n+1];
			for (int i = 0; i < n+1; i++) {
				a[i]=Integer.parseInt(aa[i]+"");
			    b[i]=Integer.parseInt(bb[i]+"");
			}

			ArrayList<Integer> compA = new ArrayList<Integer>();
			ArrayList<Integer> compB = new ArrayList<Integer>();
			int prev = 0;
		
			for (int i = 0; i < n+1; i++){
				if (i==0) prev = a[i];
				else if (a[i]!=prev) {
					if (prev!=0)compA.add(prev);
					prev = a[i];
				}

			}
			for (int i = 0; i < n+1; i++){
				if (i==0) prev = b[i];
				else if (b[i]!=prev) {
					if (prev!=0)compB.add(prev);
					prev = b[i];
				}

			}
			ArrayList<String> out = f(compA, compB, compA.get(0));
			StringBuilder s = new StringBuilder("");
			
			System.out.println(out.size());
			
			for (String i: out) {
				s.append(i+"\n");
			}
			if (p!=1)
			System.out.print(s);
			
			
		
			
		}

		





	
	}
	static ArrayList<String>f (ArrayList<Integer>a, ArrayList<Integer>b, int m) {
		ArrayList<Integer> compA = new ArrayList<Integer>();
		ArrayList<Integer> compB = new ArrayList<Integer>();
		for (int i: a) compA.add(i);
		for (int i: b) compB.add(i);
		ArrayList<String> out = new ArrayList<String>();
		int beaker = 0;
		int topS = compB.get(compB.size()-1);
		while (true){
			if (compA.size()==1) break;
			if (compA.size()==2 && compA.get(1)==topS) break;
			int p = compA.remove(compA.size()-1);
			if (p==topS){
				out.add("1 2");
			} else {
				beaker=p;
				out.add("1 3");
			}
		}
		boolean bo = false;
		int topF = compA.get(compA.size()-1); 
		//System.out.println(topF);
		while (true) {
			if (compB.size()==1 && compB.get(0)!=m) break;
			if (compB.size()==0) break;
			int p = compB.remove(compB.size()-1);
			if (p == topF){
				out.add("2 1");
			} else {
				out.add("2 3");
				beaker = p;
			}
		}
		if (compA.size()==2) {
			out.add("1 2");
		}

		if (beaker != 0) {
			if (beaker == m) {
				out.add("3 1");
			} else{
				out.add("3 2");
			}
		}
			

		
		
		
		return out;
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
