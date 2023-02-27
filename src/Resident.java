/**
 * This is the resident class which implements the student class/
 * @author Jaison Prajapati
 */
public class Resident implements Comparable<Student>{
    private int scholarship;

    /**
     * This method creates a student through resident
     * @param profile is the input profile
     * @param major is the input major
     * @param creditCompleted is the input credit completed
     * @return the student object
     */
    public Student Student(Profile profile, Student.Major major, int creditCompleted) {
        Student newResidentStudent = new Student(profile, major, creditCompleted) {
            /**
             * Override for the student method
             * @param creditsEnrolled is the input credits enrolled.
             * @return the tuition due.
             */
            @Override
            public double tuitionDue(int creditsEnrolled) {
                return 0;
            }

            /**
             * Override for the student method
             * @return true since this is the resident class.
             */
            @Override
            public boolean isResident() {
                return true;
            }
        };
        return newResidentStudent;
    }


    //getters

    /**
     * Getter for the scholarship
     * @return the scholarship
     */
    public int getScholarship(){
        return scholarship;
    }

    //setters

    /**
     * Setter for the scholarship
     * @param scholarship is set.
     */
    public void setScholarship(int scholarship){
        this.scholarship = scholarship;
    }

    /**
     * Override for the equals method
     * @param oStudent is the passed in object
     * @return true if they are equal and false if they are not equal.
     */
    @Override
    public boolean equals(Object oStudent){
        if (oStudent instanceof Student student){
            boolean oScholarship = this.scholarship == student.getResident().getScholarship();
            return oScholarship;
        }
        return false;
    }

    /**
     * This overrides the compareTo method for the student object.
     * @param student the object to be compared.
     * @return Returns 0 if they are the same and -1 if they are different.
     */
    @Override
    public int compareTo(Student student){
        if(this.scholarship == student.getResident().getScholarship()){
            return 0;
        }else{
            return -1;
        }
    }
}
