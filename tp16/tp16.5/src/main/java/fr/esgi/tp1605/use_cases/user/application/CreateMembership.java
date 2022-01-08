package fr.esgi.tp1605.use_cases.user.application;

import fr.esgi.tp1605.kernel.Command;

import java.util.Date;

@SuppressWarnings("all")
public final class CreateMembership implements Command {

    public String name;
    public Date startDate;
    public Date endDate;
    public boolean isActive;
    public double prix;

    public CreateMembership(String name, Date startDate, Date endDate, boolean isActive, double prix) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActive = isActive;
        this.prix = prix;
    }
}
