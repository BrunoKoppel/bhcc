#ifndef OPERATORS_H
#define OPERATORS_H


class operators
{
public:
   double getVolume(void) {
      return length * breadth * height;
   }
   void setLength( double len ) {
      length = len;
   }
   void setBreadth( double bre ) {
      breadth = bre;
   }
   void setHeight( double hei ) {
      height = hei;
   }

   // Overload + operator to add two Box objects.
   operators operator+(const operators& b) {
      operators box;
      box.length = this->length + b.length;
      box.breadth = this->breadth + b.breadth;
      box.height = this->height + b.height;
      return box;
   }

private:
   double length;      // Length of a box
   double breadth;     // Breadth of a box
   double height;      // Height of a box
};

#endif // OPERATORS_H
