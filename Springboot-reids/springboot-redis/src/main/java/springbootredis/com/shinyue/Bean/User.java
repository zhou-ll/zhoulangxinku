package springbootredis.com.shinyue.Bean;


/**
 * @PackageName: springbootredis.com.shinyue.Bean
 * @Description: author:周浪浪
 * @date:2019/10/23 17:57
 */

public class User {
    private int id;
    private String name;
    private int age;
    private String address;


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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
