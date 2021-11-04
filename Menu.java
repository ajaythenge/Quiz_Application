import java.io.IOException;
import java.util.Scanner;

class Menu
{
    static Scanner scan = new Scanner(System.in);

    static void mainMenu()
    {
        System.out.println("Select Your Exam Type ");
        System.out.println();
        System.out.println("1. MCQ Type Mock Exam");
        System.out.println("2. Practice Exam");
        System.out.println("3. Oral Exam");
        System.out.println("4. Quit");
    }

    static String selectSubject()
    {
        System.out.println("Select The Subject");
        System.out.println();
        System.out.println("1. Core Java");
        System.out.println("2. Operating System");
        System.out.println("3. Data Structure");
        System.out.println("4. All Subject Mixed");
        System.out.println();
        System.out.print("Enter Your Choice : ");
        int choice = scan.nextInt();
        System.out.println();
        String subject = "";
        switch (choice)
        {
            case 1: subject = "core_java.txt";
                break;
            case 2: subject = "os.txt";
                break;
            case 3: subject = "data_structure.txt";
                break;
            case 4:
            default: subject = "xyz.txt";
        }
        return subject;
    }

    static void selectExam() throws IOException {
        System.out.println();
        System.out.print("Enter Your Choice : ");
        int choice = scan.nextInt();
        switch (choice)
        {
            case 1:
            {
                Quiz.createMCQTest();
                break;
            }
        }
    }


    public static void main(String[] args) throws IOException
    {
        mainMenu();
        selectExam();
        Quiz.showResult();
    }
}
