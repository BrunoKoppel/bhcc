import math

class Flower:
  def __init__(self, name = "", x = 0, y = 0):
    self.name = name
    self.x = x
    self.y = y
    self.radius = 0
    self.is_blooming = False
    self.flowers_bloomed = 0

  def get_state(self):
    return self.is_blooming()

  def bloom(self):
    if self.is_blooming is False:
      self.is_blooming = True
  
  def make_bloom(self, factor):
    if self.is_blooming:
      self.radius = self.radius + (0.1 * factor)
  
  def detect_collision(self, other_flower):
    distance = math.sqrt(
      math.pow(self.x - other_flower.x, 2) + 
      math.pow(self.y - other_flower.y, 2))
    
    if self.radius > distance and not other_flower.is_blooming:
      self.flowers_bloomed = self.flowers_bloomed + 1
      other_flower.bloom()
      print(f'Flower {self.name} made {other_flower.name} bloom')

  def print_information(self):
    print(f'Flower {self.name}')
    print(f'X: {self.x}')
    print(f'Y: {self.y}')
    print(f'Radius: {self.radius}')
    print(f'Flowers: {self.flowers_bloomed}\n')



