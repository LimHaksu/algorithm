#include <iostream>
#include <vector>
using namespace std;
int check(vector<vector<int>>& paper, int top, int bottom, int left, int right){
	int ref = paper[top][left];
	for(int i = top; i < bottom; ++i){
		for(int j = left; j < right; ++j){
			if(paper[i][j] != ref)
				return 2;
		}
	}
	return ref;
}
void count(vector<vector<int>>& paper, vector<int>& num, int top, int bottom, int left, int right){
	int index;
	if((index = check(paper,top,bottom,left,right)) != 2){
		num[index+1]++;
	}else{
		int size = (bottom-top)/3;
		for(int i = 0; i < 3; ++i){
			for(int j = 0; j < 3; ++j){
				count(paper,num,top+i*size,top+(i+1)*size,left+j*size,left+(j+1)*size);
			}
		}
	}
}
int main() {
	int n;
	cin >> n;
	vector<vector<int>> paper(n,vector<int>(n));
	for(int i = 0; i < n; ++i){
		for(int j = 0; j < n; ++j){
			cin >> paper[i][j];
		}
	}
	vector<int> number(3,0);
	count(paper,number,0,n,0,n);
	for(int i = 0; i < 3; ++i){
		cout << number[i] << '\n';
	}
	return 0;
}