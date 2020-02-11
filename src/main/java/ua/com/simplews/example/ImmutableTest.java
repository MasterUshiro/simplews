package ua.com.simplews.example;

public final class ImmutableTest {

    private String name;
    private Integer age;

    public ImmutableTest(String name, Integer age) {
        this.name = name;
        this.age = age;
        System.out.println("Name is " + name + " age: " + age);
    }

    public ImmutableTest setName(String name) {
        return new ImmutableTest(name, this.age);
    }

    public ImmutableTest setAge(Integer age) {
        return new ImmutableTest(this.name, age);
    }

    public static void main(String[] args) {
        String test1= "Zopa opa";
        String test2 = test1;
        test1 = "OPa Zopa!";
        System.out.println("test1 = " + test1);
        System.out.println("test2 = " + test2);

        Integer iTest = 222;
        Integer iTest2 = iTest;

        iTest = 100;
        System.out.println("iTest = " + iTest);
        System.out.println("iTest2 = " + iTest2);



        int i = 0;
        switch (i) {
            case 0:
                System.out.println("zopa " + i);
            case 3:
                System.out.println("zopa " + 3);
            case 4:
                System.out.println("zopa " + 4);
        }


    }
}

