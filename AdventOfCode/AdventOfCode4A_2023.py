import sys
import numpy as np

f = open("Input_day4", "r")
current = f.readline()
grandTotal=0

while current:
    currentScratch = 0
    arrWin = []
    arrHold = []
    currentNum = ''

    for i in range(current.index(':') + 2, len(current)):
        if '|' in current and current.index('|') == i:
            break
        if current[i].isdigit():
            currentNum += current[i]
        elif(currentNum!=''):
            arrWin.append((currentNum))
            currentNum = ''

    for i in range(current.index('|') + 2, len(current)):
        if current[i].isdigit():
            currentNum += current[i]
        elif(currentNum!=''):
            arrHold.append((currentNum))
            currentNum = ''
    for s in arrHold:
        if(s in arrWin):
            if(currentScratch==0):
                currentScratch=1
            else:
                currentScratch*=2
    grandTotal+=currentScratch
    current = f.readline()
print(grandTotal)

f.close() 
    
    



        






