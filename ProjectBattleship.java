/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectbattleship;
import java.util.*;
import java.io.*;
/**
 *
 * @author ivorcheung
 */
public class ProjectBattleship {
    
    Random randNumber = new Random(); //declaring a random number generator.

   char playerBoard [][] = { //variable for the player's grid.
        {'~','~','~','~','~','~','~','~','~','~'},
        {'~','~','~','~','~','~','~','~','~','~'},
        {'~','~','~','~','~','~','~','~','~','~'},
        {'~','~','~','~','~','~','~','~','~','~'},
        {'~','~','~','~','~','~','~','~','~','~'},
        {'~','~','~','~','~','~','~','~','~','~'},
        {'~','~','~','~','~','~','~','~','~','~'},
        {'~','~','~','~','~','~','~','~','~','~'},
        {'~','~','~','~','~','~','~','~','~','~'},
        {'~','~','~','~','~','~','~','~','~','~'},
        {'~','~','~','~','~','~','~','~','~','~'},
        {'~','~','~','~','~','~','~','~','~','~'},
        
    };
    
    char computerBoard [][] = { //variable for the computer's grid.
        {'~','~','~','~','~','~','~','~','~','~'},
        {'~','~','~','~','~','~','~','~','~','~'},
        {'~','~','~','~','~','~','~','~','~','~'},
        {'~','~','~','~','~','~','~','~','~','~'},
        {'~','~','~','~','~','~','~','~','~','~'},
        {'~','~','~','~','~','~','~','~','~','~'},
        {'~','~','~','~','~','~','~','~','~','~'},
        {'~','~','~','~','~','~','~','~','~','~'},
        {'~','~','~','~','~','~','~','~','~','~'},
        {'~','~','~','~','~','~','~','~','~','~'},
        {'~','~','~','~','~','~','~','~','~','~'},
        {'~','~','~','~','~','~','~','~','~','~'},  
        
    };

   int computerHit = 0; //this variable is for how many hits the computer has
    int playerHit  = 0; //this variable is for how many hits the player has

   public void playerGrid(){ //an array for printing grid for the Player

    for (int x=0;x<12;x++){
        System.out.println("");
        for (int y=0;y<10;y++){
        System.out.print(playerBoard[x][y]); 
        
        }  
    } 
}
           
   public void computerGrid(){ //an array for printing grid for the computer           
        for (int x=0;x<12;x++){
        System.out.println("");
        for (int y=0;y<10;y++){
           
            if (computerBoard[x][y]=='S'){ //this prevents the computer ships from being seen.
                System.out.print('~');
                
            }else{ 
        System.out.print(computerBoard[x][y]);
            } 

        }       
    }
}

   public void Continue(){ /* This method is just a simple method that 
    * When the player enters 0, it will continue on with the rest of the program.
    
           /*throws IOException <-- this is necessary in the main method, but gave
           an error when executed.*/
  
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        while (true){
          
            try{ //Error Handling.
                
                //the above code presents a keyboard input variable.
                System.out.println("Press 0 to continue; ");
                String s = input.readLine();
                int cont = Integer.parseInt(s);
        
                if (cont == 0){ //this breaks the loop and continues on it's way.
                        break;
               }else{
                    System.out.println("Invalid choice, press 0 to continue ");
                    }
               }   
            
            catch(Exception e){ /*an error exception catch. In the event that
                                the code above statement isn't properly exectuted
                                it will print the below error.
                                */
        
        System.out.println("Invalid choice, press 0 to continue ");
            
       } 
    }
}
   
  public void tankSet(){ //method to set the longer ship
      
BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

int a2; //variable for the x co-ordinate
int b2; //variable for the y co-ordinate
int position; //variable for the position
int tankers = 0; //variable for counting


    while(tankers <2){ //this loops while variable tanker is less than 2.

    try{ //error handling.

            System.out.println("Please enter a column number, it must be \n"
                + "between 0-11; ");

            String a1 = input.readLine(); 
            a2 = Integer.parseInt(a1);

            System.out.println("Now enter the row number, this number \n"
                            + "must be between row 0-9:");
            String b1 = input.readLine();
            b2 = Integer.parseInt(b1);

            System.out.println("Now you must choose a postion");

            System.out.println("Choose 1 for Horizontal, and 2 for Vertical ");

            String p1 = input.readLine();
            position = Integer.parseInt(p1);

            if (position >=3){
                    System.out.println("Invalid Position, try again");
                        }

                if (a2+4 >=0 && a2+4 <=11 && b2+4 >=0 && b2+4 <=9){ /* this if statement
                 * basically ensures that the ship is within the grid size.
                 */

                    if (position == 1 && playerBoard[a2][b2] !='S' && playerBoard[a2][b2+1] !='S' && playerBoard[a2][b2+2] !='S' && playerBoard[a2][b2+3] !='S'){
                        //this if statement ensures that tere are no ships already planted
                        //and positions it Horizontally.
                        
                        playerBoard[a2][b2]   = 'S';
                        playerBoard[a2][b2+1] = 'S'; //adds one to the array 
                        playerBoard[a2][b2+2] = 'S'; //horiztontally
                        playerBoard[a2][b2+3] = 'S';
                        tankers++; //adds to the tanker variable if successfully set
                    }

                    else if (position == 2 && playerBoard[a2][b2] !='S' && playerBoard[a2+1][b2] !='S' && playerBoard[a2+2][b2] !='S' && playerBoard[a2+3][b2] !='S'){

                        playerBoard[a2][b2]   = 'S';
                        playerBoard[a2+1][b2] = 'S'; //adds one to the array
                        playerBoard[a2+2][b2] = 'S'; //vertically
                        playerBoard[a2+3][b2] = 'S';
                        tankers++; //adds to the tanker variable if successfully set
                    }

                    else if (playerBoard[a2][b2] =='S' || playerBoard[a2+1][b2] =='S' || playerBoard [a2+2][b2] =='S' || playerBoard [a2+3][b2] =='S' || playerBoard [a2] [b2+1] =='S' || playerBoard [a2][b2+2] =='S' || playerBoard [a2][b2+3] =='S'){
                        System.out.println("You ship is intersecting with another ship, try again.");
                        //the elseif will print if the ship clashes with another 
                        //and the loop will continue

                    }

                 }
                
                else { //if not within the grid it will print this statement
                    System.out.println("Ship out of bounds, try again");
                }

            if (tankers == 1){ //prints statement if tanker = 1 
            System.out.println("\nTime for the second ship\n");  
            }

            if (tankers == 2){ //prints statement if tanker = 2
                System.out.println("\nTankers set, now time for the Legions\n");
            }

            }

        catch (Exception e){ /*exception handling. If user inputs character 
                               instead of numbers, it will print this error*/

        System.out.println("\nError 404. Try again\n");
        }
    }
}

    public void legionSet(){ //method to set the ship

BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

int a2; //variable for the x co-ordinate
int b2; //variable for the y co-ordinate
int position; //variable for the position
int legions = 0; //variable for counting

    while(legions <2){

    try{

            System.out.println("Please enter a column number, it must be \n"
                + "between 0-11; ");

            String a1 = input.readLine(); 
            a2 = Integer.parseInt(a1);

            System.out.println("Now enter the row number, this number \n"
                            + "must be between row 0-9:");
            String b1 = input.readLine();
            b2 = Integer.parseInt(b1);

            System.out.println("Now you must choose a postion");

            System.out.println("Choose 1 for Horizontal, and 2 for Vertical ");

            String p1 = input.readLine();
            position = Integer.parseInt(p1);

            if (position >=3){
                    System.out.println("Invalid Position, try again");

                    }

                if (a2+3 >=0 && a2+3 <=11 && b2+3 >=0 && b2+3 <=9){



                    if (position == 1 && playerBoard[a2][b2] !='S' && playerBoard[a2][b2+1] !='S' && playerBoard[a2][b2+2] !='S'){

                        playerBoard[a2][b2]   = 'S';
                        playerBoard[a2][b2+1] = 'S';
                        playerBoard[a2][b2+2] = 'S';

                        legions++;
                    }

                    else if (position == 2 && playerBoard[a2][b2] !='S' && playerBoard[a2+1][b2] !='S' && playerBoard[a2+2][b2] !='S'){


                        playerBoard[a2][b2]   = 'S';
                        playerBoard[a2+1][b2] = 'S';
                        playerBoard[a2+2][b2] = 'S';

                        legions++;
                    }

                    else if (playerBoard[a2][b2] =='S' || playerBoard[a2+1][b2] =='S' || playerBoard [a2+2][b2] =='S'|| playerBoard [a2] [b2+1] =='S' || playerBoard [a2][b2+2] =='S'){
                        System.out.println("You ship is intersecting with another ship, try again.");

                    }

                    }

                if (legions == 1){  
                System.out.println("\nTime for the second legion\n");  
                }

                if (legions == 2){
                    System.out.println("Ships all set.");
                    
                }
            }

        catch (Exception e){

        System.out.println("Error 404. Try again");
        }
    }
}

  public void computerTanker(){

      int tankers = 0;
      
             
    while(tankers <2){
        
        try{ //error handling
            
      int a2       = randNumber.nextInt(12); //chooses a random number between 0-11 (for column number)
      int b2       = randNumber.nextInt(10); //chooses a random number between 0-9  (for row number)
      int position = randNumber.nextInt(2);  //chooses a random number between 0+1  (for position)


        if (a2+4 >=0 && a2+4 <=11 && b2+4 >=0 && b2+4 <=9){



            if (position == 0 && computerBoard[a2][b2] !='S' && computerBoard[a2][b2+1] !='S' && computerBoard[a2][b2+2] !='S' && computerBoard[a2][b2+3] !='S'){

                computerBoard[a2][b2]   = 'S';
                computerBoard[a2][b2+1] = 'S';
                computerBoard[a2][b2+2] = 'S';
                computerBoard[a2][b2+3] = 'S';
                tankers++;
            }

            else if (position == 1 && computerBoard[a2][b2] !='S' && computerBoard[a2+1][b2] !='S' && computerBoard[a2+2][b2] !='S' && computerBoard[a2+3][b2] !='S'){


                computerBoard[a2][b2]   = 'S';
                computerBoard[a2+1][b2] = 'S';
                computerBoard[a2+2][b2] = 'S';
                computerBoard[a2+3][b2] = 'S';
                tankers++;
            }

            else if (computerBoard[a2][b2] =='S' || computerBoard[a2+1][b2] =='S' || computerBoard [a2+2][b2] =='S' || computerBoard [a2+3][b2] =='S' || computerBoard [a2] [b2+1] =='S' || computerBoard [a2][b2+2] =='S' || computerBoard [a2][b2+3] =='S'){

            }
            }
        }
        
        catch(ArrayIndexOutOfBoundsException e){ //catches the following error (not necessary)
            
        }
    }
}
  
    public void computerLegion(){
       
      
      int legions = 0;
      
             
    while(legions <2){
        
        try{
            
      int a2       = randNumber.nextInt(12);
      int b2       = randNumber.nextInt(10);
      int position = randNumber.nextInt(2);

        if (a2+3 >=0 && a2+3 <=11 && b2+3 >=0 && b2+3 <=9){

            if (position == 0 && computerBoard[a2][b2] !='S' && computerBoard[a2][b2+1] !='S' && computerBoard[a2][b2+2] !='S' && computerBoard[a2][b2+3] !='S'){

                computerBoard[a2][b2]   = 'S';
                computerBoard[a2][b2+1] = 'S';
                computerBoard[a2][b2+2] = 'S';
                legions++;
            }

            else if (position == 1 && computerBoard[a2][b2] !='S' && computerBoard[a2+1][b2] !='S' && computerBoard[a2+2][b2] !='S' && computerBoard[a2+3][b2] !='S'){


                computerBoard[a2][b2]   = 'S';
                computerBoard[a2+1][b2] = 'S';
                computerBoard[a2+2][b2] = 'S';
                legions++;
            }

            else if (computerBoard[a2][b2] =='S' || computerBoard[a2+1][b2] =='S' || computerBoard [a2+2][b2] =='S' || computerBoard [a2] [b2+1] =='S' || computerBoard [a2][b2+2] =='S'){

            }
            }
        }
        
        catch(ArrayIndexOutOfBoundsException e){
            
        }
    }
}
    
    public void shipSet(){
            System.out.println("You are to plant 2 tankers. "
                    + "These ships are the longest ship available. \n"
            + "Choose where you would like to plant them: ");

            tankSet(); //calls the tankSet method
            legionSet(); //calls the legionSet method
            computerTanker(); //calls the computerTanker method
            computerLegion(); //calls the computerLegion method
            System.out.println("Fine work! The enemy has their ships set, "
                    + "so it's time to attack.");
            Continue();
            
}
 
  
  public void playerShot(){
    
    BufferedReader number = new BufferedReader(new InputStreamReader(System.in));

    System.out.println("It's time to Strike the enemy!\n");
    
    while(true){// this while executes if the same move has been already executed.
    
        try{

            System.out.println("Please enter an X coordinate: "); 
            String x = number.readLine(); //keyboard input to be parsed
            int playShotx = Integer.parseInt(x);  //user input for X coordinate

            System.out.println("Now please enter a Y coordinate: ");
            String y = number.readLine(); //keyboard input to be parsed
            int playShoty = Integer.parseInt(y);  //user input for y coordinate

            if (playShotx <0 || playShotx >11 || playShoty <0 || playShoty >9){ 
            } //an if that displays error if it meets the above statement

            if (computerBoard[playShotx][playShoty]=='S'){ //an IF statement that specifies
                                //if the grid has a 'S' on the grid - it will = HIT

                System.out.println("HIT");
                computerBoard[playShotx][playShoty]='X'; // this replaces 'S' with 'X'
                playerHit++;
                break;
                }

            if (computerBoard[playShotx][playShoty]=='~'){ //an IF statement that specifies
                                //if the grid has a '~' on the grid - it will = MISS

                System.out.println("MISS");
                computerBoard[playShotx][playShoty]='M'; // this replaces '~' with a 'M'
                break;

            }

            if (computerBoard[playShotx][playShoty] == 'M'){ // if the move has already been made
                                            // it will ask user to make another move.
                System.out.println("You already made that move, try again.");
            }
        }

    catch(Exception e){ //prints statement if an error happens
        
        System.out.println("Error 404. Try again.");
        
     }
   }
}    

  public void computerShot(){

    System.out.println("The enemy has took a shot! ");
    
    int shotx = randNumber.nextInt(12); //this variable chooses a number for col (computerShot method)
    int shoty = randNumber.nextInt(10); //this variable chooses a number for row (computerShot method)
    
    if (playerBoard[shotx][shoty] == 'S'){ //enemy takes shot with global variable
        System.out.println("You have been HIT");
        playerBoard[shotx][shoty] = 'X';
        computerHit++; //adds to the int computerHit each time it hits the ship.   
    }

    if (playerBoard[shotx][shoty] == '~'){
        System.out.println("The enemy shot MISS");
        playerBoard[shotx][shoty] = 'M';
    }
}

  public void Battleship(){
      
     while(true){

        playerShot(); //calls the playerShot method
        computerGrid(); //calls and displays the computer grid
        Continue(); //calls the continue method
        computerShot(); //calls the computerShot method
        playerGrid(); //calls and displays the player grid
        Continue(); //calls the continue method

        if (playerHit==14){ //this helps determines the winner of the game
            System.out.println("Congratulations Soldier, you beat the enemy");
            break;
        }

        if (computerHit==14){
            System.out.println("The enemy destroyed us! ");
            break;
        }
    } 
}
  
    public static void main(String[] args) { //this is the main method.

        ProjectBattleship PBs = new ProjectBattleship(); //declaring a new class within a class
        
        pbsDialogue test = new pbsDialogue();
        
        Scanner input = new Scanner(System.in); //keyboard input variable for player's name.
        String name;//a string variable for the player's name
        
        System.out.println ("Hello player, what is your name?");
        name = input.nextLine();
        
        System.out.println("\nHello "+name);
        
        
        System.out.println("\nWelcome to Battleship. Here are the Instructions\n"
                + "You are to declare war against the computer.\n"
                + "Be advised, the computer can be smart, so you \n"
                + "must strategically plot against him in order to \n"
                + "win the battle.\n");
        System.out.println("In order to win the battle, you must attack \n"
                + "the enemy's ship that he has strategically planned.\n"
                + "You can only hit one target at a time so make sure it's \n"
                + "a good move. The enemy has 4 ships identical to ours.");
        System.out.println("Here are your ships, two are tankers, and the \n"
                + "others are Legions. The tanker is longer than the legion, \n");
        System.out.println("Your mission is to plot the tanker and legions in \n"
                + "safe spaces and to lead your team to victory. The first thing \n"
                + "we got to do is plant the ships for defence.\n");
         // these are the instructions for the game.
        PBs.Continue();//this gives a loop that the player will have to input a certain
                   //command. If successful - it will execute the below code.
        System.out.println("\n\n");
        System.out.println("This is your grid" );
        PBs.playerGrid(); //prints player's grid
        System.out.println("\n\n");
        System.out.println("This is the enemy's grid" );
        PBs.computerGrid(); //prints enemy's grid
        System.out.println("\n\n");
        System.out.println("You can't see the enemy's grid, so you will \n"
                + "have to plot your attack carefully. The first thing \n"
                + "we have to do is plant your ships for attack. \n\n"
                + "As you can see on your map there is a grid,  \n"
                + "You can plot your ships anywhere in the grid, horizontally \n"
                + "or vertically. Be advised that the ship must stay in the grid \n"
                + "otherwise it will be spotted by the enemy. So let's start plotting \n"
                + "your ships \n"); // more instructions
        
        PBs.Continue(); //continue method
        System.out.println("\n\n");
        PBs.shipSet(); //calls the ship placing method method
        PBs.computerGrid(); //calls and prints the computer's grid
        PBs.Battleship(); // the beginning of the game - where the attack takes place
        PBs.Continue(); //Once finished - it will ask for 0 to continue again
        System.exit(0); //this exits the game
        
    }

}