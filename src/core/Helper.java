package src.core;

import javax.swing.*;
import java.awt.*;

public class Helper {
    public static void setTheme(){
        for (
                UIManager.LookAndFeelInfo info: UIManager.getInstalledLookAndFeels()){
            if ("Nimbus".equals(info.getName())){
                try {
                    UIManager.setLookAndFeel(info.getClassName());

                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                break;
            }
        }
    }
    public static void showMsg(String str){
        String msg;
        String title = switch (str) {
            case "fill" -> {
                msg = "Lütfen tüm alanları doldurunuz!";
                yield "HATA";
            }
            case "done" -> {
                msg = "İşlem Başarılı!";
                yield "HATA";
            }
            case "notFound" -> {
                msg = "Kayıt Bulunamadı!";
                yield "Bulunamadı!";
            }
            default -> {
                msg = str;
                yield "Mesaj!";
            }
        };


        JOptionPane.showMessageDialog(null,msg,title,JOptionPane.INFORMATION_MESSAGE );


    }
    public static boolean isFiledEmpty(JTextField field){
        return field.getText().trim().isEmpty();

    }
    public static  boolean isFieldListEmpty(JTextField[] fieldList) {
        for (JTextField field : fieldList){
            if (isFiledEmpty(field)) return true;
        }
        return false;
    }
    public static int getLocationPoint(String type, Dimension size){
        return switch (type) {
            case "x" -> (Toolkit.getDefaultToolkit().getScreenSize().width - size.width) / 2;
            case "y" -> (Toolkit.getDefaultToolkit().getScreenSize().height - size.height) / 2;
            default -> 0;
        };

    }
}
