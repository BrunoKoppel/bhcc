results = {}

def memo(num, result):
  if results[num] is not None:
    return results[num]
  else:
    results[num] = result

def fib(n):
  fib_result = None
  assert n >= 0
  # ending conditions
  if n < 2:
    return n
  else:
      # recursive call
    return fib(n - 1) + fib(n - 2)
 
if __name__ == '__main__':
  try:
    # fibs = [fib(i) for i in range(10)]
    # print(fibs)
    print(fib(25))
  except AssertionError:
    print('Invalid input to fib()')