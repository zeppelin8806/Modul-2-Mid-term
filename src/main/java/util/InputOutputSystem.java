package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class InputOutputSystem implements BasicControls{
    private final Scanner input = new Scanner(System.in);
    File existingMembers = new File("data/gym_members.dat");
    File location = new File("data/");



    public void printMainMenu(){
        printMessage("Welcome to the Gym!!!");
        printBlankLine();
        printMessage("Please select from the following options:");
        printMessage("1: Make a new Gym Member");
        printMessage("2: View current Gym Members");
        printMessage("3: Generate a new workout Routine");
        printMessage("0: Exit");
        printBlankLine();
    }
    //This asks a series of questions that will add the input to the gym_members.dat data file.
    public void printNewGymMemberMenu(){
        printMessage("Please enter a First Name:");
        try(PrintWriter firstName = new PrintWriter(new FileOutputStream(existingMembers, true))){
            String prompt = input.nextLine();
            firstName.println();
            firstName.print(prompt + "|");
        } catch(FileNotFoundException e){
            printErrorMessage("Cannot add to current Gym Members.");
        }
        printMessage("Please enter a Last Name: ");
        try(PrintWriter lastName = new PrintWriter(new FileOutputStream(existingMembers, true))){
            String prompt = input.next();
            lastName.print(prompt + "|");
        } catch(FileNotFoundException e){
            printErrorMessage("Cannot add to current Gym Members.");
        }
        printMessage("Would you like a workout routine made for you? (Y/N): ");
        try(PrintWriter routine = new PrintWriter(new FileOutputStream(existingMembers, true))){
            String prompt = input.next();
            if(prompt.equalsIgnoreCase("y")){
                prompt = "true";
            } else{
                prompt = "false";
            }
            routine.print(prompt + "|");
        } catch(FileNotFoundException e){
            printErrorMessage("Cannot add to current Gym Members.");
        }
        printMessage("Please enter how many times a week you plan to visit the gym: ");
        try(PrintWriter visits = new PrintWriter(new FileOutputStream(existingMembers, true))){
            String prompt = input.next();
            visits.print(prompt);
        } catch(FileNotFoundException e){
            printErrorMessage("Cannot add to current Gym Members.");
        }
        printMessage("Thank you! One moment...\n");
    }

    public void printBackToMainMenu(){
        printMessage("Please enter any key followed by enter to go back to the main menu: ");
        String next = input.nextLine();
    }
    public String[] printGenerateNewWorkout(){
        String[] workout = new String[4];
        printMessage("Please select current Gym Member or hit enter for not current Gym Members: ");
        workout[0] = input.nextLine();
        String[] currentMembers;
        try(Scanner dataInput = new Scanner(existingMembers)){
            while(dataInput.hasNext()){
                currentMembers = dataInput.nextLine().split("\\|");
                if(currentMembers[0].equalsIgnoreCase(workout[0])){
                    workout[1] = currentMembers[1];
                    workout[2]= currentMembers[3];
                    workout[3] = currentMembers[2];
                    }
                }
            while(workout[2] == null){
                if(workout[2] == null){
                    printMessage("Please enter how many times a week you plan to visit the gym: ");
                    String days = input.nextLine();
                    int daysTemp = Integer.parseInt(days);
                    //Loop to make sure the number entered is 7 or less.
                    while(daysTemp>8){
                       printMessage("Please enter a number between 0 & 7: ");
                       days = input.nextLine();
                       daysTemp = Integer.parseInt(days);
                    }
                    workout[2] = days;
                    printMessage("Would you like to include Cardio exercises as well? (Y/N): ");
                    String cardio = input.nextLine();
                    if (cardio.equalsIgnoreCase("Y")) {
                        workout[3] = "true";
                    } else if (cardio.equalsIgnoreCase("N")) {
                        workout[3] = "false";
                    }
                }
            }
        } catch (FileNotFoundException e){
            printErrorMessage("Current Gym Members cannot be found.");
        }

        return workout;
    }
    /*
    public void createNameFile(String firstName, String lastName){
        printMessage("Would you like to save this workout? (Y/N):");
        String answer = input.nextLine();
        if(answer.equalsIgnoreCase("y")){
            try(PrintWriter savedData = new PrintWriter(new FileOutputStream(location + "_" + firstName + "_" + lastName+ ".dat"))){
                savedData.print(firstName + " " + lastName);
            } catch(FileNotFoundException e){
                printErrorMessage("Cannot add new database.");
            }
        }

    }
*/

    public int promptForMenuSelection(String prompt){
        System.out.println(prompt);
        int menuSelection;
        try{
            menuSelection = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e){
            menuSelection = -1;
        }
        return menuSelection;
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void printErrorMessage(String message) {
        System.out.println("***" + message + "***");
    }

    @Override
    public void printBlankLine() {
        System.out.println();
    }

}
