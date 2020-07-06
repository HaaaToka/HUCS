import sys

def calculateTotalCost(list):
    resultList=[]
    for b in list:
        resultList.append(b[0] + (10 * b[1]) + (b[0] * b[2] * 10))
    return resultList

def displayCost(list):
    displayList=calculateTotalCost(list)
    print("The total cost of each house :")
    for i in range(len(displayList)):
        print(i + 1, ".house's total cost is", str(displayList[i]))

def selectBestBuy(list):
    BestBuyList=calculateTotalCost(list)
    TempList2=calculateTotalCost(list)
    BestSorted=bubbleSort(BestBuyList)
    a=TempList2.index(BestSorted[0])
    print("You should select {0}. house whose total cost is {1}".format(str(a + 1), str(BestSorted[0])))

def bubbleSort(list):
    for passnum in range(len(list) - 1, 0, -1):
        for i in range(passnum):
            if list[i] > list[i + 1]:
                temp = list[i]
                list[i] = list[i + 1]
                list[i + 1] = temp
    return list


BulletList=[]
TempList=[]

inputfile=sys.argv[1]
myFile=open(inputfile,"r")
#myFile=open("HouseData.txt","r")
for line in myFile.readlines():
    line=line.rstrip("\n")
    TempList.append(line)
for i in range(len(TempList)):
    a=TempList[i]
    c=(a.split(" "))
    c[0] = int(c[0])
    c[1] = int(c[1])
    c[2] = float(c[2])
    BulletList.append(c)

displayCost(BulletList)
selectBestBuy(BulletList)
myFile.close()