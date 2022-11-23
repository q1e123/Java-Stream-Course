import java.io.File;
import java.io.FilenameFilter;

public class Main {

    /*
    * Code taken and modified from the Java Course made by Gabriel Danciu.
    */
    public static void fileDemo(){
        File f1 = new File("/java/COPYRIGHT");
        System.out.println("File Name: " + f1.getName());
        System.out.println("Path: " + f1.getPath());
        System.out.println("Abs Path: " + f1.getAbsolutePath());
        System.out.println("Parent: " + f1.getParent());
        System.out.println(f1.exists() ? "exists" : "does not exist");
        System.out.println(f1.canWrite() ? "is writeable" : "is not writeable");
        System.out.println(f1.canRead() ? "is readable" : "is not readable");
        System.out.println("is " + (f1.isDirectory() ? "" : "not" + " a directory"));
        System.out.println(f1.isFile() ? "is normal file" : "might be a named pipe");
        System.out.println(f1.isAbsolute() ? "is absolute" : "is not absolute");
        System.out.println("File last modified: " + f1.lastModified());
        System.out.println("File size: " + f1.length() + " Bytes");
    }

    public static void directoryDemo(){
        String dirname = "/java";
        File f1 = new File(dirname);
        if (f1.isDirectory()) {
            System.out.println("Directory of " + dirname);
            String s[] = f1.list();
            for (int i = 0; i < s.length; i++) {
                File f = new File(dirname + "/" + s[i]);
                if (f.isDirectory()) {
                    System.out.println(s[i] + " is a directory");
                } else {
                    System.out.println(s[i] + " is a file");
                }
            }
        } else {
            System.out.println(dirname + " is not a directory");
        }
    }

    public static void fileFilterDemo(){
        String dirname = "/java";
        File f1 = new File(dirname);
        FilenameFilter only = new OnlyExt("html");
        String s[] = f1.list(only);
        try{
            for (int i = 0; i < s.length; i++) {
                System.out.println(s[i]);
            }
        } catch (NullPointerException exception){
            System.out.println("No files having that extension were found.");
        }

    }

    public static void main(String[] args) {
        fileDemo();
        directoryDemo();
        fileFilterDemo();
    }
}