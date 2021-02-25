// BrunoKoppel_BitwiseOperations.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <time.h>
#include "Questions.h"

#define MASKINGBIT01                0x01   // => 00000001
#define MASKINGBIT02                0x02   // => 00000010
#define MASKINGBIT03                0x04   // => 00000100
#define MASKINGBIT04                0x08   // => 00001000
#define MASKINGBIT05                0x10   // => 00010000
#define MASKINGBIT06                0x20   // => 00100000
#define MASKINGBIT07                0x40   // => 01000000
#define MASKINGBIT08                0x80   // => 10000000

#define RIGHTANSWERS                0xBD   // => 10111101

#define VERBOSE0                    false
#define VERBOSE1                    false
#define VERBOSE2                    false
#define VERBOSE3                    false

void printBinary(int binary, std::string extraInfo);
bool askUserQuestion(Questions question); 
int getBitFromNumber(int variable, int index);
int changeBit(int variable, int index, bool isItOne);

int main()
{
    bool gameRunning = false;
    Questions game[8];

    game[0] = Questions("Did the chicken cross the road?", 0, true);
    game[1] = Questions("Is the sky blue?", 1, false);
    game[2] = Questions("Are you alive?", 2, true);
    game[3] = Questions("Is 3 x (4 ^ 2) = 48?", 3, true);
    game[4] = Questions("Can a human run at 28mph?", 4, true);
    game[5] = Questions("Do you have electricity in your computer?", 5, true);
    game[6] = Questions("Are able to look within your skull, without any scanner?", 6, false);
    game[7] = Questions("If you cut a lizard's tail, does the lizard still live?", 7, true);

    if (VERBOSE0) {
        printBinary(MASKINGBIT01, "");
        printBinary(MASKINGBIT02, "");
        printBinary(MASKINGBIT03, "");
        printBinary(MASKINGBIT04, "");
        printBinary(MASKINGBIT05, "");
        printBinary(MASKINGBIT06, "");
        printBinary(MASKINGBIT07, "");
        printBinary(MASKINGBIT08, "");
    }

    int whichQuestionsHaveBeenAsked = 0;
    int responses = 0;
    int score = 0;
    int numberOfQuestionsAsked = 0;

    unsigned long seed;
    srand((unsigned)time(NULL));
    
    while (numberOfQuestionsAsked < 8) {
        int index = rand() % 8;
        if (VERBOSE1){ std::cout << "Index => " << index << std::endl; }

        if (getBitFromNumber(whichQuestionsHaveBeenAsked, index) == 0) {
            responses = changeBit(responses, index, askUserQuestion(game[index]));
            whichQuestionsHaveBeenAsked = changeBit(whichQuestionsHaveBeenAsked, index, true);

            if (VERBOSE1) {
                printBinary(RIGHTANSWERS, " <= Correct Answers");
                printBinary(responses, " <= User Answers");
                printBinary(whichQuestionsHaveBeenAsked, " <= Questions asked");
            }

            numberOfQuestionsAsked++;
        }
    }

    for (int index = 0; index < 8; index++) {
        if (getBitFromNumber(RIGHTANSWERS, index) != getBitFromNumber(responses, index)) {
            
            if (VERBOSE3) {
                std::cout << "Score Changed from " << score;
            }

            if (score == 0) {
                score = 10;
            }
            else {
                score = score << 1;
            }

            if (VERBOSE3) {
                std::cout << " to " << score << std::endl;
            }
        }
    }

    std::cout << "\nYou've got an score of: " << score << std::endl;

    if (VERBOSE2) {
        printBinary(RIGHTANSWERS, " <= Correct Answers");
        printBinary(responses, " <= User Answers");
        printBinary(whichQuestionsHaveBeenAsked, " <= Questions asked");
    }

    return 1;
}

void printBinary(int binary, std::string extraInfo) {
    for (int i = 7; i > -1; i--) {
        std::cout << ((binary >> i) & 1);
    }
    
    std::cout << extraInfo << std::endl;
};

int getBitFromNumber(int variable, int index) {
    return (variable >> index) & 1;
}

int changeBit(int variable, int index, bool isItOne) {
    if (isItOne) {
        switch (index) {
        case 0:
            variable = variable ^ MASKINGBIT01;
            break;
        case 1:
            variable = variable ^ MASKINGBIT02;
            break;
        case 2:
            variable = variable ^ MASKINGBIT03;
            break;
        case 3:
            variable = variable ^ MASKINGBIT04;
            break;
        case 4:
            variable = variable ^ MASKINGBIT05;
            break;
        case 5:
            variable = variable ^ MASKINGBIT06;
            break;
        case 6:
            variable = variable ^ MASKINGBIT07;
            break;
        case 7:
            variable = variable ^ MASKINGBIT08;
            break;
        default:
            break;
        }
    }
    else {
    }

    return variable;
}

bool askUserQuestion(Questions question) {
    char userInput;
    std::cout << "\n" << question.prompt << " (t/f): ";
    std::cin >> userInput;
    if (userInput == 't' || userInput == 'T') {
        return true;
    }
    else {
        return false;
    }

}