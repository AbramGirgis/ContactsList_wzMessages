package ContactsList_wzMessages;

public class Message {
    //    Fields
    private String text;
    private String recipient; //the contact to whom the msg is to be sent
    private int id;

    // Constructor
    public Message(String text, String recipient, int id) {
        this.text = text;
        this.recipient = recipient;
        this.id = id;
    }

    // A method to display a message details
    public void getDetails() {
        System.out.println("Contact Name: " + recipient +
                "\nMessage: " + text + "" +
                "\nId: " + id);
    }

    // getters & setters
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
