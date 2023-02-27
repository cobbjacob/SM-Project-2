/**
 * This is the non-resident class which implements the student class.
 * @author Jaison Prajapati
 */
public class NonResident implements Comparable<Student>{
    /**
     * Method to create a student through the nonresident class
     * @param profile is the input profile
     * @param major is the input major
     * @param creditCompleted is the input credits completed.
     * @return the student object.
     */
    public Student Student(Profile profile, Student.Major major, int creditCompleted) {
        Student newNonResidentStudent = new Student(profile, major, creditCompleted) {
            /**
             * The override method for the tuition due for the non resident class.
             * @param creditsEnrolled is the input credits enrolled.
             * @return the tuition due
             */
            @Override
            public double tuitionDue(int creditsEnrolled) {
                return 0;
            }

            /**
             * The override method for the is resident method
             * @return false since it is non resident.
             */
            @Override
            public boolean isResident() {return false;}
        };
        return newNonResidentStudent;
    }

    /**
     * The override for the compareto method.
     * @param student the object to be compared.
     * @return 0 if they are the same and -1 if they are not.
     */
    @Override
    public int compareTo(Student student){ //not sure what this is supposed to do
        return 0;
    }
}
