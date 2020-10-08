class Solution {
	public long solution(int w,int h) {
        int gcd = getGCD(w,h);
        int sw = w / gcd;
        int sh = h / gcd;
        int dCount = sw+sh-1;
		return (long)w*h - (long)dCount * w / sw;
	}
    int getGCD(int a, int b){
        while(b > 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
public class 멀쩡한_사각형 {
	public static void main(String[] args) {
		Solution sol = new Solution();
	}
}
