package programming193;

/*
Author: Alex Manley 
Date: 7/13/22 
 */
import java.util.ArrayList;
public class Exercise19_03 {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(14);
    list.add(24);
    list.add(14);
    list.add(42);
    list.add(25);
    
    ArrayList<Integer> newList = removeDuplicates(list);
    
    System.out.print(newList);
  }
  
  public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){
	  ArrayList<E> newList = new ArrayList<>(); 
	  
	  while (list.isEmpty() == false) {
		  newList.add(list.get(0));
		  for (int i = list.size() - 1; i > 0; i--) {
			if (list.get(i) == list.get(0))
				list.remove(i); 
		  	}
		  list.remove(0);
	  }	  
	  return newList; 
	  
  }
}
