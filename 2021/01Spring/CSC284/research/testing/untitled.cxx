/*
 * untitled.cxx
 * 
 * Copyright 2021 Bruno Köppel <brunokoppel@Thareos.local>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */


#include <iostream>

using namespace std;

class Base {
	public:
		static  int get() { return 1;}
};

class Derived : public Base {
	public:
		static  int get() { return 2;}
};

int get() { return 3;}

namespace NS {
    int get() { return 4;}

}

int main() {

	Derived d;
	
    
    auto base1 = std::make_unique<Base>(d);
    
    cout << base1->get();
    cout << " " << d.get();
    cout << " " << get() << " " << get();
    cout << " " << NS::get();

    // write code so that the program prints

    // 1 2 3 3 4

    // using only the get() functions.

    // access the global get function in 2 ways.


    return 0;

}

