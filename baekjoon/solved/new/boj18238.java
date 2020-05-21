import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char currentChar = 'A';
        int answer = 0;
        for(int i = 0; i < s.length(); ++i){
        	int right, left;
             right = Math.abs((currentChar-'A') - (s.charAt(i)-'A'));
        	if(currentChar < s.charAt(i)){
             left = Math.abs((currentChar-'A'+'Z'+1-'A')- (s.charAt(i)-'A'));
        	}else{
             left = Math.abs((s.charAt(i)-'A'+'Z'+1-'A')- (currentChar-'A'));
        	}
             answer += Math.min(left, right);
            currentChar = s.charAt(i);
        }
        System.out.println(answer);
    }
}