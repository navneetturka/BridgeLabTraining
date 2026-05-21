import java.util.Scanner;

public class BrowserHistoryNavigation {

    static class Node {
        String page;
        Node next;
        Node prev;

        Node(String page) {
            this.page = page;
            this.next = null;
            this.prev = null;
        }
    }

    static class BrowserHistory {
        Node head;
        Node tail;
        Node current;

        BrowserHistory() {
            head = null;
            tail = null;
            current = null;
        }

        void visitPage(String url) {
            if (url == null || url.length() == 0) {
                System.out.println("Invalid URL. Try again.");
                return;
            }

            if (current == null) {
                Node newNode = new Node(url);
                head = newNode;
                tail = newNode;
                current = newNode;
                System.out.println("Visited: " + url);
                return;
            }

            if (current != tail) {
                Node forward = current.next;
                while (forward != null) {
                    Node nextForward = forward.next;
                    forward.prev = null;
                    forward.next = null;
                    forward = nextForward;
                }

                current.next = null;
                tail = current;
            }

            Node newNode = new Node(url);
            tail.next = newNode;
            newNode.prev = tail;

            tail = newNode;
            current = newNode;

            System.out.println("Visited: " + url);
        }

        void back() {
            if (current == null) {
                System.out.println("No pages in history.");
                return;
            }

            if (current.prev == null) {
                System.out.println("You are at the first page. Can't go back.");
                return;
            }

            current = current.prev;
            System.out.println("Moved back to: " + current.page);
        }

        void forward() {
            if (current == null) {
                System.out.println("No pages in history.");
                return;
            }

            if (current.next == null) {
                System.out.println("You are at the last page. Can't go forward.");
                return;
            }

            current = current.next;
            System.out.println("Moved forward to: " + current.page);
        }

        void currentPage() {
            if (current == null) {
                System.out.println("No current page. Visit a page first.");
                return;
            }
            System.out.println("Current page: " + current.page);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BrowserHistory history = new BrowserHistory();

        while (true) {
            System.out.println("\n--- Browser History Navigation ---");
            System.out.println("1. Visit Page");
            System.out.println("2. Back");
            System.out.println("3. Forward");
            System.out.println("4. Show Current Page");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice;

            choice = sc.nextInt();

            if (choice == 1) {
                sc.nextLine();
                System.out.print("Enter URL/Page: ");
                String url = sc.nextLine();
                history.visitPage(url);

            } else if (choice == 2) {
                history.back();

            } else if (choice == 3) {
                history.forward();

            } else if (choice == 4) {
                history.currentPage();

            } else if (choice == 5) {
                System.out.println("Exiting program. Bye!");
                break;

            } else {
                System.out.println("Invalid choice. Enter 1 to 5.");
            }
        }

        sc.close();
    }
}