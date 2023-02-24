/**
 * This is the roster class where the students are stored.
 * Helper methods are made to sort the students in different ways.
 * @author Jaison Prajapati, Jacob Cobb
 */


public class Roster {
    private Student[] roster;
    private int sAize;

    /**
     * This method finds specific student and returns their index in the roster.
     * @param student This student is the one we need to find.
     * @return the index of the student. If the student is not in the roster -1 is returned.
     */
    private int find(Student student){ //search the given student in roster
        for(int i = 0; i < roster.length; i++){
            if(roster[i] != null && roster[i].compareTo(student) == 0){
                return i;
            }
        }
        return -1;
    }

    /**
     * This method increases the array size of the roster by 4
     */
    private void grow(){ //increase the array capacity by 4
        if(roster == null){
            Student[] newRoster = new Student[4];
            roster = newRoster;
        }else{
            Student[] newRoster = new Student[roster.length + 4];
            for(int i = 0; i < roster.length; i++){
                newRoster[i] = roster [i];
            }
            roster = newRoster;
        }
    }

    /**
     * This method adds a student to the roster.
     * @param student This student is passed in in order to add them to the roster.
     * @return Returns true if the student is added, returns false if nothing is done.
     */
    public boolean add(Student student){ //add student to end of array
        if(roster == null){
            grow();
        }
        for(int i = 0; i < roster.length; i++){
            if(roster[roster.length-1] != null){
                grow();
            }
            if(roster[i] == null){
                roster[i] = student;
                return true;
            }
        }
        return false;
    }

    /**
     * This method removes the student which is passed in.
     * @param student This is the student which needs to be removed.
     * @return If the student is in the roster and is removed the method will return true, if the student
     * is not in the roster then it will return false.
     */
    public boolean remove(Student student){ //maintain the order after remove
        for(int i = 0; i < roster.length; i++){
            if(roster[i] != null && roster[i].compareTo(student) == 0){
                for(int j = i; j < roster.length - 1; j++){
                    roster[j] = roster[j+1];
                }
                return true;
            }
        }
        return false;
    }

    /**
     * This method checks if the passed in student is in the roster.
     * @param student This is the student which is passed in.
     * @return Returns false if the roster is empty or if the student is not in the roster.
     * True if the student is in the roster.
     */
    public boolean contains(Student student){ //if the student is in roster
        if(roster == null){
            return false;
        }
        for(int i = 0; i < roster.length; i++){
            if(roster[i] == null){
                return false;
            }else{
                if(roster[i].getProfile().getFname().equalsIgnoreCase(student.getProfile().getFname()) == true &&
                        roster[i].getProfile().getLname().equalsIgnoreCase(student.getProfile().getLname()) == true &&
                        roster[i].getProfile().getDob().getDay() == student.getProfile().getDob().getDay() &&
                        roster[i].getProfile().getDob().getMonth() == student.getProfile().getDob().getMonth() &&
                        roster[i].getProfile().getDob().getYear() == student.getProfile().getDob().getYear()){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This is the print method which sorts the student roster by last name, first name, and date of birth
     * and prints it out.
     */
    public void print(){ //print roster sorted by profiles
        if(roster == null){
            System.out.println("Student roster is empty!");
        }else{
            sortByName(roster);
            System.out.println("* Student roster sorted by last name, first name, DOB **");
            int count = 0;
            while(roster[count] != null){
                System.out.println(roster[count].getProfile().getFname() + " " +
                        roster[count].getProfile().getLname() + " " +
                        roster[count].getProfile().getDob() + " " +
                        "(" + roster[count].getMajor().code + " " + roster[count].getMajor() + " " + roster[count].getMajor().school + ")"
                        + " credits completed: " +
                        roster[count].getCreditCompleted() + " (" + roster[count].standing() + ")");
                count += 1;
            }
            System.out.println("* end of roster **");
        }
    }

    /**
     * This is a helper method which sorts the student roster by last name, first name, and date of birth.
     */
    public void sortByName(Student[] roster){
        for(int i = 0; i < roster.length; i++){
            for(int j = 0; j < i + 1; j++){
                if(roster[j] != null && roster[i] != null &&
                        roster[i].getProfile().getLname().compareTo(roster[j].getProfile().getLname()) < 0){
                    Student temp = roster[i];
                    roster[i] = roster[j];
                    roster[j] = temp;
                }
                else if(roster[j] != null && roster[i] != null &&
                        roster[i].getProfile().getLname().compareTo(roster[j].getProfile().getLname()) == 0){
                    if(roster[j] != null && roster[i] != null &&
                            roster[i].getProfile().getFname().compareTo(roster[j].getProfile().getFname()) < 0){
                        Student temp = roster[i];
                        roster[i] = roster[j];
                        roster[j] = temp;
                    }

                    else if(roster[j] != null && roster[i] != null &&
                            roster[i].getProfile().getLname().compareTo(roster[j].getProfile().getLname()) == 0 &&
                            roster[i].getProfile().getFname().compareTo(roster[j].getProfile().getFname()) == 0){
                        if(roster[j] != null && roster[i] != null &&
                                roster[i].getProfile().getDob().compareTo(roster[j].getProfile().getDob()) < 0){
                            Student temp = roster[i];
                            roster[i] = roster[j];
                            roster[j] = temp;
                        }

                    }
                }


            }
        }
    }

    /**
     * This is the print method which sorts the student roster by school major.
     * and prints it out.
     */
    public void printBySchoolMajor(){ //print roster sorted by school major
        if(roster == null){
            System.out.println("Student roster is empty!");
        }else {
            for (int i = 0; i < roster.length; i++) {
                for (int j = 0; j < i + 1; j++) {
                    if (roster[j] != null && roster[i] != null &&
                            roster[i].getMajor().school.compareToIgnoreCase(roster[j].getMajor().school) < 0) {
                        Student temp = roster[i];
                        roster[i] = roster[j];
                        roster[j] = temp;
                    }else if(roster[j] != null && roster[i] != null &&
                            roster[i].getMajor().school.compareToIgnoreCase(roster[j].getMajor().school) == 0){
                        if(roster[j] != null && roster[i] != null &&
                                roster[i].getMajor().code.compareToIgnoreCase(roster[j].getMajor().code) < 0){
                            Student temp = roster[i];
                            roster[i] = roster[j];
                            roster[j] = temp;
                        }
                    }
                }
            }
            System.out.println("* Student roster sorted by school, major **");
            int count = 0;
            while(roster[count] != null){
                System.out.println(roster[count].getProfile().getFname() + " " +
                        roster[count].getProfile().getLname() + " " +
                        roster[count].getProfile().getDob() + " " +
                        "(" + roster[count].getMajor().code + " " + roster[count].getMajor() + " " + roster[count].getMajor().school + ")"
                        + " credits completed: " +
                        roster[count].getCreditCompleted() + " (" + roster[count].standing() + ")");
                count += 1;
            }
            System.out.println("* end of roster **");
        }
    }

    /**
     * This is the print method which sorts the student roster by their standing.
     * and prints it out.
     */
    public void printByStanding(){ //print roster sorted by standing
        if(roster == null){
            System.out.println("Student roster is empty!");
        }else {
            for (int i = 0; i < roster.length; i++) {
                for (int j = 0; j < i + 1; j++) {
                    if (roster[j] != null && roster[i] != null &&
                            roster[i].getCreditCompleted() < roster[j].getCreditCompleted()) {
                        Student temp = roster[i];
                        roster[i] = roster[j];
                        roster[j] = temp;
                    }
                }
            }
            System.out.println("* Student roster sorted by standing **");
            int count = 0;
            while(roster[count] != null){
                System.out.println(roster[count].getProfile().getFname() + " " +
                        roster[count].getProfile().getLname() + " " +
                        roster[count].getProfile().getDob() + " " +
                        "(" + roster[count].getMajor().code + " " + roster[count].getMajor() + " " + roster[count].getMajor().school + ")"
                        + " credits completed: " +
                        roster[count].getCreditCompleted() + " (" + roster[count].standing() + ")");
                count += 1;
            }
            System.out.println("* end of roster **");
        }
    }

    /**
     * This method changes the major of the passed in student.
     * @param student This is the passed in student.
     * @param commands This is the user input of which major the student is changing into.
     * @return Returns true if the student major is valid and false if the student is not found or if
     * an invalid major was passed in.
     */
    public boolean changeMajor(Student student, String[] commands){
        if(contains(student) == true){
            int studentIndex = find(student);
            if(commands[4].equalsIgnoreCase("CS") == true){
                roster[studentIndex].setMajor(Student.Major.CS);
            }else if(commands[4].equalsIgnoreCase("MATH") == true){
                roster[studentIndex].setMajor(Student.Major.MATH);
            }else if(commands[4].equalsIgnoreCase("EE") == true){
                roster[studentIndex].setMajor(Student.Major.EE);
            }else if(commands[4].equalsIgnoreCase("ITI") == true){
                roster[studentIndex].setMajor(Student.Major.ITI);
            }else if(commands[4].equalsIgnoreCase("BAIT") == true){
                roster[studentIndex].setMajor(Student.Major.BAIT);
            }
            return true;
        }else{
            return false;
        }
    }

    /**
     * This method put the students of a specific school into an array of students.
     * @param schools This is the passed in school which the user wants a list of.
     * @return Returns a student array of the students who are in the passed in school.
     */
    public Student[] listSchool(String schools){
        int count = 0;
        if(schools.equalsIgnoreCase("SAS") == true){
            count = getCount(roster, schools);
            Student[] studentSchool = new Student[count];
            int schoolIndex = 0;
            for(int i = 0; i < roster.length; i++){
                if(roster[i] != null && roster[i].getMajor().school.compareToIgnoreCase(schools) == 0){
                    studentSchool[schoolIndex] = roster[i];
                    schoolIndex += 1;
                }
            }
            sortByName(studentSchool);
            return studentSchool;
        }else if(schools.equalsIgnoreCase("SOE") == true){
            count = getCount(roster, schools);
            Student[] studentSchool = new Student[count];
            int schoolIndex = 0;
            for(int i = 0; i < roster.length; i++){
                if(roster[i] != null && roster[i].getMajor().school.compareToIgnoreCase(schools) == 0){
                    studentSchool[schoolIndex] = roster[i];
                    schoolIndex += 1;
                }
            }
            sortByName(studentSchool);
            return studentSchool;
        }else if(schools.equalsIgnoreCase("SC&I") == true){
            count = getCount(roster, schools);
            Student[] studentSchool = new Student[count];
            int schoolIndex = 0;
            for(int i = 0; i < roster.length; i++){
                if(roster[i] != null && roster[i].getMajor().school.compareToIgnoreCase(schools) == 0){
                    studentSchool[schoolIndex] = roster[i];
                    schoolIndex += 1;
                }
            }
            sortByName(studentSchool);
            return studentSchool;
        }else if(schools.equalsIgnoreCase("RBS") == true){
            count = getCount(roster, schools);
            Student[] studentSchool = new Student[count];
            int schoolIndex = 0;
            for(int i = 0; i < roster.length; i++){
                if(roster[i] != null && roster[i].getMajor().school.compareToIgnoreCase(schools) == 0){
                    studentSchool[schoolIndex] = roster[i];
                    schoolIndex += 1;
                }
            }
            sortByName(studentSchool);
            return studentSchool;
        }else{
            Student[] nothing = new Student[0];
            return nothing;
        }
    }

    /**
     * This is a helper method to listSchools to count how many students are in a specific school.
     * @param roster This is the passed in roster of students.
     * @param schools This is the user input of the specific school they want a list of.
     * @return Returns the number of students that are in a specific school.
     */
    public int getCount(Student[] roster, String schools){
        int count = 0;
        for(int i = 0; i < roster.length; i++){
            if(roster[i] != null && roster[i].getMajor().school.compareToIgnoreCase(schools) == 0){
                count += 1;
            }
        }
        return count;
    }
}
