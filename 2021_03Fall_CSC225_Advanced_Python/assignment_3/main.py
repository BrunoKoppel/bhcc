from flower import Flower
flowers = [
  Flower("A", 2, 1),
  Flower("B", 9, 10),
  Flower("C", 8, 2),
  Flower("D", 2, 9),
  Flower("E", 0, 5),
  Flower("F", 5, 9),
  Flower("G", 2, 5),
  Flower("H", 9, 0),
  Flower("I", 0, 0)
]

flowers[0].bloom()

all_flowers_blooming = False

while(all_flowers_blooming is False):
  count = 0

  for i in range(0, len(flowers)):    
    if flowers[i].is_blooming:
      flowers[i].make_bloom(1)
      count += 1

      for y in range(0, len(flowers)):
        if i != y:
          flowers[i].detect_collision(flowers[y])

  if count == len(flowers):
    all_flowers_blooming = True
    

biggest_bloomer = flowers[0]
for flower in flowers:
  if flower.flowers_bloomed > biggest_bloomer.flowers_bloomed:
    biggest_bloomer = flower

print("\nThe Flower with most blooms:\n")
biggest_bloomer.print_information()