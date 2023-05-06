package com.example.recycleview;

import java.util.ArrayList;

public class EtudaintContent {
    public static ArrayList<Etudaint> getEtudaints(){
        ArrayList<Etudaint> etudaints=new ArrayList<Etudaint>();
        etudaints.add(new Etudaint("560","wessim"));
        etudaints.add(new Etudaint("6000","iheb"));
        etudaints.add(new Etudaint("580","ala"));
        return etudaints;
    }
}
