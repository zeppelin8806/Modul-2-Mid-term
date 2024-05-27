public class Member{

    private String lastName;
    private String firstName;
    private boolean cardio;
    private int daysInGym;// Per week.

    // Class that holds a gym member's information
    public Member(String firstName, String lastName, boolean cardio, int daysInGym){
        this.firstName = firstName;
        this.lastName = lastName;
        this.cardio = cardio;
        this.daysInGym = daysInGym;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public boolean isCardio() {
        return cardio;
    }

    public void setCardio(boolean cardio) {
        this.cardio = cardio;
    }

    public int getDaysInGym() {
        return daysInGym;
    }

    public void setDaysInGym(int daysInGym) {
        this.daysInGym = daysInGym;
    }

}
