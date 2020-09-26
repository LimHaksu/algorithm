import java.io.*;
import java.util.*;

class Pair {
	int x, y, gb;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}

class Solution {
	Set<Pair> gidungs = new HashSet<Pair>();
	Set<Pair> bos = new HashSet<Pair>();

	public int[][] solution(int n, int[][] build_frame) {
		// [x,y,a,b] a 0 기둥 1 보, b 0 삭제 1, 설치
		for(int i = 0; i < build_frame.length; ++i) {
			int x = build_frame[i][0];
			int y = build_frame[i][1];
			int a = build_frame[i][2];
			int b = build_frame[i][3];
			Pair p = new Pair(x, y);
			if(a == 0) {
				// 기둥
				if(b == 1) {
					// 설치
					if(isValidInsertGidung(p)) {
						gidungs.add(p);
					}
				}else {
					// 삭제
					deleteGidung(p);
				}
			}else {
				//보
				if(b == 1) {
					// 설치
					if(isValidInsertBo(p)) {
						bos.add(p);
					}
				}else {
					// 삭제
					deleteBo(p);
				}
			}
		}
		List<Pair> list = new ArrayList<>();
		for(Pair p : gidungs) {
			p.gb = 0;
			list.add(p);
		}
		for(Pair p : bos) {
			p.gb = 1;
			list.add(p);
		}
		list.sort((o1, o2)->{
			if(o1.x < o2.x) {
				return -1;
			}else if(o1.x > o2.x) {
				return 1;
			}else {
				if(o1.y < o2.y) {
					return -1;
				}else if(o1.y > o2.y) {
					return 1;
				}
			}
			return Integer.compare(o1.gb, o2.gb);
		});
		int[][] answer = new int[list.size()][3];
		for(int i = 0; i < answer.length; ++i) {
			answer[i][0] = list.get(i).x;
			answer[i][1] = list.get(i).y;
			answer[i][2] = list.get(i).gb;
		}
		return answer;
	}

	boolean isValidInsertGidung(Pair coord) {
		// 바닥 위에 있으면 설치 가능
		if (coord.y == 0) {
			return true;
		}
		// 보의 한쪽 끝 부분위에 있으면 가능
		for (Pair p : bos) {
			int lx = p.x;
			int rx = lx + 1;
			int y = p.y;
			if ((coord.x == lx && coord.y == y) || (coord.x == rx && coord.y == y)) {
				return true;
			}
		}
		// 또다른 기둥 위에 있으면 가능
		for (Pair p : gidungs) {
			int gx = p.x;
			int gy = p.y + 1;
			if (coord.x == gx && coord.y == gy) {
				return true;
			}
		}
		return false;
	}

	boolean isValidInsertBo(Pair coord) {
		// 한쪽 끝 부분이 기둥 위면 가능
		int lx = coord.x;
		int rx = lx + 1;
		int y = coord.y;
		for (Pair p : gidungs) {
			int gx = p.x;
			int gy = p.y + 1;
			if ((lx == gx && y == gy) || (rx == gx && y == gy)) {
				return true;
			}
		}
		// 양쪽 끝 부분이 다른 보와 동시에 연결되면 가능
		boolean leftCheck = false;
		boolean rightCheck = false;
		for (Pair p : bos) {
			int blx = p.x;
			int brx = blx + 1;
			int by = p.y;
			// 왼쪽 체크 (lx)
			if(by == y && lx == brx) {
				leftCheck = true;
			}else if(by == y && rx == blx){ // 오른쪽 체크 (rx)
				rightCheck = true;
			}
		}
		if(leftCheck && rightCheck) {
			return true;
		}
		
		return false;
	}

	void deleteGidung(Pair coord) {
		// 해당 좌표 기둥 제거 후 남은 기둥, 보에 대하여 insert 만족하는지 체크
		boolean check = true;
		gidungs.remove(coord);
		for(Pair p : gidungs) {
			if(!isValidInsertGidung(p)) {
				check = false;
				break;
			}
		}
		if(check) {
			for(Pair p : bos) {
				if(!isValidInsertBo(p)) {
					check = false;
					break;
				}
			}
		}
		if(!check) {
			gidungs.add(coord);
		}
		// 만족하지 않으면 다시 기둥 넣기
	}

	void deleteBo(Pair coord) {
		// 해당 좌표 보 제거 후 남은 기둥, 보에 대하여 insert 만족하는지 체크
		boolean check = true;
		bos.remove(coord);
		for(Pair p : gidungs) {
			if(!isValidInsertGidung(p)) {
				check = false;
				break;
			}
		}
		if(check) {
			for(Pair p : bos) {
				if(!isValidInsertBo(p)) {
					check = false;
					break;
				}
			}
		}
		if(!check) {
			bos.add(coord);
		}
		// 만족하지 않으면 다시 보 넣기
	}
}

public class 기둥과_보_설치 {
	public static void main(String[] args) throws Exception {
		int n = 5;
		int[][] build_frame = { { 1, 0, 0, 1 }, { 1, 1, 1, 1 }, { 2, 1, 0, 1 }, { 2, 2, 1, 1 }, { 5, 0, 0, 1 },
				{ 5, 1, 0, 1 }, { 4, 2, 1, 1 }, { 3, 2, 1, 1 } };
		Solution sol = new Solution();
		int[][] answer = sol.solution(n, build_frame);
		for(int i = 0; i < answer.length; ++i) {
			System.out.println(Arrays.toString(answer[i]));
		}
	}
}
