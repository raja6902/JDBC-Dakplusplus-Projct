package be.raja.model;


import java.sql.Date;

public class Employee {
    private int id;
    private String first_name;
    private String sir_name;
    private String telephone_number;
    private String telephone_number_ICE;
    private Date birth_date;
    private double salary_per_month;

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSir_name() {
        return sir_name;
    }

    public void setSir_name(String sir_name) {
        this.sir_name = sir_name;
    }

    public String getTelephone_number() {
        return telephone_number;
    }

    public void setTelephone_number(String telephone_number) {
        this.telephone_number = telephone_number;
    }

    public String getTelephone_number_ICE() {
        return telephone_number_ICE;
    }

    public void setTelephone_number_ICE(String telephone_number_ICE) {
        this.telephone_number_ICE = telephone_number_ICE;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public double getSalary_per_month() {
        return salary_per_month;
    }

    public void setSalary_per_month(double salary_per_month) {
        this.salary_per_month = salary_per_month;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", sir_name='" + sir_name + '\'' +
                ", telephone_number='" + telephone_number + '\'' +
                ", telephone_number_ICE='" + telephone_number_ICE + '\'' +
                ", birth_date=" + birth_date +
                ", salary_per_month=" + salary_per_month +
                '}';
    }


}

