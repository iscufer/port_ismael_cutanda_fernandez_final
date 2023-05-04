package PaqGroupName;
public class Hub {
    Container[][] contIDs;
    Container[] containers;
    Hub() {
        this.contIDs = new Container[10][12];
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 12; j++) {
                this.contIDs[i][j] = new Container();
            }
        }
    }
    Hub(Container[][] contIDS) {
        this.contIDs = contIDS;
    }
    public Container[][] getContIDs() {
        return this.contIDs;
    }
    public void setContIDs(Container[][] contIDs) {
        this.contIDs = contIDs;
    }
    String hubToString() {
        String strHub = "";
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 12; j++) {
                if (this.contIDs[i][j].ID == 0) {
                    strHub = strHub + "0 ";
                }
                if(this.contIDs[i][j].ID != 0) {
                    strHub = strHub + "X ";
                }
            }
            strHub = strHub + "\n";
        }
        return strHub;
    }
    int stackCont(Container cont) {
        int i;
        if (cont.priority == 1) {
            for(i = 9; i >= 0; i++) {
                if (this.contIDs[i][0].ID == 0) {
                    this.contIDs[i][0].setID(cont.ID);
                    this.contIDs[i][0].setCountry(cont.country);
                    this.contIDs[i][0].setDescription(cont.description);
                    this.contIDs[i][0].setInspected(cont.inspected);
                    this.contIDs[i][0].setPriority(cont.priority);
                    this.contIDs[i][0].setReceiver(cont.receiver);
                    this.contIDs[i][0].setSender(cont.sender);
                    this.contIDs[i][0].setWeight(cont.weight);
                    System.out.println("Container stacked");
                    return 1;
                }
            }
            if (i == -1) {
                System.out.println("Section full, please go to another");
                return -1;
            }
        }
        if (cont.priority == 2) {
            for(i = 9; i >= 0; i++) {
                if (this.contIDs[i][1].ID == 0) {
                    this.contIDs[i][1].setID(cont.ID);
                    this.contIDs[i][1].setCountry(cont.country);
                    this.contIDs[i][1].setDescription(cont.description);
                    this.contIDs[i][1].setInspected(cont.inspected);
                    this.contIDs[i][1].setPriority(cont.priority);
                    this.contIDs[i][1].setReceiver(cont.receiver);
                    this.contIDs[i][1].setSender(cont.sender);
                    this.contIDs[i][1].setWeight(cont.weight);
                    System.out.println("Container stacked");
                    return 1;
                }
            }
            if (i == -1) {
                System.out.println("Section full, please go to another");
                return -1;
            }
        }
        if (cont.priority == 3) {
            i = 9;
            int j = 2;
            for (boolean flag = false; j < 12; i = 9) {
                while (i >= 0) {
                    if (this.contIDs[i][j].ID == 0) {
                        this.contIDs[i][j].setID(cont.ID);
                        this.contIDs[i][j].setCountry(cont.country);
                        this.contIDs[i][j].setDescription(cont.description);
                        this.contIDs[i][j].setInspected(cont.inspected);
                        this.contIDs[i][j].setPriority(cont.priority);
                        this.contIDs[i][j].setReceiver(cont.receiver);
                        this.contIDs[i][j].setSender(cont.sender);
                        this.contIDs[i][j].setWeight(cont.weight);
                        System.out.println("Container stacked");
                        return 1;
                    }
                    i++;
                }
                j++;
            }
        }
        return -1;
    }
    void removeContFrom(int column) {
        if (column >= 0 && column <= 11) {
            int i;
            for(i = 0; i < 10; i++) {
                if (this.contIDs[i][column].ID != 0) {
                    this.contIDs[i][column] = new Container();
                    System.out.println("Container removed");
                    break;
                }
            }
            if (i == 10) {
                System.out.println("This column is empty");
            }
        } else {
            System.out.println("This column does not exist");
        }
    }
    String dataContID(int ID) {
        String str = "Not found";
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 12; j++) {
                if (this.contIDs[i][j].ID == ID) {
                    str = "ID: " + ID + "\nWeight (in tons): " + this.contIDs[i][j].weight + "\nColumn: " + j + "\nRow: " + i + "\nCountry of origin: " + this.contIDs[i][j].country + "\nSender company: " + this.contIDs[i][j].sender + "\nReceiving company: " + this.contIDs[i][j].receiver + "\nContent description: " + this.contIDs[i][j].description + "\nPriority level: " + this.contIDs[i][j].priority + "\nInspected: " + this.contIDs[i][j].inspected;
                    return str;
                }
            }
        }
        return str;
    }
    int howManyFrom(String country) {
        int howMany = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                if (this.contIDs[i][j].country == country) {
                    howMany++;
                }
            }
        }
        return howMany;
    }
    public boolean checkDuplicateID(int id) {
        for (Container c : containers) {
            if (c.getID() == id) {
                return true;
            }
        }
        return false;
    }
}