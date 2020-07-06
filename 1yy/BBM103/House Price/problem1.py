import sys

def avgFirstThreeDigit(list):
    total=0
    ListSorting=[]
    for x in list:
        for number in str(x)[0:3]:
            total += int(number)
        if total%3==0:
            ListSorting.insert(0,int(total / 3))
        else:
            ListSorting.insert(0,total / 3)
        total = 0
    return ListSorting


ListIntegers=[]
TempList=[]

inputfile=sys.argv[1]
file=open(inputfile,"r")
#file=open("Integer.txt","r")
for line in file.readlines():
    ListIntegers=line.split(";")
for i in range(len(ListIntegers)):
    ListIntegers[i]=int(ListIntegers[i])

output=avgFirstThreeDigit(ListIntegers)
print(output)

file.close()