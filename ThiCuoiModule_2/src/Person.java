public abstract class Person {
    private String name;
    private String dateOfBirth;
    private String gender;
    private String phoneNumber;

    public Person(String name, String dateOfBirth, String gender, String phoneNumber) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    abstract String getData();

    public String toString() {
        return "Person{name='" + this.name + "', dateOfBirth='" + this.dateOfBirth + "', gender='" + this.gender + "', phoneNumber='" + this.phoneNumber + "'}";
    }
}
