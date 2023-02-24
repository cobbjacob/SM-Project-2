public class Enrollment {
    private EnrollStudent[] enrollStudents;
    private int size;
    public void add(EnrollStudent enrollStudent){

    } //add to the end of array
    //move the last one in the array to replace the deleting index position
    public void remove(EnrollStudent enrollStudent){
        for(int i = 0; i < enrollStudents.length; i++){
            if(enrollStudents[i] != null && enrollStudents[i].compareTo(enrollStudent) == 0){
                for(int j = i; j < enrollStudents.length - 1; j++){
                    enrollStudents[j] = enrollStudents[j+1];
                }
            }
        }
    }
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
    public void print() {
        for(int i = 0; i < enrollStudents.length; i++){
            System.out.println(enrollStudents[i]);
        }
    } //print the array as is without sorting
}


