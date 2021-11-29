import matplotlib.pyplot as plt

x_values = list(range(0,10))
squares = [i**2 for i in x_values]
cubes = [i**3 for i in x_values]

fig, ax = plt.subplots()
ax.plot(x_values, squares)
ax.plot(x_values, cubes)

ax.set_xlabel("Values")
ax.set_ylabel("Cubes and Squares")
ax.set_title("Squares and Cubes")

plt.style.use('seaborn')

plt.show()