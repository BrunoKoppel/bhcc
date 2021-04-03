#pragma once
#include<ostream>;
#include<string>;

#define ROOT2 1.414
#define NAME "Bruno Koppel"

namespace Bruno {
	void message(std::string stringLine, std::ostream& output) {
		output << "From Bruno Namespaces.h: " << stringLine << std::endl;
	};
	void message(double number, std::ostream& output) {
		output << "From Bruno Namespaces.h: " << number << std::endl;
	};

}