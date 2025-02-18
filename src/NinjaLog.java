import java.util.Date;

public class NinjaLog {
    private int id;
    private String name;
    private Rank rank;
    private String description;
    private Date date;
    private double points;


    public NinjaLog(int id, String name, Rank rank, String description, Date date, double points) {
        this.id = id;
        this.name = name;
        this.rank = rank;
        this.description = description;
        this.date = date;
        this.points = points;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "NinjaLog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rank=" + rank +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", points=" + points +
                '}';
    }
}
