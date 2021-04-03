#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <iomanip>
#include <string>
#include <fstream>

using namespace std;

struct MovieData
{
	string title;
	string director;
	int yearReleased;
	double runningTime;
};

void clear_cin();
int findLargestRunningTimeAmongMovies(MovieData movies[], int ArraySize);
int userInputArraySize (string prompt);
void userInputMovieData (MovieData movies[], int ArraySize);
void displayMovieDataArray(MovieData movies[], int ArraySize, int longestMovie);

int main()
{
	int ArraySize;
	
	ArraySize = userInputArraySize("Enter the amount of movies for which you are giving their data: ");
	MovieData *movies = new MovieData [ArraySize];
	
	cout << "arrayPtr = " << movies << endl;
	
	userInputMovieData(movies, ArraySize);
	
	int longestMovie = findLargestRunningTimeAmongMovies(movies, ArraySize);

	displayMovieDataArray(movies, ArraySize, longestMovie);

	cout << "\n\nDELETING array at arrayPtr = " << movies << endl;
	delete[] movies;
	return 0;
}

int findLargestRunningTimeAmongMovies(MovieData movies[], int ArraySize)
{
	int position = 0;
	if (ArraySize > 1)
	{
		for(int i = 1; i < ArraySize; i++)
		{
			if (movies[i].runningTime > movies[position].runningTime)
			{
				position = i;
			}
		}
	}
	return position;
}

void displayMovieDataArray(MovieData movies[], int ArraySize, int longestMovie)
{
	cout << endl;
	for(int i = 0; i < ArraySize; i++)
	{
		cout << &movies[i] << ":  arrayPtr[" << i << "]" << endl;
		cout << "\t\t" << setw(12) << "Title" << ": " << movies[i].title << endl;
		cout << "\t\t" << setw(12) << "Director" << ": " << movies[i].director << endl;
		cout << "\t\t" << setw(12) << "Released" << ": " << movies[i].yearReleased << endl;
		cout << "\t\t" << setw(12) << "Running Time" << ": " << movies[i].runningTime << endl;
		cout << endl;
	}
	cout << "\nLongest Movie in list:" << endl;
	cout << "\t\t" << setw(12) << "Title" << ": " << movies[longestMovie].title << endl;
	cout << "\t\t" << setw(12) << "Director" << ": " << movies[longestMovie].director << endl;
	cout << "\t\t" << setw(12) << "Released" << ": " << movies[longestMovie].yearReleased << endl;
	cout << "\t\t" << setw(12) << "Running Time" << ": " << movies[longestMovie].runningTime << endl;
	cout << "\nLongest Movie is:  " << movies[longestMovie].runningTime << " minutes long" << endl;
}

void userInputMovieData (MovieData movies[], int ArraySize)
{
	clear_cin();
	for(int i = 0; i < ArraySize; i++)
	{
		cout << "\nWhat's the Title of the movie #" << i + 1 << ": ";
		getline(cin, movies[i].title);
		cout << "What's the Director of the movie #" << i + 1 << ": ";
		getline(cin, movies[i].director);
		cout << "What's the Year of Release of the movie #" << i + 1 << ": ";
		cin >> movies[i].yearReleased;
		cout << "What's the Running Time of the movie #" << i + 1 << "(Enter just the minutes): ";
		cin >> movies[i].runningTime;
		clear_cin();
	}
}

void clear_cin()
{
    cin.clear();
    cin.ignore(100, '\n');
}

int userInputArraySize (string prompt)
{
	int number;
	cout << prompt; 
	cin >> number;
	return number;
}
