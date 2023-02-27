/**
 * This is the tuition manager where the user input is read and the commands are executed.
 * @author Jaison Prajapati, Jacob Cobb
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class TuitionManager {
    Roster studentRoster = new Roster();
    Enrollment studentsEnrolled = new Enrollment();

    /**
     * This is the class which runs the program.
     * It reads the user input and uses specific methods to perform the
     * tasks.
     */
    public void run() throws FileNotFoundException {
        System.out.println("Tuition Manager running...");
        Scanner scan = new Scanner(System.in);
        String command = "";
        String[] commands;
        while(scan.hasNext()){
            command = scan.nextLine();
            commands = command.split("\\s+");
            if(commands[0].equals("R")){removeStudent(commands);}
            else if(commands[0].equals("P")){displayRoster();}
            else if(commands[0].equals("PS")){displayRosterStanding();}
            else if(commands[0].equals("PC")){displayRosterSchool();}
            else if(commands[0].equals("C")){changeMajor(commands);}
            else if(commands[0].equals("Q")){programExecution();}
            else if(commands[0].equals("LS")){loadStudentRoster();}
            else if(commands[0].equals("AR")){addResidentStudent(commands);}
            else if(commands[0].equals("AN")){addNonResidentStudent(commands);}
            else if(commands[0].equals("AT")){addTriStateStudent(commands);}
            else if(commands[0].equals("AI")){addInternationalStudent(commands);}
            else if(commands[0].equals("E")){enrollStudent(commands);}
            else if(commands[0].equals("D")){dropStudent(commands);}
            else if(commands[0].equals("S")){awardScholarship();}
            else if(commands[0].equals("PE")){displayEnrollmentList();}
            else if(commands[0].equals("PT")){displayTuition();}
            else if(commands[0].equals("SE")){semesterEnd();}
            else if(commands[0].equals("\\s")){}
            else{System.out.println(commands[0] + " is an invalid command!");}
        }
    }

    /**
     * This is where teh students are sorted by the where they are from
     * @throws FileNotFoundException if the text file is not found.
     */
    public void loadStudentRoster() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("studentList.txt"));
        String studentCommand = "";
        String[] studentCommands;
        while(scanner.hasNext()) {
            studentCommand = scanner.nextLine();
            studentCommands = studentCommand.split(",");
            if(studentCommands[0].equals("R")){
                addResidentStudent(studentCommands);
            }else if(studentCommands[0].equals("N")){
                addNonResidentStudent(studentCommands);
            }else if(studentCommands[0].equals("T")){
                addTriStateStudent(studentCommands);
            }else if(studentCommands[0].equals("I")){
                addInternationalStudent(studentCommands);
            }
        }
        System.out.println("Students loaded to the roster");
    }

    /**
     * This method adds a resident student to the roster.
     * @param commands is the user input used to create the student.
     */
    public void addResidentStudent(String[] commands){
        if(commands.length < 6){
            System.out.println("Missing data in line command.");
        }else{
            Profile newProfile = new Profile();
            newProfile.setFname(commands[1]);
            newProfile.setLname(commands[2]);
            Date studentDob = new Date(commands[3]);

            if(validCredits(commands) == true && validDateOfBirth(studentDob, commands) == true){
                newProfile.setDob(studentDob);
                int creditsCompleted = Integer.parseInt(commands[5]);
                if(commands[4].equalsIgnoreCase("CS") == true){
                    Student newStudent = new Resident().Student(newProfile, Student.Major.CS, creditsCompleted);
                    if(studentRoster.contains(newProfile) == true){
                        System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " is already in the roster.");
                        return;
                    }
                    studentRoster.add(newStudent);
                    System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " added to the roster.");
                }else if(commands[4].equalsIgnoreCase("MATH") == true){
                    Student newStudent = new Resident().Student(newProfile, Student.Major.MATH, creditsCompleted);
                    if(studentRoster.contains(newProfile) == true){
                        System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " is already in the roster.");
                        return;
                    }
                    studentRoster.add(newStudent);
                    System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " added to the roster.");
                }else if(commands[4].equalsIgnoreCase("EE") == true){
                    Student newStudent = new Resident().Student(newProfile, Student.Major.EE, creditsCompleted);
                    if(studentRoster.contains(newProfile) == true){
                        System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " is already in the roster.");
                        return;
                    }
                    studentRoster.add(newStudent);
                    System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " added to the roster.");
                }else if(commands[4].equalsIgnoreCase("ITI") == true){
                    Student newStudent = new Resident().Student(newProfile, Student.Major.ITI, creditsCompleted);
                    if(studentRoster.contains(newProfile) == true){
                        System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " is already in the roster.");
                        return;
                    }
                    studentRoster.add(newStudent);
                    System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " added to the roster.");
                }else if(commands[4].equalsIgnoreCase("BAIT") == true){
                    Student newStudent = new Resident().Student(newProfile, Student.Major.BAIT, creditsCompleted);
                    if(studentRoster.contains(newProfile) == true){
                        System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " is already in the roster.");
                        return;
                    }
                    studentRoster.add(newStudent);
                    System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " added to the roster.");
                }else{
                    System.out.println("Major code invalid: " + commands[4]);
                }
            }
        }
    }

    /**
     * This method adds a non-resident student to the roster.
     * @param commands is the user input used to create the student.
     */
    public void addNonResidentStudent(String[] commands){
        if(commands.length < 6){
            System.out.println("Missing data in line command.");
        }else{
            Profile newProfile = new Profile();
            newProfile.setFname(commands[1]);
            newProfile.setLname(commands[2]);
            Date studentDob = new Date(commands[3]);

            if(validCredits(commands) == true && validDateOfBirth(studentDob, commands) == true){
                newProfile.setDob(studentDob);
                int creditsCompleted = Integer.parseInt(commands[5]);
                if(commands[4].equalsIgnoreCase("CS") == true){
                    Student newStudent = new NonResident().Student(newProfile, Student.Major.CS, creditsCompleted);
                    if(studentRoster.contains(newProfile) == true){
                        System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " is already in the roster.");
                        return;
                    }
                    studentRoster.add(newStudent);
                    System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " added to the roster.");
                }else if(commands[4].equalsIgnoreCase("MATH") == true){
                    Student newStudent = new NonResident().Student(newProfile, Student.Major.MATH, creditsCompleted);
                    if(studentRoster.contains(newProfile) == true){
                        System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " is already in the roster.");
                        return;
                    }
                    studentRoster.add(newStudent);
                    System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " added to the roster.");
                }else if(commands[4].equalsIgnoreCase("EE") == true){
                    Student newStudent = new NonResident().Student(newProfile, Student.Major.EE, creditsCompleted);
                    if(studentRoster.contains(newProfile) == true){
                        System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " is already in the roster.");
                        return;
                    }
                    studentRoster.add(newStudent);
                    System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " added to the roster.");
                }else if(commands[4].equalsIgnoreCase("ITI") == true){
                    Student newStudent = new NonResident().Student(newProfile, Student.Major.ITI, creditsCompleted);
                    if(studentRoster.contains(newProfile) == true){
                        System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " is already in the roster.");
                        return;
                    }
                    studentRoster.add(newStudent);
                    System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " added to the roster.");
                }else if(commands[4].equalsIgnoreCase("BAIT") == true){
                    Student newStudent = new NonResident().Student(newProfile, Student.Major.BAIT, creditsCompleted);
                    if(studentRoster.contains(newProfile) == true){
                        System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " is already in the roster.");
                        return;
                    }
                    studentRoster.add(newStudent);
                    System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " added to the roster.");
                }else{
                    System.out.println("Major code invalid: " + commands[4]);
                }
            }
        }
    }

    /**
     * This method adds a triState student to the roster.
     * @param commands is the user input used to create the student.
     */
    public void addTriStateStudent(String[] commands){
        if(commands.length < 6){
            System.out.println("Missing data in line command.");
        }else if(commands.length == 6) {
            System.out.println("Missing the state code.");
        }else{
            Profile newProfile = new Profile();
            newProfile.setFname(commands[1]);
            newProfile.setLname(commands[2]);
            Date studentDob = new Date(commands[3]);
            if(validCredits(commands) == true && validDateOfBirth(studentDob, commands) == true && checkState(commands[6]) == true){
                newProfile.setDob(studentDob);
                int creditsCompleted = Integer.parseInt(commands[5]);
                if(commands[4].equalsIgnoreCase("CS") == true){
                    Student newStudent = new TriState().Student(newProfile, Student.Major.CS, creditsCompleted, commands[6]);
                    if(studentRoster.contains(newProfile) == true){
                        System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " is already in the roster.");
                        return;
                    }
                    studentRoster.add(newStudent);
                    System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " added to the roster.");
                }else if(commands[4].equalsIgnoreCase("MATH") == true){
                    Student newStudent = new TriState().Student(newProfile, Student.Major.MATH, creditsCompleted, commands[6]);
                    if(studentRoster.contains(newProfile) == true){
                        System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " is already in the roster.");
                        return;
                    }
                    studentRoster.add(newStudent);
                    System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " added to the roster.");
                }else if(commands[4].equalsIgnoreCase("EE") == true){
                    Student newStudent = new TriState().Student(newProfile, Student.Major.EE, creditsCompleted, commands[6]);
                    if(studentRoster.contains(newProfile) == true){
                        System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " is already in the roster.");
                        return;
                    }
                    studentRoster.add(newStudent);
                    System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " added to the roster.");
                }else if(commands[4].equalsIgnoreCase("ITI") == true){
                    Student newStudent = new TriState().Student(newProfile, Student.Major.ITI, creditsCompleted, commands[6]);
                    if(studentRoster.contains(newProfile) == true){
                        System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " is already in the roster.");
                        return;
                    }
                    studentRoster.add(newStudent);
                    System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " added to the roster.");
                }else if(commands[4].equalsIgnoreCase("BAIT") == true){
                    Student newStudent = new TriState().Student(newProfile, Student.Major.BAIT, creditsCompleted, commands[6]);
                    if(studentRoster.contains(newProfile) == true){
                        System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " is already in the roster.");
                        return;
                    }
                    studentRoster.add(newStudent);
                    System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " added to the roster.");
                }else{
                    System.out.println("Major code invalid: " + commands[4]);
                }
            }
        }
    }

    /**
     * This method adds an international student to the roster.
     * @param commands is the user input used to create the student.
     */
    public void addInternationalStudent(String[] commands){
        if(commands.length < 6){
            System.out.println("Missing data in line command.");
        }else{
            Profile newProfile = new Profile();
            newProfile.setFname(commands[1]);
            newProfile.setLname(commands[2]);
            Date studentDob = new Date(commands[3]);
            boolean isStudyAbroad = isStudyAbroad(commands);
            if(validCredits(commands) == true && validDateOfBirth(studentDob, commands) == true){
                newProfile.setDob(studentDob);
                int creditsCompleted = Integer.parseInt(commands[5]);
                if(commands[4].equalsIgnoreCase("CS") == true){
                    Student newStudent = new International().Student(newProfile, Student.Major.CS, creditsCompleted, isStudyAbroad);
                    if(studentRoster.contains(newProfile) == true){
                        System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " is already in the roster.");
                        return;
                    }
                    studentRoster.add(newStudent);
                    System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " added to the roster.");
                }else if(commands[4].equalsIgnoreCase("MATH") == true){
                    Student newStudent = new International().Student(newProfile, Student.Major.MATH, creditsCompleted, isStudyAbroad);
                    if(studentRoster.contains(newProfile) == true){
                        System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " is already in the roster.");
                        return;
                    }
                    studentRoster.add(newStudent);
                    System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " added to the roster.");
                }else if(commands[4].equalsIgnoreCase("EE") == true){
                    Student newStudent = new International().Student(newProfile, Student.Major.EE, creditsCompleted, isStudyAbroad);
                    if(studentRoster.contains(newProfile) == true){
                        System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " is already in the roster.");
                        return;
                    }
                    studentRoster.add(newStudent);
                    System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " added to the roster.");
                }else if(commands[4].equalsIgnoreCase("ITI") == true){
                    Student newStudent = new International().Student(newProfile, Student.Major.ITI, creditsCompleted, isStudyAbroad);
                    if(studentRoster.contains(newProfile) == true){
                        System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " is already in the roster.");
                        return;
                    }
                    studentRoster.add(newStudent);
                    System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " added to the roster.");
                }else if(commands[4].equalsIgnoreCase("BAIT") == true){
                    Student newStudent = new International().Student(newProfile, Student.Major.BAIT, creditsCompleted, isStudyAbroad);
                    if(studentRoster.contains(newProfile) == true){
                        System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " is already in the roster.");
                        return;
                    }
                    studentRoster.add(newStudent);
                    System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " added to the roster.");
                }else{
                    System.out.println("Major code invalid: " + commands[4]);
                }
            }
        }
    }

    /**
     * This method enrolls the student into the enrollment array.
     * @param commands This is the passed in input.
     */
    public void enrollStudent(String[] commands){
        if(commands.length < 5){
            System.out.println("Missing data in line command.");
        }else {
            Profile newProfile = new Profile();
            newProfile.setFname(commands[1]);
            newProfile.setLname(commands[2]);
            Date studentDob = new Date(commands[3]);
            if(validCreditsEnroll(commands) == true && validDateOfBirth(studentDob, commands) == true){
                newProfile.setDob(studentDob);
                if(rosterProfile(newProfile) == true){
                    Student oldStudent = getOldProfile(newProfile);
                    int credits = Integer.parseInt(commands[4]);

                    //check if type of student + credits valid to enroll
                    if(credits < 3){
                        System.out.println("(Resident) " + credits + ": Invalid credit hours.");
                    }
                    if(credits > 24){
                        System.out.println("(Non-Resident) " + credits + ": Invalid credit hours.");
                    }

                    EnrollStudent newEnroll = new EnrollStudent(newProfile, credits);
                    studentsEnrolled.add(newEnroll);
                    System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " enrolled " + commands[4] + " credits.");
                }
            }
        }
    }

    /**
     * This method drops a student from the enrollment array.
     * @param commands This is the user input.
     */
    public void dropStudent(String[] commands){
        Date rStudentDob = new Date(commands[3]);
        Profile profileStudent = new Profile(commands[2], commands[1], rStudentDob);
        EnrollStudent droppedStudent = new EnrollStudent(profileStudent);
        if(studentsEnrolled.contains(droppedStudent) == true){
            studentsEnrolled.remove(droppedStudent);
            System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " dropped.");
        }else{
            System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " is not enrolled.");
        }
    }

    /**
     * This method awards a scholarship to a certain student.
     */
    public void awardScholarship(){

    }

    /**
     * This method displays the enrollment list as it is.
     */
    public void displayEnrollmentList(){
        studentsEnrolled.print();
    }

    /**
     * This method displays the enrollment list based on tuition.
     */
    public void displayTuition(){
        studentsEnrolled.printTuition();
    }

    /**
     * This method displays the students who have more than 120 credits.
     */
    public void semesterEnd(){

    }

    /**
     * This method find the profile of a student if they are in the roster.
     * @param newProfile This is the passed in profile of the student we are trying to find.
     * @return the student in the roster.
     */
    public Student getOldProfile(Profile newProfile){
        if(rosterProfile(newProfile) == true){
            return studentRoster.getType(newProfile);
        }else{
            return null;
        }
    }

    /**
     * This method tells you if the student we are looking for exists in the roster or not.
     * @param newProfile is the passed in student we are looking for.
     * @return the student if they are in the roster and null if they aren't.
     */
    public boolean rosterProfile(Profile newProfile){
        if(studentRoster.contains(newProfile) == true){
            return true;
        }else{
            System.out.println("Cannot enroll: " + newProfile.getFname() + " " + newProfile.getLname()
                    + " " + newProfile.getDob() + " is not in the roster.");
            return false;
        }
    }

    /**
     * This method tells you if a student is study abroad or not.
     * @param commands is the input of the user.
     * @return true if they are study abroad and false if they aren't.
     */
    public boolean isStudyAbroad(String[] commands){
        if(commands.length == 6){
            return false;
        }else if(commands[6].equalsIgnoreCase("True")){
            return true;
        }else{
            return false;
        }
    }

    /**
     * This method checks the state of the tristate student.
     * @param state is the input string of the state by the user.
     * @return true if the state is valid and false if the state is invalid.
     */
    public boolean checkState(String state) {
        if(state.equalsIgnoreCase("NY") || state.equalsIgnoreCase("CT")) {
            return true;
        }else {
            System.out.println(state + ": Invalid state code.");
            return false;
        }
    }

    /**
     * This method checks if the credits to enroll are valid or not
     * @param commands is the input by the user
     * @return true if the credits are valid and false if they are not valid.
     */
    public boolean validCreditsEnroll(String[] commands){
        boolean validCreditsCompleted = true;
        try{
            Integer.parseInt(commands[4]);
        }catch(NumberFormatException e){
            validCreditsCompleted = false;
            System.out.println("Credits enrolled is not an integer.");
        }

        if(validCreditsCompleted == true){
            int creditsCompleted = Integer.parseInt(commands[4]);
            if(creditsCompleted < 0) {
                System.out.println("Credits completed invalid: cannot be negative!");
                validCreditsCompleted = false;
            }
        }

        return validCreditsCompleted;
    }

    /**
     * This is a method to check the credits of the roster
     * @param commands is the input of the user.
     * @return true if the credit input is valid and false if it is not valid.
     */
    public boolean validCredits(String[] commands){
        boolean validCreditsCompleted = true;
        try{
            Integer.parseInt(commands[5]);
        }catch(NumberFormatException e){
            validCreditsCompleted = false;
            System.out.println("Credits completed invalid: not an integer!");
        }

        if(validCreditsCompleted == true){
            int creditsCompleted = Integer.parseInt(commands[5]);
            if(creditsCompleted < 0) {
                System.out.println("Credits completed invalid: cannot be negative!");
                validCreditsCompleted = false;
            }
        }

        return validCreditsCompleted;
    }

    /**
     * This method checks to see if the date of birth is valid
     * @param studentDob is the date of birth of the student
     * @param commands is the input by the user
     * @return true if the date of birth is valid and false if it is not valid
     */
    public boolean validDateOfBirth(Date studentDob, String[] commands){
        if(studentDob.isValid() == false){
            System.out.println("DOB invalid: " + commands[3] + " not a valid calendar date!");
            return false;
        }else if(studentDob.age(studentDob) == false){
            System.out.println("DOB invalid: " + commands[3] + " younger than 16 years old!");
            return false;
        }else{
            return true;
        }
    }

    /**
     * This method removes a specific student from the roster (R).
     * @param commands This is an array of strings which holds the user input commands and information
     */
    public void removeStudent(String[] commands){
        Date rStudentDob = new Date(commands[3]);
        Profile profileStudent = new Profile(commands[2], commands[1], rStudentDob);
        if(studentRoster.remove(profileStudent) == true){
            System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " removed from the roster.");
        }else{
            System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " is not in the roster.");
        }
    }

    /**
     * This method displays the students in the roster and sorts them in last name, first name, date of birth order (P).
     */
    public void displayRoster(){
        studentRoster.print();
    }

    /**
     * This method displays the students in the roster and sorts them by their standing (PS).
     */
    public void displayRosterStanding(){
        studentRoster.printByStanding();
    }

    /**
     * This method displays the students in the roster and sorts them by their major in alphabetical order (PC).
     */
    public void displayRosterSchool(){
        studentRoster.printBySchoolMajor();
    }

    /**
     * This method changes the major of a student (C)
     * @param commands This is an array which holds the user inputs.
     */
    public void changeMajor(String[] commands){
        Date changeStudentDob = new Date(commands[3]);
        Profile changeProfileStudent = new Profile(commands[2], commands[1], changeStudentDob);
        if(commands[4].equalsIgnoreCase("CS") == true ||
                commands[4].equalsIgnoreCase("MATH") == true ||
                commands[4].equalsIgnoreCase("EE") == true ||
                commands[4].equalsIgnoreCase("ITI") == true ||
                commands[4].equalsIgnoreCase("BAIT") == true) {
            if (studentRoster.changeMajor(changeProfileStudent, commands) == true) {
                System.out.println(commands[1] + " " + commands[2] + " " + commands[3] +
                        " major changed to " + commands[4]);
            } else {
                System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " is not in the roster.");
            }
        }else{
            System.out.println("Major code invalid: " + commands[4]);
        }
    }

    /**
     * This method terminates the program when the user inputs "Q".
     */
    public void programExecution(){
        System.out.println("Roster Manager terminated.");
        System.exit(0);
    }
}
