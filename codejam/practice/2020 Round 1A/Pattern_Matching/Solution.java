package A;

import java.io.*;
import java.util.*;

public class Solution{
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= t; ++tc) {
			int n = Integer.parseInt(br.readLine());
			String[] p = new String[n];
			for(int i = 0; i < n; ++i) {
				p[i] = br.readLine();
			}
			// 스트링, pf는 앞에서부터, sf는 뒤에서부터, mid는 가운데 
			StringBuilder pf = new StringBuilder();
			StringBuilder mid = new StringBuilder();
			StringBuilder sf = new StringBuilder();
			boolean check = true;
			// 각각의 패턴에 대해서
			f : for(int i = 0; i < n; ++i) {
				int l = p[i].length();
				// j는 앞에서부터, k는 뒤에서부터, c는 sf의 인덱스
				int j, k, c;
				for(j = 0; j < l; ++j) {
					// 앞에서부터 읽다가 *가 나타나면 탈출
					if(p[i].charAt(j) == '*') break;
					// pf의 길이가 j보다 짧으면 그 이후로 이어붙임
					if(pf.length() == j) pf.append(p[i].charAt(j));
					// j번째 문자가 이미 생성한 문자와 다르면 불가능
					if(pf.charAt(j) != p[i].charAt(j)) {
						check = false;
						break f;
					}
				}
				for(k = l-1, c= 0; k > 0; --k, ++c) {
					// 뒤에서부터 읽다가 *가 나타나면 탈출
					if(p[i].charAt(k) == '*') break;
					// sf의 길이가 c보다 짧으면 그 이후로 이어붙임
					if(sf.length()==c) sf.append(p[i].charAt(k));
					// k번째 문자가 이미 생성한 문자와 다르면 불가능.
					if(sf.charAt(c)!= p[i].charAt(k)) {
						check = false;
						break f;
					}
				}
				// j는 첫번째 *의 위치, k는 마지막 *의 위치
				for(;j<k;++j) {
					// *가 아닌 문자는 mid에 붙임
					if(p[i].charAt(j) != '*') {
						mid.append(p[i].charAt(j));
					}
				}
			}
			sf = sf.reverse();
			if(check) {
				System.out.println("Case #"+tc+": "+pf+mid+sf);
			}else {
				System.out.println("Case #"+tc+": *");
			}
		}
	}
}
