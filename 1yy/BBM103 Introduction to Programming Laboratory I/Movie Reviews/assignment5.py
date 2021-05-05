import os
os.makedirs("filmList",exist_ok=True)

data=open("u.data","r")
genre=open("u.genre","r")
item=open("u.item","r")
occupation=open("u.occupation","r")
user=open("u.user","r")
reviewOutputFile=open("review.txt","w")
stopwordaFile=open("stopwords.txt","r",encoding='utf-8') #iso-8859-1
filmGenreOutputFile=open("filmGenre.txt","w")
filmGenreOutputFile.write("Guess Genres of Movie based on Movies\n")

dataListe=[]
genreDict={}
itemListe=[]
occupationDict={}
userListe=[]
stopwordsList=[]

for line in stopwordaFile.readlines():
    stopwordsList.append(line.rstrip("\n").upper())
for line in item.readlines():
    itemListe.append(line.rstrip("\n").split("|"))
    """movie id | movie title | video release date | IMDb URL
    | unknown | Action | Adventure | Animation | Children's | Comedy | Crime | Documentary | Drama
    | Fantasy | Film-Noir | Horror | Musical | Mystery | Romance | Sci-Fi | Thriller | War | Western |     """
for line in genre.readlines():
    a=(line.rstrip("\n").split("|"))
    genreDict[a[1]] = a[0]
    """ genre id | genre     """
for line in user.readlines():
    userListe.append(line.rstrip("\n").split("|"))
    """ user id | age | gender | occupation id | zip code   """
for line in occupation.readlines():
    a=(line.rstrip("\n").split("|"))
    occupationDict[a[0]] = a[1]
    """ id | occupation    """
for line in data.readlines():
    dataListe.append(line.rstrip("\n").split("\t"))
    """ userid movieid rating timestamp     """

infilmFile=os.listdir("film")
infilmGuessFile=os.listdir("filmGuess")

filmNames = [x[1][:-7].upper() for x in itemListe]
infileFilmName=[]
turler={"unknown":[] ,"Action":[],"Adventure":[],"Animation":[],"Children's":[],"Comedy":[],"Crime":[],"Documentary":[],"Drama":[],"Fantasy":[],"Film-Noir":[],"Horror":[],"Musical":[],"Mystery":[],"Romance":[],"Sci-Fi":[],"Thriller":[],"War":[],"Western":[]}

for i in infilmFile:
    filmAnlatimi=[]
    z = open("film/" + str(i), "r") #acilan dosya
    firstline=z.readline()
    firstline=firstline.rstrip("\n").split(" (")
    infileFilmName.append(firstline[0])
    for line in z.readlines():
        filmAnlatimi+=line.rstrip("\n").split()
    z.seek(1)
    indeks=filmNames.index(firstline[0].upper())
    genres=itemListe[indeks][-19:]
    gg=[]
    for k in range(len(genres)):
        if int(genres[k])==1:
            gg.append(genreDict[str(k)])
        else:pass
    for line in z.readlines():
        line=line.rstrip("\n").split(" ")
        for x in range(len(gg)):
            turler[gg[x]]+=[t.upper() for t in line if t.upper() not in stopwordsList]
    y = open("filmList/"+str(indeks+1)+".html","w")  #yazilacak dosya
    y.write('<html><head><meta http-equiv="Content-Type" content="text/html; charset=utf-8">')
    y.write('<title>'+firstline[0].title()+'</title></head><body><font face="Times New Roman" font="" size="6" color="red" <b>'+firstline[0].title()+'</font><br>')
    y.write('<b>Genre: </b>'+",".join(gg)+'<br>')
    y.write('<b>IMDB Link: </b><a href="' + itemListe[indeks][-20] + '">'+firstline[0].title()+' </a><br>')
    y.write('<font face="Times New Roman" font="" size="4" color="black"><b>Review: </b><br>'+" ".join(filmAnlatimi)+'</font><br><br>')
    usercount,sumrate=0,0
    for kk in dataListe:
        if int(kk[1])==indeks+1:
            usercount+=1
            sumrate+=int(kk[2])
    y.write('<b>Total User: </b>'+str(usercount)+'/<b>TotalRate:</b> '+str(sumrate/usercount)+'<br><br>')
    y.write('<b>User who rate the film:</b><br>')
    for kk in dataListe:
        if int(kk[1])==indeks+1:
            y.write('<b>User</b>: '+kk[0]+'<b>Rate</b>: '+kk[2]+'<br>')
            y.write('<b>User Detail: Age: </b>' +"".join([str(kkk[1]) for kkk in userListe if int(kk[0])==int(kkk[0]) if type(kkk[1])==int])+ '<b> Gender: </b>' +"".join([str(kkk[-3]) for kkk in userListe if int(kk[0])==int(kkk[0])])+'<b> Occupation: </b>' +"".join([str(occupationDict[kkk[-2]]) for kkk in userListe if int(kk[0])==int(kkk[0])])+'<b> Zipcode: </b>' +"".join([str(kkk[-1]) for kkk in userListe if int(kk[0])==int(kkk[0])])+ '<br>')
        else:pass
    y.write('<br></body></html>')

for it in itemListe:
    reviewOutputFile.write(it[0]+" ")
    reviewOutputFile.write(it[1][:-7]+" ")
    try:
        if it[1][:-7].upper() in infileFilmName:
            reviewOutputFile.write("is found in folder\n")
        else:
            reviewOutputFile.write("is not found in folder. Look at "+it[-20]+"\n")
    except Exception:
        reviewOutputFile.write("Bir sey oldu.")    #Microsoft :) #kusura bakmayin hocam hala bulamadim #267. film icin yada 2 tane olan filmler icin isdiniz ama hata vermiyor Liste

#====================================   STAGE 1  ==========================================#

gecersiz="unknown,Action,Adventure,Animation,Children's,Comedy,Crime,Documentary,Drama,Fantasy,Film-Noir,Horror,Musical,Mystery,Romance,Sci-Fi,Thriller,War,Western".split(",")
for i in range(len(gecersiz)):
    turler[gecersiz[i]]=list(set(turler[gecersiz[i]]))

for i in infilmGuessFile:
    filmGuesss=[]
    z = open("filmGuess/" + str(i), "r")
    firstline=z.readline()
    firstline=firstline.rstrip("\n").split(" (")
    filmName=firstline[0].upper()
    filmGenreOutputFile.write(filmName+" : ")
    for line in z.readlines():
        line=line.rstrip("\n").split()
        filmGuesss.append([t.upper() for t in line if t.upper() not in stopwordsList])
    filtt=[]
    filmGuesssNoneSilme=filmGuesss[:]
    for j in range(len(filmGuesss)):
        if filmGuesssNoneSilme[j]==None:
            filmGuesss.remove(filmGuesssNoneSilme[j])
    filmGuesssUniqe=[]
    for j in range(len(filmGuesss)):
        filmGuesssUniqe+=filmGuesss[j]
    filmGuesssUniqe=list(set(filmGuesssUniqe))
    for j in range(len(gecersiz)):
        count=0
        for ss in filmGuesssUniqe:
            if ss in turler[gecersiz[j]]:
                count+=1
            if count==20:
                filtt.append(gecersiz[j])
    filtt=list(set(filtt))
    filmGenreOutputFile.write(" ".join(filtt)+"\n")
    z.close()

data.close()
genre.close()
item.close()
occupation.close()
user.close()
reviewOutputFile.close()
stopwordaFile.close()
filmGenreOutputFile.close()