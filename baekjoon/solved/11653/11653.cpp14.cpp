#include <iostream>
#include <vector>
using namespace std;
int main(){
    int n;
    cin >> n;
    vector<bool> prime_check(n+1,true);
    vector<int> prime_list;
    for(int i = 2; i <= n; i++){
        if(prime_check[i] == true){
            prime_list.push_back(i);
            for(int j = 2*i; j <= n; j+=i){
                prime_check[j] = false;
            }
        }
    }
    for(int i = 0; i < prime_list.size(); i++){
        if(n%prime_list[i] == 0){
            cout << prime_list[i] << "\n";
            n /= prime_list[i];
            i--;
        }
        if(n == 0)
            break;
    }
    return 0;
}