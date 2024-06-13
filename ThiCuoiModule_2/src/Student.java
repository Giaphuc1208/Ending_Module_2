public class Student extends Person {
    private static int lastedStudentCode = 0;
    private int studentCode;
    private int classCode;

    public Student(String name, String dateOfBirth, String gender, String phoneNumber, int classCode) {
        super(name, dateOfBirth, gender, phoneNumber);
        this.studentCode = lastedStudentCode + 1;
        this.classCode = classCode;
    }

    public int getStudentCode() {
        return this.studentCode;
    }

    public void setStudentCode(int studentCode) {
        this.studentCode = studentCode;
    }

    public int getClassCode() {
        return this.classCode;
    }

    public void setClassCode(int classCode) {
        this.classCode = classCode;
    }

    public String getData() {
        int var10000 = this.getClassCode();
        return "" + var10000 + "," + this.getName() + "," + this.getDateOfBirth() + "," + this.getGender() + "," + this.getPhoneNumber();
    }

    public String toString() {
        ClassRoom classRoom = StudentManager.findClassRoomByClassCode(this.classCode);
        int var10000 = this.studentCode;
        return "Student{studentCode='" + var10000 + "', classCode='" + this.classCode + "', className='" + classRoom.getClassName() + "', teacherName='" + classRoom.getClassName() + "'} " + super.toString() + StudentManager.findTeacherByTeacherID(classRoom.getTeacherCode()).toString();
    }
}
