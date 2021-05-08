#bbm741 pdfleri notasyon konusu icin
from collections import defaultdict
from math import ceil,floor,inf
import heapq
import os
import sys
from time import clock

class Heap():

    def __init__(self):
        self.array = []
        self.size = 0
        self.position = []

    def newMinHeapNode(self, v, dist):
        minHeapNode = [v, dist]
        return minHeapNode

    def swapMinHeapNode(self, a, b):
        temp = self.array[a]
        self.array[a] = self.array[b]
        self.array[b] = temp

    def minHeapify(self, idx):
        smallest = idx
        left = 2 * idx + 1
        right = 2 * idx + 2

        if left < self.size and self.array[left][1] < self.array[smallest][1]:
            smallest = left

        if right < self.size and self.array[right][1] < self.array[smallest][1]:
            smallest = right

        if smallest != idx:
            self.position[self.array[smallest][0]] = idx
            self.position[self.array[idx][0]] = smallest

            self.swapMinHeapNode(smallest, idx)

            self.minHeapify(smallest)


    def extractMin(self):

        if self.isEmpty() == True:
            return

        root = self.array[0]

        lastNode = self.array[self.size - 1]
        self.array[0] = lastNode

        self.position[lastNode[0]] = 0
        self.position[root[0]] = self.size - 1

        self.size -= 1
        self.minHeapify(0)

        return root

    def isEmpty(self):
        return True if self.size == 0 else False

    def decreaseKey(self, v, dist):

        i = self.position[v]

        self.array[i][1] = dist

        while i > 0 and self.array[i][1] < self.array[(i - 1) // 2][1]:
            self.position[self.array[i][0]] = (i - 1) // 2
            self.position[self.array[(i - 1) // 2][0]] = i
            self.swapMinHeapNode(i, (i - 1) // 2)

            i = (i - 1) // 2

    def isInMinHeap(self, v):

        if self.position[v] < self.size:
            return True
        return False


class Graph:

    def __init__(self, vertices,file):
        self.V = vertices
        self.graph = defaultdict(list)
        self.outFile=open("./output4/ou"+file.split(".")[0][-1]+".txt","w")
        self.s=clock()


    def addEdge(self, u, v, w):
        self.graph[u].append([v,w])
        self.graph[v].append([u,w])

    def PrimMST(self,source):

        V = self.V

        key = [float("inf")]*V
        key[source] = 0

        parent = [-1]*V

        minHeap = Heap()

        for v in range(V):
            minHeap.array.append(minHeap.newMinHeapNode(v, key[v]))
            minHeap.position.append(v)

        minHeap.position[source] = source
        minHeap.decreaseKey(source, key[source])

        minHeap.size = V

        while minHeap.isEmpty() == False:

            newHeapNode = minHeap.extractMin()
            u = newHeapNode[0]

            for pCrawl in self.graph[u]:

                v = pCrawl[0]

                if minHeap.isInMinHeap(v) and pCrawl[1] < key[v]:
                    key[v] = pCrawl[1]
                    parent[v] = [u,pCrawl[1]]

                    minHeap.decreaseKey(v, key[v])

        self.printRes(parent)


    def printRes(self,parent):
        reswt=0
        for i in range(len(parent)):
            elem=parent[i]
            if type(elem)==list:
                print(elem[0],"-",i,"-->>",elem[1],file=self.outFile)
                reswt+=elem[1]
        print(reswt,file=self.outFile)
        print("Time: ",clock()-self.s,file=self.outFile)

def main():


    for file in os.listdir("./input"):
        #print(file)
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

        mst.PrimMST(0)



if __name__ == '__main__':
    main()
