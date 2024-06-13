//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class StudentManager {
    private static final String REGEX_PHONE_NUMBER = "^(090|091)\\d{7}$";
    private final ArrayList<Student> students = new ArrayList();
    private final ArrayList<Teacher> teachers = new ArrayList();
    private final ArrayList<ClassRoom> classRooms = new ArrayList();
    private static final StudentManager studentManager = new StudentManager();

    private StudentManager() {
        this.teachers.add(new Teacher(1, "Teacher 1", "01/01/2001", "Male", "0908765152"));
        this.teachers.add(new Teacher(2, "Teacher 2", "01/01/2001", "Male", "0907162718"));
        this.classRooms.add(new ClassRoom(1, "Class 1", 1));
        this.classRooms.add(new ClassRoom(2, "Class 2", 2));
        this.readFile();
    }

    public static StudentManager getInstance() {
        return studentManager;
    }

    public void start() {
        while(true) {
            this.showMenu();
            int choice = Helper.getInt();
            switch (choice) {
                case 1:
                    this.add();
                    break;
                case 2:
                    this.delete();
                    break;
                case 3:
                    this.showList();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Không hợp lệ, vui lòng chọn lại!!");
            }
        }
    }

    private Student findStudentByStudentCode(String studentCode) {
        Iterator var2 = this.students.iterator();

        Student student;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            student = (Student)var2.next();
        } while(student.getStudentCode() != Integer.parseInt(studentCode));

        return student;
    }

    private void delete() {
        System.out.println("Vui lòng nhập mã học sinh:");
        String studentCode = Helper.getText();
        Student student = this.findStudentByStudentCode(studentCode);
        if (student == null) {
            System.out.println("Không tìm thấy hoọc sinh này!");
        } else {
            while(true) {
                System.out.println("Xác nhận xóa:");
                System.out.println("1. Yes");
                System.out.println("2. No");
                int choice = Helper.getInt();
                if (choice == 1) {
                    this.students.remove(student);
                    System.out.println("Xóa thành công!");
                    this.updateFile();
                    return;
                }

                if (choice == 2) {
                    return;
                }

                System.err.println("Không hợp lệ, vui lòng chọn lại!");
            }
        }
    }

    private void showList() {
        if (this.students.isEmpty()) {
            System.out.println("Chưa có học sinh nào!");
        } else {
            System.out.println("Danh sách học sinh: ");
            Iterator var1 = this.students.iterator();

            while(var1.hasNext()) {
                Student student = (Student)var1.next();
                System.out.println(student);
            }

        }
    }

    public void showMenu() {
        System.out.println("-- STUDENT MANAGER --");
        System.out.println("Select options by number (to continue): ");
        System.out.println("1. Add new");
        System.out.println("2. Delete");
        System.out.println("3. View Student List");
        System.out.println("4. EXIT");
        System.out.println("Select options:");
    }

    public void add() {
        String name = "";
        String dob = "";
        String gender = "";
        String phone = "";

        int classId;
        for(classId = 0; name.isEmpty() || name.length() < 4 || name.length() > 50; name = Helper.getText()) {
            System.out.println("Enter a name between 4 and 50 characters:");
        }

        while(gender.isEmpty()) {
            System.out.println("Enter gender:");
            gender = Helper.getText();
        }

        while(!this.validateDate(dob)) {
            System.out.println("Nhập ngày sinh đúng định dạng (dd/MM/yyyy):");
            dob = Helper.getText();
        }

        while(phone.isEmpty() || !phone.matches("^(090|091)\\d{7}$")) {
            System.out.println("Số điện thoại bắt đầu bằng 090 hoặc 091 và chưa tồn tại:");
            phone = Helper.getText();
            if (this.checkExitsPhone(phone)) {
                phone = "";
            }
        }

        while(classId == 0 || !this.checkExitsClassId(classId)) {
            System.out.println("Nhập mã lớp:");
            classId = Helper.getInt();
        }

        Student student = new Student(name, dob, gender, phone, classId);
        this.students.add(student);
        this.updateFile();
        System.out.println("Thêm học sinh thành công!");
    }

    private void updateFile() {
        try {
            FileWriter fileWriter = new FileWriter("src/student.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            Iterator var3 = this.students.iterator();

            while(var3.hasNext()) {
                Student student = (Student)var3.next();
                bufferedWriter.write(student.getData());
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception var5) {
            var5.printStackTrace();
        }

    }

    private boolean checkExitsClassId(int classId) {
        Iterator var2 = this.classRooms.iterator();

        ClassRoom classRoom;
        do {
            if (!var2.hasNext()) {
                return false;
            }

            classRoom = (ClassRoom)var2.next();
        } while(classRoom.getClassCode() != classId);

        return true;
    }

    private boolean checkExitsPhone(String phoneNumber) {
        Iterator var2 = this.students.iterator();

        Student student;
        do {
            if (!var2.hasNext()) {
                return false;
            }

            student = (Student)var2.next();
        } while(!student.getPhoneNumber().equals(phoneNumber));

        return true;
    }

    private boolean validateDate(String date) {
        try {
            String[] dateArr = date.split("/");
            new Date(Integer.parseInt(dateArr[2]), Integer.parseInt(dateArr[1]), Integer.parseInt(dateArr[0]));
            return true;
        } catch (Exception var3) {
            return false;
        }
    }

    private void readFile() {
        try {
            FileReader fileReader = new FileReader("src/student.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                Student student = new Student(data[1], data[2], data[3], data[4], Integer.parseInt(data[0]));
                this.students.add(student);
            }
        } catch (Exception var6) {
            System.err.println(var6.getMessage());
        }

    }

    public ArrayList<Teacher> getTeachers() {
        return this.teachers;
    }

    public ArrayList<ClassRoom> getClassRooms() {
        return this.classRooms;
    }

    public static ClassRoom findClassRoomByClassCode(int classCode) {
        Iterator var1 = getInstance().getClassRooms().iterator();

        ClassRoom classRoom;
        do {
            if (!var1.hasNext()) {
                return null;
            }

            classRoom = (ClassRoom)var1.next();
        } while(classRoom.getClassCode() != classCode);

        return classRoom;
    }

    public static Teacher findTeacherByTeacherID(int teacherID) {
        Iterator var1 = getInstance().getTeachers().iterator();

        Teacher teacher;
        do {
            if (!var1.hasNext()) {
                return null;
            }

            teacher = (Teacher)var1.next();
        } while(teacher.getTeacherID() != teacherID);

        return teacher;
    }
}
