public class Teacher extends Person {
    private int teacherID;

    public Teacher(int id, String name, String dateOfBirth, String gender, String phoneNumber) {
        super(name, dateOfBirth, gender, phoneNumber);
        this.teacherID = id;
    }

    public int getTeacherID() {
        return this.teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    String getData() {
        return "";
    }

    public String toString() {
        int var10000 = this.teacherID;
        return "Teacher{teacherID='" + var10000 + "'} " + super.toString();
    }
}
