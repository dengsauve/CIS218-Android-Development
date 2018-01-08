public class Animal {
    // VOCAB: Encapsulation
    private String name;
    private String color;

    public Animal (String name){
        //this.name = name;
        //this.name = "purple";
        // Would Rather call on existing code below
        this(name, "purple");
    }

    public Animal (String name, String color){
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String newColor) {
        this.color = newColor;
    }

    @Override // tells compiler we mean to override method from parent. Also a check for devs
    public String toString() {
        return "Name: " + name + ", Color: " + color;
    }
}