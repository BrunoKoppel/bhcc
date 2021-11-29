def reverse1(s):
  rev_str = ""
  for l in s:

    rev_str = rev_str + l
  return rev_str

def reverse2(s):
  rev_str = ""
  for l in s:
    rev_str = l + rev_str
  return rev_str

input_str = "hello"
print("#1")
print(reverse1(input_str))
print("#2")
print(reverse2(input_str))
print("#3")
print(input_str[::-1])
print("#4")
print("". join(reversed(input_str)))