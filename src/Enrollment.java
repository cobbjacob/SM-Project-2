/**
 * This is the enrollment class which creates the enrollment array.
 * @author Jaison Prajapati
 */
public class Enrollment {
    private EnrollStudent[] enrollStudents;
    private int size;

    /**
     * This method adds an EnrollStudent to the array.
     * @param enrollStudent is the student to add.
     */
    public void add(EnrollStudent enrollStudent){
        if(enrollStudents == null){
            grow();
        }
        for(int i = 0; i < enrollStudents.length; i++) {
            if (enrollStudents[enrollStudents.length - 1] != null) {
                grow();
            }
            if (enrollStudents[i] == null) {
                enrollStudents[i] = enrollStudent;
            }
        }
    } //add to the end of array

    /**
     * This method grows the enrollment array by 4 if it ever fills up.
     */
    private void grow(){ //increase the array capacity by 4
        if(enrollStudents == null){
            EnrollStudent[] newEnrollList = new EnrollStudent[4];
            enrollStudents = newEnrollList;
        }else{
            EnrollStudent[] newEnrollList = new EnrollStudent[enrollStudents.length + 4];
            for(int i = 0; i < enrollStudents.length; i++){
                newEnrollList[i] = enrollStudents [i];
            }
            enrollStudents = newEnrollList;
        }
    }

    /**
     * This method removes the passed in student from the enrollment array.
     * @param enrollStudent is the student to be removed.
     */
    public void remove(EnrollStudent enrollStudent){ //move the last one in the array to replace the deleting index position
        for(int i = 0; i < enrollStudents.length; i++){
            if(enrollStudents[i] != null && enrollStudents[i].compareTo(enrollStudent) == 0){
                for(int j = i; j < enrollStudents.length - 1; j++){
                    enrollStudents[j] = enrollStudents[j+1];
                }
            }
        }
    }

    /**
     * Thsi method checks to see if the input student is in the enrollment array.
     * @param enrollStudent is the student we need to find
     * @return true if the student is in the array and false if they are not in the array.
     */
    public boolean contains(EnrollStudent enrollStudent){
        if(enrollStudents == null){
            return false;
        }
        for(int i = 0; i < enrollStudents.length; i++){
            if(enrollStudents[i] == null){
                return false;
            }else{
                if(enrollStudents[i].getProfile().getFname().equalsIgnoreCase(enrollStudent.getProfile().getFname()) == true &&
                        enrollStudents[i].getProfile().getLname().equalsIgnoreCase(enrollStudent.getProfile().getLname()) == true &&
                        enrollStudents[i].getProfile().getDob().getDay() == enrollStudent.getProfile().getDob().getDay() &&
                        enrollStudents[i].getProfile().getDob().getMonth() == enrollStudent.getProfile().getDob().getMonth() &&
                        enrollStudents[i].getProfile().getDob().getYear() == enrollStudent.getProfile().getDob().getYear()){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This method prints the enrollment array as it is.
     */
    public void print() {
        if(enrollStudents != null){
            for(int i = 0; i < enrollStudents.length; i++){
                System.out.println(enrollStudents[i].getProfile().getFname() + " " +
                        enrollStudents[i].getProfile().getLname() + " " +
                        enrollStudents[i].getProfile().getDob() +
                        ": credits enrolled: " + enrollStudents[i].getCreditsEnrolled());
            }
        }else{
            System.out.println("Enrollment is empty!");
        }

    } //print the array as is without sorting

    /**
     * This method prints the array in an order of tuition.
     */
    public void printTuition(){
        if(enrollStudents == null){
            System.out.println("Student roster is empty!");
        }
    }
}


