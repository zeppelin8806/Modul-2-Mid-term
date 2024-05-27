import util.Workout;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Routine {

    File Strength = new File("data/fitness_exercises.dat");
    File Cardio = new File("data/cardio_exercises.dat");
    private int workoutsPerDay = 3;

    public Routine(){
    }
    public Routine(File strength,File cardio){
        this.Strength = strength;
        this.Cardio = cardio;
    }

    public void strengthTrain(int daysInGym){
        List<Workout> muscles = new ArrayList<>();
        try(Scanner dataInput = new Scanner(Strength)){
            while(dataInput.hasNext()){
                String[] currentMuscles = dataInput.nextLine().split(",");
                Workout area = new Workout(currentMuscles[0], currentMuscles[1], currentMuscles[4], currentMuscles[5]);
                muscles.add(area);
            }
            // Create an array of days for specific body parts.
            String[] workOutDay = new String[daysInGym];
            workOutDay[0] = muscles.get((int)((Math.random())*100)).getBodyPart();
            for (int i = 1; i < workOutDay.length; i++) {
                workOutDay[i] = muscles.get((int)((Math.random())*100)).getBodyPart();
                while(workOutDay[i].equals(workOutDay)){
                    workOutDay[i] = muscles.get((int)((Math.random())*100)).getBodyPart();
                }
            }
            // Create a strength training routine by randomly pick from the fitness database and assigning it to its corresponding day.
            for (int i = 0; i < workOutDay.length; i++) {
                System.out.println("Day " + (i + 1) + ":\tYou are going to work out your " + workOutDay[i]);
                int j = 0;
                while(j<workoutsPerDay){
                    int r = (int)((Math.random())*100);
                    if(workOutDay[i].equals(muscles.get(r).getBodyPart())){
                        System.out.println("\tThis movement is called " + muscles.get(r).getName());
                        System.out.println("\tThis will target your " + muscles.get(r).getTarget() + "\n");
                        j++;
                    }
                }
            }
        } catch (java.io.FileNotFoundException e){
            System.out.println("Strength training database is down.");
        }
    }
    public void cardioTrain(boolean cardio){
        if(cardio){
            List<Workout> cardioTraining = new ArrayList<>();
            try(Scanner dataInput = new Scanner(Cardio)){
                dataInput.nextLine();
                while(dataInput.hasNext()){
                    String[] currentCardio = dataInput.nextLine().split(",");
                    Workout heart = new Workout(currentCardio[2], (currentCardio[3]), (currentCardio[4]));
                    cardioTraining.add(heart);
                }
                int r = (int)((Math.random())*100);
                System.out.println("**" + "\tThe cardio exercise for this week is " + cardioTraining.get(r).getWorkoutType());
                System.out.println("\tYou will go for " + cardioTraining.get(r).getDistance() + "km.");
                System.out.println("\tYour goal will be to complete it in approximately " + cardioTraining.get(r).getTime() + " minutes.");
            } catch (FileNotFoundException e){
                System.out.println("Cardio routes calculator is down.");
            }
        }
    }

}
