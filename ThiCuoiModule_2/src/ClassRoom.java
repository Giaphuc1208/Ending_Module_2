public class ClassRoom {
    private int classCode;
    private String className;
    private int teacherCode;

    public ClassRoom() {
    }

    public ClassRoom(int classCode, String className, int teacherCode) {
        this.classCode = classCode;
        this.className = className;
        this.teacherCode = teacherCode;
    }

    public int getClassCode() {
        return this.classCode;
    }

    public void setClassCode(int classCode) {
        this.classCode = classCode;
    }

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getTeacherCode() {
        return this.teacherCode;
    }

    public String toString() {
        return "ClassC03{classCode='" + this.classCode + "', className='" + this.className + "', teacherCode='" + this.teacherCode + "'}";
    }
}
