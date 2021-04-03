#include<iostream>

using namespace std;

//void printer (long int TotalSeconds,long int Seconds,long int Minutes,long int Hours,long int Days,long int Weeks);

int main()
{
	long int TotalSeconds = 0;
	long int Seconds = 0;
	long int Minutes = 0;
	long int Hours = 0;
	long int Days = 0;
	long int Weeks = 0;
	
	cout << "Welcome to the Time Calculator 3000!!" << endl;
	do
	{
		cout << "Enter a number of seconds (or negative number to EXIT): " << endl;
		cin >> TotalSeconds;
		
		if (TotalSeconds > 59)
		{
			Minutes = TotalSeconds / 60;
			Seconds = TotalSeconds % 60;
			
			if (Minutes > 59)
			{
				Hours = Minutes / 60;
				Minutes = Minutes % 60;
				
				if (Hours > 23)
				{
					Days = Hours / 24;
					Hours = Hours % 24;
					
					if (Days > 6)
					{
						Weeks = Days / 7;
						Days = Days % 7;
					}
				}
			}
		}
		else
		{
			Seconds = TotalSeconds;
		}
		
		//printer(TotalSeconds, Seconds, Minutes, Hours, Days, Weeks);
		
		cout << "Total Seconds = " << TotalSeconds << ":"; 
		if (Weeks > 0)
		{
			cout << "   Weeks = " << Weeks ;
		}
		if (Days > 0)
		{
			cout << "   Days = " << Days ;
		}
		if (Hours > 0)
		{
			cout << "   Hours = " << Hours ;
		}
		if (Minutes > 0)
		{
			cout << "   Minutes = " << Minutes ;
		}
		if (Seconds > 0)
		{
			cout << "   Seconds = " << Seconds ;
		}
		cout << endl;
		
		Seconds = 0;
		Minutes = 0;
		Hours = 0;
		Days = 0;
		Weeks = 0;
		
	} while (TotalSeconds >= 0);
	
	
}

//void printer(long int TotalSeconds,long int Seconds,long int Minutes,long int Hours,long int Days,long int Weeks)
//{
	
//}
