import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gym {
    File existingMembers = new File("data/gym_members.dat");


    public Gym(){
    }

    public void currentmembers(){
        System.out.println("\nLIST OF CURRENT GYM MEMBERS\n");
        List<Member> allMembers = new ArrayList<>();
        try(Scanner dataInput = new Scanner(existingMembers)){
            while(dataInput.hasNext()){
                String[] currentGym = dataInput.nextLine().split("\\|");
                Member temp = new Member(currentGym[0], currentGym[1], Boolean.parseBoolean(currentGym[2]), Integer.parseInt(currentGym[3]));
                allMembers.add(temp);
            }
            for(Member member: allMembers){
                System.out.println(member.getFirstName() + " " + member.getLastName());
                if(member.isCardio()){
                    System.out.println(member.getFirstName() + " likes to include cardio into their workout.");
                }
                System.out.println(member.getFirstName() + " likes to work out " + member.getDaysInGym() + " days a week.\n");
            }
        } catch (FileNotFoundException e){
            System.out.println("Current Gym Members cannot be found.");
        }
    }

}

