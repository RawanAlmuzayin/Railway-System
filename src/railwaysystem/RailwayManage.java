package railwaysystem;

public class RailwayManage {

    SLL passanagerList = new SLL();

    public void AddPasanger(Passanger passanger) {
        passanagerList.add(passanger);
    }

    public void UpdatePasanger(Passanger passanger) {

    }

    public void DeleteTicket(String TicketNo) {
        if (passanagerList.isEmpty()) {
            System.out.println("Empty List");
            return;
        }
        passanagerList.delete(TicketNo);
    }

    public void SortTickets() {
        passanagerList.sortList();
    }

    public void DisplayTicket() {
        SLL tmp = passanagerList.head;
        while (tmp != null) {
            System.out.println(tmp.passanger.toString());
            tmp = tmp.next;
        }
    }

    public boolean DisplayTicket(String TicketNo) {
        SLL passNode = passanagerList.search(TicketNo);
        if (passNode != null) {
            passNode.passanger.toString();
            return true;
        }
        return false;
    }
}
