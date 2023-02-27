/**
 * This is the enroll student object where you can create student who are going to be enrolled into the enrollment.
 * @author Jaison Prajapati
 */
public class EnrollStudent {
    private Profile profile;
    private int creditsEnrolled;

    /**
     * This method creates an enrollstudent object with the given parameters.
     * @param profile is the profile of the student.
     * @param creditsEnrolled is the credits enrolled of the student.
     */
    public EnrollStudent(Profile profile, int creditsEnrolled){
        this.profile = profile;
        this.creditsEnrolled = creditsEnrolled;
    }

    /**
     * This method creates and enrollstudent object with the given parameters.
     * @param profile is the profile of the student.
     */
    public EnrollStudent(Profile profile){
        this.profile = profile;
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
     * Getter for the credits completed
     * @return the student's credits completed
     */
    public int getCreditsEnrolled(){
        return creditsEnrolled;
    }

    //setters

    /**
     * Setter for the profile
     * @param profile is the input profile to set
     */
    public void setProfile(Profile profile){
        this.profile = profile;
    }

    /**
     * Setter  for the credits enrolled
     * @param creditsEnrolled is the input of credits enrolled to set
     */
    public void setCreditsEnrolled(int creditsEnrolled){
        this.creditsEnrolled = creditsEnrolled;
    }

    /**
     * This is the override equals method for the enroll student class.
     * @param oEnrollStudent is the object to equal.
     * @return true if the objects are the same and false if they are not the same.
     */
    @Override
    public boolean equals(Object oEnrollStudent){
        if (oEnrollStudent instanceof EnrollStudent enrollStudent){
            boolean oProfile = this.profile.equals(enrollStudent.profile);
            boolean oCreditsEnrolled = this.creditsEnrolled == enrollStudent.creditsEnrolled;
            return oProfile && oCreditsEnrolled;
        }
        return false;
    }

    /**
     * This is the override compareTo method for the enroll student class
     * @param enrollStudent is the object to compare to.
     * @return 0 if the objects are the same and -1 if they are not the same.
     */
    public int compareTo(EnrollStudent enrollStudent){
        if(this.profile.equals(enrollStudent.getProfile()) == true){
            return 0;
        }else{
            return -1;
        }
    }
}
