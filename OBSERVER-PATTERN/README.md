

Name - MANISH KUMAR


Assuming you are in the directory containing this README:

## Initial steps:
Before cleaning, compiling & running follow the steps below:
	1. navigate into the directory studentcoursesbackup starting from
	the directory containing the README.txt
		(use cd studentcoursesbackup from terminal for linux)

## To clean:
ant -buildfile src/build.xml clean

--------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

--------------------------------------------------------
## To run by specifying arguments from command line

ant -buildfile src/build.xml run -Darg0=src/input.txt -Darg1=src/delete.txt -Darg2=src/output1.txt -Darg3=src/output2.txt -Darg4=src/output3.txt

(assuming the input file is "input.txt" , the file with courses to be deleted is "delete.txt"
and the respective output files for the three trees are output1.txt,output2.txt & output3.txt
within the src/ directory)

1.place these five text files within the src folder for the exact commands to work.
Otherwise please note that the absolute path for  files must be given.
2. Assuming the output.txt files were not present at runtime then the program will create 
such text files within the specified path.Even then the absolute path must be given.

--------------------------------------------------------
## Note :

1.As per the guidelines for Assignment, it is assumed that the input.txt
  and delete.txt would be well formatted. Therefore in extension it is assumed:

   a) A case where the formatting per line is not xxxx:T would not exist.
      Where x would each be a nonnegative integer between 0 and 9 and T a course name 
      of the set {A,B,C,D,E,F,G,H,I,J,K}. Exceptions for the following cases have been 
      added : 
        -If any input line length in a text file > 6 an exception would be thrown and the program exits.
        -If an input file(input/delete) is empty an exception is thrown and the program exits. 
        -if any intermediary line within the document is empty, an exception is thrown and the program exits.
        -If the BNumber has any value which is not an int, an exception would be thrown and the program exits.

   b) With this in Mind the BNumbers would range from 0000-9999 only.
      All Bnumbers must have four digits irrespective of its numeric value.
      Therefore 0 would be 0000 and 33 would be 0033 and vice verca. If this format is 
      not followed for BNumbers<1000 then an exception is thrown and the program exits.

2.However repeated entries for a valid course per valid Student would be automatically
  ignored within the program. If an invalidcourse is added with a nonexisting bNumber, 
  then that student(Node) will not be added into any tree. In such a case an error message will be
  printed on terminal. This error message would be printed for an invalid delete operation as well.

3.The method implementations for BST were referenced and modified from
  the book: Data Structures & Algorithms in Java(second edition) by 
  Robert Lafore, p406-410. The code snippets were modified as per the 
  requirements for the Assignment.

4 The three instances of the same BinarySearchTree class is created within
  TreeBuilder.java

5.Implementation of Observer Pattern and Prototype Pattern:
  
    a)The Observer Pattern was established between the Nodes of the master tree and Nodes of
      the backup trees. Each Node implements both Subject & Observer Interfaces. When a new Node is 
      created for the master tree, the Prototype pattern is implemented and that Node is cloned into
      the backup Nodes. Afterwards these nodes are added as observers of the master node. Finally all
      the nodes are inserted into their respective trees using standard BST method.  

    b)When a course needs to be deleted. Initially that course is removed from the course List within 
      the master node, afterwards the maser node calls notifyAll() which updates the state of its observers.
      (backup nodes) At no point would a node be deleted from any tree.  



## justification for Data Structures & Time Complexity

Data Structure : Binary Search Tree
     	         
find Nodes(search) : Θ(log(n)) (Average case)
Insert Nodes(insert) : Θ(log(n)) (Average case)
Space Complexity : O(n)

No delete operation for nodes is implemented, since at no point would an
inserted Node(student) would be deleted from the tree.

--------------------------------------------------------

## sample output

     [java] initiating studentCoursesBackup
     [java] 
     [java] master tree complete
     [java] backup tree 1 complete
     [java] backup tree 2 complete
     [java] studentCoursesbackup complete: 
     [java] check src/output1.txt, src/output2.txt, src/output3.txt for output
