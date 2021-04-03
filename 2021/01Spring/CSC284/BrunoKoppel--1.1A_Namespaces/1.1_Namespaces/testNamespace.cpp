#include <iostream>
#include "Namespace.h"

void message(std::string, std::ostream&);
void message(double, std::ostream&);
void dumbFunction(std::string);

int main() {
	dumbFunction("Using #Define ");
	return 0;
}

void message(std::string stringLine, std::ostream& output) {
	output << "From testNamespaces.cpp: " << stringLine << std::endl;
}

void message(double number, std::ostream& output) {
	output << "From testNamespaces.cpp: " << number << std::endl;
}

void dumbFunction(std::string s) {
	Bruno::message("Bruno Koppel", std::cout);
	Bruno::message(1.414, std::cout);
	::message("Bruno Koppel", std::cout);
	::message(1.414, std::cout);
	std::cout << s << std::endl;
	::message(NAME, std::cout);
	::message(ROOT2, std::cout);
}