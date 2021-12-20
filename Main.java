import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc;

    public static void main(String[] args) {
        System.out.println("IbraTech File Tree Extractor");
        System.out.println(
                "This script will extract all files from a given directory and its subdirectories into one folder\n");
        System.out.println(
                "Disclaimer: No warranties accompany this script, whether stated explicitly or implicitly. Usage of this product is at the user's own risk. The owner does not provide supervision and cannot be held liable for any damage caused. Through the utilization of this script, you acknowledge and accept the inherent risks posed by a product composed by a 17-year-old in 15 minutes.\n");
        System.out.println();
        // Ask user to agree to terms
        System.out.println("Do you agree to the terms and conditions? (y/n)\n");
        sc = new Scanner(System.in);
        String ans = sc.nextLine();
        if (ans.equals("y")) {
            // take source path from user
            System.out.println("Enter the source path");
            String sourceText = sc.nextLine();
            // check if file exists
            File source = new File(sourceText);
            while (!source.exists() || source.isFile()) {
                System.out.println("Path does not exist. Try again");
                System.out.println("Enter the source path");
                sourceText = sc.nextLine();
                source = new File(sourceText);
            }
            System.out.println("Enter the destination path");
            String destinationText = sc.nextLine();
            // check if file exists
            File destination = new File(destinationText);
            while (!destination.exists()) {
                System.out.println("Path does not exist. Would you like to create a new file? (y/n)");
                ans = sc.nextLine();
                if (ans.equals("y")) {
                    try {
                        Files.createFile(destination.toPath());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Enter the destination path");
                    destinationText = sc.nextLine();
                    destination = new File(destinationText);
                }
            }

            System.out.println("Starting extraction...");

            transferFiles(destination, source);

            System.out.println("Extraction complete");
        } else {
            System.out.println("Exiting...");
            System.exit(0);
        }
    }

    static void transferFiles(File saveDirectory, File currentDirectory) {
        ArrayList<String> paths = new ArrayList<String>();
        try {
            Files.list(currentDirectory.toPath())
                    .forEach(path -> {
                        paths.add(path.toString());
                    });

            for (String path : paths) {
                File file = new File(path);
                if (file.isDirectory()) {
                    System.out.println("New Folder Found!: " + path);
                    transferFiles(saveDirectory, new File(path));
                }
            }

            File[] files = currentDirectory.listFiles();

            for (File file : files) {
                if (!file.isDirectory()) {
                    System.out.println("New File Found!: " + file.getName());
                    File destination = new File(saveDirectory.getAbsolutePath() + System.getProperty("file.separator")
                            + currentDirectory.getName() + " " + file.getName());
                    // check if destination file exists
                    if (destination.exists()) {
                        // Ask user if they want to overwrite or rename
                        System.out.println(
                                "File already exists in output directory. Would you like to overwrite or rename? (o/r)");
                        String answer = sc.nextLine();
                        if (answer.equals("o")) {
                            destination.delete();
                        } else {
                            System.out.println("Enter a new name");
                            String newName = sc.nextLine();
                            destination = new File(saveDirectory.getAbsolutePath()
                                    + System.getProperty("file.separator") + currentDirectory.getName() + " " + newName
                                    + getFileExtension(destination));
                        }
                    }
                    System.out.println("Copying file: " + file.getName());
                    Files.copy(file.toPath(), destination.toPath());
                } else {
                    System.out.println("Folder detected: " + file.getName() + " Already copied. Skipping....");
                }

            }
        } catch (IOException e) {
            System.out.println("Something went wrong: \n" + e + "\nPlease report this issue to IbraTech04 on GitHub");
            System.out.println("Would you like to contiue or exit? (c/e)");
            String answer = sc.nextLine();
            if (answer.equals("c")) {
                System.out.println("Continuing...");
            } else {
                System.out.println("Exiting...");
                System.exit(0);
            }
        }
    }

    public static String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return "." + fileName.substring(fileName.lastIndexOf(".") + 1);
        else
            return "";
    }
}