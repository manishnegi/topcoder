import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class P12 {

	public static void main(String[] args) {
		highlyDivisibleTriangularNumber(System.in);
	}

	public static void highlyDivisibleTriangularNumber(InputStream in) {
		Scanner scan = new Scanner(in);
		StringBuilder sb = new StringBuilder();

		int t = scan.nextInt();
		for (int i = 0; i < t; i++) {
			int n = scan.nextInt();
			sb.append(highlyDivisibleTriangularNumber(n));
			sb.append("\n");
		}
		scan.close();
		System.out.println(sb.toString());
	}
	
	public static int[] cache = {0, 1, 3, 6, 6, 28, 28, 36, 36, 36, 120, 120, 120, 120, 120, 120, 120, 300, 300, 528, 528, 630, 630, 630, 630, 2016, 2016, 2016, 2016, 2016, 2016, 2016, 2016, 2016, 2016, 2016, 2016, 3240, 3240, 3240, 3240, 5460, 5460, 5460, 5460, 5460, 5460, 5460, 5460, 25200, 25200, 25200, 25200, 25200, 25200, 25200, 25200, 25200, 25200, 25200, 25200, 25200, 25200, 25200, 25200, 25200, 25200, 25200, 25200, 25200, 25200, 25200, 25200, 25200, 25200, 25200, 25200, 25200, 25200, 25200, 25200, 25200, 25200, 25200, 25200, 25200, 25200, 25200, 25200, 25200, 25200, 73920, 73920, 73920, 73920, 73920, 73920, 73920, 73920, 73920, 73920, 73920, 73920, 73920, 73920, 73920, 73920, 73920, 73920, 73920, 73920, 73920, 73920, 157080, 157080, 157080, 157080, 157080, 157080, 157080, 157080, 157080, 157080, 157080, 157080, 157080, 157080, 157080, 157080, 437580, 437580, 437580, 437580, 437580, 437580, 437580, 437580, 437580, 437580, 437580, 437580, 437580, 437580, 437580, 437580, 749700, 749700, 749700, 749700, 749700, 749700, 749700, 749700, 749700, 749700, 749700, 749700, 749700, 749700, 749700, 749700, 749700, 749700, 1385280, 1385280, 1385280, 1385280, 1385280, 1385280, 1493856, 1493856, 1493856, 1493856, 1493856, 1493856, 1493856, 1493856, 1493856, 1493856, 1493856, 1493856, 1493856, 1493856, 1493856, 1493856, 1493856, 1493856, 1493856, 1493856, 1493856, 1493856, 1493856, 1493856, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2031120, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 2162160, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 17907120, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 76576500, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 103672800, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 236215980, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320, 842161320};

	public static String highlyDivisibleTriangularNumber(int n) {
		return cache[n+1]+"";
	}
	
	public static String getHighlyDivisibleTriangularNumber(int n) {
		int max = 0;
		long[] cache = new long[1345];
		Arrays.fill(cache, Integer.MAX_VALUE);
		for (long i = 0; i < 100000; i++) {
			long triangle = i*(i+1)/2;
			int num = 0;
			for (long j = 1; j*j <= triangle; j++) {
				if (triangle % j == 0) {
					long res = triangle / j;
					if (res != j) {
						num += 2;
					} else {
						num++;
					}
				}
			}
			for (int j = 0; j <= num; j++) {
				cache[j] = Math.min(cache[j], triangle);
			}
			if (cache[num] == 0) {				
				cache[num] = triangle;
			}
			
			max = Math.max(max, num);
		}
		
		System.out.println(Arrays.toString(cache));
		return cache[n+1]+"";
	}

}