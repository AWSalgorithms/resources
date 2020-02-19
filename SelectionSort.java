//Selection Sort Algorithm by Mr. Considine

//imports allow us to use code from libraries
//that we did not have access to originally

import java.util.Random;
import java.util.*;

//every java program has a "Class"
//class is always the name of the file
//java is an object-oriented design language
//class defines how to build the "object"

class SelectionSort {

  //constructor method has the same name as
  //the class
  //defines how we build the class object
  public SelectionSort() {

  }

  // selection sort method
  // takes an Arraylist as input for the method
  // outputs an Arraylist
  // variable name "l" given to input
  // no variable name needed for output
  public ArrayList<Integer> sort(ArrayList<Integer> l) {

    // "for" is a repetitive loop
    // repeat for l.size() times = n times
    // start at i = 0
    // stop at i = n
    // every time repeat add 1 more to i
    for (int i = 0; i < l.size(); i++) {

      int min = 10000000;
      int minI = 0;
      for (int j = i; j < l.size(); j++) {
        if (l.get(j) < min) {
          min = l.get(j);
          minI = j;
        }
      }
      int temp = l.get(i);
      l.set(i, min);
      l.set(minI, temp);
    }
    return l;
  }

  private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

  public static void main(String[] args) {

    SelectionSort s = new SelectionSort();

    ArrayList<Integer> mylist = new ArrayList<Integer>();

    for (int i = 0; i < 50000; i++) {
      mylist.add(getRandomNumberInRange(1,100000));
    }

    System.out.println("Unsorted: ");
    System.out.println(Arrays.toString(mylist.toArray()));
    double start = System.nanoTime();

    System.out.println("Sorted: ");
    System.out.println(Arrays.toString(s.sort(mylist).toArray()));

    double finish = System.nanoTime();
    double t = (finish - start) / 1000000000;
    System.out.print(t);
    System.out.println(" seconds");

  }
}
