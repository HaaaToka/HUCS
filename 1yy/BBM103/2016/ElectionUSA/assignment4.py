import csv
import sys
import matplotlib.pyplot as plot
import numpy as np
import random

names=sys.argv[2]
csvInputFile=sys.argv[1]
names=names.split(",")

step1Output=open("retrievedData.txt","w")
myAnswerOutput=open("myAnswer.txt","w")

def bubbleSort(list):
    for passnum in range(len(list) - 1, 0, -1):
        for i in range(passnum):
            if list[i] > list[i + 1]:
                temp = list[i]
                list[i] = list[i + 1]
                list[i + 1] = temp
    return list

#-----------------------------------------------------#
def retreiveData(csvFİle,nameList):
    liste=[]
    with open(csvFİle,"r") as f:
        reader=csv.DictReader(f,delimiter=",")
        for i in range(len(nameList)):
            for line in reader:
                liste.append(line[nameList[i]])
            f.seek(0)#dosyayı tekrar okumanı sağlıyor
    length = len(liste) - len(nameList) + 1
    for i in range(len(nameList)-1):
        liste.pop(int(length/len(nameList))*(i+1))
    for i in range(len(liste)):
        liste[i]=int(liste[i])
    return liste

retrievedDataListe=retreiveData(csvInputFile,names) #step1 in sonucu
for i in range(len(retrievedDataListe)):
    print(retrievedDataListe[i],file=step1Output)
step1Output.close()
#-------------------------STEP 1----------------------------#
def SumVotes():
    s2List=retrievedDataListe.copy()
    sToplam=[]
    point=int(len(s2List)/len(names))
    k=0
    for i in range(len(names)):
        toplam=0
        while k<(i+1)*point:
            toplam+=s2List[k]
            k+=1
        sToplam.append(toplam) #bütün oyların toplamı [A,B,C,D]
    return sToplam

def DispBarPlot():

    s2Toplam=SumVotes()
    s2sortedToplam=s2Toplam.copy()
    s2sortedToplam=bubbleSort(s2sortedToplam)
    dominatedName1=names[s2Toplam.index(s2sortedToplam[-1])]
    dominatedName2=names[s2Toplam.index(s2sortedToplam[-2])]

    dominatedName1Votes=[]
    dominatedName2Votes = []

    states = []
    with open(csvInputFile,"r") as f:
        reader=csv.reader(f)
        for line in reader:
            states.append(line[0])
        f.seek(0)
    states.pop(0)
    with open(csvInputFile,"r") as f:
        reader=csv.DictReader(f)
        for line in reader:
            dominatedName1Votes.append(int(line[dominatedName1]))
            dominatedName2Votes.append(int(line[dominatedName2]))
        f.seek(0)

    N=len(dominatedName1Votes)      #http://matplotlib.org/examples/api/barchart_demo.html
    ind=np.arange(N)
    width =0.35
    fig,aaa=plot.subplots()
    sutun1=aaa.bar(ind,dominatedName2Votes,width,color="r")
    sutun2=aaa.bar(ind+width,dominatedName1Votes,width,color="b")  #ind+width konumu için    2.width=genişliği

    aaa.set_ylabel('Vote Count')
    aaa.set_xlabel("States")
    aaa.set_xticks(ind + width)
    aaa.set_xticklabels(states,rotation=90)
    plot.xlim(-0.35,ind.size) #x eksenin uzunluğu ve grafiğin yayılması(start,stop)
    aaa.legend((sutun1[0], sutun2[0]), (dominatedName2, dominatedName1))
    plot.savefig("ComparativeVotes.pdf", bbox_inches='tight',format="pdf")
    #plot.show()
    plot.close()
DispBarPlot()
#================================  STEP2  ============================================#
def compareVoteonBar():
    toplamOyListe = SumVotes()
    toplamoy=0
    for i in range(len(toplamOyListe)):toplamoy+=toplamOyListe[i]
    for i in range(len(toplamOyListe)):toplamOyListe[i]=toplamOyListe[i]/toplamoy*100
    N = len(toplamOyListe)
    ind = np.arange(N)
    fig, bbb = plot.subplots()
    rects = []
    colors=["r","b","y","c","g","m","k","w"]
    for i in range(len(toplamOyListe)):
        rr=bbb.bar(i+0.25, toplamOyListe[i],0.5,color=colors[i])
        rects.append(rr)
    toplamOyListe=[str("%.3f" %x)+"%" for x in toplamOyListe]
    bbb.set_xlabel("Nominess")
    bbb.set_ylabel("Vote percentages")
    bbb.set_xticks(ind+0.5)
    bbb.set_xticklabels(toplamOyListe)
    plot.xlim(0,len(rects))
    bbb.legend((x[0] for x in rects),(k for k in names))
    plot.savefig("CompVotePercs.pdf", bbox_inches='tight', format="pdf")
    #plot.show()
    plot.close()
    return None
compareVoteonBar()
#================================  STEP3  ============================================#
def obtainHistogram(liste):
    liste=[x%100 for x in liste]    #son iki basamağı alma
    frequancyList = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    for i in range(len(liste)):
        if liste[i]>=0 and liste[i]<10:
            liste[i]="0"+str(liste[i])
        liste[i]=str(liste[i])
        frequancyList[int(liste[i][0])]+=1
        frequancyList[int(liste[i][1])]+=1
    frequancyList=[x/(len(liste)*2) for x in frequancyList]
    return frequancyList
#================================  STEP4  ============================================#

kiz=0
def plotHistogram(histogramList):
    histogramList = obtainHistogram(histogramList)
    global kiz
    xAxis=[x for x in range(len(histogramList))]
    averageofFrequancy=sum(histogramList)/float(len(histogramList))
    averageofFrequancyL=[averageofFrequancy for i in range(len(histogramList))]
    plot.xlabel("Digits")
    plot.ylabel("Distribution")
    colors=["r","y","c","m","g","k","b"]
    plot.plot(xAxis,averageofFrequancyL, color='green', label='Mean', linestyle='--')
    plot.plot(xAxis,histogramList,colors[kiz],label="Digit Dist.")
    legendbox = plot.legend(loc="upper left")
    legendbox.set_zorder(20)
    if kiz==0:
        plot.title("Histogram of least sign digits")
        plot.savefig("Histogram.pdf", bbox_inches='tight', format="pdf")
    else:
        plot.title("Histogram of least sign digits-Sample:"+str(kiz))
        plot.savefig("HistogramofSample"+str(kiz)+".pdf", bbox_inches='tight', format="pdf")
    kiz += 1
    #plot.show()
    plot.close()
    return None
allofVotesFrequancy = retreiveData(csvInputFile, names)
plotHistogram(allofVotesFrequancy)
#================================  STEP5  ============================================#
def list_Uret(kacEleman):
    liste=[]
    for i in range(kacEleman):
        liste.append(random.randint(0,100))
    return liste
def plotHistogragWithSample():
    firstList = list_Uret(10)
    plotHistogram(firstList)
    secondList = list_Uret(50)
    plotHistogram(secondList)
    thirdList = list_Uret(100)
    plotHistogram(thirdList)
    fourthList = list_Uret(1000)
    plotHistogram(fourthList)

    fifthList = list_Uret(10000)
    plotHistogram(fifthList)
    return None
plotHistogragWithSample()
#================================  STEP6  ============================================#
def calculateMSE (liste1,liste2):
    yakınlıkToplamı=[]
    for i in range(len(liste1)):
        yakınlıkToplamı.append((liste1[i]-liste2[i])**2)
    closeness=sum(yakınlıkToplamı)
    return closeness
#================================  STEP7  ============================================#
def calculateMSEforElection(histogram_liste):
    histogram_liste = obtainHistogram(histogram_liste)
    avgofFrequancy=sum(histogram_liste)/float(len(histogram_liste))
    avgfFrequancyL=[avgofFrequancy for i in range(len(histogram_liste))]
    return calculateMSE(histogram_liste,avgfFrequancyL)
step8List = retreiveData(csvInputFile, names)
MSEvalue=calculateMSEforElection(step8List)

#================================  STEP8  ============================================#
def compareMSEs(mseValue):
    listeUretme=[]
    mseler=[]
    buyukmseler=[]
    kucukmseler=[]
    for i in range(10000):  #204 elemanlı 10000liste yi  2 boyutlu dizeye attık
        listeUretme.append(list_Uret(len(retrievedDataListe)))
    for i in range(10000):  #10000lik listedeki değerleri
        a=calculateMSEforElection(listeUretme[i])
        mseler.append(a)
        if a>=mseValue:
            buyukmseler.append(a)
        else:
            kucukmseler.append(a)
    print("MSE value of 2012 USA election is", mseValue)
    print("MSE value of 2012 USA election is", mseValue, file=myAnswerOutput)
    print("The number of MSE of random samples which are larger than or equal to USA election MSE is", len(buyukmseler))
    print("The number of MSE of random samples which are larger than or equal to USA election MSE is",len(buyukmseler),file=myAnswerOutput)
    print("The number of MSE of random samples which are smaller than USA election MSE is", len(kucukmseler))
    print("The number of MSE of random samples which are smaller than USA election MSE is",len(kucukmseler),file=myAnswerOutput)
    p_Value=(len(kucukmseler))/10000
    print("2012 USA election rejection level p is", p_Value,)
    print("2012 USA election rejection level p is",p_Value,file=myAnswerOutput)
    significanceLevel=(1-p_Value)*100 #(len(buyukmseler)/10000)*100
    if significanceLevel<=5:
        print("Finding:We reject the null hypothesis at the p="+str(p_Value).lstrip("0")+" level")
        print("Finding:We reject the null hypothesis at the p="+str(p_Value).lstrip("0")+" level",file=myAnswerOutput)
    else:
        print("Finding:There is no statistical evidence to reject null hypothesis")
        print("Finding:There is no statistical evidence to reject null hypothesis",file=myAnswerOutput)
    return None
compareMSEs(MSEvalue)
myAnswerOutput.close()
#================================  STEP 9-10  ============================================#

