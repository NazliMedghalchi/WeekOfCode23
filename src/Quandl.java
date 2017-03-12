import sun.awt.image.ImageWatched;

import javax.print.DocFlavor;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;
import java.util.Scanner;
/**
 * Created by Nazli on 2017-01-11.
 */

/**
 * Algorithm:
 * Add all datasets into one dataset then sort the new list
 * Create hashtable of new list in descending order
 * check if every list has the key add the value
 * otherwise add null
 * */

/***
 * README:
 * To run the code download 3 input .csv files into the "/Users/username/Downloads"
 * This will create a file under same dir (under /Downloads) as mergeData.csv
 * It takes time for running (downside) - run time is long for the scope of program
 * Meantime reading datasets, it outputs in standard output
 *
 * Methods:===========
 * mergeData: first merges all datasets into one linkedlist
 *            then sorts the final linkedlist and returns the linkedlist
 * merge: checks each element from mergeData into each original dataset
 *        if it exsits adds the value otherwise adds 0
 * */

public class Quandl {

//    Every dataset is considered as an object of class "node"

    public class Node {
        String date;
        String value;
        public Node(String date, String value) {
            this.date = date;
            this.value = value;
        }

    }

    public Quandl() {}

    // Merge data sets based on decreasing order of dates
    public LinkedList<String> mergeData (LinkedList<String> d1, LinkedList<String> d2, LinkedList<String> d3) throws IOException {


        LinkedList<String> allDates = new LinkedList<String>();

        while (!d1.isEmpty() && !d2.isEmpty() && !d3.isEmpty()){
            /* take date as string and compare strings
                sort arrayLists of dates in descending order
                ideally sort strings by encoding strings */
            for (int i = 0; i<d1.size(); i++)
                allDates.add(d1.get(i));
//            for (int i = 0; i<d2.size(); i++)
//                allDates.add(d2.get(i));
//            for (int i = 0; i<d3.size(); i++)
//                allDates.add(d3.get(i));
        }

        LinkedList<String> sorted = sortDates(allDates);
        return sorted;
    }

    public LinkedList<String> sortDates ( LinkedList<String> date) {
        if (date.isEmpty()) return new LinkedList<>();
        String[] year = new String[date.size()];
        String split = "-";
        LinkedList<String> sorted = new LinkedList<>();
        int i =0;
        for (String s : date){
            year[i] = String.valueOf(s.split(split)[0]);
        }
        Arrays.sort(year, Comparator.reverseOrder());
        int j = 0;
        for (String s : year){
            sorted.add(s);
        }
        return sorted;
    }


    public Hashtable<String, LinkedList<String>> merge (Hashtable<String, LinkedList<String>> records,
                                                        LinkedList<String> d1, LinkedList<String> d2, LinkedList<String> d3,
                                                        ArrayList<Node> data1, ArrayList<Node> data2, ArrayList<Node> data3,
                                                        LinkedList<String> sorted) {
        /* Merge 3 lists into 1 then sort using sort method
         * Add to final table as records */


        int j = 0;
        while (!sorted.isEmpty()){
            records.put(sorted.get(j), new LinkedList<>());
        }

        int start = 0;
        LinkedList<String> values = new LinkedList<String>();
        while (!d1.isEmpty()){
            String key = d1.poll();
            if (sorted.contains(key)){
                values.offer(data1.get(start).value);
                records.put(key, values);
            }
            values.offer("0");
            records.put(key, values);

            String key2 = d2.poll();
            if (sorted.contains(key2)){
                values.offer(data2.get(start).value);
                records.put(key2, values);
            }
            values.offer("0");
            records.put(key2, values);

            String key3 = d3.poll();
            if (sorted.contains(key3)){
                values.offer(data3.get(start).value);
                records.put(key3, values);
            }
            values.offer("0");
            records.put(key, values);

            start++;
        }

        return records;
    }


    public LinkedList<String>  mergeSort (LinkedList<String> d, int leftInd, int rightInd, LinkedList<String> list){

        int i=0;
        while (list.isEmpty()){
            list.add(d.get(i));
            i++;
        }
        if (leftInd > rightInd) {return list;}
        if (d.size() == 2) {
            for (int j = 0; j+1 <2; j++) {
                if (list.get(j).compareTo(list.get(j+1)) > 0) {
                    String temp = list.get(j);
                    list.add(j, list.get(j + 1));
                    list.add(j+1, temp);
                }
            }
            return list;
        }

        int mid = (rightInd + leftInd)/2;
        // left side
        mergeSort(d, leftInd, mid, list);
        // right side
        mergeSort(d,mid+1, rightInd, list);
        return list;
    }

    public LinkedList<String> readFile(String fileName, ArrayList<Node> dataset) throws IOException {

        File file = new File(fileName);
        String spliter = ",";
        String line = null;

        // list is list of dates from every dataset
        LinkedList<String> list = new LinkedList<String>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            Scanner scan = new Scanner(bufferedReader);
//            System.out.print(scan.nextLine());
            scan.nextLine();
            while (scan.hasNextLine()) {
                line = scan.nextLine();
//                line = bufferedReader.readLine();
                System.out.println(line);
                String[] r = line.split(spliter);
                list.add(r[0]);
                Node node = new Node(r[0], r[1]);
                dataset.add(node);
            }
            bufferedReader.close();
        }catch (NullPointerException e ) {System.out.print(e);}

//        scan.close();
        return list;
    }

    public void writeFile(Hashtable<String, LinkedList<String>> entire) throws IOException {

        StringBuilder sb = new StringBuilder();
        String spliter = ",";

        String filename = "mergeData.csv";
        Charset charset = Charset.forName("US-ASCII");
        String homeAddress = System.getProperty("user.home");
        String outputFolder = homeAddress + File.separator + "Desktop" + File.separator + filename;
        Path path = FileSystems.getDefault().getPath(outputFolder);

        File file = new File(outputFolder);
        if(!file.exists()){
            file.mkdir();
        }

        BufferedWriter bufferedWriter1 = null;
        try{
            FileWriter fileWriter = new FileWriter(file);
            bufferedWriter1 = new BufferedWriter(fileWriter);
            while (!entire.isEmpty()) {
                for (String key : entire.keySet()) {
                    sb.append(entire.get(key));
                    sb.append(spliter);
                    sb.append(String.valueOf(entire.get(key)));
                    sb.append('\n');
                    System.out.print(sb.toString());
                    bufferedWriter1.write(sb.toString());
                }
            }
        }catch (IOError e ){
            System.out.println(e);
        }
        bufferedWriter1.flush();
        bufferedWriter1.close();

    }


    public static void main (String[] args) throws IOException {

        String homeAddress = System.getProperty("user.dir");
        String outputFolder = homeAddress + File.pathSeparator + "Desktop" + File.pathSeparator + "inter_mergData";
        Hashtable<String, LinkedList<String>> hash = new Hashtable<>();
        String address = System.getProperty("user.home") + "/Downloads/";

        String fileName1 = address + "SERGEI-INTER_1.csv";
        String fileName2 = address + "SERGEI-INTER_2.csv";
        String fileName3 = address + "SERGEI-INTER_3.csv";
        Quandl q = new Quandl();

        ArrayList<Node> data1 = new ArrayList<Node>();
        ArrayList<Node> data2 = new ArrayList<>();
        ArrayList<Node> data3 = new ArrayList<>();
        q.writeFile(hash);

        try {
            LinkedList<String> d1 = q.readFile(fileName1, data1);
            LinkedList<String> d2 = q.readFile(fileName2, data2);
            LinkedList<String> d3 = q.readFile(fileName3, data3);
            long heapSize = Runtime.getRuntime().totalMemory();
            System.out.println("Heap Size = " + heapSize);
            LinkedList<String> sorted = q.mergeData(d1, d2, d3);
            hash = q.merge(hash, d1, d2, d3, data1, data2, data3, sorted);
            q.writeFile(hash);

            System.out.print("End of program ... ");
        }catch (FileNotFoundException e){System.out.print(e);}


    }
}