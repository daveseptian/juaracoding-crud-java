package com.juaracoding;

import java.util.ArrayList;
import java.util.Scanner;

public class CRUDJava {
    static Scanner input = new Scanner(System.in);
    static ArrayList<String> listBarang = new ArrayList<>();
    static ArrayList<Integer> listHargaBarang = new ArrayList<>();
    static ArrayList<Integer> listStockBarang = new ArrayList<>();

    public static void main(String[] args) {
        listBarang.add("hitam");
        listBarang.add("putih");
        listBarang.add("kuning");
        listBarang.add("hitam ketiga");
        listBarang.add("hitam keempat");
        listBarang.add("hitam kelima");
        listBarang.add("hitam keenam");
        listBarang.add("hitam ketujuh");

        listHargaBarang.add(10000);
        listHargaBarang.add(12000);
        listHargaBarang.add(80000);
        listHargaBarang.add(8000);
        listHargaBarang.add(15000);
        listHargaBarang.add(20000);
        listHargaBarang.add(1000);
        listHargaBarang.add(2000);

        listStockBarang.add(5);
        listStockBarang.add(2);
        listStockBarang.add(3);
        listStockBarang.add(7);
        listStockBarang.add(12);
        listStockBarang.add(100);
        listStockBarang.add(0);
        listStockBarang.add(1);

        PrintMenu();
    }

    public static void PrintMenu(){
        while(true){
            System.out.println("===Menu CRUD Toko Madu===");
            System.out.println("1. Create");
            System.out.println("2. Read");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Search");
            System.out.println("6. Sort");
            System.out.println("0. Close");

            System.out.print("Pilihan : ");
            String choice = input.nextLine();

            if (choice.equalsIgnoreCase("1")){
                Create();
            }
            else if (choice.equalsIgnoreCase("2")){
                Read();
            }
            else if (choice.equalsIgnoreCase("3")){
                Update();
            }
            else if (choice.equalsIgnoreCase("4")){
                Delete();
            }
            else if (choice.equalsIgnoreCase("5")){
                SearchMenu();
            }
            else if (choice.equalsIgnoreCase("6")){
                SortMenu();
            }
            else if (choice.equalsIgnoreCase("0")){
                break;
            }
        }
    }

    private static void PrintData(){
        if(listBarang.size() == listHargaBarang.size()){
            for(int i = 0; i < listBarang.size(); i++){
                System.out.println((i+1) + ". " + listBarang.get(i) + " (Rp. " + listHargaBarang.get(i) + " Stok : " + listStockBarang.get(i) + ") ");
            }
        }
        else{
            System.out.println("Terdapat kesalahan pada data");
        }
    }

    private static void Create(){
        System.out.print("Masukkan nama barang : ");
        listBarang.add(input.nextLine());
        System.out.println();

        System.out.print("Masukkan harga barang : ");
        listHargaBarang.add(Integer.parseInt(input.nextLine()));
    }

    private static void Read(){
        if(!listBarang.isEmpty()){
            PrintData();

            System.out.print("Pilih data barang yang ingin dilihat : ");
            int index = Integer.parseInt(input.nextLine());

            System.out.println((index) + ". " + listBarang.get(index-1) + " (Rp. " + listHargaBarang.get(index-1) + ")");
        }
        else{
            System.out.println("Tidak terdapat data saat ini");
        }
    }

    private static void Update(){
        PrintData();

        System.out.print("Pilih data barang yang ingin diubah : ");
        int index = input.nextInt();

        System.out.print("Masukkan nama barang yang baru : ");
        String newName = input.nextLine();

        System.out.print("Masukkan harga barang yang baru : ");
        Integer newPrice = Integer.parseInt(input.nextLine());

        listBarang.set(index, newName);
        listHargaBarang.set(index, newPrice);

        System.out.println("Data sudah terupdate!");
    }

    private static void Delete(){
        PrintData();

        System.out.print("Pilih data barang yang ingin dihapus : ");
        Integer index = Integer.parseInt(input.nextLine());

        System.out.println("Apakah anda yakin ingin menghapus barang " + listBarang.get(index) + "? (Y/N)");
        String answer = input.nextLine();

        if (answer.equalsIgnoreCase("y")){
            listBarang.remove(listBarang.get(index));
            listHargaBarang.remove(listHargaBarang.get(index));
        }
    }

    private static void SearchMenu(){
        System.out.print("Masukkan nama barang yang ingin Anda cari : ");
        String searchBarang = input.nextLine();
        boolean isFound = false;

        for(int i = 0; i < listBarang.size(); i++){
            if (listBarang.get(i).equalsIgnoreCase(searchBarang)){
                System.out.println("Kami menemukan barang " + searchBarang + " pada inventori kami di indeks ke-" + (i+1) + "!");
                isFound = true;
            }
        }

        System.out.println(!isFound ? "Maaf barang yang Anda masukkan tidak terdapat pada inventori kami" : "");
    }

    private  static void SortMenu(){
        System.out.println("===Menu Sorting===");

        System.out.println("1. Sorting berdasarkan harga");
        System.out.println("2. Sorting berdasarkan stok");

        int choice = Integer.parseInt(input.nextLine());

        System.out.println("1. Sorting dari kecil ke besar (ascending)");
        System.out.println("2. Sorting dari besar ke kecil (descending)");

        int sortOrder = Integer.parseInt(input.nextLine());

        if(choice == 1){
            if(sortOrder == 1){
                PrintSort("harga", "asc");
            }
            else if(sortOrder == 2){
                PrintSort("harga", "desc");
            }
        }
        else if(choice == 2){
            if(sortOrder == 1){
                PrintSort("stok", "asc");
            }
            else if(sortOrder == 2){
                PrintSort("stok", "desc");
            }
        }
    }

    private static void PrintSort(String sortBy, String sortOrder){
        ArrayList<String> templistBarang = listBarang;
        ArrayList<Integer> tempListHargaBarang = listHargaBarang;
        ArrayList<Integer> tempListStockBarang = listStockBarang;

        if(sortBy.equalsIgnoreCase("Harga")){
            if(sortOrder.equalsIgnoreCase("asc")){
                if(templistBarang.size() == tempListHargaBarang.size()){
                    int size = templistBarang.size();
                    for(int i = 0; i < size; i++){
                        int lowestPrice = Integer.MAX_VALUE, index = -1;
                        for(int j = 0; j < size - i; j++){
                            if(tempListHargaBarang.get(j) < lowestPrice){
                                lowestPrice = tempListHargaBarang.get(j);
                                index = j;
                            }
                        }
                        String tempBarang = templistBarang.get(index);
                        int tempHargaBarang = tempListHargaBarang.get(index);

                        templistBarang.remove(templistBarang.get(index));
                        tempListHargaBarang.remove(tempListHargaBarang.get(index));

                        templistBarang.add(tempBarang);
                        tempListHargaBarang.add(tempHargaBarang);
                    }
                }
            }
            else if (sortOrder.equalsIgnoreCase("desc")) {
                if(templistBarang.size() == tempListHargaBarang.size()){
                    int size = templistBarang.size();
                    for(int i = 0; i < size; i++){
                        int highestPrice = Integer.MIN_VALUE, index = -1;
                        for(int j = 0; j < size - i; j++){
                            if(tempListHargaBarang.get(j) > highestPrice){
                                highestPrice = tempListHargaBarang.get(j);
                                index = j;
                            }
                        }
                        String tempBarang = templistBarang.get(index);
                        int tempHargaBarang = tempListHargaBarang.get(index);

                        templistBarang.remove(templistBarang.get(index));
                        tempListHargaBarang.remove(tempListHargaBarang.get(index));

                        templistBarang.add(tempBarang);
                        tempListHargaBarang.add(tempHargaBarang);
                    }
                }
            }

        }
        else if (sortBy.equalsIgnoreCase("Stok")) {
            if(sortOrder.equalsIgnoreCase("asc")){
                if(templistBarang.size() == tempListStockBarang.size()){
                    int size = templistBarang.size();
                    for(int i = 0; i < size; i++){
                        int lowestStock = Integer.MAX_VALUE, index = -1;
                        for(int j = 0; j < size - i; j++){
                            if(tempListStockBarang.get(j) < lowestStock){
                                lowestStock = tempListStockBarang.get(j);
                                index = j;
                            }
                        }
                        String tempBarang = templistBarang.get(index);
                        int tempStockBarang = tempListStockBarang.get(index);

                        templistBarang.remove(templistBarang.get(index));
                        tempListStockBarang.remove(tempListStockBarang.get(index));

                        templistBarang.add(tempBarang);
                        tempListStockBarang.add(tempStockBarang);
                    }
                }
            }
            else if (sortOrder.equalsIgnoreCase("desc")) {
                if(templistBarang.size() == tempListStockBarang.size()){
                    int size = templistBarang.size();
                    for(int i = 0; i < size; i++){
                        int highestStock = Integer.MIN_VALUE, index = -1;
                        for(int j = 0; j < size - i; j++){
                            if(tempListStockBarang.get(j) > highestStock){
                                highestStock = tempListStockBarang.get(j);
                                index = j;
                            }
                        }
                        String tempBarang = templistBarang.get(index);
                        int tempHargaBarang = tempListStockBarang.get(index);

                        templistBarang.remove(templistBarang.get(index));
                        tempListStockBarang.remove(tempListStockBarang.get(index));

                        templistBarang.add(tempBarang);
                        tempListStockBarang.add(tempHargaBarang);
                    }
                }

            }

        }

        listBarang = templistBarang;
        listHargaBarang = tempListHargaBarang;

        PrintData();
    }
}
