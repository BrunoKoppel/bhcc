#include <iostream>
#include <functional>

#define VERBOSE1 false
#define VERBOSE2 false
#define VERBOSE3 true
#define VERBOSE4 false


using namespace std;

function<int(void)> multiplyBy2Lambda(int x)
{
	return [x] { return 2 * x; };
}

int main()
{
	if (VERBOSE1) {
		// Basic lambda
		auto basicLambda = [] { cout << "Hello from Lambda" << endl; };
		basicLambda();

		// Lambda with parameters
		auto parametersLambda = [](int value) { cout << "The value is " << value << endl; };
		parametersLambda(42);

		// Lambda returning a value
		auto returningLambda = [](int a, int b) -> int { return a + b; };
		int sum = returningLambda(11, 22);
		cout << "The result is " << sum << endl;

		// Lambda returning a value, with return type omitted
		auto returningLambda2 = [](int a, int b) { return a + b; };
		sum = returningLambda2(11, 22);
		cout << "The result is " << sum << endl;

		// Lambda capturing a variable by value
		double data = 1.23;
		auto capturingVLambda = [data] { cout << "Data = " << data << endl; };
		capturingVLambda();

		// Lambda capturing a variable by value
		auto capturingVLambda2 = [data]() mutable { data *= 2; cout << "Data = " << data << endl; };
		capturingVLambda2();

		// Lambda capturing a variable by reference
		auto capturingRLambda = [&data] { data *= 2; };
		capturingRLambda();
		cout << "Data = " << data << endl;
	}
	
	if (VERBOSE2) {
		{
			double pi = 3.1415;
			auto myLambda = [myCapture = "Pi: ", pi]{ cout << myCapture << pi; };
			myLambda();
		}

		cout << endl;

		{
			auto myPtr = std::make_unique<double>(3.1415);
			auto myLambda = [p = std::move(myPtr)]{ cout << *p; };
			myLambda();
		}

		cout << endl;

		{
			auto myPtr = std::make_unique<double>(3.1415);
			auto myLambda = [myPtr = std::move(myPtr)]{ cout << *myPtr; };
			myLambda();
		}

		cout << endl;
	}

	if (VERBOSE3) {
		auto fn = multiplyBy2Lambda(5);
		cout << fn() << endl;
	}

	return 0;
}
