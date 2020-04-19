package com.example.sugeng;

import java.util.ArrayList;

public class MakananData {
    private static String[] makananNames = {
            "Donat",
            "Adonan Donat",
            "Batagor",
            "Bakso",
            "Cruby Patty",
            "Jagung Bakar",
            "Bakso Bakar",
            "Lemon Tea",
            "Mie Karet",
            "Mie Ayam"
    };
    private static String[] makananDetails = {
            "detail Donatxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
            "dAdonan Donat",
            "dBatagor",
            "dBakso",
            "dCruby Patty",
            "dJagung Bakar",
            "dBakso Bakar",
            "dLemon Tea",
            "dMie Karet",
            "dMie Ayam"
    };
    private static int[] makananImages = {
            R.drawable.donat,
            R.drawable.adonandonat,
            R.drawable.batagor,
            R.drawable.bakso,
            R.drawable.crubypatty,
            R.drawable.jagungbakar,
            R.drawable.baksobakar,
            R.drawable.lemontea,
            R.drawable.miekaret,
            R.drawable.mieayam,
    };

    static ArrayList<Makanan> getListData() {
        ArrayList<Makanan> list = new ArrayList<>();
        for (int position = 0; position < makananNames.length; position++) {
            Makanan makanan = new Makanan();
            makanan.setName(makananNames[position]);
            makanan.setDetail(makananDetails[position]);
            makanan.setPhoto(makananImages[position]);
            list.add(makanan);
        }
        return list;
    }
}
