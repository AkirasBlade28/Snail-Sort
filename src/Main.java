import java.util.ArrayList;

public class Main  {
	
	public static int length;
	public static int width;
	public static ArrayList<Integer> resultTest;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] array = {{1,2,3,5},
		             	{4,5,6,5},
		             	{7,8,9,5},
		             	{9,0,1,3}};
		
		
		int[] result = Snail.snail(array);
		for(var e: result) System.out.print(e);
	}

	
}
