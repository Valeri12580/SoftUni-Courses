package customException;

public class Student {
    private String name;
    private String email;

    public Student(String name, String email) {
        setName(name);
        setEmail(email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidPersonNameException {

        for (int i = 0; i <name.length() ; i++) {
            if(!Character.isAlphabetic(name.charAt(i))){
                throw  new InvalidPersonNameException();
            }
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
