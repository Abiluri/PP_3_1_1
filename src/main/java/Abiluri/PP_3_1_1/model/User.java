package Abiluri.PP_3_1_1.model;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(id);
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(email);
        return result;
    }
}