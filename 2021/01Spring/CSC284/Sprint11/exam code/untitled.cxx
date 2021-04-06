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

class  Base {
   public:
      virtual void someMethod();
   protected:
      int mProtectedInt;
   private:
      int mPrivate;
};

void Base::someMethod() { cout << "This is Base's version of someMethod()" << endl; }

class Derived : public Base {
public:
    virtual void someOtherMethod();
    virtual void someMethod() override;
};

void Derived::someMethod() { cout << "This is Derived's version of someMethod()" << endl; }

int main(int argc, char **argv)
{
	Derived myDerived;
	myDerived.someMethod();
	return 0;
}

