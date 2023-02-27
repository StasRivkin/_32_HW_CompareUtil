package telran.compare.controller;

import java.io.FileInputStream;
import java.io.IOException;

public class CompareAppl {
    //To run this application you should open the Terminal in the following folder of the project: /out/artifacts/_32_HW_CompareUtil_jar/;
    //That folder also contains test files to check the app works right: test1, test2, testWrong - where 1 and 2 are the same, and 3 are not;
    //In the Terminal write the command with two arguments, where the arguments will be the name of the file you want to check,
    //like this: "java -jar CompareUtil.jar test1.dat test2.dat";
    //Also, you can check other files, just put them in the folder where the file "CompareUtil.jar" is.
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Wrong numbers of arguments");
            return;
        }
        try (FileInputStream file1 = new FileInputStream(args[0]);
             FileInputStream file2 = new FileInputStream(args[1])) {
            int a = file1.read();
            int b = file2.read();
            if (file1.available() == file2.available()) {
                while ((a != -1 && b != -1) && a == b) {
                    a = file1.read();
                    b = file2.read();
                }
                if ((a == -1 && b == -1)) {
                    System.out.println("You have the same files");
                } else System.out.println("The files aren't the same");
            } else System.out.println("The files aren't the same");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
