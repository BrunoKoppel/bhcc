//==============================================================================
// Verbose Recusion Demo
// 
//
//
//==============================================================================

#include <cstdlib>
#include <string>
#include <iostream>
#include <iomanip>

using namespace std;

//  Global Constants and variables:
const int SUCCESS = 0; // return code for SUCCESS
const int FAILURE = 1; // return code for FAILURE
int displayWidth = 12;   // output display width

// Function Prototypes:
long factorial(long);
short sFactorial(short);
long long lFactorial(long long);

void checkSizes();


void outputHelpMessage();
void quitProgram(int exitStatus);
void setVerboseMode(bool param);
bool getVerboseMode();

static bool verboseMode; // Global variable 

int main() {
    // Local variables for 'main' function:	
    string command; //	command string, input by user
    string text; // text data, input by user
	
    long x; // number input by user
    long result;
    short shortX; // number input by user
    short shortResult;
	long long longLongX;
	long long longLongResult;

    setVerboseMode(false);

    while (true) {

        // Prompt for command input.
        cout << "\nCommand: ";
        getline(cin, command);

        if (command == "") {
            // ignore empty command
        } else if (command == "f" || command == "F"
                || command == "factorial") {

            // Prompt the user for input.
            cout << "Enter x: ";
            cin >> x;
            cin.ignore(80, '\n');
            if (getVerboseMode() == true) {
                cout << "main (line " << __LINE__ << "): calling factorial, "
                        << "x = " << x  << endl; 
            }
            result = factorial(x);
            cout << " factorial(" << right << setw(displayWidth) << x << ") = " << setw(displayWidth) << result
				<< " (" << hex << setw(displayWidth) << result << dec << " hex)"
				<< endl;

        } else if (command == "sf" || command == "SF"
                || command == "sfactorial") {

            // Prompt the user for input.
            cout << "Enter shortX: ";
            cin >> shortX;
            cin.ignore(80, '\n');
            if (getVerboseMode() == true) {
                cout << "main (line " << __LINE__ << "): calling sFactorial, "
                        << "shortX = " << shortX << endl;
            }
            shortResult = sFactorial(shortX);
            cout << "sFactorial(" << right << setw(15) << setw(displayWidth) << shortX << ") = " << setw(displayWidth) << shortResult
				<<" (" << hex << setw(displayWidth) << shortResult<< dec << " hex)"<< endl;

		}
		else if (command == "lf" || command == "LF"
			|| command == "lfactorial") {

			// Prompt the user for input.
			cout << "Enter longLongX: ";
			cin >> longLongX;
			cin.ignore(80, '\n');
			if (getVerboseMode() == true) {
				cout << "main (line " << __LINE__ << "): calling sFactorial, "
					<< "longLongX = " << longLongX << endl;
			}
			longLongResult = lFactorial(longLongX);
			cout << "lFactorial(" << right << setw(displayWidth) << longLongX << ") = " << setw(displayWidth) << longLongResult
				<< " (" << hex << setw(displayWidth) << longLongResult << dec << " hex)" << endl;

        } else if (command == "h" || command == "help") {
            // Output help text
            outputHelpMessage();

        } else if (command == "q" || command == "quit") {
            // Quit program
            quitProgram(SUCCESS);
        } else if (command == "s" || command == "size") {
            // Check variable sizes
            checkSizes();

        } else if (command == "v" || command == "verbose") {
            if (getVerboseMode() == true) {
                cout << "Clearing verboseMode." << endl;
                setVerboseMode(false);
            } else {
                cout << "Setting verboseMode." << endl;
                setVerboseMode(true);
            }
		}
		else if (command == "w" || command == "width") {
			// Set displayWidth
			cout << "Enter dislayWidth: ";
			cin >> displayWidth;
			cin.ignore(80, '\n');

        } else
            cout << "Invalid command:  " << command << endl;

    } // (end 'while')

    return 0;
} // (end function 'main')

/*=============================================================================
 *  Function:	outputHelpMessage - Output short description of commands.						
 *  Inputs:     none
 *  Outputs:
 *      Outputs help text to the cout stream
 *  Desciption:
 *	Output (to the screen) a short description of each interactive command
 *      supported by the program.
 *
 *---------------------------------------------------------------------------*/
void outputHelpMessage() {
    // Help text.
    cout << "Supported commands: \n"
            << "	f or F  Factorial.\n"
            << "	sf      Factorial with short int variables.\n"
	   		<< "	lf      Factorial with long long int variables.\n"
            << "	h       print this help text.\n"
            << "	q       quit (end the program).\n"
            << "	s       check variable sizes.\n"
            << "	v       Set or Clear VERBOSE mode\n"
		    << "	w       Set displayWidth (width of output result).\n"
            << endl;

} // (end function 'outputHelpMessage')

/*=============================================================================
 *  Function:	quitProgram  -	 Exit the program, returning status from caller					
 *  Inputs:
 *      exitStatus =         Exit code to be returned to operating system.
 *  Outputs:
 *      exits the program, passing status value from caller
 *  Desciption:
 *		Exit the program
 *
 *---------------------------------------------------------------------------*/
void quitProgram(int exitStatus) {
    cout << "Exiting program with status = " << exitStatus << endl;
    exit(exitStatus);
} // (end function 'quitProgram')

/*=============================================================================
 *  Function:	checkSizes  -	 Output the sizes of various data types			
 *  Inputs:   none
 *  Outputs:  Size values to console
 *  Desciption:
 *          Creates local variables of various types, reports sizeof() values
 *
 *---------------------------------------------------------------------------*/
void checkSizes() {

    cout << "sizeof(char)=" << sizeof (char) << endl
            << "sizeof(short)=" << sizeof (short) << endl
            << "sizeof(int)=" << sizeof (int) << endl
            << "sizeof(long)=" << sizeof (long) << endl
            << "sizeof(long long)=" << sizeof (long long) << endl
            << "sizeof(float)=" << sizeof (float) << endl
            << "sizeof(double)=" << sizeof (double) << endl
            << "sizeof(long double)=" << sizeof (long double) << endl;
    cout << "sizeof(unsigned char)=" << sizeof (unsigned char) << endl
            << "sizeof(unsigned short)=" << sizeof (unsigned short) << endl
            << "sizeof(unsigned int)=" << sizeof (unsigned int) << endl
            << "sizeof(unsigned long)=" << sizeof (unsigned long) << endl
            << "sizeof(unsigned long long)=" << sizeof (unsigned long long) << endl;
    return;

} // (end function 'checkSizes')

//___________________________________________________________________________
// Debug-related functions:

void setVerboseMode(bool param) {
    verboseMode = param;
}

bool getVerboseMode() {
    return verboseMode;
}

//=============================================================================
// factorial():  Recursive calculation of factorial function
// 
// PRE:  x = non-negative integer
// POST: returns x!  (x factorial)

long factorial(long n) {
    long result=0;
    long recursive_output=0;
    if (getVerboseMode() == true) {
        cout << " factorial (line " << __LINE__ << "): Enter with n=" << n
			<< " recursive_output=" << setw(displayWidth) << recursive_output
                << endl;
    }
    if (n > 0) {
        recursive_output = factorial(--n);
        result = ++n * recursive_output;
        if (getVerboseMode() == true) {
            cout << " factorial (line " << __LINE__ << "): n=" << setw(3) << n
                    << " result=" << setw(displayWidth) << result
				<< " recursive_output=" << setw(displayWidth) << recursive_output
                    << endl;
        }
        return result;

    } else {
        result = 1;
        if (getVerboseMode() == true) {
            cout << " factorial (line " << __LINE__ << "): BASE CASE, n=" << n
				<< " recursive_output=" << setw(displayWidth) << recursive_output
                    << setw(3) << n << ", result=" << setw(displayWidth) << result
                    << " (address of result=" << &result << ")" << endl;
        }
        return result;
    }
} // end factorial

//=============================================================================
// sFactorial():     Recursive calculation of factorial with short integers
// 
// PRE:  x = non-negative integer
// POST: returns x!  (x factorial with short data type)
short sFactorial(short n) {
    short result;
    short recursive_output;
    if (getVerboseMode() == true) {
        cout << "sFactorial (line " << __LINE__ << "): Enter with n="
                << setw(3) << n << " (address of n=" << &n << ")" << endl;
    }
    if (n > 0) {
        recursive_output = sFactorial(n - 1);
        result = n * recursive_output;
        if (getVerboseMode() == true) {
            cout << "sFactorial (line " << __LINE__ << "): n=" << setw(3) << n
                    << " result=" << setw(displayWidth) << result
                    << " (address of result = " << &result << ")" << endl;
        }
        return result;
    } else {
        result = 1;
        if (getVerboseMode() == true) {
            cout << "sFactorial (line " << __LINE__ << "): BASE CASE, n="
                    << setw(3) << n << ", result=" << setw(displayWidth) << result
                    << " (address of result=" << &result << ")" << endl;
        }
        return result;
    }
} // end sFactorial

  //=============================================================================
  // lFactorial():     Recursive calculation of factorial with long long integers
  // 
  // PRE:  x = non-negative integer
  // POST: returns x!  (x factorial with long long data type)
long long lFactorial(long long n) {
	long long result;
	long long recursive_output;
	if (getVerboseMode() == true) {
		cout << "lFactorial (line " << __LINE__ << "): Enter with n="
			<< setw(3) << n << " (address of n=" << &n << ")" << endl;
	}
	if (n > 0) {
		recursive_output = lFactorial(n - 1);
		result = n * recursive_output;
		if (getVerboseMode() == true) {
			cout << "sFactorial (line " << __LINE__ << "): n=" << setw(3) << n
				<< " result=" << setw(displayWidth) << result
				<< " (address of result = " << &result << ")" << endl;
		}
		return result;
	}
	else {
		result = 1;
		if (getVerboseMode() == true) {
			cout << "lFactorial (line " << __LINE__ << "): BASE CASE, n="
				<< setw(displayWidth) << n << ", result=" << setw(displayWidth) << result
				<< " (address of result=" << &result << ")" << endl;
		}
		return result;
	}
} // end lFactorial
