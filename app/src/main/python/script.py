import random
import numpy as np

inputs = np.zeros(shape=(2, 2, 2), dtype=int) 

last_1 = 0
last_2 = 0



def update_inputs(current):
  global last_1, last_2
  if inputs[last_2][last_1][0] == current:
    inputs[last_2][last_1][1] = 1 
    inputs[last_2][last_1][0] = current
  else:
    inputs[last_2][last_1][1] = 0 
    inputs[last_2][last_1][0] = current
  
  last_2 = last_1 # last_1 becomes last_2 
  last_1 = current # current becomes last_1, i.e., current -> last_1 -> last_2 
    
def prediction():
  if inputs[last_2][last_1][1] == 1: 
    predict = inputs[last_2][last_1][0]    
  else:
    predict = random.randint(0, 1)  
  return predict


    
     

def reset():
  for i in range(2):
    for j in range(2):
      for k in range(2):
        inputs[i][j][k] = 0
  
  


def gameplay(number):
  
  predicted = prediction()
  player_input = int(number)
  update_inputs(player_input)
  a = prediction()
  return a
        
    


