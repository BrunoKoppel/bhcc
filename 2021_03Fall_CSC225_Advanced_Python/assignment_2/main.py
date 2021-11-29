from admin import *
from user import User
# from privileges import Privileges
import random

first_names = ["Luis","Charles","Tony","Carlos","Salma","Rea","Thaila","Rossy"]
last_names = ["Jones","Terrance", "Crew", "Julliard", "Ivy", "Williams", "Hull", "Saint"]

new_admin = Admin("Bruno","Koppel","brunokoppel","bko@brunokoppel.com", "klon")
new_admin.add_priviledge("View Messages between Users")
new_admin.add_priviledge("Post Server-Wide Updates and Announcements")
new_admin.add_priviledge("Ban Users")
new_admin.add_priviledge("Promote Users")
users = []
for i in range(0,5):
  fn = random.choice(first_names)
  ln = random.choice(last_names)
  un = fn.lower()[0:5] + ln.lower()[0:5]
  em = fn.lower()[0:5] + ln.lower()[0:5] + "@brunokoppel.com"
  ps = random.sample((fn + ln),4)
  users.append( User(fn, ln, un, em, ps) )

new_admin.show_priviledges()