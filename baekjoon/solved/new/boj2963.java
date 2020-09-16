import java.io.*;
import java.math.BigInteger;
public class boj2963 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		BigInteger answer = BigInteger.ONE;
		BigInteger plus = BigInteger.ONE;
		BigInteger two = new BigInteger("2");
		BigInteger five = new BigInteger("5");
		BigInteger three = new BigInteger("3");
		for(int i = 0; i < input.length(); ++i) {
			switch(input.charAt(i)) {
			case 'L':
				answer = answer.multiply(two);
				break;
			case 'R':
				answer = answer.multiply(two).add(plus);
				break;
			case '*':
				answer = answer.multiply(five).add(plus);
				plus = plus.multiply(three);
				break;
			default:
				;
			}
		}
		System.out.println(answer);
	}
}
