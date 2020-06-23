import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {


	public static void main(String[] args) throws IOException {

		System.out.println("The Main Memory size is: "+Config.AVAILABLE_MEMORY+" B");
		System.out.println("Main Memory usage: "+Config.MEMORY_USAGE);

		File file_T1 = new File(Config.SAMPLE);
		File file_T2 = new File(Config.SAMPLE_LA);
		
		long nano_startTime = System.nanoTime(); 
		ArrayList<File> subFiles1 = TPMMSort.phaseOne(file_T1);
		int COUNT_START_TUPLES_T1=Config.COUNT_START_TUPLES;

		ArrayList<File> subFiles2 = TPMMSort.phaseOne(file_T2);
		int COUNT_START_TUPLES_T2=Config.COUNT_START_TUPLES;
		

		//ArrayList<File> subFiles2 = TPMMSort.phaseOne(file_T2);			
		File filea = new File("file1_sorted");
		File fileb = new File("file2_sorted");

		//File filec = 
		TPMMSort.phaseTwo(subFiles1,filea);
		//File filed = 
		TPMMSort.phaseTwo(subFiles2,fileb);

		
		ArrayList<File> merge_file = new ArrayList<File>();
		merge_file.add(filea);
		merge_file.add(fileb);
		
		File final_merge = new File("merged_text");
		//File final_file = 
		TPMMSort.phaseTwo(merge_file, final_merge);
		long nano_endTimeSort = System.nanoTime(); 
		File final_file = new File("final_file");
		TPMMSort.mergeAndRemoveDuplicateID(final_merge,final_file);
		long nano_endTime = System.nanoTime(); 
		
		/*File file = new File("merge.txt");
		File file_test = new File("testresult.txt");
		TPMMSort.mergeAndRemoveDuplicateID(file,file_test);	
		
		*/

		//calculate the I/O of input in pass one
		int sublist_num_T1=(int)Math.ceil(COUNT_START_TUPLES_T1/Config.MAX_TUPLE_NUMBER);
		int sublist_num_T2=(int)Math.ceil(COUNT_START_TUPLES_T2/Config.MAX_TUPLE_NUMBER);
		int IO_input_passOne=sublist_num_T1+sublist_num_T2;
		
		//calculate the I/O of output in pass one
		int IO_output_passOne=IO_input_passOne;
		
		//calculate the I/O of input in pass two		
		int temp=(int)Math.ceil(Config.MAX_TUPLE_NUMBER/Config.TUPLES_IN_BLOCK);
		int remainingTupleQty=COUNT_START_TUPLES_T1%(int)Config.MAX_TUPLE_NUMBER;
		int IO_T1_Input_PassTwo=(sublist_num_T1-1)*temp+(int)Math.ceil(remainingTupleQty/Config.TUPLES_IN_BLOCK);
		
		int temp2=(int)Math.ceil(Config.MAX_TUPLE_NUMBER/Config.TUPLES_IN_BLOCK);
		int remainingTupleQty2=COUNT_START_TUPLES_T2%(int)Config.MAX_TUPLE_NUMBER;
		int IO_T2_Input_PassTwo=(sublist_num_T2-1)*temp+(int)Math.ceil(remainingTupleQty2/Config.TUPLES_IN_BLOCK);
		
		int IO_input_passTwo=IO_T1_Input_PassTwo+IO_T2_Input_PassTwo;
		
		//calculate the I/O of output in pass two
		int IO_output_passTwo=(int)Math.ceil((COUNT_START_TUPLES_T1+COUNT_START_TUPLES_T2)/Config.TUPLES_IN_BLOCK);
		
		//calculate the I/O of input in merging two files
		int IO_iuput_mergeFiles=(int)Math.ceil(COUNT_START_TUPLES_T1/Config.TUPLES_IN_BLOCK)+(int)Math.ceil(COUNT_START_TUPLES_T2/Config.TUPLES_IN_BLOCK);
		
		//calculate the I/O of output in merging two files
		int IO_output_mergeFiles=(int)Math.ceil(Config.COUNT_END_TUPLES/Config.TUPLES_IN_BLOCK);
		
		System.out.println("");
		System.out.println("The number of input tuples: "+(COUNT_START_TUPLES_T1+COUNT_START_TUPLES_T2));
		System.out.println("The number of output tuples: "+Config.COUNT_END_TUPLES);
		System.out.println("The number of duplicated tuples: "+(Config.COUNT_START_TUPLES-Config.COUNT_END_TUPLES));
		System.out.println("");
		System.out.println("The execution time (sort operation) is: "+(nano_endTimeSort-nano_startTime)/(1000000000)+" seconds.");
		System.out.println("The execution time (total task) is: "+(nano_endTime-nano_startTime)/(1000000000)+" seconds.");
		System.out.println("");		
		System.out.println("The number of I/O (sort operation): "+(2*IO_input_passOne+IO_input_passTwo+IO_output_passTwo));
		System.out.println("The number of I/O (whole task): "+(2*IO_input_passOne+IO_input_passTwo+IO_output_passTwo+IO_iuput_mergeFiles+IO_output_mergeFiles));
    } 


}
