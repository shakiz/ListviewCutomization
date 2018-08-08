package com.customlistview.shakil.listviewcutomization;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<DataModel> dataModels;
    ListView listView;
    private static CustomAdapter adapter;
    TextView itemname,itemcompany,itemprice,itemavialability;
    Dialog dialog=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        listView=(ListView)findViewById(R.id.list);


        dataModels= new ArrayList<>();
        dataModels.add(new DataModel("Asus GT710-SL-2GD5", "Asus-GPU", "5800Tk.","Available in Bangladesh"));
        dataModels.add(new DataModel("XFX AMD Radeon RX 570", "XFX-GPU", "26300Tk.","Available in Bangladesh"));
        dataModels.add(new DataModel("XFX RX 580 GTS XXX Edition", "XFX-GPU", "34500Tk.","Available in Bangladesh"));
        dataModels.add(new DataModel("GALAX GeForce GTX 1070 Ti", "Galax-GPU", "65000Tk.","Available in Bangladesh"));
        dataModels.add(new DataModel("GALAX GeForce® GTX 1080 EXOC-SNPR", "Galax-GPU", "67000Tk.","Available in Bangladesh"));
        dataModels.add(new DataModel("GALAX GeForce® GTX 1050 Ti", "Galax-GPU", "17500Tk.","Available in Bangladesh"));
        dataModels.add(new DataModel("Gigabyte GT 710 2GB DDR3 ", "Gigabyte-GPU", "4700Tk.","Available in Bangladesh"));
        dataModels.add(new DataModel("Gigabyte GT 730 2GB DDR5 ", "Gigabyte-GPU", "7000Tk.","Available in Bangladesh"));
        dataModels.add(new DataModel("Gigabyte Aorus GeForce® GTX 1060", "Gigabyte-GPU", "37000Tk.","Available in Bangladesh"));
        dataModels.add(new DataModel("Zotac GeForce GT 710 2GB DDR3 ", "Zotac-GPU", "4500Tk.","Available in Bangladesh"));
        dataModels.add(new DataModel("Zotac GeForce® GT 1030 2GB GDDR5", "Zotac-GPU", "9200Tk.","Available in Bangladesh"));
        dataModels.add(new DataModel("Toshiba 1TB Sata Desktop Hard Disk", "Toshiba-HARD DISK", "3600Tk.","Available in Bangladesh"));
        dataModels.add(new DataModel("Toshiba 1TB Sata Laptop Hard Disk", "Toshiba-HARD DISK", "4200Tk.","Available in Bangladesh"));
        dataModels.add(new DataModel("Adata SU 650 120 GB", "Adata-SSD", "3400Tk.","Available in Bangladesh"));
        dataModels.add(new DataModel("ADATA SU 800S 128GB", "Adata-SSD", "3900Tk.","Available in Bangladesh"));

        adapter= new CustomAdapter(getApplicationContext(),dataModels);

        listView.setAdapter(adapter);

        try{
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    DataModel dataModel= dataModels.get(position);
                    dialog= new Dialog(MainActivity.this);
                    dialog.setContentView(R.layout.custom_layout);
                    dialog.setTitle("Title...");
                    dialog.show();
                    itemname= (TextView) dialog.findViewById(R.id.tv_item_name);
                    itemcompany= (TextView) dialog.findViewById(R.id.tv_item_company);
                    itemprice= (TextView) dialog.findViewById(R.id.tv_price);
                    itemavialability= (TextView) dialog.findViewById(R.id.tv_avialability);
                    itemname.setText("Item name : "+dataModel.getName());
                    itemcompany.setText("Item company name : "+dataModel.getType());
                    itemprice.setText("Item price : "+dataModel.getVersion_number());
                    itemavialability.setText("Item availability : "+dataModel.getFeature());
                }
            });
        }catch(Exception e){
            Toast.makeText(getApplicationContext(),""+e.getMessage(),Toast.LENGTH_SHORT).show();
        }

    }
}
