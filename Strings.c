#include <iostream>
#include <ostream>
#include <string>
using namespace std;

int main() {
	string a,b;
    cin >> a >> b;
    string c  = a + b;
    char d = a[0];
    char e = b[0];
    cout << a.size() << " " << b.size() <<endl;
    cout << c << endl;
    a[0] = e;
    b[0] = d;
    cout << a << " " << b << endl;

    return 0;
}

