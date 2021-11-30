import unittest
from haiku import Haiku

valid_haiku_input_file = "valid_haiku_list.txt"
invalid_haiku_input_file = "invalid_haiku_list.txt"
valid_input = open(valid_haiku_input_file,"r")
invalid_input = open(invalid_haiku_input_file,"r")

class HaikuValidator(unittest.TestCase):
  def test_valid_haikus(self):
    print("\nValid Haikus\n")
    for haiku_line in valid_input:
      haiku_line = haiku_line[0:-1]
      print("Haiku => " + haiku_line)
      current_haiku = Haiku(haiku_line)
      self.assertEqual([5,7,5], current_haiku.get_syllables_in_each_line())
      self.assertEqual(True, current_haiku.check_validity())
      print("Success")

  def test_invalid_haikus(self):
    print("\nInvalid Haikus\n")
    for haiku_line in invalid_input:
      haiku_line = haiku_line[0:-1]
      print("Haiku => " + haiku_line)
      current_haiku = Haiku(haiku_line)
      self.assertEqual(True,current_haiku.run_exception_checking())
      self.assertEqual(False, current_haiku.check_validity())
      
if __name__ == '__main__':
  unittest.main()  # pragma: no cover

