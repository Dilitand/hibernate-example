package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PERSON")
public class Personx {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "name")
    String name;

    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
    List<Account> accountList = new ArrayList<>();


    public Personx(){

    }

    public Personx(String name) {
        this.name = name;

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

    public void addAcc(Account account){
        account.setPerson(this);
        accountList.add(account);
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    @Override
    public String toString() {
        return "Personx{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accountList=" + accountList +
                '}';
    }
}
