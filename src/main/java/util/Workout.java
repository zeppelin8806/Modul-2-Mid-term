package util;

public class Workout {
    private String bodyPart;
    private String equipment;
    private String name;
    private String target;
    private String workoutType;
    private String distance;
    private String time;

    public Workout(String bodyPart, String equipment, String name, String target) {
        this.bodyPart = bodyPart;
        this.equipment = equipment;
        this.name = name;
        this.target = target;
    }

    public Workout(String workoutType, String distance, String time) {
        this.workoutType = workoutType;
        this.distance = distance;
        this.time = time;
    }

    public String getBodyPart() {
        return bodyPart;
    }


    public String getEquipment() {
        return equipment;
    }


    public String getName() {
        return name;
    }


    public String getTarget() {
        return target;
    }

    public String getWorkoutType() {
        return workoutType;
    }

    public String getDistance() {
        return distance;
    }

    public String getTime() {
        return time;
    }

}
