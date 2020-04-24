import java.util.*;

class Solution {
	public boolean solution(int[][] key, int[][] lock) {
		boolean answer = false;
		int[][] tLock = new int[2*(key.length - 1) + lock.length][2*(key.length - 1) + lock.length];
		for (int i = key.length - 1; i < key.length - 1 + lock.length; ++i) {
			for (int j = key.length - 1; j < key.length - 1 + lock.length; ++j) {
				tLock[i][j] = lock[i - key.length + 1][j - key.length + 1];
			}
		}
		ff: for (int r = 0; r < 4; ++r) {
			for (int i = 0; i < tLock.length - key.length + 1; ++i) {
				for (int j = 0; j < tLock.length - key.length + 1; ++j) {
					int[][] ttLock = new int[tLock.length][tLock.length];
					for (int ii = key.length - 1; ii < key.length - 1 + lock.length; ++ii) {
						ttLock[ii] = tLock[ii].clone();
					}
					f: for (int ii = i; ii < i + key.length; ++ii) {
						for (int jj = j; jj < j + key.length; ++jj) {
							if (key[ii - i][jj - j] == 1) {
								if (ttLock[ii][jj] == 1) {
									break f;
								} else {
									ttLock[ii][jj] = 1;
								}
							}
						}
					}
					int count = 0;
					for(int ii = key.length-1; ii < key.length-1+lock.length; ++ii) {
						for(int jj = key.length-1; jj < key.length-1 + lock.length; ++jj) {
							if(ttLock[ii][jj]==1) {
								count++;
							}
						}
					}
					if (count == lock.length * lock.length) {
						answer = true;
						break ff;
					}
				}
			}
			rotate(key);
		}
		return answer;
	}

	void print(int[][] arr) {
		for(int i = 0; i < arr.length; ++i) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
	}
	void rotate(int[][] key) {
		int[][] temp = new int[key.length][key.length];
		for (int i = 0; i < key.length; ++i) {
			for (int j = 0; j < key.length; ++j) {
				temp[i][j] = key[j][key.length - 1 - i];
			}
		}
		for(int i = 0; i < key.length; ++i) {
			key[i] = temp[i].clone();
		}
	}
}

public class 자물쇠와_열쇠 {
	public static void main(String[] args) {
		int[][] key = { { 0, 0, 0 }, { 1, 1, 1 }, { 1, 1, 1 } };
		int[][] lock = { { 0, 0, 0 }, { 1, 1, 1 }, { 1, 1, 1 } };
		Solution sol = new Solution();
		System.out.println(sol.solution(key, lock));
	}
}
