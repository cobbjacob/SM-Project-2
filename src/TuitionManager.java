/**
 * This is the tuition manager where the user input is read and the commands are executed.
 * @author Jaison Prajapati, Jacob Cobb
 */

import java.util.Scanner;
public class TuitionManager {
    Roster studentRoster = new Roster();

    /**
     * This is the class which runs the program.
     * It reads the user input and uses specific methods to perform the
     * tasks.
     */
    public void run(){
        System.out.println("Tuition Manager running...");
        Scanner scan = new Scanner(System.in);
        String command = "";
        String[] commands;
        while(scan.hasNext()){
            command = scan.nextLine();
            commands = command.split("\\s+");

            if(commands[0].equals("A")){
                addStudent(commands);
            }else if(commands[0].equals("R")){
                removeStudent(commands);
            }else if(commands[0].equals("P")){
                displayRoster();
            }else if(commands[0].equals("PS")){
                displayRosterStanding();
            }else if(commands[0].equals("PC")){
                displayRosterSchool();
            }else if(commands[0].equals("L")){
                listStudentsSchool(commands);
            }else if(commands[0].equals("C")){
                changeMajor(commands);
            }else if(commands[0].equals("Q")){
                programExecution();
            }else if(commands[0].equals("LS")){
                loadStudentRoster();
            }else if(commands[0].equals("AR")){
                addResidentStudent();
            }else if(commands[0].equals("AN")){
                addNonResidentStudent();
            }else if(commands[0].equals("AT")){
                addTriStateStudent();
            }else if(commands[0].equals("AI")){
                addInternationalStudent();
            }else if(commands[0].equals("E")){
                enrollStudent();
            }else if(commands[0].equals("D")){
                dropStudent();
            }else if(commands[0].equals("S")){
                awardScholarship();
            }else if(commands[0].equals("PE")){
                displayEnrollmentList();
            }else if(commands[0].equals("PT")){
                displayTuition();
            }else if(commands[0].equals("SE")){
                semesterEnd();
            }else if(commands[0].equals(" ")){
            }else{
                System.out.println(commands[0] + " is an invalid command!");
            }
        }
    }

    public void loadStudentRoster(){

    }

    public void addResidentStudent(){

    }

    public void addNonResidentStudent(){

    }

    public void addTriStateStudent(){

    }

    public void addInternationalStudent(){

    }

    public void enrollStudent(){

    }

    public void dropStudent(){

    }

    public void awardScholarship(){

    }

    public void displayEnrollmentList(){

    }

    public void displayTuition(){

    }

    public void semesterEnd(){

    }

    /**
     * This method adds a student to the roster (A).
     * @param commands This stores the user input as an array of strings
     */
    public void addStudent(String[] commands){
        Profile newProfile = new Profile();
        newProfile.setFname(commands[1]);
        newProfile.setLname(commands[2]);
        Date studentDob = new Date(commands[3]);


        if(studentDob.isValid() == false){
            System.out.println("DOB invalid: " + commands[3] + " not a valid calendar date!");
            return;
        }else if(studentDob.age(studentDob) == false){
            System.out.println("DOB invalid: " + commands[3] + " younger than 16 years old!");
            return;
        }else{
            newProfile.setDob(studentDob);
        }

        boolean validCreditsCompleted = true;
        try{
            Integer.parseInt(commands[5]);
        }catch(NumberFormatException e){
            validCreditsCompleted = false;
            System.out.println("Credits completed invalid: not an integer!");
        }

        if(validCreditsCompleted == true){
            int creditsCompleted = Integer.parseInt(commands[5]);
            if(creditsCompleted < 0){
                System.out.println("Credits completed invalid: cannot be negative!");
                return;
            }else{
                if(commands[4].equalsIgnoreCase("CS") == true){
                    Student newStudent = new Student(newProfile, Student.Major.CS, creditsCompleted);
                    if(studentRoster.contains(newStudent) == true){
                        System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " is already in the roster.");
                        return;
                    }
                    studentRoster.add(newStudent);
                    System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " added to the roster.");
                }else if(commands[4].equalsIgnoreCase("MATH") == true){
                    Student newStudent = new Student(newProfile, Student.Major.MATH, creditsCompleted);
                    if(studentRoster.contains(newStudent) == true){
                        System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " is already in the roster.");
                        return;
                    }
                    studentRoster.add(newStudent);
                    System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " added to the roster.");
                }else if(commands[4].equalsIgnoreCase("EE") == true){
                    Student newStudent = new Student(newProfile, Student.Major.EE, creditsCompleted);
                    if(studentRoster.contains(newStudent) == true){
                        System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " is already in the roster.");
                        return;
                    }
                    studentRoster.add(newStudent);
                    System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " added to the roster.");
                }else if(commands[4].equalsIgnoreCase("ITI") == true){
                    Student newStudent = new Student(newProfile, Student.Major.ITI, creditsCompleted);
                    if(studentRoster.contains(newStudent) == true){
                        System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " is already in the roster.");
                        return;
                    }
                    studentRoster.add(newStudent);
                    System.out.println(commands[1] + " " + commands[2] + " " + commands[3] + " added to the roster.");
                }else if(commands[4].equalsIgnoreCase("BAIT") == true){
                    Student newStudent = new Student(newProfile, Student.Major.BAIT, creditsCompleted);
                    if(studentRoster.contains(newStudent) == true){
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
     * This method removes a specific student from the roster (R).
     * @param commands This is an array of strings which holds the user input commands and information
     */
    public void removeStudent(String[] commands){
        Date rStudentDob = new Date(commands[3]);
        Profile profileStudent = new Profile(commands[2], commands[1], rStudentDob);
        Student removeStudent = new Student(profileStudent);
        if(studentRoster.remove(removeStudent) == true){
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
     * This method lists the students in a specific school (L).
     * @param commands This is an array full of the user inputs.
     */
    public void listStudentsSchool(String[] commands){
        if(studentRoster.listSchool(commands[1]).length == 0){
            System.out.println("School doesn't exist: " + commands[1]);
        }else{
            Student[] schoolList;
            schoolList = studentRoster.listSchool(commands[1]);
            System.out.println("* Students in " + commands[1] + "*");
            for(int i = 0; i < schoolList.length; i++){
                System.out.println(schoolList[i].getProfile().getFname() + " " +
                        schoolList[i].getProfile().getLname() + " " +
                        schoolList[i].getProfile().getDob() + " " +
                        "(" + schoolList[i].getMajor().code + " " + schoolList[i].getMajor() + " " + schoolList[i].getMajor().school + ")"
                        + " credits completed: " +
                        schoolList[i].getCreditCompleted() + " (" + schoolList[i].standing() + ")");
            }
            System.out.println("* end of list **");
        }
    }

    /**
     * This method changes the major of a student (C)
     * @param commands This is an array which holds the user inputs.
     */
    public void changeMajor(String[] commands){
        Date changeStudentDob = new Date(commands[3]);
        Profile changeProfileStudent = new Profile(commands[2], commands[1], changeStudentDob);
        Student changeStudent = new Student(changeProfileStudent);
        if(commands[4].equalsIgnoreCase("CS") == true ||
                commands[4].equalsIgnoreCase("MATH") == true ||
                commands[4].equalsIgnoreCase("EE") == true ||
                commands[4].equalsIgnoreCase("ITI") == true ||
                commands[4].equalsIgnoreCase("BAIT") == true) {
            if (studentRoster.changeMajor(changeStudent, commands) == true) {
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
