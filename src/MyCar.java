import java.util.List;

public class MyCar implements Comparable<MyCar> {
    private String name;
    private int year;


    public MyCar(String name, int year) {
        this.name = name;
        this.year = year;
    }

        
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Name: " + name + ", Year: " + year + "\n";
    }


    @Override
    public int compareTo(MyCar o) {
        return year - o.getYear();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + year;
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MyCar other = (MyCar) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (year != other.year)
            return false;
        return true;
    }
}
