package Frames.invoice;

public class InvoiceRemover {

    public String[][] DeleteInvoice(String[][] arr, int row) {
        String[][] RowDeleted = new String[arr.length-1][arr[0].length];
        for(int r=0; r<arr.length; r++)
        {
            for(int c=0; c<arr[0].length; c++)
            {
                if(r!=row)
                    RowDeleted[r][c] = arr[r][c];
            }
        }
        return RowDeleted;
    }
}
