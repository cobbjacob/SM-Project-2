/**
 * This is the student class where the student objects are created.
 * @author Jaison Prajapati, Jacob Cobb
 */

public abstract class Student implements Comparable<Student> {
    private Profile profile;
    private Major major; //Major is an enum type
    private int creditCompleted;
    private Resident resident;
    private NonResident nonResident;
    private International international;
    private boolean studyAbroad;
    private TriState triState;
    private String state;

    /**
     * This methos checks if the credits enrolled is valid.
     * @param creditEnrolled is the input credits enrolled.
     * @return true if the input if valid and false if it is not valid.
     */
    public boolean isValid(int creditEnrolled){ //NEED TO FINISH THIS
        return true;
    } //polymorphism

    /**
     * This method is for polymorphism of the tuition due.
     * @param creditsEnrolled is the input credits enrolled.
     * @return the tuition due.
     */
    public abstract double tuitionDue(int creditsEnrolled); //polymorphism

    /**
     * This method is for polymorphism to see if a student is a resident or not.
     * @return true if the student is a resident and false if not.
     */
    public abstract boolean isResident(); //polymorphism


    /**
     * This is the method which makes student objects with a passed in profile, major, and credits completed.
     * @param profile This is the profile which is passed in.
     * @param major This is the major which is passed in.
     * @param creditCompleted This is the number of credits completed which is passed in.
     */
    public Student(Profile profile, Major major, int creditCompleted){
        this.profile = profile;
        this.major = major;
        this.creditCompleted = creditCompleted;
    }

    /**
     * This is the method which makes student objects with a passed in profile, major, and credits completed.
     * @param profile This is the profile which is passed in.
     * @param major This is the major which is passed in.
     * @param creditCompleted This is the credits completed which is passed in.
     * @param studentState This is the students state which is passed in.
     */
    public Student(Profile profile, Major major, int creditCompleted, String studentState){
        this.profile = profile;
        this.major = major;
        this.creditCompleted = creditCompleted;
        this.state = studentState;
    }

    /**
     * This is the method which makes student objects with a passed in profile, major, and credits completed.
     * @param profile This is the profile which is passed in.
     * @param major This is the major whick is passed in.
     * @param creditCompleted This is the credits completed which is passed in.
     * @param studyAbroad This is whether the student is in study abroad or not.
     */
    public Student(Profile profile, Major major, int creditCompleted, boolean studyAbroad){
        this.profile = profile;
        this.major = major;
        this.creditCompleted = creditCompleted;
        this.studyAbroad = studyAbroad;
    }

    /**
     * This is the method to make a student object with only a profile.
     * @param profile This is the passed in profile.
     */
    public Student(Profile profile){
        this.profile = profile;
    }

    /**
     * This is the enum method for the majors and their class code and school.
     */
    public enum Major{
        CS ("01:198", "SAS"),
        MATH ("01:640", "SAS"),
        EE ("14:332", "SOE"),
        ITI ("04:547", "SC&I"),
        BAIT ("33:136", "RBS");
        String code;
        String school;
        Major(String c, String s){
            code = c;
            school = s;

        }
    }

    /**
     * This is a helper method which tells you which year a student is.
     * @return Returns a string of the type of student they are.
     */
    public String standing(){
        if(creditCompleted < 30){
            return "Freshman";
        }else if(creditCompleted >= 30 && creditCompleted < 60){
            return "Sophomore";
        }else if(creditCompleted >= 60 && creditCompleted < 90 ){
            return "Junior";
        }else{
            return "Senior";
        }
    }

    //getters
    /**
     * Getter for profile
     * @return the student's profile
     */
    public Profile getProfile(){
        return profile;
    }

    /**
     * Getter for major
     * @return the student's major
     */
    public Major getMajor(){
        return major;
    }

    /**
     * Getter for the credits completed
     * @return the student's credits completed
     */
    public int getCreditCompleted(){
        return creditCompleted;
    }

    /**
     * Getter for the resident
     * @return the resident
     */
    public Resident getResident(){
        return resident;
    }

    /**
     * Getter for the non resident
     * @return the non resident
     */
    public NonResident getNonResident(){
        return nonResident;
    }

    /**
     * Getter for the international student
     * @return the international student
     */
    public International getInternational(){
        return international;
    }

    /**
     * Getter for the triState student
     * @return the triState student.
     */
    public TriState getTriState(){
        return triState;
    }

    //setters
    /**
     * Setter for new profile
     * @param newProfile which is set
     */
    public void setProfile(Profile newProfile){
        profile = newProfile;
    }

    /**
     * Setter for new major
     * @param newMajor which is set
     */
    public void setMajor(Major newMajor){
        major = newMajor;
    }

    /**
     * Setter for credits completed
     * @param newCreditCompleted which is set
     */
    public void setCreditCompleted(int newCreditCompleted){
        creditCompleted = newCreditCompleted;
    }

    /**
     * Setter for the resident
     * @param newResident is set
     */
    public void setResident(Resident newResident){
        resident = newResident;
    }

    /**
     * Setter for the nonresident
     * @param newNonResident is set
     */
    public void setNonResident(NonResident newNonResident){
        nonResident = newNonResident;
    }

    /**
     * Setter for the international student
     * @param newInternational is set
     */
    public void setInternational(International newInternational){
        international = newInternational;
    }

    /**
     * Setter for the tristate
     * @param newTriState is set
     */
    public void setTriState(TriState newTriState){
        triState = newTriState;
    }

    /**
     * This overrides the toString method for the Student object.
     * @return This returns a string value of the student object.
     */
    @Override
    public String toString(){
        return profile.getFname() + " " + profile.getLname() + " " + profile.getDob();
    }

    /**
     * This overrides the equals method for the student object.
     * @param oStudent This is the student which is passed in.
     * @return Returns true if they are the same and false if they are different.
     */
    @Override
    public boolean equals(Object oStudent){
        if (oStudent instanceof Student student){
            boolean oProfile = this.profile.equals(student.profile);
            boolean oMajor = this.major.equals(student.major);
            boolean oCredits = this.creditCompleted == student.creditCompleted;
            return oProfile && oMajor && oCredits;
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
        if(this.profile.equals(student.getProfile()) == true){
            return 0;
        }else{
            return -1;
        }
    }

    /**
     * Helper method for testMain to compare two boolean values
     * @param expected boolean value 1
     * @param actual boolean value 2
     */

    public static void testResult(int expected, int actual){
        if (expected == actual){
            System.out.println("\n passed");
        }
        else{
            System.out.println("\n failed");
        }
    }



    /*
    public static void main(String[] args){
        Date date = new Date("1/1/2001");
        Profile p1 = new Profile("John", "Doe", date);
        Profile p2 = new Profile("John", "Doe", date);
        Student s1 = new Student(p1);
        Student s2 = new Student(p2);
        int expectedOutput = 0;
        int actualOutput = s1.compareTo(s2);
        System.out.print("** Test case #1: Students are identical (base case)");
        testResult(expectedOutput, actualOutput);

        date = new Date("1/1/2001");
        p1 = new Profile("John", "Doe", date);
        date = new Date("1/1/2002");
        p2 = new Profile("John", "Doe", date);
        s1 = new Student(p1);
        s2 = new Student(p2);
        expectedOutput = -1;
        actualOutput = s1.compareTo(s2);
        System.out.print("** Test case #2: Student names are identical but birthdays are different");
        testResult(expectedOutput, actualOutput);

        date = new Date("1/1/2001");
        p1 = new Profile("John", "Doe", date);
        date = new Date("1/1/2001");
        p2 = new Profile("James", "Doe", date);
        s1 = new Student(p1);
        s2 = new Student(p2);
        expectedOutput = -1;
        actualOutput = s1.compareTo(s2);
        System.out.print("** Test case #3: Student 1's first name differ slightly; last name & dob are identical");
        testResult(expectedOutput, actualOutput);

        date = new Date("1/1/2001");
        p1 = new Profile("John", "Doe", date);
        date = new Date("1/1/2001");
        p2 = new Profile("JoHN", "Doe", date);
        s1 = new Student(p1);
        s2 = new Student(p2);
        expectedOutput = 0;
        actualOutput = s1.compareTo(s2);
        System.out.print("** Test case #4: Same first name but different capitalization; last name & dob are identical");
        testResult(expectedOutput, actualOutput);
    }
    */

}

