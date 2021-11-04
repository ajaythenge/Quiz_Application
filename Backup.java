/*
import java.util.Scanner;
import java.util.Random;
import java.io.*;

class Quiz {
    static Scanner scan = new Scanner(System.in);
    static BufferedReader bf;
    static {
        try {
            bf = new BufferedReader(new FileReader("xyz.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static int question_no = 1;
    static int index = 0;
    static int marks=0;

    String question;
    String option1;
    String option2;
    String option3;
    String option4;
    String correct_option;
    int que;

    static Quiz[] questionSet = new Quiz[10];

    Quiz(String question, String option1, String option2, String option3, String option4, String correct_option) throws FileNotFoundException {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correct_option = correct_option;
        this.que = this.question_no;
        question_no++;
        index++;
    }

    void showQuestion() {
        System.out.println("Q." + this.que + ". " + this.question);
        System.out.println();
        System.out.println("a) " + this.option1);
        System.out.println("b) " + this.option2);
        System.out.println("c) " + this.option3);
        System.out.println("d) " + this.option4);
        System.out.println();
    }

    void checkAns(char ch)
    {
        String ans="";
        switch(ch)
        {
            case 'a':
            case 'A':
            {
                ans = this.option1;
                break;
            }
            case 'b':
            case 'B':
            {
                ans = this.option2;
                break;
            }
            case 'c':
            case 'C':
            {
                ans = this.option3;
                break;
            }
            case 'd':
            case 'D':
            {
                ans = this.option4;
                break;
            }
            default:
            {
                System.out.println("Invalid Answer");
            }
        }
        if(ans.equals(this.correct_option))
        {
            System.out.println("Correct Answer");
            marks++;
        }
        else
        {
            System.out.println("Wrong Answer..");
            System.out.println("Correct Answer is : " + this.correct_option);
        }

    }

    public static void main(String[] args) throws IOException
    {
        String line1 = "";
        while ( line1 != null )
        {
            line1 = bf.readLine();
            String line2 = bf.readLine();
            String line3 = bf.readLine();
            String line4 = bf.readLine();
            String line5 = bf.readLine();
            String line6 = bf.readLine();
            bf.readLine();
            questionSet[index] = new Quiz(line1, line2, line3, line4, line5, line6);
        }

        for (int i = 0; i <index-1 ; i++)
        {
            questionSet[i].showQuestion();
            System.out.print("Enter your option : ");
            char ans = scan.next().charAt(0);
            questionSet[i].checkAns(ans);
        }

    }
}

*/
