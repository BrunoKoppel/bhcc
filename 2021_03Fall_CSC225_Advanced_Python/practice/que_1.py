"""
try:
  numerator = float(input('Enter numerator: '))
  denominator = float(input('Enter denominator: '))
  
  print(f'result={numerator/denominator}')

except ValueError as e:
  print("Error, input is not a number! => { " + str(e) + " }")
except ZeroDivisionError as e:
  print("Error, denominator is zero! => { " + str(e) + " }")
"""

# Course: Dictionary
## Assignments: List
## Quizzes: List
## Exams: List
## Projects: String(one variable)

"""
{
  "CSC-225-01": {
    "assignments": [
      "assignment_1",
      "assignment_2",
      "assignment_3",
      "assignment_4",
      "assignment_5"
      ],
    "quizzes": [
      "quiz_1",
      "quiz_2",
      "quiz_3",
      "quiz_4"
      ],
    "exams": [
      "exam_1",
      "exam_2"
      ],
    "projects": "project_1"
  }
}
"""

def remove_duplicates(my_list):
  new_list = []
  for obj in my_list:
    if obj not in new_list:
      new_list.append(obj)
  
  return(new_list)

l = [1, 2, 3, 4, 5, 5, 6, 2, 4]
print(remove_duplicates(l))