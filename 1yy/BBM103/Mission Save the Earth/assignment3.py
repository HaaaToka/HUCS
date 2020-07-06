#------------------------------------------------------------#
# Student Name: OKAN ALAN
# Student ID: 21526638
# BBM103 Introduction to Programming Laboratory I, Fall 2016 
# Assignment 3: Mission: Save the Earth
#------------------------------------------------------------#

import sys

#-------------------------------------------------#
#                   Functions                     #
#-------------------------------------------------#

MyDictionary={}
alienMessage=" "
metaData=[]
astrophysicalData=[]

def read_dictionary(file_handle):
    Dictt={}
    for line in file_handle.readlines():
        line = line.rstrip("\n")
        word = line.split(" ")
        Dictt[word[0]] = word[1:3]
    return Dictt

def binarian_to_english(text):
    anka = ""
    text=text.split(" ")
    for item in text:
        try:
            anka += MyDictionary[item][0] + " "
        except KeyError:
            anka += item + " "
    return anka


def english_to_binarian(text):
    text=text.split(" ")
    baba=""
    for i in range(len(text)):
        text[i] = text[i].rstrip(",")
        text[i] = text[i].rstrip(".")
        text[i] = text[i].rstrip("?")
        text[i] = text[i].rstrip("!")
        if text[i].isdigit()==True:
            text[i]=str(decimal_to_binary(int(text[i])))
    for item in text:
        temp=item
        try:
            item=item.lower()
            baba+=tersD[item]+" "
        except KeyError:
            baba+=temp+" "
    return baba

def binary_to_decimal(number):
    number=int(number,2)
    return number

def decimal_to_binary(number):
    number=bin(number)
    number=(str(number)).lstrip("0b")
    return int(number)

def ly_to_km(distance):
    distance=distance*9.4607e+12
    return distance

def formission2(aranan,liste):
    indeks=liste.index(aranan)
    sayi = liste[indeks+1]
    sayi=float(binary_to_decimal(sayi))
    return sayi

#-------------------------------------------------#
#                 Main Program                    #
#-------------------------------------------------#



"""messageDictionaryFile=open("dictionary.txt","r")
messageBinarianFile=open("binarian_transmission.txt","r")
messagePeaceFile=open("peace_message.txt","r")"""
messageDictionaryFile=open(sys.argv[1],"r")
messageBinarianFile=open(sys.argv[2],"r")
messagePeaceFile=open(sys.argv[3],"r")

BinarianToEnglishOutputFile=open("binarian_message.txt","w")
computationsFile=open("computations.txt","w")
PeaceOutputFile=open("message.txt","w")

#---------------     Mission1     --------------------#
MyDictionary=read_dictionary(messageDictionaryFile)
tersD = {}
for i in MyDictionary.keys():
    tersD[MyDictionary[i][0]] = i


for line in messageBinarianFile.readlines():
    line=line.rstrip("\n")
    if(line[0]=="#"):
        metaData.append(line.lstrip("#"))

    elif (line[0] == "+"):
        astrophysicalData.append(line.lstrip("+ "))

    else:
        alienMessage=binarian_to_english(line)
        print(alienMessage)
        print(alienMessage,file=BinarianToEnglishOutputFile)

#--------------   Mission2  ------------------#

dd=tersD["temperature"]
oo=tersD["orbital-speed"]
did=tersD["distance"]
for item in astrophysicalData:
    item=item.split(" ")
    for value in item:
        if value==dd:
            degree=formission2(value,item)
        elif value==oo:
            orbitalSpeed=formission2(value,item)
        elif value==did:
            distance=int(formission2(value,item))
            distance="%.6E" % ly_to_km(int(distance))
            #http://stackoverflow.com/questions/6913532/display-a-decimal-in-scientific-notation>>>>>E-Notation
            #%.??  ?? işareti yerinegelen sayı virgülden sonra kaç basamak olsun istersin
print("Data about Binarian planet:",file=computationsFile)
print("Data about Binarian planet:")
print("Distance from the Earth: "+str(distance)+" km",file=computationsFile)
print("Distance from the Earth: "+str(distance)+" km")
print("Planet temperature: "+str(degree)+" degrees Celsius",file=computationsFile)
print("Planet temperature: "+str(degree)+" degrees Celsius")
print("Orbital speed: "+str(orbitalSpeed)+" m/s",file=computationsFile)
print("Orbital speed: "+str(orbitalSpeed)+" m/s")

#--------------   Mission3   -----------------#
for line in messagePeaceFile.readlines():
    line=line.rstrip("\n")
    print(english_to_binarian(line))
    print(english_to_binarian(line),file=PeaceOutputFile)


messagePeaceFile.close()
messageBinarianFile.close()
messageDictionaryFile.close()
BinarianToEnglishOutputFile.close()
computationsFile.close()
PeaceOutputFile.close()



#-------------------------------------------------#
#                 Dear Teacher,                   #
#    Thanks for this assignment.                  #
#    Story was perfect.                           #
#                                                 #
#    Hocam merak ettim  # ile başlayan satırlar   #
#      ne işe yarayacak baya uğraştımda bir şey   #
#      çıkaramadım.Bulabnildiklerim               #
#    1) başta bu satırı çekince -0 ile ilk başı   #
#       sileceğiz "strip ile"                     #
#    2)-%'&*-  yeri silecez "strip ile"           #
#                                                 #
#    bir ara renk kodları yakaladım 8bitlik       #
#     bla:bla:bla şeklinde   sonra renkle bişey   #
#     uyduramayıncabiraz daha uğraşıp bıraktım    #
#    -_-              *_*             +_+         #
#-------------------------------------------------#