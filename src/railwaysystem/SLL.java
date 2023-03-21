package railwaysystem;

public class SLL {

    protected SLL head, tail, next;
    protected Passanger passanger;

    public SLL() {
        head = tail = null;
    }

    public SLL(Passanger passanger) {
        this(passanger, null);
    }

    public SLL(Passanger passanger, SLL next) {
        this.passanger = passanger;
        this.next = next;
    }

    public void add(Passanger passanger) {
        if (!isEmpty()) {
            tail.next = new SLL(passanger);
            tail = tail.next;
        } else {
            head = tail = new SLL(passanger);
        }
    }

    public void delete(String ticketNo) {
        if (!isEmpty()) {
            if (head == tail && ticketNo.equals(head.passanger.getPassangerTicket())) {
                head = tail = null;
            } else if (ticketNo.equals(head.passanger.getPassangerTicket())) {
                head = head.next;
            } else {
                SLL predessor = head, tmp = head.next;
                while (tmp != null && !ticketNo.equals(tmp.passanger.getPassangerTicket())) {
                    predessor = predessor.next;
                    tmp = tmp.next;
                }
                if (tmp != null) {
                    predessor.next = tmp.next;
                    if (tmp == tail) {
                        tail = predessor;
                    }
                }
            }
        }
    }

    //Using Bubble Sort
    public void sortList() {
        SLL current = head, index = null;
        Passanger tempPass;

        if (isEmpty()) {
            System.out.println("List is empty");
        } else {
            while (current != null) {
                index = current.next;

                while (index != null) {
                    String currentFN = current.passanger.getFirstName();
                    String indexFN = index.passanger.getFirstName();

                    if (currentFN.compareTo(indexFN) > 0) {
                        tempPass = current.passanger;
                        current.passanger = index.passanger;
                        index.passanger = tempPass;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    public SLL search(String ticketNo) {
        SLL predessor = head, tmp = head.next;
        while (tmp != null && !ticketNo.equals(tmp.passanger.getPassangerTicket())) {
            predessor = predessor.next;
            tmp = tmp.next;
        }
        return tmp;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
