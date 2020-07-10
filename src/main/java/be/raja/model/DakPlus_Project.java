package be.raja.model;


import java.util.Date;

public class DakPlus_Project {
    private int id;
    private Date start_date;
    private String description;
    private double price;
    private Date end_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStart_date(Date start_date) {
        return this.start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    @Override
    public String toString() {
        return "DakPlus_Project{" +
                "id=" + id +
                ", start_date=" + start_date +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", end_date=" + end_date +
                '}';
    }
}
