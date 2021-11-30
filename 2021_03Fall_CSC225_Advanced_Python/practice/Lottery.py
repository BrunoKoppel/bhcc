import random
import time

class Lottery:
  def __init__(self):
    self.options = "0123456789ABCDEF"

  def draw_winner(self):
    return ''.join(random.sample(self.options, 5))

game = Lottery()
my_ticket = 'AB234'
count = 0

winner_ticket = game.draw_winner()
while my_ticket != winner_ticket:
  print(f'Winning Ticket => {winner_ticket} and your Ticket = {my_ticket}', end='\r')
  winner_ticket = game.draw_winner()
  # print('-\/'[count%3], end='\r')
  count += 1

print(f'\nYou won after {count} tries')