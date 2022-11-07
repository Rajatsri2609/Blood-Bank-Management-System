
/*** Importing Essential Libraries ***/

import java.util.*;
import java.io.*;

/*** Features OF Blood Blank Management System ****/

class MainMenu {
  public void menu() {
    System.out.println("\t\t*******");
    System.out.println("\t  BLOOD BANK MANAGEMENT SYSTEM \t");
    System.out.println("\t\t*******");
    System.out.println("\n\nPress 1 : To Add an Donor Details");
    System.out.println("Press 2 : To See an Donor Details ");
    System.out.println("Press 3 : To Remove an Donor");
    System.out.println("Press 4 : To Update Donor Details");
    System.out.println("Press 5 : To Exit the Blood Blank Management System Portal");

  }
}

/*** To add details of Donor ****/

class Donor_Add {
  public void createFile() {
    Scanner sc = new Scanner(System.in);

    DonorDetail donor = new DonorDetail();
    donor.getInfo();
    try {
      File f1 = new File("Blood_Group" + donor.don_id + " " + donor.donor_bldgrp + ".txt");
      if (f1.createNewFile()) {
        FileWriter myWriter = new FileWriter("file" + donor.don_id + donor.donor_bldgrp + ".txt");
        myWriter.write("Donor ID:" + donor.don_id + "\n" + "Donor Name     :" + donor.name + "\n" +
            "Father's Name     :" + donor.father_name + "\n" + "Donor Contact  :" + donor.donor_contact + "\n" +
            "Email Information :" + donor.email + "\n" + "Donor Haemoglobin :" + donor.haemo + "\n" +
            "Donor Blood group   :" + donor.donor_bldgrp);
        myWriter.close();
        System.out.println("\nDonor has been Added :)\n");

        System.out.print("\nPress Enter to Continue...");
        sc.nextLine();
      } else {
        System.out.println("\n Donor already exists :(");
        System.out.print("\nPress Enter to Continue...");
        sc.nextLine();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}

/*** Taking Donor Details ****/

class DonorDetail {
  String name;
  String father_name;
  String email;
  int haemo;
  String don_id;
  String donor_bldgrp;
  String donor_contact;

  public void getInfo() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter Donor's Haemoglobin ----: ");
    haemo = sc.nextInt();
    if (haemo < 120) {
      System.out.println("You cannot donate blood");
      return;
    } else {
      System.out.println("You are fit for donating");
    }
    System.out.print("Enter Donor's name --------: ");
    name = sc.nextLine();
    name = sc.nextLine();
    System.out.print("Enter Donor's Father name -: ");
    father_name = sc.nextLine();
    System.out.print("Enter Donor ID ----------: ");
    don_id = sc.nextLine();
    System.out.print("Enter Donor's Email ID ----: ");
    email = sc.nextLine();

    System.out.print("Enter Donor contact Info --: ");
    donor_contact = sc.nextLine();
    System.out.print("Enter Donor's Blood Group ------: ");
    donor_bldgrp = sc.nextLine();
  }
}

/*** To Show details of Donor ****/

class Donor_Show {
  public void viewFile(String s) throws Exception {
    File file = new File("file" + s + ".txt");
    Scanner sc = new Scanner(file);

    while (sc.hasNextLine()) {
      System.out.println(sc.nextLine());
    }
  }
}

/**** To Remove Donor ****/

class Donor_Remove {
  public void removeFile(String ID) {

    File file = new File("file" + ID + ".txt");
    if (file.exists()) {
      if (file.delete())
        ;
      {
        System.out.println("\n Donor has been removed Successfully");
      }
    } else {
      System.out.println("\n Donor does not exists :( ");
    }
  }
}

/*** To Update details of Donor ***/

class Donor_Update {
  public void updateFile(String s, String o, String n) throws IOException {
    File file = new File("file" + s + ".txt");
    Scanner sc = new Scanner(file);
    String fileContext = "";
    while (sc.hasNextLine()) {
      fileContext = fileContext + "\n" + sc.nextLine();
    }
    FileWriter myWriter = new FileWriter("file" + s + ".txt");
    fileContext = fileContext.replaceAll(o, n);
    myWriter.write(fileContext);
    myWriter.close();

  }
}

/*** To Exit from the BBMS Portal ****/

class CodeExit {
  public void out() {
    System.out.println("\n*********\n");
    System.out.println("Thanks for Using our Software");
    System.out.println("\n*********\n");
    System.exit(0);
  }
}

/**** Main Class ****/
class BloodBankManagementSystem {
  public static void main(String arv[]) {
    /* To clear the output Screen */
    System.out.print("\033[H\033[2J");

    Scanner sc = new Scanner(System.in);
    Donor_Show epv = new Donor_Show();
    

    int i = 0;

    /* Callining Mainmenu Class function **/
    MainMenu obj1 = new MainMenu();
    obj1.menu();

    /* Initialising loop for Menu Choices */
    while (i < 6) {

      System.out.print("\nPlease Enter choice :");
      i = Integer.parseInt(sc.nextLine());

      /* Switch Case Statements */
      switch (i) {
        case 1: {
          /* Creating class's object and calling Function using that object */
          Donor_Add ep = new Donor_Add();
          ep.createFile();

          System.out.print("\033[H\033[2J");
          obj1.menu();
          break;
        }
        case 2: {
          System.out.print("\nPlease Enter Donor's ID :");
          String s = sc.nextLine();
          try {
            epv.viewFile(s);
          } catch (Exception e) {
            System.out.println(e);
          }

          System.out.print("\nPress Enter to Continue...");
          sc.nextLine();
          System.out.print("\033[H\033[2J");
          obj1.menu();
          break;
        }

        case 3: {
          System.out.print("\nPlease Enter File Name (in the format----> 'ID''Blood Group' ) :");
          String s = sc.nextLine();
          Donor_Remove epr = new Donor_Remove();
          epr.removeFile(s);

          System.out.print("\nPress Enter to Continue...");
          sc.nextLine();
          System.out.print("\033[H\033[2J");
          obj1.menu();
          break;
        }
        case 4: {
          System.out.print("\nPlease Enter File Name (in the format----> 'ID''Blood Group' ) :");
          String I = sc.nextLine();
          try {
            epv.viewFile(I);
          } catch (Exception e) {
            System.out.println(e);
          }
          Donor_Update epu = new Donor_Update();
          System.out.print("Please Enter the detail you want to Update :");
          System.out.print("\nFor Example :\n");
          System.out.println(
              "If you want to Change the Name, then Enter Current Name and Press Enter. Then write the new Name then Press Enter. It will Update the Name.\n");
          String s = sc.nextLine();
          System.out.print("Please Enter the Updated Info :");
          String n = sc.nextLine();
          try {
            epu.updateFile(I, s, n);

            System.out.print("\nPress Enter to Continue...");
            sc.nextLine();
            System.out.print("\033[H\033[2J");
            obj1.menu();
            break;
          } catch (IOException e) {
            System.out.println(e);
          }
        }
        case 5: {
          CodeExit obj = new CodeExit();
          obj.out();
        }
      }
    }
  }
}