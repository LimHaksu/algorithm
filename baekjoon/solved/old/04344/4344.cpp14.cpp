#include<iostream>
#include<math.h>
using namespace std;
int main(void){
    int testcases;
    cin>>testcases;
    for(int i = 0; i < testcases; i++){
        int n;
        cin >> n;
        int total=0;
        double avg;
        int pts[n];
        for(int j = 0; j< n; j++){
            cin>>pts[j];
            total+=pts[j];
        }
        avg = (double)total/n;
        int cnt=0;
        for(int j = 0; j<n; j++){
            if(pts[j]>avg){
                cnt++;
            }
        }        
        cout<<fixed;
        cout.precision(3);
        cout<<floor(((double)cnt/n)*100*pow(10,3)+0.5)*pow(10,-3)<<"%"<<endl;
    }
    return 0;
}