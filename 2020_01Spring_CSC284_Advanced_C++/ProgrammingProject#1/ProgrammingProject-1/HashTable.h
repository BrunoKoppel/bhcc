// Here is where we will prototype the functions and constructors
#pragma once
#define HashTable_H

#include <string>


class HashTable
{
	private:
		std::string english;
		std::string german;
		std::string latin;
		std::string hebrew;

	public:
		HashTable();

		//General Functions
		void createNewWord();

		//Mutators
		void setEnglish(std::string);
		void setGerman(std::string);
		void setLatin(std::string);
		void setHebrew(std::string);
		
};

