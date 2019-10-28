package model.one_to_one;

public class TUser {
    private int id;
    private String name;
    private TPassport passport;

    public TPassport getPassport() {
        return passport;
    }

    public void setPassport(TPassport passport) {
        this.passport = passport;
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
}
