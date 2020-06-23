
public class Config {
	
	public static final String TEMPPATH = "/TempFile/";

	public static final String FILE_T1 = "T1.txt";
	public static final String FILE_T2 = "T2.txt";
	public static final String SAMPLE = "sample.txt";
	public static final String SAMPLE1 = "sample1.txt";
	public static final String SAMPLE_LA = "LA1-DS1.txt";

	public static final String outputFileT1 = "sortedT1.txt";
	public static final String outputFileT2 = "sortedT2.txt";
	//main memory size 10mb
	//public static final int MAIN_MEMORY_SIZE = 10485760;
	public static final long AVAILABLE_MEMORY = Runtime.getRuntime().freeMemory();
	public static int COUNT_START_TUPLES=0;
	public static int COUNT_END_TUPLES=0;
	
	public static final double MEMORY_USAGE=0.314;
	public static final long TUPLE_SIZE = 100;
	public static final int TUPLES_IN_BLOCK = 40;
	public static final int BLOCK_SIZE = 4000;
	//manually set the number of tuples in each chunk
	public static final int TUPLES_IN_CHUNKS = 250*TUPLES_IN_BLOCK;
	public static final int EMPID_LEN = 8;
	public static final int LASTUPDATE_LEN = 10;
	// how many tuple can store in main memory
	public static final long MAX_TUPLE_NUMBER=(long)(AVAILABLE_MEMORY*MEMORY_USAGE ) / TUPLE_SIZE;

}
