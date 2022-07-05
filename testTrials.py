# this script randomises the lines in the file
# then writes the lines to a new file in random order
# then it returns the best, worst and average insert and find operations for subset chosen
# subset is determined by user in GUI.py
# names of students in subset are also printed because of printStudent method 
# needing to be called in Experiment.java

import os
import shutil
import random
import sys

oklist="../data/oklist.txt"
writeOver= "../data/overWrite.txt"
subsetData= "../data/subset.txt"
copyOklist= "../data/oklistCopy.txt" #to store original oklist while its being manipulated

def main():
    studentArgs=""
    FileRandom()
    limit=int(sys.argv[1]) #takes input from user in GUI.py
    with open(writeOver) as fp:
        i=0      
        subsets= open(subsetData, "w")
        for lines in fp:
            if (i<limit):
                subsets.write(lines)
                i=i+1
                    
    subsets.close()
    # change oklist to have the specific subset so AccessAVLApp can be run dynamically
    shutil.copy(subsetData, oklist)
            
    with open(oklist) as sd:        
        for lines in sd:
            studentID=lines[:9]
            studentArgs= studentArgs + " " + studentID # string of studentIDs to be used as arguments
        cmd2= 'java Experiment' + studentArgs  
        
    os.system(cmd2)
    
    # set oklist back to the original        
    shutil.copy(copyOklist, oklist)

# method to randomise oklist everytime its used
# results in best, average, worst numbers not being the exact same each time
def FileRandom():
    with open(oklist, "r") as fp:
        students=[(random.random(),line) for line in fp]
        students.sort()
    with open (writeOver, "w") as rw:
        for _, line in students:
            rw.write(line)

if __name__=="__main__":
    main()       