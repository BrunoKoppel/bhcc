class Privileges:
  def __init__(self, priviledges=[]):
    self.privileges = priviledges
  
  def add_priviledge(self, priviledge):
    if (priviledge is not None):
      self.privileges.append(priviledge)

  def get_priviledges(self):
    return self.privileges