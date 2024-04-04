public class Faculty {
    
    private int facultyID;
    public String name;
    private String email;
    public String buildingName;
    public int officeNumber;
    private int phoneNumber;
    public String department;
    public String position;
    static public int[] facIDs;
    
public Faculty (int facultyID, String name, String email, 
                String buildingName, int officeNumber, int phoneNumber,
                String department, String position){
    
    this.facultyID = facultyID;
    this.name = name;
    this.email = email;
    this.buildingName = buildingName;
    this.officeNumber = officeNumber;
    this.phoneNumber = phoneNumber;
    this.department = department;
    this.position = position;
    
}
    
public int getFacultyID(){
    return this.facultyID;
}

public String getEmail(){
    return this.email;
}

public int getPhone(){
    return this.phoneNumber;
}


}
