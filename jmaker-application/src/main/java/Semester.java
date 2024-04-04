public class Semester {

    public String period;
    public int year;

    public Semester(String period, int year) {
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
    
    
    }
