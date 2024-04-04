public class Semester {

    private String period;
    private int year;

    public Semester(String period, int year) {
        this.period = period;
        this.year = year;
    }
    public void editSemester(String period, int year) {
        this.period = period;
        this.year = year;
    }

    
    public String getPeriod(){
        return this.period;
    }
    public int getYear(){
        return this.year;
    }
    
    public boolean equals(Semester sem){
        return this.period.equals(sem.getPeriod()) && this.year==sem.getYear();
    }
    
    public String toString(){
        return this.period + " " + this.year;
    }
    
    
    }
