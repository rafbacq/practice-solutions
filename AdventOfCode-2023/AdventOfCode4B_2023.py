import sys
import numpy as np
#sys.path.append("/Users/cartehs1/kidsProject/AdventOfCode-day4")
f = open("Input_day4", "r")
current = f.readline()


grandTotal=0
numCard =1
scratchcards ={}

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
            currentScratch+=1   
    
    for current in range(numCard, numCard+currentScratch+1):
        if(current in scratchcards and current>numCard):
            scratchcards[current] = scratchcards[current]+ scratchcards[numCard]
        elif(current not in scratchcards):
            if numCard in scratchcards:
                scratchcards[current]= 1+ scratchcards[numCard]
            else:
                 scratchcards[current]= 1
        
        #if(numCard==1 and current!=1):
        #    scratchcards[current]=scratchcards[current]+1
        
    grandTotal+=scratchcards.get(numCard)
      


    numCard+=1
    current = f.readline()
print(grandTotal)

f.close() 



