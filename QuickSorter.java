import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;

public class QuickSorter {
     enum PivotStrategy{
         FIRST_ELEMENT,
         RANDOM_ELEMENT,
         MEDIAN_OF_THREE_RANDOM_ELEMENTS,
         MEDIAN_OF_THREE_ELEMENTS

    }
     public static <E extends Comparable<E>>Duration timedQuickSort (ArrayList<E> list, PivotStrategy pivotStrategy) throws NullPointerException{
         Duration time;
         Duration start = Duration.ofNanos(java.lang.System.nanoTime());
         QuickSort(list,0,list.size() -1, pivotStrategy);
         Duration end = Duration.ofNanos(java.lang.System.nanoTime());
         time = end.minus(start);
         return time;
     }

     public static ArrayList<Integer> generateRandomList(int size)throws IllegalArgumentException{
        if(size < 0)
            throw new IllegalArgumentException();
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();

        for(int i = 0; i < size; i++){
            list.add(random.nextInt());
        }
        return list;
     }

    public static <E extends Comparable<E>> void QuickSort(ArrayList<E> list, int low, int high, PivotStrategy pivotStrategy){
        if (low < high)
        {
            int pi = partition(list, low, high, pivotStrategy);
            QuickSort(list, low, pi - 1, pivotStrategy);
            QuickSort(list, pi + 1, high, pivotStrategy);
        }

    }

    public static <E extends Comparable<E>> int partition(ArrayList<E> list, int low, int high, PivotStrategy pivotStrategy){

         E pivot = null;
         int index = 0;
         if(pivotStrategy == PivotStrategy.FIRST_ELEMENT){
            pivot = list.get(low);
            index = low;
         }
         else if( pivotStrategy == PivotStrategy.RANDOM_ELEMENT){
             Random r = new Random();
             int bottom = low;
             int top = high;
             int result = r.nextInt(top-bottom) + bottom;
             pivot = list.get(result);
             index = result;
         }
         else if(pivotStrategy == PivotStrategy.MEDIAN_OF_THREE_RANDOM_ELEMENTS){
             Random r = new Random();
             int bottom = low;
             int top = high;
             int r1 = r.nextInt(top-bottom) + bottom;
             int r2 = r.nextInt(top-bottom) + bottom;
             int r3 = r.nextInt(top-bottom) + bottom;
             assert r1 <= high && r1 >= low;
             assert r2 <= high && r2 >= low;
             assert r3 <= high && r3 >= low;
             int med = 0;
             if(list.get(r1).compareTo(list.get(r2)) <= 0 && list.get(r2).compareTo(list.get(r3)) <= 0) {med = r2;}
             if(list.get(r3).compareTo(list.get(r2)) <= 0 && list.get(r2).compareTo(list.get(r1)) <= 0) {med = r2;}
             if(list.get(r1).compareTo(list.get(r3)) <= 0 && list.get(r3).compareTo(list.get(r2)) <= 0) {med = r3;}
             if(list.get(r2).compareTo(list.get(r3)) <= 0 && list.get(r3).compareTo(list.get(r1)) <= 0) {med = r3;}
             if(list.get(r2).compareTo(list.get(r1)) <= 0 && list.get(r1).compareTo(list.get(r3)) <= 0) {med = r1;}
             if(list.get(r3).compareTo(list.get(r1)) <= 0 && list.get(r1).compareTo(list.get(r2)) <= 0) {med = r1;}
             pivot = list.get(med);
             index = med;
         }
         else if(pivotStrategy == PivotStrategy.MEDIAN_OF_THREE_ELEMENTS){
             int r1 = high/2;
             int r2 = high;
             int r3 = low;
             int med = 0;
             if(list.get(r1).compareTo(list.get(r2)) <= 0 && list.get(r2).compareTo(list.get(r3)) <= 0) {med = r2;}
             if(list.get(r3).compareTo(list.get(r2)) <= 0 && list.get(r2).compareTo(list.get(r1)) <= 0) {med = r2;}
             if(list.get(r1).compareTo(list.get(r3)) <= 0 && list.get(r3).compareTo(list.get(r2)) <= 0) {med = r3;}
             if(list.get(r2).compareTo(list.get(r3)) <= 0 && list.get(r3).compareTo(list.get(r1)) <= 0) {med = r3;}
             if(list.get(r2).compareTo(list.get(r1)) <= 0 && list.get(r1).compareTo(list.get(r3)) <= 0) {med = r1;}
             if(list.get(r3).compareTo(list.get(r1)) <= 0 && list.get(r1).compareTo(list.get(r2)) <= 0) {med = r1;}
             pivot = list.get(med);
             index = med;
         }
        E temp = list.get(high);
        list.set(high, list.get(index));
        list.set(index, temp);

        int i = (low - 1);

        for(int j = low; j <= high - 1; j++)
        {
            if (list.get(j).compareTo(pivot) < 0)
            {
                i++;
                E temp2 = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp2);
            }
        }
        E temp3 = list.get(i+1);
        list.set(i+1, list.get(high));
        list.set(high, temp3);
        return (i + 1);

    }
}
