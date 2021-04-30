import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String []args){
        ArrayList<Integer> list = new ArrayList<>();


        int size = Integer.parseInt(args[0]);
        String report = args[1];
        String usort = args[2];
        String sort = args[3];
        list = QuickSorter.generateRandomList(size);
        ArrayList<Integer> list2 = list;
        ArrayList<Integer> list3 = list;
        ArrayList<Integer> list4 = list;
        try {
            FileWriter myWriter = new FileWriter(usort);
            FileWriter ReportWrite = new FileWriter(report);
            FileWriter sortWrite = new FileWriter(sort);
            for(int i = 0; i < size -1; i++){
                myWriter.write(String.valueOf(list.get(i)) + "\n");
            }
            myWriter.close();
            ReportWrite.write("Array Size = " + size + "\n\n");
            ReportWrite.write("FIRST_ELEMENT : " + QuickSorter.timedQuickSort(list, QuickSorter.PivotStrategy.FIRST_ELEMENT).toString() + "\n\n");
            ReportWrite.write("RANDOM_ELEMENT : " + QuickSorter.timedQuickSort(list2, QuickSorter.PivotStrategy.RANDOM_ELEMENT).toString() + "\n\n");
            ReportWrite.write("MEDIAN_OF_THREE_RANDOM_ELEMENTS : " + QuickSorter.timedQuickSort(list3, QuickSorter.PivotStrategy.MEDIAN_OF_THREE_RANDOM_ELEMENTS).toString() + "\n\n");
            ReportWrite.write("MEDIAN_OF_THREE_ELEMENTS : " + QuickSorter.timedQuickSort(list4, QuickSorter.PivotStrategy.MEDIAN_OF_THREE_ELEMENTS).toString() + "\n\n");
            ReportWrite.close();
            for(int i = 0; i < size -1; i++){
                sortWrite.write(String.valueOf(list4.get(i)) + "\n");
            }
            sortWrite.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
