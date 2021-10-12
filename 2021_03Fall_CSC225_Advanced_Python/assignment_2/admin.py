from user import User
from privileges import Privileges

class Admin(User):
  def __init__(self, first_name="", last_name="", username="", email="", password=""):
    super().__init__(first_name, last_name, username, email, password)
    self.privileges = Privileges()

  def show_priviledges(self):
    print("\n" + self.describe_user())
    print("\nPriviledges of User:")
    priviledges = self.privileges.get_priviledges()
    if len(priviledges) == 0:
      print("No Priviledges Defined")
    else:
      for priviledge in priviledges:
        print(priviledge)

  def add_priviledge(self, priviledge):
    if priviledge is not None:
      self.privileges.add_priviledge(priviledge)
 