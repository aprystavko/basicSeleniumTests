package libs;

public class WaitTimeWhenLoadingPage {

    public void WaitTimeWhenLoadingPage() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
