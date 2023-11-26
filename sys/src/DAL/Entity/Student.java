package DAL.Entity;

public class Student {
    private String studentId;
    private String name;
    private String gender;
    private String ethnicity;
    private int classId;
//    private byte[] photo;

    public Student() {
    }

    public Student(String studentId, String name, String gender, String ethnicity, int classId) {
        this.studentId = studentId;
        this.name = name;
        this.gender = gender;
        this.ethnicity = ethnicity;
        this.classId = classId;
//        this.photo = photo;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

//    public byte[] getPhoto() {
//        return photo;
//    }
//
//    public void setPhoto(byte[] photo) {
//        this.photo = photo;
//    }
}
