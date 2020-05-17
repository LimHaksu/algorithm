import java.io.*;
import java.util.*;
public class boj10757{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String num1 = st.nextToken();
        String num2 = st.nextToken();
        int num1Idx = num1.length()-1;
        int num2Idx = num2.length()-1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while(num1Idx >=0 && num2Idx >= 0){
            int n1 = num1.charAt(num1Idx)-'0';
            int n2 = num2.charAt(num2Idx)-'0';
            int tSum = n1+n2+carry;
            carry = tSum / 10;
            sb.insert(0, tSum%10);
            num1Idx--;
            num2Idx--;
        }
        while(num1Idx >=0){
            int n1 = num1.charAt(num1Idx)-'0';
            int tSum = n1+carry;
            carry = tSum / 10;
            sb.insert(0, tSum%10);
            num1Idx--;
        }
        while(num2Idx >= 0){
            int n2 = num2.charAt(num2Idx)-'0';
            int tSum = n2+carry;
            carry = tSum / 10;
            sb.insert(0, tSum%10);
            num2Idx--;
        }
        if(carry==1) {
        	sb.insert(0, 1);
        }
        System.out.println(sb);
    }
}