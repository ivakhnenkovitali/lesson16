import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        final int SIZE = 10;
        int[] arr1 = new int[SIZE];

        int d1 = -50, d2 = 50;
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (int) (Math.random() * (d2 - d1 + 1) + d1);
        }

        //File io        Path  Files  nio
        final String FILE_NAME = "src/array.txt";
        //File file = new File(FILE_NAME);


        System.out.println(Arrays.toString(arr1));
        //try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File(FILE_NAME))))
        //если такого файла не было, то поток вывода его сосздаст
        //если такой файл был, то поток ввода перезапишет его содержимое
        //BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))
        //при наличии true будет осуществлена дозапись в конец файла

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (int elem : arr1) {
                bw.write(elem * 2 + " ");
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }

        int[] arr2 = new int[arr1.length];
        int index = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {

            String fileLine = br.readLine().trim();
            String[] elems = fileLine.split(" ");
            for (String elem : elems) {
                int x = Integer.parseInt(elem);
                if (x > 0) {
                    arr2[index++] = x;
                }
            }

        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        arr2 = Arrays.copyOf(arr2, index);
        System.out.println(Arrays.toString(arr2));
    }
}
