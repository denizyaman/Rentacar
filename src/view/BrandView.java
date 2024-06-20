package src.view;

import src.business.BrandManager;
import src.core.Helper;
import src.entity.Brand;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BrandView extends Layout {
    private JPanel container;
    private JLabel lbl_brand;
    private JLabel lbl_brand_name;
    private JTextField fld_brand_name;
    private JButton btn_brand_save;
    private Brand brand;
    private BrandManager brandManager;
    public BrandView(Brand brand){
        this.brandManager = new BrandManager();
        this.brand = brand;
        this.add(container);
        this.GuiInitilaze(300,200);

        if (brand != null){
            fld_brand_name.setText(brand.getName());
        }

        btn_brand_save.addActionListener(e -> {

            if (Helper.isFieldEmpty(this.fld_brand_name)){
                Helper.showMsg("fill");
            }else {
                boolean result;
                if (this.brand == null){
                    Brand obj = new Brand(fld_brand_name.getText());
                    result = this.brandManager.save(obj);
                }else {
                    this.brand.setName(fld_brand_name.getText());
                    result = this.brandManager.update(this.brand);
                }

                if (result){
                    Helper.showMsg("done");
                    dispose();
                }else {
                    Helper.showMsg("error");
                }
            }
        });
    }
}