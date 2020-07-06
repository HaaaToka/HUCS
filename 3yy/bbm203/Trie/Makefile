CC=gcc
CFLAGS=
EXECUTABLE=Simon
Simon: tree.o linkedlist.o main.c
	$(CC) $(CFLAGS) tree.o linkedlist.o main.c -o $(EXECUTABLE)
tree.o: tree.h
linkedlist.o: linkedlist.h
clean:
	rm -rf *.o *.gch $(EXECUTABLE)
leaks:
	valgrind --leak-check=yes ./$(EXECUTABLE)
