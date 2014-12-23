CSci211.A2.java
===============

Assignment #2 for CSci 211. 

csci 211 Assignment 2
A Filesystem Hierarchy
Due: Wednesday, December 4 20131
This assignment provides experience with object oriented design, trees, iterators, generics, packages,
basic parsing, testing, debugging, and problem solving.
Overview
You are asked to implement a general tree class and associated iterator. You’ll then use your
code to model a simple filesystem as a tree containing directory and file objects.
What is provided
A zip archive containing a2.java and other required files can be found on blackboard.
Input files are text files containing filesystem descriptions (FDs). An FD is a sequence of characters
described by the following rules:
entry ⟶ file | directory
file ⟶ filename size
directory ⟶ ‘(‘ dirname entry* ‘)’
FD ⟶ directory
So, an entry is either a file or directory. A file is described as a name (string) and size (int). A directory
always begins with (, followed by the directory name (string). The * in the directory rule
says that after the directory name, we can expect a sequence of zero or more entries, where each
entry could be either a file or a directory containing a collection of files and directories. Lastly,
every FD must be a directory at the top level. Below are several examples of valid FDs:
(foo)
(foo bar 20 baz 12 )
(flim (flam bim 2 bam 4) ole 10 miss 12 )
(flim (flam bim 2 (foo bar 20 baz 10) bam 4) ole 10 miss 12 )
1 Assignments are not considered late until 8AM the following morning. After that, a late penalty of 5% per
day will be applied up to five days, after which the assignment cannot be accepted.
A Parser class is provided that is able to properly parse files and directories. Part of your task is
to modify it so that it builds a tree containing File and Directory objects (which are also provided).
Comments in the code will indicate the relevant places to modify.
After parsing, the program accepts various commands from the user. Execution of these commands
relies on a correct implementation of your own code.
75% Level
For 75% of the assignment credit, you’ll need to implement and test a Tree<T> class and then
use this class as the parent class of FileSystem in the a2 code.
This tree class supports any number of children per node, so it is not a typical binary tree with
left and right subtrees. Instead, each node maintains a list of children in an Unordered List.
You’ll need to implement a print() method for your tree class that prints the tree to standard
output. It should successively indent text by four spaces according to the level of the tree being
printed. It is important to match this format carefully to ensure correct grading. In the example
continued below, the output of print() is given in response to the list command.
Parsing complete. Please enter commands at the prompt below.
?>list
flim
flam
bim size: 2
foo
bar size: 20
baz size: 10
bam size: 4
ole size: 10
miss size: 12
Although it is not required for the assignment, it is recommended that you write JUnit tests for
Tree<T>, so the class can be verified in isolation from the main program.
85% Level
For an additional 10% of the credit, you’ll also need to complete the implementation of the locate
command. This command accepts a string as an argument, and then searches the tree for all
entries that match that string. Some examples are given below.
Please enter a valid filesystem description (FD):
(flim (flam bim 2 (foo bar 20 baz 10) bam 4) ole 10 foo 12 )
Directory: flim
Directory: flam
File:bim size:2
Directory: foo
File:bar size:20
File:baz size:10
File:bam size:4
File:ole size:10
File:foo size:12
Parsing complete. Please enter commands at the prompt below.
?>
locate foo
/flim/flam/foo
/flim/foo size: 12
?>locate bam
/flim/flam/bam size: 4
?>locate flam
/flim/flam
100% Level
For the remainder of the credit, you’ll need to implement an iterator for the Tree class as described
in lecture. The main task is to build a list of nodes using preorder traversal, and then use
an ordinary linked list iterator to iterate over the list, rather than the tree itself.
We’ll test this iterator with the space command. The space command computes the total space
consumed by the filesystem using a preorder traversal. (Directories take 0 space, but you’ll
likely get this behavior for free.) Some examples are given below.
?>space
Node size: 1
Node size: 1
Node size: 2
Node size: 1
Node size: 20
Node size: 10
Node size: 4
Node size: 10
Node size: 12
total space: 61
?>
Program Testing
Sadly, Eclipse doesn’t support redirection of console input, but we can simply paste test files into
the console. The input files have names like “75.1.in”. Copy it, run the program, and paste it into
the console in order to run the test case. If you are unsure of what the test case does, try running
the program by hand, typing in the test file’s text manually.
Submission
It is important to put your name on all of your files. It also important to make a single zip archive
(not 7zip, or any other weird formats) containing your project (You can do this from inside
Eclipse). Next, submit your archive file using blackboard. Be sure to complete the blackboard
submission process entirely.
