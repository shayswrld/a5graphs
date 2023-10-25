#Makefile with multiple files

JAVAC =/usr/bin/javac
JAVA = /usr/bin/java
.SUFFIXES: .java .class
SRCDIR=src
BINDIR=bin


$(BINDIR)/%.class:$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) -sourcepath $(SRCDIR) $<
	
CLASSES=Edge.class Vertex.class Path.class GraphException.class Graph.class GenerateGraph.class GraphExperiment.class

CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)

default: $(CLASS_FILES)
	
clean:
	rm $(BINDIR)/*.class
	> results.txt
	> count.csv
	
run: $(CLASS_FILES)	
	$(JAVA) -cp bin GraphExperiment
	mv dataset* data
	mv results.txt data
	mv *.csv data
	
