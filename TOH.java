    import java.util.Scanner;

    class TOH{
        static void toh(int n, String start, String inter, String end)
        {
            if(n==1)
                System.out.println("Disk from " + start + " to " + end);
            else{
                toh(n-1,start,end,inter);
                System.out.println("Disk from " + start + " to " + end);
                toh(n-1,inter,start,end);
            }
        }
        public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter number of disks : ");
            int n = sc.nextInt();
            toh(n, "start", "inter", "end");
        }
    }

