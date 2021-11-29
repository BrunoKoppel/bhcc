class Car(object): 
  def __init__(self, w, d): 
    self.wheels = w 
    self.doors = d 
    self.color = ""

class Animal():
  def __init__(self, age):
    self.age = age
    self.name = None

  def get_age(self):
    return self.age

  def get_name(self):
    return self.name

  def set_age(self, newage):
    self.age = newage

  def set_name(self, newname=""):
    self.name = newname

  def speak(self):
    print('!!!')

  def __str__(self):
    return "animal:"+str(self.name)+":"+str(self.age)

# begin code

class Point3d():
  def __init__(self, x, y, z):
    self.x = x
    self.y = y
    self.z = z

  def __str__(self):
    return f"Point ({self.x}, {self.y}, {self.z})"

if __name__ == '__main__':
  origin = Point3d(0, 0, 0)
  point1 = Point3d(3, 4, 5)

  print(origin.__str__())
  print(point1.__str__())
