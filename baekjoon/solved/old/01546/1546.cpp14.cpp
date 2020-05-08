#include<iostream>
using namespace std;
int main(void){
    int n;
    cin>>n;
    int pts[n];
    double pts_modify[n];
    int pts_max=0;
    double total = 0;
    for(int i = 0; i<n ; i++){
        cin>>pts[i];
        if(pts[i]>pts_max){
            pts_max = pts[i];
        }        
    }
    for(int i=0; i<n; i++){
        pts_modify[i] = (double)pts[i]/pts_max*100;
        total += pts_modify[i];
    }
    cout<<(total/n);
    return 0;    
}