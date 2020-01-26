#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

class Person{
 protected:
 string name;
 int age, sum = 0;
 public:
     
    virtual void getdata() = 0;
    virtual void putdata() = 0;
};
class Professor: public Person{
private:
int publications;
int id;
static int cur_id;
public:
Professor():
id{cur_id++}
{}
    void getdata(){
     
        cin >> name >> age >> publications;
}

    void putdata(){
        cout << name << " " << age << " " << publications << " " << id << endl; 
}
};

class Student: public Person{

private:
vector<int> marks;
static int cur_id;
int id;

    public:
    Student():
    marks(6),
    id{cur_id++}
    {}
        void getdata(){
            int input;
            cin >> name >> age;
            for (auto& mark : marks){
                cin >> mark;
                sum += mark;
            }
        }
            
        
        void putdata(){
            cout << name << " " << age << " " << sum << " " << id << endl;
        }
};
int Professor::cur_id {1};

int Student::cur_id {1};

int main(){
