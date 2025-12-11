#include <bits/stdc++.h>
using namespace std;
class bank
{
public:
    int id;
    string name;
    int balance = 0;

    void withdrawal(int amount)
    {
        if (amount > balance)
        {
            cout << "insufficient balance." << endl;
            return;
        }
        balance -= amount;
        cout << "Money withdawed " << amount << ". New Balance:" << balance << endl;
    }

    void deposit(int amount)
    {

        balance += amount;
        cout << "Money depositeded " << amount << ". New Balance:" << balance << endl;
    }
};

int main()
{
    
    bank h;
    h.deposit(100000);
    h.withdrawal(50000);

   
    return 0;
}
