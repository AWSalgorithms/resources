import java.util.*;

class BinarySearch {

  public BinarySearch() {

  }
  //method for generating random numbers
  private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

  public void search(ArrayList<Integer> s, int key) {
    int mid = s.size()/2;
    if (key == s.get(mid)) {
      System.out.println("Found key");
    }
    if (key > s.get(mid)) {
      s.subList(0,mid + 1).clear();
      this.search(s, key);
    }
    if (key < s.get(mid)) {
      s.subList(mid,s.size()).clear();
      this.search(s, key);
    }

  }

  //main method
  public static void main(String[] args) {

    System.out.println("Welcome! This is a Binary search.");
    ArrayList<Integer> mylist = new ArrayList<Integer>();

    //for loop generates sorted numbers
    for (int i = 0; i < 100; i++) {
      mylist.add(i);
    }
    //print sorted list
    System.out.println("My list: ");
    System.out.println(Arrays.toString(mylist.toArray()));

    //Linear search time
    int key = 3;
    BinarySearch b = new BinarySearch();

    //start time
    double start = System.nanoTime();

    //run the search
    b.search(mylist, key);
    //end time and print
    double finish = System.nanoTime();
    double t = (finish - start);
    System.out.print(t);
    System.out.println(" nanoseconds");
  }

}
