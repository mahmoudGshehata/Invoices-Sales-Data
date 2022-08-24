package Frames.invoice;

public class InvoiceCreator {

    public String[][] CreateNewInvoice(String[][] arr, int r, String[] data) {
        String[][] out = new String[arr.length + 1][];
        for (int i = 0; i < r; i++) {
            out[i] = arr[i];
        }
        out[r] = data;
        for (int i = r + 1; i < out.length; i++) {
            out[i] = arr[i - 1];
        }
        return out;
    }
}
