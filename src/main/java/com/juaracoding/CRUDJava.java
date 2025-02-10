package com.juaracoding;

import java.util.ArrayList;
import java.util.Scanner;

public class CRUDJava {
    //deklarasi global untuk kemudahan saja
    //variabel-variabel ArrayList dapat dideklarasikan di dalam main
    //dan dijadikan parameter untuk setiap method
    static Scanner input = new Scanner(System.in);
    static ArrayList<String> listBarang = new ArrayList<>();
    static ArrayList<Integer> listHargaBarang = new ArrayList<>();
    static ArrayList<Integer> listStockBarang = new ArrayList<>();

    public static void main(String[] args) {
        //data hanya untuk pengujian saja
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
            //Menampilkan menu-menu yang dapat diakses, ketik 0 untuk keluar
            System.out.println("===Menu CRUD Toko Madu===");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Detail Produk");
            System.out.println("3. Ubah Produk");
            System.out.println("4. Hapus Produk");
            System.out.println("5. Cari Produk");
            System.out.println("6. Urutkan Produk");
            System.out.println("0. Tutup");

            System.out.print("Pilihan : ");
            String choice = input.nextLine();

            if (choice.equalsIgnoreCase("1")){
                Create(); //Mengakses menu menambahkan data
            }
            else if (choice.equalsIgnoreCase("2")){
                Read(); //Mengakses menu untuk melihat detil data
            }
            else if (choice.equalsIgnoreCase("3")){
                Update(); //Mengakses menu untuk mengubah data
            }
            else if (choice.equalsIgnoreCase("4")){
                Delete(); //Mengakses menu untuk menghapus data secara fisik
            }
            else if (choice.equalsIgnoreCase("5")){
                SearchMenu(); //Membuka menu mencari data
            }
            else if (choice.equalsIgnoreCase("6")){
                SortMenu(); //Membuka menu untuk mensortir data
            }
            else if (choice.equalsIgnoreCase("0")){
                break; //Keluar dari loop, sehingga program tertutup
            }
        }
    }

    private static void PrintData(){
        if(!listBarang.isEmpty() && !listStockBarang.isEmpty() && !listHargaBarang.isEmpty()){
            if(listBarang.size() == listHargaBarang.size() && listBarang.size() == listStockBarang.size()){
                for(int i = 0; i < listBarang.size(); i++){
                    //Menampilkan data
                    System.out.println((i+1) + ". " + listBarang.get(i));
                }
            }
            else{
                //Jika jumlah dari ketiga data tidak sama persis jumlahnya, maka ada yang salah
                System.out.println("Terdapat kesalahan pada data");
            }
        }
        else{
            //Jika tidak terdapat data ketika ingin menampilkan data
            System.out.println("Data kosong saat ini");
        }
    }

    private static void Create(){
        while(true){
            System.out.print("Masukkan nama barang : ");
            String namaBarang = input.nextLine();

            System.out.print("Masukkan harga barang : ");
            String strHargaBarang = input.nextLine();

            System.out.print("Masukkan stok barang : ");
            String strStokBarang = input.nextLine();

            //Memeriksa apakah data dalam bentuk angka atau tidak
            if(isNumeric(strHargaBarang) && isNumeric(strStokBarang)){
                int hargaBarang = Integer.parseInt(strHargaBarang);
                int stokBarang = Integer.parseInt(strStokBarang);

                //Harga dan Stok harus angka positif
                if(hargaBarang >= 0 && stokBarang >= 0){
                    listBarang.add(namaBarang);
                    listHargaBarang.add(hargaBarang);
                    listStockBarang.add(stokBarang);
                    break;
                }
                else {
                    System.out.println("Maaf data yang anda masukkan tidak valid, harga dan stok barang harus positif");
                }
            }
        }
    }

    private static void Read(){
        //Periksa apakah data kosong atau tidak
        if(!listBarang.isEmpty()){
            PrintData();

            System.out.print("Pilih data barang yang ingin dilihat : ");
            int index = Integer.parseInt(input.nextLine());

            //Menunjukkan detil dari barang yang dipilih
            System.out.println((index) + ". " + listBarang.get(index-1)
                    + " \nRp. " + listHargaBarang.get(index-1)+ " \nStok : "
                    + listStockBarang.get(index-1));
        }
        else{
            System.out.println("Tidak terdapat data saat ini");
        }
    }

    private static void Update(){
        while(true){
            PrintData();

            //Memeriksa apakah terdapat data atau tidak
            if(!listBarang.isEmpty() && !listStockBarang.isEmpty() && !listHargaBarang.isEmpty()) {

                System.out.print("Pilih data barang yang ingin diubah : ");
                int index = Integer.parseInt(input.nextLine());

                System.out.print("Masukkan nama barang yang baru : ");
                String newName = input.nextLine();

                System.out.print("Masukkan harga barang yang baru : ");
                String strPrice = input.nextLine();

                System.out.print("Masukkan stok barang yang baru : ");
                String strStock = input.nextLine();

                //Memeriksa apakah stok dan harga dalam bentuk numerik atau tidak
                if (isNumeric(strStock) || isNumeric(strPrice)) {
                    System.out.println("Maaf input anda tidak valid, harga dan stok harus dalam bentuk angka");
                    continue;
                }

                int newPrice = Integer.parseInt(strPrice);
                int newStock = Integer.parseInt(strStock);

                //Memeriksa apakah harga dan stok bernilai positif
                if (newPrice >= 0 && newStock >= 0) {
                    listBarang.set(index, newName);
                    listHargaBarang.set(index, newPrice);
                    listStockBarang.set(index, newStock);

                    System.out.println("Data sudah terupdate!");
                    break;
                } else {
                    System.out.println("Maaf input anda tidak valid, harga dan stok harus angka positif");
                }
            }
            else break;
        }
    }

    private static void Delete(){
        while(true){
            PrintData();

            //Memeriksa apakah data kosong atau tidak
            if(!listBarang.isEmpty() && !listStockBarang.isEmpty() && !listHargaBarang.isEmpty()) {

                System.out.print("Pilih data barang yang ingin dihapus : ");
                String strIndex = input.nextLine();

                //Memeriksa apakah memilih angka pada menu atau tidak karena akan dijadikan index
                if (isNumeric(strIndex)) {
                    //Dikurangi 1 karena index yang dimasukkan dimulai dari angka 1
                    int index = Integer.parseInt(strIndex) - 1;

                    System.out.println("Apakah anda yakin ingin menghapus barang " + listBarang.get(index) + "? (Y/N)");
                    String answer = input.nextLine();

                    if (answer.equalsIgnoreCase("y")) {
                        String namaBarang = listBarang.get(index);
                        int hargaBarang = listHargaBarang.get(index);
                        int stokBarang = listStockBarang.get(index);

                        listBarang.remove(namaBarang);
                        listHargaBarang.remove(hargaBarang);
                        listStockBarang.remove(stokBarang);
                        System.out.println("Data barang [" + namaBarang + "] sudah dihapus!");
                        break;
                    }
                }
            }
            else break;
        }
    }

    private static void SearchMenu(){
        PrintData();

        //Memeriksa apakah data kosong atau tidak
        if(!listBarang.isEmpty() && !listStockBarang.isEmpty() && !listHargaBarang.isEmpty()) {
            System.out.print("Masukkan nama barang yang ingin Anda cari : ");
            String searchBarang = input.nextLine();
            boolean isFound = false;

            //Mencoba mencari data ada di dalam list atau tidak
            for (int i = 0; i < listBarang.size(); i++) {
                if (listBarang.get(i).equalsIgnoreCase(searchBarang)) {
                    isFound = true;
                }
            }

            System.out.println(!isFound
                    ? "Maaf barang yang Anda masukkan tidak terdapat pada inventori kami"
                    : "Kami menemukan barang [" + searchBarang + "] pada inventori kami!"
            );
        }
    }

    private  static void SortMenu(){

        if(!listBarang.isEmpty() && !listStockBarang.isEmpty() && !listHargaBarang.isEmpty()){
            while(true){

                //Menampilkan pilihan menu sortir
                System.out.println("===Menu Sorting===");

                System.out.println("1. Sorting berdasarkan harga");
                System.out.println("2. Sorting berdasarkan stok");

                String strChoice = input.nextLine();

                System.out.println("1. Sorting dari kecil ke besar (ascending)");
                System.out.println("2. Sorting dari besar ke kecil (descending)");

                String strSortOrder = input.nextLine();

                if(isNumeric(strChoice) && isNumeric(strSortOrder)){
                    int choice = Integer.parseInt(strChoice);
                    int sortOrder = Integer.parseInt(strSortOrder);

                    if(choice == 1){
                        if(sortOrder == 1){
                            PrintSort("harga", "asc");
                            break;
                        }
                        else if(sortOrder == 2){
                            PrintSort("harga", "desc");
                            break;
                        }
                    }
                    else if(choice == 2) {
                        if (sortOrder == 1) {
                            PrintSort("stok", "asc");
                            break;
                        } else if (sortOrder == 2) {
                            PrintSort("stok", "desc");
                            break;
                        }
                    }
                }
                else break;
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

        System.out.println("Data sudah diurutkan berdasarkan " + sortBy
                + "secara "
                + (
                    sortOrder.equalsIgnoreCase("asc")
                            ? "dari kecil ke besar"
                            : "dari besar ke kecil"
                )
        );
    }

    static boolean isNumeric(String str){
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
