package ContactsList_wzMessages;

import java.util.ArrayList;

public class Contact {
    // properties
    private String name;
    private String number;
    private String email;
    private ArrayList<Message> messages; // saving in it the messages related to each contact

    // Constructor
    public Contact(String name, String number, String email, ArrayList<Message> messages) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.messages = messages;
    }
    // Another constructor for a new contact who still have no messages related to him
    public Contact(String name, String number, String email) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.messages = new ArrayList<>();
    }

// A method to display the contact details
   public void getDetails(){
       System.out.println("Name: " + this.name + "" +
               "\nNumber: " + this.number + ""+
               "\nEmail: " + this.email);
   }

    // getters & setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }
}
