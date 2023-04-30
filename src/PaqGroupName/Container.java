package PaqGroupName;
public class Container {
    int ID;
    int weight;
    int priority;
    String country;
    String sender;
    String receiver;
    String description;
    boolean inspected;
    Container(int ID, int weight, int priority, String country, String sender, String receiver, String description, boolean inspected) {
        this.ID = ID;
        this.weight = weight;
        this.priority = priority;
        this.country = country;
        this.description = description.substring(0, 100);
        this.sender = sender.substring(0, 20);
        this.receiver = receiver.substring(0, 20);
        this.inspected = inspected;
    }
    Container() {}
    public int getID() {
        return this.ID;
    }
    public int getWeight() {
        return this.weight;
    }
    public int getPriority() {
        return this.priority;
    }
    public String getCountry() {
        return this.country;
    }
    public String getReceiver() {
        return this.receiver;
    }
    public String getDescription() {
        return this.description;
    }
    public String getSender() {
        return this.sender;
    }
    public boolean getInspected() {
        return this.inspected;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }
    public void setInspected(boolean inspected) {
        this.inspected = inspected;
    }
}