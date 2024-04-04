public class Faculty {
    
    private int facultyID;
    public String name;
    private String email;
    public String buildingName;
    public int officeNumber;
    private int phoneNumber;
    public String department;
    public String position;
    private static int[] facIDs = new int[50];
    
    public Faculty (String name, String email, String buildingName, 
                        int officeNumber, int phoneNumber,
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
    
    public int getFacultyID(){
        return this.facultyID;
    }

    public String getEmail(){
        return this.email;
    }

    public int getPhone(){
        return this.phoneNumber;
    }

    private static int getNewId() {
        if (facIDs[0] == null) {
            int id = 100;
            facIDs[0] = id;
            return id;
        } else {
            for (int i = 1; i < facIDs.length; i++) {
                if (facIDs[i] == null) {
                    facIDs[i] = facIDs[i - 1]++;
                    return facIDs[i];
                }
            }
        }
    }

}
