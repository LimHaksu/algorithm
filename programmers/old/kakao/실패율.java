package A1;

import java.io.*;
import java.util.*;

class Stage{
	int stage, count, current;
	Stage(int s){
		this.stage = s;
		this.count = 0;
		this.current = 0;
	}
	double getFailRatio() {
		if(count == 0) {
			return 0;
		}
		return (double)current / count;
	}
}

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Stage[] stage = new Stage[N];
        for(int i = 0; i < N; ++i) {
        	stage[i] = new Stage(i+1);
        }
        for(int i = 0; i < stages.length; ++i) {
        	for(int j = 0; j < stages[i] && j < N; ++j) {
        		stage[j].count++;
        	}
        	if(stages[i]-1 < N) {
        		stage[stages[i]-1].current++;
        	}
        }
        Arrays.sort(stage, new Comparator<Stage>() {
			@Override
			public int compare(Stage o1, Stage o2) {
				double d1 = o1.getFailRatio();
				double d2 = o2.getFailRatio();
				if(d1 > d2) {
					return -1;
				}else if(d1 < d2) {
					return 1;
				}else {
					return Integer.compare(o1.stage, o2.stage);
				}
			}
        });
        for(int i = 0; i < N; ++i) {
        	answer[i] = stage[i].stage;
        }
        return answer;
    }
}
public class 실패율 {
	public static void main(String[] args) {
		int N = 5;
		int[] stages = {2,1,2,6,2,4,3,3};
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(N, stages)));
	}
}
