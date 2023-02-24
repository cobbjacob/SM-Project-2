/**
 * This is the profile class where the student profiles are.
 * @author Jaison Prajapati, Jacob Cobb
 */

public class Profile implements Comparable<Profile> {
    private String lname;
    private String fname;
    private Date dob; //use the Date class described in (f)

    /**
     * This makes a profile object.
     */
    public Profile(){

    }

    /**
     * This makes a profile object with a last name, first name, and date of birth.
     * @param lname This is the user input last name.
     * @param fname This is the user input first name.
     * @param dob This is the user input date of birht.
     */
    public Profile(String lname, String fname, Date dob){
        this.lname = lname;
        this.fname = fname;
        this.dob = dob;
    }

    //getters
    /**
     * Getter for profile last name
     * @return last name of the profile
     */
    public String getLname(){
        return lname;
    }

    /**
     * Getter for profile first name
     * @return fist name of the profile
     */
    public String getFname(){
        return fname;
    }

    /**
     * Getter for profile date of birth
     * @return date of birth of the profile
     */
    public Date getDob(){
        return dob;
    }

    //setters
    /**
     * Setter for profile last name
     * @param newLname which is set
     */
    public void setLname(String newLname){
        lname = newLname;
    }

    /**
     * Setter for profile first name
     * @param newFname which is set
     */
    public void setFname(String newFname){
        fname = newFname;
    }

    /**
     * Setter for profile date of birth
     * @param newDob which is set
     */
    public void setDob(Date newDob){
        dob = newDob;
    }

    /**
     * This overrides the toString method for the profile object.
     * @return Returns the string format of the profile object.
     */
    @Override //NEED TO FINISH THIS
    public String toString(){
        // Return whatever string needed for this method.
        return "";
    }

    /**
     * This overrides the equals method for the profile object.
     * @param oProfile This is the profile which is being equals to.
     * @return Returns true if the profile is the same and false if the profiles are different.
     */
    @Override
    public boolean equals(Object oProfile){
        boolean firstName = false;
        boolean lastName = false;
        boolean dateOfBirth = false;
        if (oProfile instanceof Profile profile) {
            firstName = this.fname.equalsIgnoreCase(profile.fname);
            lastName = this.lname.equalsIgnoreCase(profile.lname);
            dateOfBirth = this.getDob().getDay() == profile.getDob().getDay() &&
                    this.getDob().getMonth() == profile.getDob().getMonth() &&
                    this.getDob().getYear() == profile.getDob().getYear();
        }

        if(firstName == true && lastName == true && dateOfBirth == true){
            return true;
        }else{
            return false;
        }
    }

    /**
     * This overrides the compareTo method for the profile object.
     * @param profile the object to be compared.
     * @return Returns true if the profiles are the same and false if they are different.
     */
    @Override
    public int compareTo(Profile profile){
        if(this.fname.equals(profile.getFname()) == true && this.lname.equals(profile.getLname()) == true &&
                this.dob.getDay() == profile.getDob().getDay() &&
                this.dob.getMonth() == profile.getDob().getMonth() &&
                this.dob.getYear() == profile.getDob().getYear()){
            return 0;
        }else{
            return -1;
        }
    }

}


