// Practice 1
// Threads, multithreading, Runnable interface.


// Task 1
// Create an Operation class that inherits from the Thread class with parameters:
// - - String operationName;
// - - int operationTime; //operation time in seconds
// Redefine the run() method in which we start our thread, and display:
// For example, operation Time = 4, operation Name = "Add Client to Bank"
//         Operation "Add Client to Bank": started
//         Operation "Add Client to Bank": 1 second
//         Operation "Add Client to Bank": 2 second
//         Operation "Add Client to Bank": 3 second
//         Operation "Add Client to Bank": 4 second
//         Operation "Add Client to Bank": finished
// That is, every second we display the operation status on the screen, thereby showing how much time it takes us to do one action.
// As a result, create 10 operation objects in the main class and assign different times to them. Run them at the same time.




public class Main {
    public static void main(String[] args) {
        String opName = "Add Client to Bank";
        Operation op1 = new Operation(opName, 1);
        Operation op2 = new Operation(opName, 2);
        Operation op3 = new Operation(opName, 3);
        Operation op4 = new Operation(opName, 4);
        Operation op5 = new Operation(opName, 5);
        Operation op6 = new Operation(opName, 6);
        Operation op7 = new Operation(opName, 7);
        Operation op8 = new Operation(opName, 8);
        Operation op9 = new Operation(opName, 9);
        Operation op10 = new Operation(opName, 10);

        System.out.println("Operation \"" + opName + "\": started");
        op1.start();
        op2.start();
        op3.start();
        op4.start();
        op5.start();
        op6.start();
        op7.start();
        op8.start();
        op9.start();
        op10.start();

        try {
            Thread.sleep(1000);
            System.out.println("Operation \"" + opName + "\": finished");
        }catch (Exception ignored){
        }
    }
}


public class Operation  extends Thread {
    String operationName;
    int operationTime;

    public Operation() {
    }

    public Operation(String operationName, int operationTime) {
        this.operationName = operationName;
        this.operationTime = operationTime;
    }

    public void run() {
        try {
            Thread.sleep(500);
            System.out.println("Operation \"" + operationName + "\": " + operationTime + " second");
        }catch (Exception ignored){
        }
    }
}





