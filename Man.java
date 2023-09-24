package HomeWork_5_6;

public class Man {
    Integer id;
    String fullName;
    Integer age;
    String address;

    Man(Integer id, String fullName, Integer age, String address)
    {
        this.id=id;
        this.fullName=fullName;
        this.age=age;
        this.address=address;
    }

    @Override
    public String toString() {
        return fullName;
    }
}
