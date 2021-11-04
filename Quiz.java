import java.time.LocalTime;
import java.util.Scanner;
import java.io.*;
import static java.time.temporal.ChronoUnit.SECONDS;

class Quiz {
    static int question_no = 1;
    static int index = 0;
    static int marks = 0;

    String question;
    String option1;
    String option2;
    String option3;
    String option4;
    String correct_option;
    int que;
    static int totalNoOfQuestions;
    static LocalTime startTime;
    static int timelimit;

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
        System.out.println();
        System.out.println("Q." + this.que + ". " + this.question);
        System.out.println();
        System.out.println("a) " + this.option1);
        System.out.println("b) " + this.option2);
        System.out.println("c) " + this.option3);
        System.out.println("d) " + this.option4);
        System.out.println();
    }

    void checkAns(char ch) {
        String ans = "";
        switch (ch) {
            case 'a':
            case 'A': {
                ans = this.option1;
                break;
            }
            case 'b':
            case 'B': {
                ans = this.option2;
                break;
            }
            case 'c':
            case 'C': {
                ans = this.option3;
                break;
            }
            case 'd':
            case 'D': {
                ans = this.option4;
                break;
            }
            default: {
                System.out.println("Invalid option");
            }
        }
        if (ans.equals(this.correct_option)) {
            System.out.println("Correct Answer");
            marks++;
        } else {
            System.out.println("Wrong Answer..");
            System.out.println("Correct Answer is : " + this.correct_option);
        }

    }

    static void createMCQTest() throws IOException {

        Scanner scan = new Scanner(System.in);
        BufferedReader bf;

        String fileName = Menu.selectSubject();
        try {
            bf = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            bf = new BufferedReader(new FileReader(fileName));
            e.printStackTrace();
        }
        System.out.print("How many questions you want to solve : ");
        totalNoOfQuestions = scan.nextInt();
        Quiz[] questionSet = new Quiz[60];
        timelimit=totalNoOfQuestions*5;

        String line1 = "";
        while (line1 != null) {
            line1 = bf.readLine();
            String line2 = bf.readLine();
            String line3 = bf.readLine();
            String line4 = bf.readLine();
            String line5 = bf.readLine();
            String line6 = bf.readLine();
            bf.readLine();
            questionSet[index] = new Quiz(line1, line2, line3, line4, line5, line6);
        }

        startTime = LocalTime.now();
        for (int i = 0; i < totalNoOfQuestions; i++) {
            if(timeCheck())
            {
               //System.out.println(timelimit);
                questionSet[i].showQuestion();
                System.out.print("Enter your option : ");
                char ans = scan.next().charAt(0);
                if(timeCheck())
                    questionSet[i].checkAns(ans);
                else
                {
                    System.out.println("Time Is Over...");
                    showResult();
                    break;
                }
            }else
            {
                System.out.println("Time Is Over...");
                showResult();
                break;
            }

        }

    }
    static void showResult()
    {
        System.out.println();
        double percentage = (double)marks/(question_no)*100;
        if(percentage<=40)
            System.out.println("You Failed In The Exam.");
        else
            System.out.println("Congratulation You Have Passed The Exam");

        System.out.println();
        System.out.println("You correctly answered " + marks + " questions out of " + question_no);
        System.out.println();
        System.out.printf("you got %.2f %%", percentage);
        System.out.println();
    }

    static boolean timeCheck()
    {
        LocalTime currentTime = LocalTime.now();
        long  check = SECONDS.between(startTime,currentTime);
        return check<=timelimit;
    }
}