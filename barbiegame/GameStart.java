package barbiegame;

import java.util.Scanner;

public class GameStart {
    private final int ZERO = 0;
    private final int ZOMBIE_QUANTITY_SPLIT = 2; //splits the grid length by this value to determine number of Zombies
    private Game game;
    private int gridLength;
    private Scanner scanner;

    public GameStart(){
        scanner = new Scanner(System.in);
    }

    /**
     * This method begins the game.
     * Tells players the premise for the game.
     * calls setValues.
     * calls play.
     */
    public void begin(){
        //creates new Game instance
        game = new Game();
        
        //gives users an introduction to the game
        System.out.println("Welcome to Barbie vs Zombie!");
        System.out.println("In this game you will play as Barbie and your goal is to collect all the pears before the zombies eat you!");
        System.out.println("Follow the directions shown");
        setValues();

        //updates the game to display the most up to date version to the user
        game.updateGame();

        //begins the playing of the game
        game.play();

        //close scanner
        scanner.close();
    }

    /**
     * Prompts user to enter the size of the grid.
     * Initializes Grid, Barbie, all pears, and zombies.
     * calls update game to display changed
     */
    public void setValues(){
    
        //loops while the users has not entered a number from 1-10
        String userInput = "";
        while(!validInput(userInput)){
            //prompts user to enter a number that will determine the number of zombies and pears and Barbie's health
            System.out.println("Please enter a positive integer, 5-25 is recommended");
            System.out.println("The integer will be your maps width and height.");
            System.out.println("The amount of Zombies and Pears will also reflect this: ");
            userInput = scanner.nextLine();
        }
        
        //create a new grid using the user input
        Grid grid = new Grid(Integer.parseInt(userInput));
        game.setGrid(grid);

        //sets variable gridLength for easier use later
        gridLength = grid.getSideLength();
        game.setGridLength(gridLength);

        //creates new Barbie and sets it in Game class
        Barbie barbie = new Barbie(grid);
        game.setBarbie(barbie);
        
        //adds barbie to entities in Game class
        game.addEntity(barbie);
            
        //adds pears to the pears in Game class
        Pear pear = null;
        for(int i = 0; i < gridLength; i++){
            pear = new Pear(grid);
            if(pear != null){
                game.addPear(pear);
                game.addEntity(pear);
            }
        }

        //adds zombies to the zombies in Game class
        Zombie zombie = null;
        for(int j = 0; j < gridLength/ZOMBIE_QUANTITY_SPLIT; j++){
            zombie = new Zombie(grid);
            if(zombie != null){
                game.addZombie(zombie);
                game.addEntity(zombie);
            }
        }
    }

    /**
     * Determines if user input for the grid size is valid
     * @param userInput for grid size
     * @return true if input is valid, else false
     */
    public boolean validInput(String userInput){
        //if userInput is empty return false
        if (userInput.isEmpty()) {
            return false;
        }
        try{
            //parse userInput to an integer
            int index = Integer.parseInt(userInput);
            //if index is less than or equal to 0 return false
            if(index <= ZERO){
                return false;
            }
        } catch (NumberFormatException e) {
            return false; // Return false if userInput cannot be parsed to an integer
        }
        //return true; valid input.
        return true;
    }
}
