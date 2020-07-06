from collections import defaultdict
from math import ceil,floor
import os
from time import clock


class Graph:

    def __init__(self, vertices,file):
        self.V = vertices
        self.graph = defaultdict(list)
        self.outFile=open("./output1/ou"+file.split(".")[0][-1]+".txt","w")
        self.s=clock()
        #adjancencyMatrix = [[float("inf") for _ in range(vertices)] for __ in range(vertices)]

    def addEdge(self, u, v, w):
        self.graph[u].append([v,w])
        self.graph[v].append([u,w])
        #adjancencyMatrix[u][v] = adjancencyMatrix[v][u] = weight

    def getWeight(self,i,j):
        for elem in self.graph[i]:
            if elem[0]==j:
                return elem[1]
        return float("inf")

    def isValidEdge(self,edge,visitList):
        if (visitList[edge[0]]==1 and visitList[edge[1]]==0) or (visitList[edge[0]]==0 and visitList[edge[1]]==1):
            return True
        return False

    def printRes(self,mstEdges,resWeight):
        print(resWeight)
        for edge in mstEdges:
            print(edge[0],"-",edge[1],"-->>",edge[2],file=self.outFile)
        print(resWeight,file=self.outFile)
        print("Time: ",clock()-self.s,file=self.outFile)

    def n3algo1_v2(self,source=0):
        res=[]
        reswt=0

        visited=[0]*self.V

        visited[source]=1
        for _ in range(self.V-1):
            print("v-->",_,"Time->",clock()-self.s)
            mini=[0,0,float("inf")]
            for frm in self.graph.keys():
                for to in self.graph[frm]:
                    if self.isValidEdge([frm,to[0]],visited):
                        if to[1]<mini[2]:
                            mini=[frm,to[0],to[1]]
            visited[mini[0]]=visited[mini[1]]=1
            res.append(mini)
            reswt+=mini[2]

        self.printRes(res,reswt)

def main():


    for file in os.listdir("./input"):
        inputFile=open("./input/"+file,"r")

        vertexCount = int(inputFile.readline().strip())
        edgeCount = int(inputFile.readline().strip())
        #print(vertexCount,edgeCount)

        mst=Graph(vertexCount,file)

        for line in inputFile.readlines():
            line=line.strip().split()
            x,y = map(int,line[:2])
            weight = float(line[2])
            #print(x,y,weight)
            mst.addEdge(x,y,weight)

        mst.n3algo1_v2(0)

        break


if __name__ == '__main__':
    main()
