public class Patient {
    private int patientId;
    private String firstName;
    private String lastName;
    private String dob;

    public Patient(int id, String fName, String lName, String dob) {
        this.patientId = id;
        this.firstName = fName;
        this.lastName = lName;
        this.dob = dob;
    }

    public String toString() {
        return patientId + "-" + firstName + "" + lastName + "(DOB: " + dob + ")";
    }
}
