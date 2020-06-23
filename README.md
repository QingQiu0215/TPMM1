# TPMM1

Concordia University
Dept. of Computer Science and Software Engineering
COMP 6521: Advanced Database Technology and Applications
Winter 2019-2020
Lab Assignment 1
Total Points: 8
Codes & Reports: Wed. Feb. 19, 2020 at noon
Demos: Wed. Feb. 19, 2020
Project Description: We have the data files T1 and T2
with the same schema as follows:
EmpID int(8)
LastUpdate date
EmName char(25)
Gender int(1)
Dept. int(3)
Social Insurance Number int(9)
Address char(51)
Date data type is 3 bytes -- 17 bits for the year (0-9999), 4 bits for the
month (1-12) and 5 bits for the day (1-31). Each file is stored as a text
file, and each tuple is of size 100 bytes, stored as a separate
line/record/row in the file. Suppose each block is of size 4K and holds
40 tuples. Furthermore, the blocks of each file is stored in consecutive
disk blocks. The various components of a tuple are not separated by any
symbol, but rather by the size of the data type. An example of a tuple in
these files is as follows (but would be on a single line):
1234567820200124John 12223333333331455 Maisonneuve
West, Montreal, QC, H3G 1M8, Canada
Each of these files could have duplicated Employee IDs. So in this
application, we say tuples t1 and t2 are duplicated if they have the same
EmpID. (Note that this definition is different from what the standard case
where t1 and t2 are duplicates if they are identical on every attribute).
A tuple could have any number of duplicates. In this project, you and your
team are required to merge these two files and eliminate the duplicates
as follows: for all duplicates of a tuple t, keep the one updated most
recently and eliminate any other duplicates. For this task, implement the
TPMMS method to sort T1 and T2 first, and then identify and eliminate the
duplicates in the merge phase. Report the number of output tuples, the
number of blocks holding these tuples, and the total number of disk I/O’s
and time used to perform the task. Do not bother writing the final output
back to the disk.You need to evaluate the performance of your implementation using large
instances of T1 and T2. The lab instructors will use instances of T1 and
T2 which you can use to test and evaluate the performance. Your report should
include the test results, at least on these instances. You may include
additional test results using the instances created by your team.
To further evaluate the performance of your implementation, consider
instances of T1 and T2 at around 500,000 and 1,000,000 tuples, respectively.
Study the performance of your implementation in the following two cases
of restricted main memory available: (1) 10 MB and (2) 20 MB.
Run the experiments in each of these two cases and report the following:
• Compare the number of disk I/O’s and the execution time, in seconds,
for the sort operations given in each case of the two main memory
sizes. This should include the time to write the sorted data back to
the disk.
• Compare the number of disk I/O’s and the execution time for performing
the whole task in each case of main memory sizes.
What tools you should use?
Use VM argument Xmx5m in Eclipse to restrict the main memory sizes in Java
Virtual Machine.
What to submit by the due date?
Through Moodle, submit your report (in a single PDF format) and the source
codes (a single zip file). This also includes instruction to compile and
run your code. Make sure your program compiles and runs on the computers
in the labs H-903 and H-907 assigned to the course.
Demos: Book a time slot with the lab assistants for the demo of your project
on Feb. 19th. Each member of a team must be present in their project demo.
Bonus: The lab instructors may recommend additional 2 points
for the implementation with the best performance and
additional 1 point for the next best.
