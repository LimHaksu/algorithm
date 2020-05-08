// test set1 ok, test set2 ok
#include <iostream>
#include <vector>
#include <string>
#include <cstdio>
using namespace std;

int main(){
    freopen("input.txt","r",stdin);
    int t;
    cin >> t;
    for(int tc = 1; tc <= t; ++tc){
        int a;
        cin >> a;
        vector<string> arr(a);
        for(int i = 0; i < a; ++i){
            cin >> arr[i];
        }
        string ans = "";
        bool possible = true;
        for(int j = 0; a > 0; ++j){
            int rcount=0, pcount = 0, scount = 0;
            for(int i = 0; i < a; ++i){
                char c = arr[i][j % arr[i].size()];
                switch(c){
                    case 'R': rcount++;
                        break;
                    case 'P': pcount++;
                        break;
                    case 'S': scount++;
                        break;
                }
            }
            if(rcount>0 && pcount >0 && scount>0){
                ans = "IMPOSSIBLE";
                possible = false;
                break;
            }else if(scount > 0 && rcount > 0 && pcount == 0){
                ans += 'R';
                for(int i = 0; i < a; ++i){
                    char c = arr[i][j % arr[i].size()];
                    if(c == 'S'){
                        arr.erase(arr.begin()+i);
                        a--;
                        i--;
                    }
                }
            }else if(scount > 0 && pcount > 0 && rcount == 0){
                ans += 'S';
                for(int i = 0; i < a; ++i){
                    char c = arr[i][j % arr[i].size()];
                    if(c == 'P'){
                        arr.erase(arr.begin()+i);
                        a--;
                        i--;
                    }
                }
            }else if(rcount > 0 && pcount > 0 && scount == 0){
                ans += 'P';
                for(int i = 0; i < a; ++i){
                    char c = arr[i][j % arr[i].size()];
                    if(c == 'R'){
                        arr.erase(arr.begin()+i);
                        a--;
                        i--;
                    }
                }
            }else if(scount > 0 && pcount == 0 && rcount == 0){
                ans += 'R';
                for(int i = 0; i < a; ++i){
                    char c = arr[i][j % arr[i].size()];
                    if(c == 'S'){
                        arr.erase(arr.begin()+i);
                        a--;
                        i--;
                    }
                }
            }else if(pcount > 0 && rcount == 0 && scount == 0){
                ans += 'S';
                for(int i = 0; i < a; ++i){
                    char c = arr[i][j % arr[i].size()];
                    if(c == 'P'){
                        arr.erase(arr.begin()+i);
                        a--;
                        i--;
                    }
                }
            }else if(rcount > 0 && pcount == 0 && scount == 0){
                ans += 'P';
                for(int i = 0; i < a; ++i){
                    char c = arr[i][j % arr[i].size()];
                    if(c == 'R'){
                        arr.erase(arr.begin()+i);
                        a--;
                        i--;
                    }
                }
            }
        }
        if(ans.size() > 500){
            ans = "IMPOSSIBLE";
        }
        cout << "Case #" << tc << ": " << ans << "\n";
    }
    return 0;
}