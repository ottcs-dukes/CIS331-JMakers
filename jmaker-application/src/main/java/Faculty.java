public class Faculty {
    
    private int facultyID;
    private String name;
    private String email;
    private String buildingName;
    private int officeNumber;
    private long phoneNumber;
    private String department;
    private String position;
    private static int prevFacID = 99;
    
    public Faculty (String name, String email, String buildingName, 
                        int officeNumber, long phoneNumber,
                        String department, String position) {
    
        this.facultyID = getNewId();
        this.name = name;
        this.email = email;
        this.buildingName = buildingName;
        this.officeNumber = officeNumber;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.position = position;
    
    }
    
    public void editFaculty(String name, String email, String buildingName,
                        int officeNumber, long phoneNumber, String department, String position) {
        
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

    public String getName(){
        return this.name;
    }
    public String getEmail(){
        return this.email;
    }

    public long getPhone(){
        return this.phoneNumber;
    }

    private static int getNewId() {
        int newID = prevFacID++;
        return newID;
     
        }
    

}


