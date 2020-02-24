import java.util.*;

class LinearSearch {

  //method for generating random numbers
  private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

  //main method
  public static void main(String[] args) {

    System.out.println("Welcome! This is a linear search.");
    ArrayList<Integer> mylist = new ArrayList<Integer>();

    //for loop generates random numbers
    for (int i = 0; i < 6; i++) {
      mylist.add(getRandomNumberInRange(1,10));
    }

    //print unsorted list
    System.out.println("My list: ");
    System.out.println(Arrays.toString(mylist.toArray()));

    //Linear search time
    int key = 3;
    int max = 0;
    int min = 999999999;

    //start time
    double start = System.nanoTime();

    //for loop to go through all elements in list
    for (int i = 0; i < mylist.size(); i++) {
      if (key == mylist.get(i)) {
        System.out.println("Found key!");
      }
      if (mylist.get(i) > max) {
        max = mylist.get(i);
      }
      if (mylist.get(i) < min) {
        min = mylist.get(i);
      }
    }
    //print results of search
    System.out.print("max: ");
    System.out.println(max);
    System.out.print("min: ");
    System.out.println(min);

    //end time and print
    double finish = System.nanoTime();
    double t = (finish - start);
    System.out.print(t);
    System.out.println(" nanoseconds");
  }

}
