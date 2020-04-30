package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "ACCOUNT")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ACC")
    private String acc;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID",referencedColumnName = "id")
    private Personx person;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Accountop> accountops = new ArrayList<>();

    public Account() {

    }

    public Account(String acc) {
        this.acc = acc;
    }

    public void addAccountOp(Accountop accountop){
        accountop.setAccount(this);
        accountops.add(accountop);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public Personx getPerson() {
        return person;
    }

    public void setPerson(Personx person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", acc='" + acc + '\'' +
                ", accountops=" + accountops +
                '}';
    }
}
