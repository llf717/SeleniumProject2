package utility;

public class Contants {

	public static final int column = 1; //变量前面加final，说明该变量为常量，赋值之后不可再修改
	public static final int keycolumn = 0;
//	public static final String filepath = "E:\\workspaces\\SeleniumProject2\\src\\testdata\\"; //绝对路径
	public static final String filepath = System.getProperty("user.dir") + "\\src\\testdata\\"; //user.dir项目路径
	public static final String filename = "Exceldata.xlsx";
	public static final String csvFilename = "Exceldata.csv";
	public static final String sheetname = "Login";
	public static final String sheetname2 = "办公用品登记";
	
}
