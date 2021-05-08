from collections import defaultdict
from math import ceil,floor
import os
from time import clock
import sys

sys.setrecursionlimit(15000)

class Graph:

    def __init__(self, vertices,file):
        self.V = vertices
        self.graph = defaultdict(list)
        self.edges = []
        self.outFile=open("./output3/ou"+file.split(".")[0][-1]+".txt","w")
        self.s=clock()
        self.Time=0
        self.bridges=[]


    def addEdge(self, u, v, w):
        self.graph[u].append(v)
        self.graph[v].append(u)
        self.edges.append([u,v,w])

    def BFS(self):

        source=list(self.graph.keys())[0]

        visited=[False]*self.V
        visited[source]=True
        queue=[source]

        while queue:
            cur=queue.pop(0)
            for nei in self.graph[cur]:
                if visited[nei]==False:
                    visited[nei]=True
                    queue.append(nei)

        for ver in visited:
            if ver==False:
                return False
        return True

    def DFS(self,v,visited):

        visited[v]=True

        for i in self.graph[v]:
            if not visited[i]:
                self.DFS(i,visited)

    def isConnected(self):

        visited=[False]*self.V

        self.DFS(0,visited)

        for i in range(self.V):
            if visited[i]==False:
                return False
        return True

    def algo3ReverseDelete(self):

        res=[]
        reswt=0

        self.edges = sorted(self.edges,key = lambda x:x[2],reverse=True)
        print(self.edges)

        t=0
        for i in range(len(self.edges)):
            print("t",t,"Time",clock()-self.s)
            t+=1
            u,v=self.edges[i][0],self.edges[i][1]

            self.graph[u].remove(v)
            self.graph[v].remove(u)

            # print(self.edges[i])
            # print(self.graph,"\n\n")

            if self.BFS()==False:
                self.graph[u].append(v)
                self.graph[v].append(u)

                res.append(self.edges[i])
                reswt+=self.edges[i][2]


        # return res,reswt
        self.printRes(res,reswt)


    def printRes(self,mstEdges,resWeight):
        for edge in mstEdges:
            print(edge[0],"-",edge[1],"-->>",edge[2],file=self.outFile)
        print(resWeight,file=self.outFile)
        print("Time: ",clock()-self.s,file=self.outFile)


def main():


    for file in os.listdir("./input"):
        #print(file)
        inputFile=open("./input/"+file,"r")

        vertexCount = int(inputFile.readline().strip())
        edgeCount = int(inputFile.readline().strip())
        #print(vertexCount,edgeCount)

        mst = Graph(vertexCount,file)

        for line in inputFile.readlines():
            line=line.strip().split()
            x,y = map(int,line[:2])
            weight = float(line[2])
            #print(x,y,weight)
            mst.addEdge(x,y,weight)

        mst.algo3ReverseDelete()


if __name__ == '__main__':
    main()
