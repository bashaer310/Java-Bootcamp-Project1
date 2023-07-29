import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        char [][] tictactoe = new char[3][3];
        boolean finished=false;
        int count =0;

        for (int i = 0; i < tictactoe.length; i++)
            for (int j = 0; j <tictactoe[i].length ; j++)
                tictactoe[i][j]=' ';

        do {
            boolean played=false;

            if(count%2==0){
               System.out.println("\nWere would you like to play? (1-9)");
               int num =input.nextInt();
               input.nextLine();
               if (num>=1 & num<=9) {
                   if (add(tictactoe,getIndex(num),'X'))
                   {
                       played=true;
                       printArray(tictactoe);
                       if (checkWin(tictactoe,'X'))
                       {
                           finished=true;
                           System.out.println("\nYou Win!!!");
                       }
                   }
                   else{
                       System.out.println("\n"+num + " is not valid, move ");}
               }else
                System.out.println("\n"+num+" is not valid, please enter again ");
            }
            else{
                int num=(int)(Math.random() * (9 - 1 + 1) + 1);
                if(add(tictactoe,getIndex(num),'O')) {
                    played=true;
                    System.out.println("\nComputer choose "+num);
                    printArray(tictactoe);

                    if(checkWin(tictactoe,'O')){
                        finished=true;
                        System.out.println("\nComputer Wins!");}
                }
            }

            if (played)
                count++;

        }while (finished==false & count !=9);

        if(count==9 & finished==false)
            System.out.println("\nNo one wins ");
    }

    public static int[] getIndex(int num) {

        int[][] numbers={{1,2,3},{4,5,6},{7,8,9}};
        int[] index=new int[2];

    for (int i = 0; i <numbers.length ; i++) {
            for (int j = 0; j < numbers[i].length; j++) {

                if (num == numbers[i][j])
                {
                    index[0]=i;
                    index[1]=j;
                }
            }
        }
        return index;
    }


    public static boolean add(char[][] tictactoe, int[] index, char XO){

        boolean added=false;

     if(tictactoe[index[0]][index[1]]==' '){
         tictactoe[index[0]][index[1]]=XO;
         added=true;
     }
     return added;
    }


    public static boolean checkWin(char[][] tictactoe, char XO){
        boolean win=false;

        for (int i = 0; i < tictactoe.length; i++) {
            //cheek from the rows
            if (((tictactoe[i][0]) & (tictactoe[i][1]) & (tictactoe[i][2]))==XO){
                win =true;
                break;
            }
            //cheek from the columns
            else if (((tictactoe[0][i]) & (tictactoe[1][i]) & (tictactoe[2][1]))==XO){
                win =true;
                break;
            }
        }
        //check from the diagonals
        if (((tictactoe[0][0]) & (tictactoe[1][1]) & (tictactoe[2][2]))==XO)
            win =true;
        else if (((tictactoe[0][2]) & (tictactoe[1][1]) & (tictactoe[2][0]))==XO) {
            win =true;

        }
        return win;
    }

    public static void printArray(char[][] tictactoe){
        for (int i = 0; i < tictactoe.length; i++) {
            for (int j = 0; j < tictactoe[i].length; j++) {
                System.out.print(tictactoe[i][j]);
                if (j != tictactoe[i].length - 1)
                    System.out.print("|");
            }
            if (i != tictactoe.length - 1)
                System.out.println("\n-+-+-");
        }
    }

}
