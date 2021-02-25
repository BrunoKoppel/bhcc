#include<iostream>
#include<iomanip>
#include<string>

using namespace std;

void braking(int& currentState, int& previousSpeed, int& currentSpeed, int& lapsedTime, int deltaSpeed, int timeInterval, float& totalDistance, float& intervalDistance);
void accelerating(int& currentState, int& previousSpeed, int& currentSpeed, int& lapsedTime, int deltaSpeed, int timeInterval, float& totalDistance, float& intervalDistance);
void cruising(int currentState,int& previousSpeed, int& currentSpeed, int& lapsedTime,int deltaSpeed, int timeInterval, float& totalDistance, float& intervalDistance);
int updateDeltaSpeedWithUserInput(int DeltaSpeed);
int updateTimeIntervalWithUserInput(int timeInterval);
void demo(int& currentState, int& previousSpeed,int& currentSpeed,int& lapsedTime,int deltaSpeed,int timeInterval,float& totalDistance, float& intervalDistance);

int main()
{
	string command;
	float intervalDistance = 0;
	int currentState = 0; // #0 is Stopped, #1 is Accelerating, #2 Cruising, #3 Braking
	int currentSpeed = 0; 
	int previousSpeed = 0; 
	int lapsedTime = 0; // variable for the amount of time that has passed since the car started.
	int timeInterval = 1; // variable that stores the amount of time that passes on each step.
	int deltaSpeed = 5; // variable that stores the rate of change for the speed of the car.
	float totalDistance = 0; 
	int numberOfCommandsRun = 0; 
	bool powerSwitch = true; // bool for the while loop that runs the car
	
	cout << setw(10) << right << "Function";
	cout << setw(20) << right << "Current State";
	cout << setw(30) << right << "Current Speed (MPH)";
	cout << setw(20) << right << "Interval Distance";
	cout << setw(44) << right << "Total Feet(and miles) traveled";
	cout << setw(25) << right << "Time Lapsed (seconds)" << endl;
	
	while (powerSwitch == true)
	{
		
		cout << "Command: ";
		getline(cin, command);
		
		//if instance to re-print header in case screen fills up with too many commands
		if (numberOfCommandsRun > 19)
		{
			cout << setw(10) << right << "Function";
			cout << setw(20) << right << "Current State";
			cout << setw(30) << right << "Current Speed (MPH)";
			cout << setw(20) << right << "Interval Distance";
			cout << setw(44) << right << "Total Feet(and miles) traveled";
			cout << setw(25) << right << "Time Lapsed (seconds)" << endl;
			numberOfCommandsRun = 0;
		}
		
		// IF statement to filter out the given command 
		if (command == "a")
		{
			accelerating(currentState, previousSpeed, currentSpeed, lapsedTime, deltaSpeed, timeInterval, totalDistance, intervalDistance);
			numberOfCommandsRun += 1;
		}
		else if (command == "b")
		{
			braking(currentState, previousSpeed, currentSpeed, lapsedTime, deltaSpeed, timeInterval, totalDistance, intervalDistance);
			numberOfCommandsRun += 1;
		}
		else if (command == "c")
		{
			cruising(currentState, previousSpeed, currentSpeed, lapsedTime, deltaSpeed, timeInterval, totalDistance, intervalDistance);
			numberOfCommandsRun += 1;
		}
		else if (command == "d")
		{
			demo(currentState, previousSpeed, currentSpeed, lapsedTime, deltaSpeed, timeInterval, totalDistance, intervalDistance);
			numberOfCommandsRun += 20;
		}
		else if (command == "h")
		{
			cout << "Supported commands:" << endl;
			cout << "\t\t a \t\t accelerate." << endl;
			cout << "\t\t b \t\t brake." << endl;
			cout << "\t\t c \t\t cruise." << endl;
			cout << "\t\t d \t\t demo." << endl;
			cout << "\t\t r \t\t changes the delta value for the speed of the car." << endl;
			cout << "\t\t t \t\t changes the interval of seconds in between steps." << endl;
			cout << "\t\t h \t\t print this help text." << endl;
			cout << "\t\t q \t\t quit(end the program)." << endl;
		}
		else if (command == "q")
		{
			powerSwitch = false;
		}
		else if (command == "r")
		{
			deltaSpeed = updateDeltaSpeedWithUserInput(deltaSpeed);
			numberOfCommandsRun += 2;
		}
		else if (command == "t")
		{
			timeInterval = updateTimeIntervalWithUserInput(timeInterval);
			numberOfCommandsRun += 2;
		}
		else 
		{
			cout << "You have entered an invalid command try again!"<< endl;
			numberOfCommandsRun += 1;
		}
		
	}
	
}

// Demo function
void demo(int& currentState, int& previousSpeed,int& currentSpeed,int& lapsedTime,int deltaSpeed,int timeInterval,float& totalDistance, float& intervalDistance)
{
	cruising(currentState, previousSpeed, currentSpeed, lapsedTime, deltaSpeed, timeInterval, totalDistance, intervalDistance);
	cruising(currentState, previousSpeed, currentSpeed, lapsedTime, deltaSpeed, timeInterval, totalDistance, intervalDistance);
	cruising(currentState, previousSpeed, currentSpeed, lapsedTime, deltaSpeed, timeInterval, totalDistance, intervalDistance);
	accelerating(currentState, previousSpeed, currentSpeed, lapsedTime, deltaSpeed, timeInterval, totalDistance, intervalDistance);
	accelerating(currentState, previousSpeed, currentSpeed, lapsedTime, deltaSpeed, timeInterval, totalDistance, intervalDistance);
	accelerating(currentState, previousSpeed, currentSpeed, lapsedTime, deltaSpeed, timeInterval, totalDistance, intervalDistance);
	accelerating(currentState, previousSpeed, currentSpeed, lapsedTime, deltaSpeed, timeInterval, totalDistance, intervalDistance);
	accelerating(currentState, previousSpeed, currentSpeed, lapsedTime, deltaSpeed, timeInterval, totalDistance, intervalDistance);
	cruising(currentState, previousSpeed, currentSpeed, lapsedTime, deltaSpeed, timeInterval, totalDistance, intervalDistance);
	cruising(currentState, previousSpeed, currentSpeed, lapsedTime, deltaSpeed, timeInterval, totalDistance, intervalDistance);
	cruising(currentState, previousSpeed, currentSpeed, lapsedTime, deltaSpeed, timeInterval, totalDistance, intervalDistance);
	cruising(currentState, previousSpeed, currentSpeed, lapsedTime, deltaSpeed, timeInterval, totalDistance, intervalDistance);
	cruising(currentState, previousSpeed, currentSpeed, lapsedTime, deltaSpeed, timeInterval, totalDistance, intervalDistance);
	braking(currentState, previousSpeed, currentSpeed, lapsedTime, deltaSpeed, timeInterval, totalDistance, intervalDistance);
	braking(currentState, previousSpeed, currentSpeed, lapsedTime, deltaSpeed, timeInterval, totalDistance, intervalDistance);
	braking(currentState, previousSpeed, currentSpeed, lapsedTime, deltaSpeed, timeInterval, totalDistance, intervalDistance);
	braking(currentState, previousSpeed, currentSpeed, lapsedTime, deltaSpeed, timeInterval, totalDistance, intervalDistance);
	braking(currentState, previousSpeed, currentSpeed, lapsedTime, deltaSpeed, timeInterval, totalDistance, intervalDistance);
	braking(currentState, previousSpeed, currentSpeed, lapsedTime, deltaSpeed, timeInterval, totalDistance, intervalDistance);
	braking(currentState, previousSpeed, currentSpeed, lapsedTime, deltaSpeed, timeInterval, totalDistance, intervalDistance);
	braking(currentState, previousSpeed, currentSpeed, lapsedTime, deltaSpeed, timeInterval, totalDistance, intervalDistance);
}

// Function for the Braking Machine State
void braking(int& currentState, int& previousSpeed,int& currentSpeed,int& lapsedTime,int deltaSpeed,int timeInterval,float& totalDistance, float& intervalDistance)
{
	// Braking Machine State is signaled as # 3.
	currentState = 3;
	
	// Lapsed Time is calculated in each function by adding to it the time interval variable.
	lapsedTime += timeInterval;
	
	// The Current Speed variable is saved to the Previous Speed before changing the Current Speed variable.
	previousSpeed = currentSpeed;
	
	// The if instance to avoid the speed going below zero when the car is braking.
	if (currentSpeed > deltaSpeed)
	{
		// If the Delta Speed (Change of speed variable) is smaller than the Current Speed then proceed with the braking.
		currentSpeed -= deltaSpeed;
	}
	else
	{
		// IF INSTEAD the Delta Speed is bigger than the Current Speed is procceeds 
		currentSpeed = 0;
		
		// Stopped Machine State is signaled as # 0.
		currentState = 0;
	}
	
	// FORMULA FOR CALCULATING THE INTERVAL DISTANCE WHEN BRAKING 
	intervalDistance = ((( currentSpeed * (5280.0/3600) ) * timeInterval) + (((previousSpeed - currentSpeed)*(5280.0/3600))/2));
	
	// The total distance in all functions gets calculated by using its own internal function
	totalDistance += intervalDistance;
	
	// PRINTER FOR BRAKING RESULTS
	cout << setw(10) << right << "Brake";
	switch (currentState)
	{
		case 3: cout << setw(20) << right << "Braking";
			break;
		case 0: cout << setw(20) << right << "Stopped";
			break;
	}
	cout << setw(30) << right << currentSpeed;
	cout << setw(20) << right << fixed << setprecision(3)  << intervalDistance;
	cout << setw(30) << right << fixed << setprecision(3)  << totalDistance;
	cout << "(" << setw(8) << right << fixed << setprecision(10) << (totalDistance / 5280.0) << ")";
	cout << setw(20) << right << lapsedTime << endl;
}

// Function for the Accelerating Machine State
void accelerating(int& currentState, int& previousSpeed,int& currentSpeed,int& lapsedTime,int deltaSpeed,int timeInterval,float& totalDistance, float& intervalDistance)
{
	// Accelerating Machine State is signaled as # 1.
	currentState = 1;
	previousSpeed = currentSpeed;
	currentSpeed += deltaSpeed;
	lapsedTime += timeInterval;
	
	// FORMULA FOR THE INTERVAL DISTANCE WHEN ACCELERATING
	intervalDistance = ((( previousSpeed * (5280.0/3600) ) * timeInterval) + (((currentSpeed - previousSpeed)*(5280.0/3600))/2));
	totalDistance += intervalDistance;
	
	// PRINTER FOR THE ACCELERATING RESULTS
	cout << setw(10) << right << "Accelerate";
	cout << setw(20) << right << "Accelerating";
	cout << setw(30) << right << currentSpeed;
	cout << setw(20) << right << fixed << setprecision(3)  << intervalDistance;
	cout << setw(30) << right << fixed << setprecision(3)  << totalDistance;
	cout << "(" << setw(8) << right << fixed << setprecision(10) << (totalDistance / 5280.0) << ")";
	cout << setw(20) << right << lapsedTime << endl;
	
}
	
// Function for the Cruising Machine State
void cruising(int currentState,int& previousSpeed, int& currentSpeed, int& lapsedTime,int deltaSpeed,int timeInterval,float& totalDistance, float& intervalDistance)
{
	// Cruising Machine State is signaled as # 2.
	currentState = 2;
	lapsedTime += timeInterval;
	
	// FORMULA
	intervalDistance = (( currentSpeed * (5280.0/3600) ) * timeInterval);
	totalDistance += intervalDistance;
	
	// PRINTER FOR THE CRUISING RESULTS
	cout << setw(10) << right << "Cruise";
	cout << setw(20) << right << "Cruising";
	cout << setw(30) << right << currentSpeed;
	cout << setw(20) << right << fixed << setprecision(3) << intervalDistance;
	cout << setw(30) << right << fixed << setprecision(3) << totalDistance;
	cout << "(" << setw(8) << right << fixed << setprecision(10) << (totalDistance / 5280.0) << ")";
	cout << setw(20) << right << lapsedTime << endl;
	
}

// Function to change the speed at what the car accelerates and brakes
int updateDeltaSpeedWithUserInput(int DeltaSpeed)
{
	// initiate new delta speed variable to return to the variable in Main
	int newDeltaSpeed = 0;
	cout << "What's the new value for rate of acceleration and braking? (Current value is set to: " << DeltaSpeed << " miles per hour ) " << endl;
	cout << "Enter New Value : ";
	cin >> newDeltaSpeed;
	cin.ignore(100, '\n');
	return newDeltaSpeed;
}

// Function to change the time interval that passes each time a command is run
int updateTimeIntervalWithUserInput(int timeInterval)
{
	// initiate new Time Interval variable to return to the variable in Main
	int newTimeInterval = 0;
	cout << "What's the new value for time intervals between commands going to be? (Current value is set to: " << timeInterval << " seconds ) " << endl;
	cout << "Enter New Value : ";
	cin >> newTimeInterval;
	cin.ignore(100, '\n');
	return newTimeInterval;
}
