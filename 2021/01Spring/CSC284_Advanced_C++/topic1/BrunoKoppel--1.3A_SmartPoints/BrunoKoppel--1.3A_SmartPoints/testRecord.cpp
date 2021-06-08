#include<iostream>
#include "Record.h"

void printEmployeeRecordbyPointer(Record*, std::ostream&);
void printEmployeeRecordbyReference(std::unique_ptr<Record>&, std::ostream&);
void changeYear(Record* currentPtr, std::ostream& output);
void changeYear(std::unique_ptr<Record>& currentPtr, std::ostream& output);

int main() {
	struct Record* record1 = new Record();
	auto record2 = std::make_unique<Record>();

	record1->recordID = 1001;
	record1->firstName = "Fred";
	record1->lastName = "Flintstone";
	record1->startYear = 1995;

	record2->recordID = 1002;
	record2->firstName = "Barney";
	record2->lastName = "Rubble";
	record2->startYear = 2000;
	
	printEmployeeRecordbyPointer(record1, std::cout);
	printEmployeeRecordbyReference(record2, std::cout);
	changeYear(record1, std::cout);
	changeYear(record2, std::cout);
}

void printEmployeeRecordbyPointer(Record* currentPtr, std::ostream& output) {
	output << currentPtr->returnInformation() << std::endl;
};

void printEmployeeRecordbyReference(std::unique_ptr<Record>& currentPtr, std::ostream& output) {
	output << currentPtr->returnInformation() << std::endl;
};

void changeYear(Record* currentPtr, std::ostream& output) {
	output << "Before changing: " << currentPtr->startYear << std::endl;
	currentPtr->startYear -= 10;
	output << "After changing: " << currentPtr->startYear << std::endl;
	output << std::endl;
}

void changeYear(std::unique_ptr<Record>& currentPtr, std::ostream& output) {
	output << "Before changing: " << currentPtr->startYear << std::endl;
	currentPtr->startYear -= 10;
	output << "After changing: " << currentPtr->startYear << std::endl;
	output << std::endl;
}