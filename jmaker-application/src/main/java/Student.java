public class Student {
    
    private int studentID;
    public String fullName;;
    private String Address;
    public String email;
    private double gpa;
    private int ssn; // did not include emergency contact for now
    public static int[] stuIDs;
    
public Student(int studentID, String fullName, String Address, 
              String email, double gpa, int ssn){
    this.studentID = studentID;
    this.fullName = fullName;
    this.Address = Address;
    this.email = email;
    this.gpa = gpa;
    this.ssn = ssn; // did not include the this.stuIDs
    
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

}
