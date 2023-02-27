/**
 * This is the TriState class which implements the student class.
 * @author Jaison Prajapati
 */
public class TriState implements Comparable<NonResident>{
    private String state;

    /**
     * This method creates a student through the tristate class
     * @param profile is the passed in profile
     * @param major is the passed in major
     * @param creditCompleted is the passed in credits completed
     * @param studentState is the state that the student is from
     * @return the student object.
     */
    public Student Student(Profile profile, Student.Major major, int creditCompleted, String studentState) {
        Student newTriStateStudent = new Student(profile, major, creditCompleted, studentState) {
            /**
             * The override method for the tuition due for the tristate class.
             * @param creditsEnrolled is the input credits enrolled.
             * @return the tuition due
             */
            @Override
            public double tuitionDue(int creditsEnrolled) {
                return 0;
            }

            /**
             * The override method for the is resident method
             * @return false since it is tristate.
             */
            @Override
            public boolean isResident() {
                return false;
            }
        };
        return newTriStateStudent;
    }

    //getters

    /**
     * Getter for the state
     * @return the state string
     */
    public String getState(){
        return state;
    }

    //setters

    /**
     * Setter for the state
     * @param state is the state which is set.
     */
    public void setState(String state){
        this.state = state;
    }

    /**
     * The override for the compareto method.
     * @param nonresident the object to be compared.
     * @return 0 if they are the same and -1 if they are not.
     */
    @Override
    public int compareTo(NonResident nonresident){ //not sure what this is supposed to do
        return 0;
    }
}
