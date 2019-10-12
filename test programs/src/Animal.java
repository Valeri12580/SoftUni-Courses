public class Animal {

    public String makeSound(){
       return this.toString();
    }

    @Override
    public String toString() {
        return "This animal say:";
    }
}
