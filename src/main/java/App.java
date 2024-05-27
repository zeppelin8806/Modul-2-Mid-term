import util.InputOutputSystem;

public class App {
    InputOutputSystem ioSystem = new InputOutputSystem();
    Gym gym = new Gym();
    Routine routine = new Routine();

    public static void main(String[] args){

        App app = new App();
        app.run();
    }

    /*
    Runs the main menu and directs the user to the corresponding selection.
    Each selection when complete will bring the user back to the main menu.
    When they enter 0 at the main menu, the code exits.
     */
    private void run(){
        while(true) {
            ioSystem.printMainMenu();
            int mainMenuSelection = ioSystem.promptForMenuSelection("Please choose and option: ");
            //Create a new Gym Member
            if (mainMenuSelection == 1) {
                ioSystem.printNewGymMemberMenu();
                gym.currentmembers();
            }
            //Show current Gym Members
            else if (mainMenuSelection == 2) {
                gym.currentmembers();
                ioSystem.printBackToMainMenu();
            }
            //Generate a new workout Routine from gym members data and print a new .dat file
            else if (mainMenuSelection == 3) {
                String [] workout = ioSystem.printGenerateNewWorkout();
                routine.strengthTrain(Integer.parseInt(workout[2]));
                routine.cardioTrain(Boolean.parseBoolean(workout[3]));
                //ioSystem.createNameFile(workout[0], workout[1]);
                ioSystem.printBackToMainMenu();
            }else if(mainMenuSelection ==0){
                System.out.println("Thank you and have a nice day!");
                System.out.println("Good bye!");
                break;
            } else {
                System.out.println("\nOption not valid. Going back to Main Menu.\n");
            }
        }
    }
}
