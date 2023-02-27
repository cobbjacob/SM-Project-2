/**
 * This is the international class which implements the student class.
 * @author Jaison Prajapati
 */
public class International implements Comparable<NonResident>{
    private boolean isStudyAbroad;

    /**
     * This method creates a student object through the international class
     * @param profile is the passed in profile
     * @param major is the passed in major
     * @param creditCompleted is the passed in credits completed
     * @param studyAbroad is the passed in study abroad
     * @return the student object.
     */
    public Student Student(Profile profile, Student.Major major, int creditCompleted, boolean studyAbroad) {
        Student newInternationalStudent = new Student(profile, major, creditCompleted, studyAbroad) {
            /**
             * The override method for the tuition due for the international class.
             * @param creditsEnrolled is the input credits enrolled.
             * @return the tuition due
             */
            @Override
            public double tuitionDue(int creditsEnrolled) {
                return 0;
            }

            /**
             * The override method for the is resident method
             * @return false since it is international.
             */
            @Override
            public boolean isResident() {
                return false;
            }
        };
        return newInternationalStudent;
    }

    //getters

    /**
     * Getter for if the student is study abroad
     * @return true if they are and false if they are not.
     */
    public boolean getIsStudyAbroad(){
        return isStudyAbroad;
    }

    //setters

    /**
     * Setter for the study abroad
     * @param isStudyAbroad is set.
     */
    public void setIsStudyAbroad(boolean isStudyAbroad){
        this.isStudyAbroad = isStudyAbroad;
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
