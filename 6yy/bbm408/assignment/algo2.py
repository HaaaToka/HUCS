from collections import defaultdict
from math import ceil,floor
import os
from time import clock

class Graph:

    def __init__(self, vertices,file):
        self.V = vertices
        self.graph = defaultdict(list)
        self.outFile=open("./output2/ou"+file.split(".")[0][-1]+".txt","w")
        self.s=clock()


    def addEdge(self, u, v, w):
        self.graph[u].append([v,w])
        self.graph[v].append([u,w])


    def getWeight(self,i,j):
        for elem in self.graph[i]:
            if elem[0]==j:
                return elem[1]
        return float("inf")

    def getSmallest(self,LL):
        mini,miniInd=LL[0],0
        for i in range(1,self.V):
            if LL[i]<mini:
                miniInd=i
                mini=LL[i]
        return miniInd

    def isThereTempo(self,LL):
        for el in LL:
            if el!=0:
                return True
        return False

    def getMini(self,LL,tp):
        mini,miniInd=float("inf"),0
        for i in range(self.V):
            if tp[i]!=1 and LL[i][0]!=0 and LL[i][0]<mini:
                miniInd=i
                mini=LL[i][0]
        return miniInd

    def algo2n2(self,source=0):

        #L is combine of L and back
        L = [[float("inf"),-1] for _ in range(self.V)]
        L[source]=[0,-1]
        TP=[0]*self.V
        TP[source]=1

        for _ in range(self.V-1):

            miniInd=self.getMini(L,TP)
            TP[miniInd]=1
            for neighbor in self.graph[miniInd]:
                if TP[neighbor[0]]!=1 and neighbor[1]<L[neighbor[0]][0]:
                    L[neighbor[0]][0]=neighbor[1]
                    L[neighbor[0]][1]=miniInd

        self.printRes2(L)


    def printRes2(self,LL):
        resWeight=0
        for i in range(len(LL)):
            elem=LL[i]
            if elem[1]!=-1:
                print(elem[1],"-",i,"-->>",elem[0],file=self.outFile)
                resWeight+=elem[0]
        print(resWeight,file=self.outFile)
        print("Time: ",clock()-self.s,file=self.outFile)


def main():


    for file in os.listdir("./input"):
        #print(file)
        inputFile=open("./input/"+file,"r")

        # adjancencyList = []

        vertexCount = int(inputFile.readline().strip())
        edgeCount = int(inputFile.readline().strip())
        #print(vertexCount,edgeCount)

        mst=Graph(vertexCount,file)

        for line in inputFile.readlines():
            line=line.strip().split()
            x,y = map(int,line[:2])
            weight = float(line[2])
            # print(x,y,weight)
            # adjancencyList.append([x,y,weight])
            mst.addEdge(x,y,weight)

        # algo2n2(adjancencyList,vertexCount,0)
        # print("----------")
        mst.algo2n2(0)

        break

if __name__ == '__main__':
    main()
