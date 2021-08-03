package entity;

public class Person {
    private Integer id;
    private String name;
    private String code;
    private String address;

    public Person() {
    }
    public Person(String id) {
        this.id= id.hashCode();
    }
    public Person(String name, String code, String address) {
        this.name = name;
        this.code = code;
        this.address = address;
    }
    public Person(Integer id,String name, String code, String address) {
        this.id=id;
        this.name = name;
        this.code = code;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
