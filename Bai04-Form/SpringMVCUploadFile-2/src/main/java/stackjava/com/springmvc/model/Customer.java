package stackjava.com.springmvc.model;

public class Customer {
    private int id;
    private String name;
    private String address;
    private String avatar;

    public Customer() {
    }

    public Customer(String avatar) {
        this.avatar = avatar;
    }

    public Customer(int id, String name, String address, String avatar) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.avatar = avatar;
    }

    public Customer(String name, String address, String avatar) {
        this.name = name;
        this.address = address;
        this.avatar = avatar;
    }



    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
