#include <iostream>
#include <fstream>
#include <string>
#include <iomanip>

using namespace std;

/*
 * In the project outline I noticed that I forgot to implement the CI and CO commands to close the files.
 * My code instead opens the files reads it completely and closes the file all in the same function.
 * Due to this, my code behaves differently in the sense that it stores the files input into arrays and outputs from the arrays into files.
 * At the end of each processing command the arrays get empty to prepare for the next processing.
 * I realize that if I had used CI and CO I could have skipped using arrays to store the files data, resulting in less variables being used.
 * I hope this version is acceptable, I figure it's not a big issue to worry about because it's still getting the job done.
 * However I could implement the CI and CO commands if You wanted me to.
 * (I could do it on my free time just to learn to depend on files as opposed to variables)
 */

 // Translates the txt into csv.
void processorTXTtoCSV(string unprocessedTextLines[], string processedTextLines[], int numberOfLines);

// Translates the csv into txt
void processorCSVtoTXT(string unprocessedTextLines[], string processedTextLines[], int numberOfLines);

//Gets the file name from the user.
string getFileNameFromUser(string prompt);

//Reads the file and stores its lines into an array defined in the main.
int readFile(fstream& myFile, string inputFileName, string unprocessedTextLines[]);

//Writes to the file each line as it comes out of the Processor functions.
void writeFile(fstream& myFile, string outputFileName, string processedTextLines[], int numberOfLines, string unprocessedTextLines[]);

//Function that gets called when "p" command is selected
//Analyzes the input file and output file and determines if the format is correct
//Also Analyzes whether we want csv to txt or viceversa and checks the file formats for us
//If everything is correct files are open and read and it calls one of the two processor functions to do the processing
//it writes to the files when it has finished processing.
void processCommand(fstream& myFile, bool processingMode, string inputFileName, string outputFileName, string unprocessedTextLines[], string processedTextLines[], int numberOfLines);

//prints a help menu
void printHelpMenu();

//clears the input buffer to prevent errors when input commands
void clear_cin();

int main()
{
    // state is our bool variable that closes our program if the user selects "q" (quit program)
    bool state = true;

    // true is txt to csv, false is csv to txt.
    bool processingMode = true;

    int numberOfLines = 0;

    //file names
    string inputFileName, outputFileName;

    //unprocessed text lines is going to be where we store the lines that are going to be translated
    string unprocessedTextLines[10];

    //processed text lines get saved as the proccessor outputs translations
    string processedTextLines[10];

    fstream myFile;
    char command;

    cout << "\nWelcome to the TXT to CSV converter (press m to change to CSV to TXT)\n" << endl;

    // while loop that takes in the commands.
    while (state)
    {

        cout << "\nEnter a letter command to continue (press h for a list of accepted commands): ";
        cin >> command;
        clear_cin();

        // i command only takes in the name for an input file
        if (command == 'i')
        {
            inputFileName = getFileNameFromUser("WHICH FILE ARE WE INPUTING FROM?: ");
        }

        // o command only takes in the name for an output file
        else if (command == 'o')
        {
            outputFileName = getFileNameFromUser("WHICH FILE ARE WE OUTPUTTING TO?: ");
        }

        // p command
        else if (command == 'p')
        {
            processCommand(myFile, processingMode, inputFileName, outputFileName, unprocessedTextLines, processedTextLines, numberOfLines);
        }

        // m command changes the processingMode bool to     'TRUE' for txt to csv     OR     'FALSE'     for csv to txt
        else if (command == 'm')
        {
            if (processingMode)
            {
                processingMode = false;
                cout << "NOW YOU ARE PROCCESSING CSV FILES INTO TXT" << endl;
            }
            else
            {
                processingMode = true;
                cout << "NOW YOU ARE PROCCESSING TXT FILES INTO CSV" << endl;
            }
        }

        // h command to print help menu
        else if (command == 'h')
        {
            printHelpMenu();
        }

        // q command to exit the program
        else if (command == 'q')
        {
            cout << "EXITING PROGRAM..." << endl;
            state = false;
        }

        // else statement to inform the user of a unaccepted command
        else
        {
            cout << "WRONG COMMAND. try again..." << endl;
        }
    }
    system("pause");
    return 0;
}

void processorTXTtoCSV(string unprocessedTextLines[], string processedTextLines[], int numberOfLines)
{
    // pipe delimeter to find in the txt file.
    char delimeter = '|';

    //with the number of total lines we proccess line by line
    for (int i = 0; i < numberOfLines; i++)
    {

        // inputBuffer will be where we hold the lines taken from the file (check processCommand function for how the file is open)
        string inputBuffer = unprocessedTextLines[i];

        //bool used to determine the end of the processing
        bool isAnalysisDone = false;

        // if the isAnalysisDone turns true it means we have finished processing the file
        while (!isAnalysisDone)
        {
            // function to find the index where the pipe delimeters is.
            int delimeterPos = inputBuffer.find(delimeter);

            // function that takes the string that starts at the begining of input buffer till the index of the delimeter and saves it to
            // detached string
            string detachedString = inputBuffer.substr(0, delimeterPos);

            // inputBuffer is then updated with the string remaning from the delimeter till the end of the string
            inputBuffer = inputBuffer.substr(delimeterPos + 1);

            // CCvalue stands for the ammount of commas found in the detached string
            int CCvalue = detachedString.find(',');

            // QCvalue stands for the ammount of quotes found in the detached string
            int QCvalue = detachedString.find('"');

            // these two bools turn to true if commas or quotes where found in the detached string
            bool commaCondition = false;
            bool quotesCondition = false;

            // if the commas were found in any index
            // if no commas are found the value goes up to a very large integer
            if (CCvalue < 40 and CCvalue > -1)
            {
                commaCondition = true;
            }

            // if quotes were found
            if (QCvalue < 40 and QCvalue > -1)
            {
                quotesCondition = true;
            }

            //If the substring has commas but has no quotes
            if (!quotesCondition && commaCondition)
            {
                // we just save to the processed array the string enclosed in quotes
                processedTextLines[i] += '"' + detachedString + '"' + ',';
            }

            // else if the detached string has no commas but has quotes
            else if (quotesCondition && !commaCondition)
            {
                // for quotes we separate the string into 3 parts
                // I used an string array of 3 indexes
                string fragOfDetachedString[3];

                // here i take the first part before the first quote
                // if the quote is in the beginning, this string will be empty which is just what we need.
                fragOfDetachedString[0] = detachedString.substr(0, detachedString.find('"'));

                // temp string to save the rest of the string after the quote, we do not save the quote that comes along, we take a step after the index at which we found the quote
                string temp = detachedString.substr(detachedString.find('"') + 1);

                // now we take from first quote to second quote, whatever is in the middle of both quotes
                fragOfDetachedString[1] = temp.substr(0, temp.find('"'));

                // last string stores the rest, whatever was after the second quote
                fragOfDetachedString[2] = temp.substr(temp.find('"') + 1);

                // lastly we put it all together with the new quotes and save it to the processed array
                processedTextLines[i] += '"' + fragOfDetachedString[0] + '"' + '"' + fragOfDetachedString[1] + '"' + '"' + fragOfDetachedString[2] + '"' + ',';

            }

            // else if the detached string has no commas or quotes
            else if (!quotesCondition && !commaCondition)
            {
                // we save the string as it is to the processed array
                processedTextLines[i] += detachedString + ',';
            }

            // this if will make the while close if we don't find the delimeter
            if (delimeterPos < 0)
            {
                
                isAnalysisDone = true;
            }
        }
    }
}

void processorCSVtoTXT(string unprocessedTextLines[], string processedTextLines[], int numberOfLines)
{
    // delimeter which we will be using to separete the strings

    char delimeter = ',';

    // for loop to run through each line
    for (int i = 0; i < numberOfLines; i++)
    {
        // this bool will help us determine whether we have analyze the entire array or not
        bool endOfBar = false;

        // just like the the other processor function we use a inputBuffer to store the line we are analyzing
        string inputBuffer = unprocessedTextLines[i];

        // this variable will help us initialize the index position at which we find the first delimeter.
        int delimeterPos;

        // we detach the first part which is from the beginning till the index of the delimeter
        string detachedString;

        // while loop
        while (!endOfBar)
        {
            //  everytime the while comes back around it finds the next index of delimeter and takes a string from it to analyze
            delimeterPos = inputBuffer.find(delimeter);
            detachedString = inputBuffer.substr(0, delimeterPos);

            // since the issue in csv to txt is counting whether we encounter 2 or 6 quotes we made a variable that counts the quotes
            //and an array to store the indexes of the quotes
            int quotesCounter = 0;
            int quotePOS[6];

            // for loop will find and count the quotes and save their index position by analyzing each character of the detached string we are using
            for (int j = 0; j < detachedString.length(); j++)
            {

                // if the character is a quote, save the index position into the array quotePOS
                if (detachedString[j] == '"')
                {
                    quotePOS[quotesCounter] = j;
                    quotesCounter++;
                }

            }

            // Notice that while looking for the comma delimeter some strings have quotes around a comma, which means that we find one quote between each comma delimeter.
            // for this reason we set the condition for the first if to 1 quote (THIS ONLY RUNS when it finds a quote between commas)
            if (quotesCounter == 1)
            {
                // for example in  ""  feet per mile,"5,280","quotes in ""middle"" of field",0.00,0.00,"1,000.00",  "" "5,280" is preceeded and followed by commas
                //                                  ^  ^    ^
                // first we detached the string by taking a substring 1 positions after where we find the delimeter index
                // which will take the 5 and not the quote since the find function and the substring will leave out the first comma
                detachedString = detachedString.substr(1);

                // we save the 5 into the processed array
                processedTextLines[i] += detachedString + ',';

                // next we update the inputbufer with was is after the
                inputBuffer = inputBuffer.substr(delimeterPos + 1);

                // it finds the index of the next delimeter
                delimeterPos = inputBuffer.find(delimeter);
                
                // detaches the string from the inputbuffer just before the comma
                detachedString = inputBuffer.substr(0, delimeterPos - 1);

                // adds the detached string with a pipe delimeter to the processed array
                processedTextLines[i] += detachedString + '|';

                // the inputbuffer gets updated with the string remaining after the comma
                inputBuffer = inputBuffer.substr(delimeterPos + 1);
            }
            
            // When there is 6 quotes between commas this else if will run
            else if (quotesCounter == 6)
            {
                // this will erase the quotes from the string, at each index in which they were found
                detachedString.erase(quotePOS[5], 1);
                detachedString.erase(quotePOS[4], 1);
                detachedString.erase(quotePOS[1], 1);
                detachedString.erase(quotePOS[0], 1);

                // adds the string to the processed array with the pipe delimeter
                processedTextLines[i] += detachedString + '|';

                // finds the next index position of the delimeter
                delimeterPos = inputBuffer.find(delimeter);

                // updates the inputbuffer with the substring remaining after the comma
                inputBuffer = inputBuffer.substr(delimeterPos + 1);
            }

            // when no quotes are found it will just take the string and add a pipe delimeter to the end
            else
            {
                processedTextLines[i] += detachedString + '|';

                // notice how the inputbuffer updates with whatever is left after the delimeter before the while runs again
                // this happens on every instance of the if, else if and else
                inputBuffer = inputBuffer.substr(delimeterPos + 1);
            }

            // lastly if the inputbuffer is empty
            if (inputBuffer.length() == 0)
            {
                // this will get rid of the comma attached at the end of the string
                processedTextLines[i] = processedTextLines[i].substr(0, processedTextLines[i].length() - 1);

                // and change the bool to exit the while loop
                endOfBar = true;
            }
        }
    }
}

// function that takes a string and returns it to a variable in main
string getFileNameFromUser(string prompt)
{
    string name;
    cout << prompt;
    getline(cin, name);
    return name;
}

// function to read from file
int readFile(fstream & myFile, string inputFileName, string unprocessedTextLines[])
{
    // file opened
    myFile.open(inputFileName, ios::in);

    // index counter for lines
    int i = 0;

    // while loop to ask for the correct name and doesn't stop until the right name is used
    while (myFile.fail())
    {
        cout << "File inputting failure! FILE HAS NOT BEEN FOUND!";
        inputFileName = getFileNameFromUser("\nWrite the input filename again: ");
        myFile.open(inputFileName, ios::in);
    }

    // Input file gets read
    cout << "INPUT FILE CONTENTS:\n" << endl;

    // while loop that gets a line and saves it in unprocessedtextlines array
    while (getline(myFile, unprocessedTextLines[i]))
    {

        // out puts the line just taken from the file
        cout << unprocessedTextLines[i] << endl;

        // line counter goes up
        i++;
    }

    cout << "\n" << endl;
    // file closes
    myFile.close();

    // return i which is the line counter
    return i;
}

void writeFile(fstream & myFile, string outputFileName, string processedTextLines[], int numberOfLines, string unprocessedTextLines[])
{
    // file opens for output
    myFile.open(outputFileName, ios::out);

    // then goes on to output the file contents
    cout << "OUTPUT FILE CONTENTS:\n" << endl;
    for (int i = 0; i < numberOfLines; i++)
    {
        // outputs the line
        myFile << processedTextLines[i] << endl;

        // prints the line to console
        cout << processedTextLines[i] << endl;

        // clears up both unprocessed and processed arrays
        unprocessedTextLines[i] = "";
        processedTextLines[i] = "";
    }

    // once finished it notifies in the console that the contents have been outputed to the filename given.
    cout << "\n\nContents have been saved to --> " << outputFileName << endl;

    //file closes for output
    myFile.close();
}

void processCommand(fstream & myFile, bool processingMode, string inputFileName, string outputFileName, string unprocessedTextLines[], string processedTextLines[], int numberOfLines)
{

    // the if fist check the processing mode to know which mode we are working on
    if (processingMode)
    {

        // I initialize these two to check the extension of the files in the processing line
        size_t inputPos = inputFileName.find(".txt");
        size_t outputPos = outputFileName.find(".csv");

        // this if iterates true if the index in the names where found
        if (inputPos < 50 && outputPos < 50)
        {

            string inputFileExtension = inputFileName.substr(inputPos, 4);
            string outputFileExtension = outputFileName.substr(outputPos, 4);

            // If the extension matches what we are working with then the proccessing begins
            if (inputFileExtension == ".txt" && outputFileExtension == ".csv")
            {

                // the readFile function runs, saving the file contents into the array and returns the number of lines
                numberOfLines = readFile(myFile, inputFileName, unprocessedTextLines);

                // this will print that the processing is beginning
                cout << "PROCESSING " << inputFileName << " INTO " << outputFileName << endl;

                // next the translation occurs taking unproccessed lines and processing them
                processorTXTtoCSV(unprocessedTextLines, processedTextLines, numberOfLines);

                // finally the files are populated from the processed arrays
                writeFile(myFile, outputFileName, processedTextLines, numberOfLines, unprocessedTextLines);
            }

            // if the extension is not found this error messege will print.
            else
            {
                cout << "Check the extension on your input and output file names" << endl;
            }

        }

        // if the index of the extension is not found then it will out put the error message.
        else
        {
            cout << "Check the extension on your input and output file names" << endl;
        }


    }
    else
    {
        // here, the same logic used in the if above applies, but for csv to txt translation instead
        size_t inputPos = inputFileName.find(".csv");
        size_t outputPos = outputFileName.find(".txt");

        if (inputPos < 50 && outputPos < 50)
        {
            string inputFileExtension = inputFileName.substr(inputPos, 4);
            string outputFileExtension = outputFileName.substr(outputPos, 4);

            if (inputFileExtension == ".csv" && outputFileExtension == ".txt")
            {

                // unprocessed lines saves the lines from txt or csv, it's just a place to hold the input file strings
                numberOfLines = readFile(myFile, inputFileName, unprocessedTextLines);

                cout << "PROCESSING " << inputFileName << " INTO " << outputFileName << endl;

                // the difference is that instead of running txt to csv we run csv to txt.
                processorCSVtoTXT(unprocessedTextLines, processedTextLines, numberOfLines);

                // processed lines saves the lines that the processor function generates, before the writeFile.
                writeFile(myFile, outputFileName, processedTextLines, numberOfLines, unprocessedTextLines);
            }
            else
            {
                cout << "Check the extension on your input and output file names" << endl;
            }
        }
        else
        {
            cout << "Check the extension on your input and output file names" << endl;
        }
    }
}

// function to print the help menu
void printHelpMenu()
{
    cout << "HELP MENU:" << endl;
    cout << "i: Designate the name of the file from which we are taking information. " << endl;
    cout << "o: Designate the name of the file to which we are saving the processed information. " << endl;
    cout << "p: Run the Text Processor (make sure you have assigned an input and output location on the i and o commands). " << endl;
    cout << "m: changes the processing direction from txt to csv or vice versa" << endl;
    cout << "h: Prints this help menu. " << endl;
    cout << "q: Exits this Program." << endl;

}

void clear_cin()
{
    cin.clear();
    cin.ignore(numeric_limits<streamsize>::max(), '\n');
}

