public class EnrollStudent {
    private Profile profile;
    private int creditsEnrolled;

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
    public void setProfile(Profile profile){
        this.profile = profile;
    }

    public void setCreditsEnrolled(int creditsEnrolled){
        this.creditsEnrolled = creditsEnrolled;
    }
}
