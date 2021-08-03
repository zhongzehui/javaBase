package com.zehui.designPattern.deepClone;

import java.io.*;


/*
       实现深拷贝的两种方式
        1，重新clone方法，记得以用类型也要重新set
        2，使用序列化

 */
public class Test {

    public static void main(String[] args) throws Exception {
        Person p1 = new Person("zhangsan", 5, "zhansan");
        p1.setPet(new Pet("sdifhd", "哈士奇", "erha"));

        Person p2 = (Person) p1.clone();
        System.out.println(p2);


        Test test = new Test();
        Person p3 = test.deepClone(p1);
        System.out.println(p3);

    }

    /*
        使用序列化方式执行深克隆
     */
    public <T> T deepClone(T originObject) throws Exception {
        T t = null;
        //获取输入流
        // 序列化
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);

        oos.writeObject(originObject);

        // 反序列化
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);

        t = (T) ois.readObject();

        return t;
    }


}

class Person implements Serializable ,Cloneable  {


    private static final long serialVersionUID = -1256930539171867707L;

    private String name;

    private Integer age;

    private String id;

    private Pet pet;

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Person() {
    }

    public Person(String name, Integer age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person person = new Person();
        person.setName(this.getName());
        person.setAge(this.getAge());
        person.setId(this.getId());
        Pet pet = new Pet();
        pet.setId(this.getPet().getId());
        pet.setName(this.getPet().getName());
        pet.setKind(this.getPet().getKind());

        person.setPet(pet);

        return person;
    }

}

class Pet implements Serializable, Cloneable {

    private static final long serialVersionUID = -7955878495682790415L;

    private String id;
    private String kind;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pet() {
    }

    public Pet(String id, String kind, String name) {
        this.id = id;
        this.kind = kind;
        this.name = name;
    }
}