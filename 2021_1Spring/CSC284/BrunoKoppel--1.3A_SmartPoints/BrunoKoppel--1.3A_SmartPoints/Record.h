#pragma once
#include<string>
#include<sstream>

struct Record {
	int recordID;
	std::string firstName;
	std::string lastName;
	int startYear;


	Record() {
		this->recordID = 0;
		this->firstName = "";
		this->lastName = "";
		this->startYear = 0;
	}

	Record(int id, std::string fn, std::string ln, int sy) {
		this->recordID = id;
		this->firstName = fn;
		this->lastName = ln;
		this->startYear = sy;
	}

	std::string returnInformation() {
		std::stringstream ss;
		ss << "Record ID = " << this->recordID << std::endl;
		ss << "First Name = " << this->firstName << std::endl;
		ss << "Last Name = " << this->lastName << std::endl;
		ss << "Staring Year = " << this->startYear << std::endl;
		return ss.str();
	}
};