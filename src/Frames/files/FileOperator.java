package Frames.files;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOperator {
    Component parent = null;
    public FileOperator(Component parent){
        this.parent = parent;
    }

     public void SaveFile() {
        JFileChooser FC = new JFileChooser();
        int result = FC.showOpenDialog(parent);
        if (result == JFileChooser.APPROVE_OPTION) {
            String path = FC.getSelectedFile().getPath();
            FileOutputStream FOS = null;
            try {
                FOS = new FileOutputStream(path);
                //char b = T1.getRowContent();
                //FOS.write(b);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }finally {
                try {
                    FOS.close();
                } catch (IOException e) {
                }

            }
        }
    }

     public void LoadFile(JTable table) {
        JFileChooser FC = new JFileChooser();
        int result = FC.showOpenDialog(parent);
        if (result == JFileChooser.APPROVE_OPTION) {
            String path = FC.getSelectedFile().getPath();
            FileInputStream FIS = null;
            try {
                FIS = new FileInputStream(path);
                int size = FIS.available();
                byte[] b = new byte[size];
                FIS.read(b);
                table.getUI();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    FIS.close();
                } catch (IOException e) {
                }
            }
        }
    }


}
