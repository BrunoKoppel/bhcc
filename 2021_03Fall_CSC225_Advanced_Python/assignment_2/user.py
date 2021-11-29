class User:
  def __init__(self, first_name ="", last_name ="", username ="", email ="", password =""):
    self.first_name = first_name
    self.last_name = last_name
    self.username = username
    self.email = email
    self.password = password
    self.login_attempts = 0

  def get_user_names(self):
    return (f"{self.first_name} {self.last_name}")

  def describe_user(self):
    info = f"Username => \"{self.username}\"\nEmail => \"{self.email}\""
    return ("User Data is:\n" + self.get_user_names().title() + "\n" + info)
  
  def greet_user(self):
    user_names = f"{self.first_name} {self.last_name}"
    return ("Greetings, " + user_names.title() + ", welcome to yet another day alive !!")

  def get_login_attempts(self):
    return self.login_attempts

  def increment_login_attempts(self):
    self.login_attempts += 1
  
  def reset_login_attempts(self):
    self.login_attempts = 0

new = User("Bruno", "Koppel")
print(new.describe_user())
print(new.greet_user())
for i in range(0,5):
  new.increment_login_attempts()

print(f"{new.get_user_names()} has {new.get_login_attempts()} logins")
