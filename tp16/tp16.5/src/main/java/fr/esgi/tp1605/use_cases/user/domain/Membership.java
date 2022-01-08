package fr.esgi.tp1605.use_cases.user.domain;

import fr.esgi.tp1605.kernel.Entity;

import java.util.Date;

public final class Membership implements Entity<MembershipId> {

    final private MembershipId id;
    private String name;
    private Date startDate, endDate;
    private boolean isActive;
    private double prix;

    public Membership(MembershipId id, String name, Date startDate, Date endDate, boolean isActive, double prix) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActive = isActive;
        this.prix = prix;
    }

    @Override
    public MembershipId id(){return id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Membership{" +
                "id=" + id +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", name=" + name + '\'' +
                ", prix=" + prix +
                '}';
    }
}
