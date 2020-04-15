package models;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "ACCOUNTOP")
public class Accountop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Double opcash;
    @Column(name = "OPDAY")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID",referencedColumnName = "ID")
    private Account account;


    public Accountop(){};

    public Accountop(Double opcash, Date date) {
        this.opcash = opcash;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getOpcash() {
        return opcash;
    }

    public void setOpcash(Double opcash) {
        this.opcash = opcash;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
