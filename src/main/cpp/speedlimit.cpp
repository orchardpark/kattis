#include <iostream>

using namespace std;

void solve(int n)
{
    int s, t;
    int pt =0;
    int res = 0;
    for(int i=0; i<n; i++)
    {
        cin >> s >> t;
        res += s*(t-pt);
        pt = t;
    }
    printf("%d miles\n", res);
}

int main()
{
    int n;
    while(cin >> n)
    {
        if(n==-1)
            break;
        solve(n);
    }
    return 0;
}
