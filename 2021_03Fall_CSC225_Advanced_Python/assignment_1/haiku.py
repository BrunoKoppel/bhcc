import syllables

class Haiku:
  def __init__(self, full_text):
    self.full_text = full_text
    self.lines = full_text.split("/")
    self.syllable_count_at_line = self.calculate_syllables_in_each_line()
    self.is_haiku = False
    self.error_detected = False

  def does_haiku_have_three_lines(self):
    return self.lines == 3

  def to_string_haiku(self):
    if (self.syllable_count_at_line == [5,7,5]):
      return(str(self.syllable_count_at_line) + ", Yes")
    else:
      return(str(self.syllable_count_at_line) + ", No")

  def get_total_char_length(self):
    if len(self.full_text) > 200:
      self.error_detected = True
      raise Exception("Haiku has more than 200 characters!")
    return len(self.full_text)

  def get_all_words_in_haiku(self):
    new_list = []
    for line in self.lines:
      new_list += line.split(" ")

    for word in new_list:
      if word.isupper():
        self.error_detected = True
        raise Exception("Haiku is not lowercase!")

    if len(new_list) < 3:
      self.error_detected = True
      raise Exception("Haiku has less than 3 words!")
    else:
      return new_list

  def calculate_syllables_in_each_line(self):
    new_list = []
    for line in self.lines:
      list_of_words = line.split(" ")
      syllable_count = 0
      for word in list_of_words:
        print(word + " => " + str(syllables.estimate(word)))
        syllable_count = syllable_count + syllables.estimate(word)
      new_list.append(syllable_count)
    return new_list

  def check_validity(self):
    for letter in self.full_text:
      if letter.isupper():
        return False

    if self.syllable_count_at_line == [5,7,5]:        
      return True

    return False

  def get_syllables_in_each_line(self):
    return self.syllable_count_at_line

  def run_exception_checking(self):
    try:
      self.total_char_length = self.get_total_char_length()
      self.get_all_words_in_haiku()
    except Exception as error:
      print(error)
      pass
    return True
