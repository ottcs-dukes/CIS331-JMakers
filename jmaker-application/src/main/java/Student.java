public class Student {
    
    private int studentID;
    private String fullName;;
    private String Address;
    private String email;
    private double gpa;
    private int ssn; // did not include emergency contact for now
    private static int prevStuID = 199;
        
    public Student(String fullName, String Address, 
                String email, double gpa, int ssn){
        this.studentID = studentID;
        this.fullName = fullName;
        this.Address = Address;
        this.email = email;
        this.gpa = gpa;
        this.ssn = ssn; // did not include the this.stuIDs
        
    }    

    public void editStudent(String fullName, String Address, 
                String email, double gpa){
        this.fullName = fullName;
        this.Address = Address;
        this.email = email;
        this.gpa = gpa;
    }

    public Double getGPA(){
        return this.gpa;
    }   
        
    public int getSSN(){
        return this.ssn;
    }    

    public String getAddress(){
        return this.Address;
    }

    public int getStuID(){
        
        return this.studentID;
        
    }

    // Override
    public boolean equals(Student stu) {
        return this.fullName.equals(stu.fullName);
    }

    private static int getNewID() {
        int newID = prevStuID++;
        return newID;
    }

}
