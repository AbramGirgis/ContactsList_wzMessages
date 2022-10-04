package ContactsList_wzMessages;

/* Project: Simulate your phone's contacts list and messages associated with each contact
 * Simulate your phone's contacts and messages applications
 *
 * Greet the user
 * Show these 3 options: 1- Manage contacts  2-Messages  3-Quit
 * In case of selecting 1 -> Show the following options:
 *      1. Show all contacts
 *      2. Add a new contact
 *      3. search for a contact
 *      4. delete a contact
 *      5. Go back to the main menu
 * In case of selecting 2 -> Show the following options:
 *      1. See a list of all messages
 *      2. Send a new message
 *      3. Go back to the main menu
 * In case of selecting 3 -> Quit the application
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Contact> contacts;
    private static Scanner scanner;
    private static int id = 0;

    public static void main(String[] args) {

        contacts = new ArrayList<>();
        System.out.println("Welcome to our Contacts simple App!");

        showInitialOptions();
    }

    private static void showInitialOptions() {
        System.out.println("Please select an option:" +
                "\n\t1. Manage Contacts" +
                "\n\t2. Messages" +
                "\n\t3. Quit");

        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                manageContacts();
                break;
            case 2:
                manageMessages();
                break;
            default:
                break;

        }
    }

    private static void manageContacts() {
        System.out.println("Please select one:" +
                "\n\t1. Show all contacts" +
                "\n\t2. Add a new contact" +
                "\n\t3. Search for a contact" +
                "\n\t4. Delete a contact" +
                "\n\t5. Back to the previous menu");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                showAllContacts();
                break;
            case 2:
                addNewContact();
                break;
            case 3:
                searchForContact();
                break;
            case 4:
                deleteContact();
                break;
            default:
                showInitialOptions();
                break;

        }
    }

    private static void showAllContacts() {
        if (contacts.size()>0){
            for (Contact c : contacts) {
                c.getDetails();
                System.out.println("*****************");
            }
        }else {
            System.out.println("You have 0 contacts!");
        }
        showInitialOptions();
    }

    private static void addNewContact() {
        System.out.println("Adding a new contact..." +
                "\nPlease enter the contact's name:");
        String name = scanner.next();
        System.out.println("Please enter the contact's number:");
        String number = scanner.next();
        System.out.println("Please enter the contact's email:");
        String email = scanner.next();

        if (name.equals("") | number.equals("") | email.equals("")) {
            System.out.println("Please enter all of the contact required information.");
            addNewContact();
        } else {
            boolean doesExist = false;
            for (Contact c : contacts) {
                if (c.getName().equals(name)) {
                    doesExist = true;
                }
            }
            if (doesExist) {
                System.out.println("A contact with the name '" + name + "' already exists!");
                addNewContact();
            } else {
                Contact contact = new Contact(name, number, email);
                contacts.add(contact);
                System.out.println(name + " is added successfully.");
            }
        }
        showInitialOptions();

    }

    private static void searchForContact() {
        System.out.println("Please enter the contact name:");
        String name = scanner.next();
        if (name.equals("")) {
            System.out.println("Please enter the name:");
            searchForContact();
        } else {
            boolean doesExist = false;
            for (Contact c : contacts) {
                if (c.getName().equals(name)) {
                    doesExist = true;
                    c.getDetails();
                }
            }
            if (!doesExist) {
                System.out.println("Contact is not found in your contacts list!");
            }
        }
        showInitialOptions();
    }

    private static void deleteContact() {
        System.out.println("Please enter the contact name:");
        String name = scanner.next();
        if (name.equals("")) {
            System.out.println("Please enter the name:");
            deleteContact();
        } else {
            boolean doesExist = false;
            for (Contact c : contacts) {
                if (c.getName().equals(name)) {
                    doesExist = true;
                    contacts.remove(c);
                    System.out.println("Contact is deleted successfully!");
                }
            }
            if (!doesExist) {
                System.out.println("Contact is not found in your contacts list!");
            }
        }
        showInitialOptions();
    }


    private static void manageMessages() {
        System.out.println("Please select one:" +
                "\n\t1. Show all messages" +
                "\n\t2. Send a new message" +
                "\n\t3. Back to the previous menu");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                showAllMessages();
                break;
            case 2:
                sendNewMessage();
                break;
            default:
                showInitialOptions();
                break;
        }
    }

    private static void showAllMessages() {
        ArrayList<Message> allMessages = new ArrayList<>();
        for (Contact c : contacts) {
            allMessages.addAll(c.getMessages());
        }

        if (allMessages.size() > 0) {
            for (Message m : allMessages) {
                m.getDetails();
                System.out.println("****************");
            }
        } else {
            System.out.println("There are no messages to show!");
        }

        showInitialOptions();

    }

    private static void sendNewMessage() {
        System.out.println("Send message to:");
        String name = scanner.next();
        if (name.equals("")) {
            System.out.println("Please enter the name of the contact to whom you wish to send a message:");
            sendNewMessage();
        } else {
            boolean doesExist = false;
            for (Contact c : contacts) {
                if (c.getName().equals(name)) {
                    doesExist = true;
                }
            }
            if (doesExist) {
                System.out.println("Write your message:");
                String text = scanner.next();
                if (text.equals("")) {
                    System.out.println("You did not write anything!");
                    sendNewMessage();
                } else {
                    id++;
                    Message newMessage = new Message(text, name, id);
                    for (Contact c : contacts){
                        if (c.getName().equals(name)){
                            ArrayList<Message> newMessages = c.getMessages();
                            newMessages.add(newMessage);
                            c.setMessages(newMessages);
                        }
                    }
                }
            } else {
                System.out.println("Contact does not exist in your contacts list!");
            }
        }
        showInitialOptions();
    }


}
