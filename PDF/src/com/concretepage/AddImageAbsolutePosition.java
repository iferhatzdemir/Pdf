package com.concretepage;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.itextpdf.text.Document;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;
public class AddImageAbsolutePosition {
    public static void main(String[] args) throws DocumentException, MalformedURLException, IOException {
    	
    	@SuppressWarnings("deprecation")
		Document document = new Document();
    	        PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\User\\Desktop\\test\\15.pdf"));
    	        document.open();
    	        Scanner read = new Scanner(new File("C:\\Users\\User\\eclipse-workspace\\modular-case\\inventory\\codelists\\sayfa-20.txt"));
    	       ArrayList<String> myList = new ArrayList<String>();
    	        while(read.hasNextLine()) {
    	            myList.add(read.nextLine());}
    	        
    	      float BASLANGIC_NOKTASI_YATAY=17.007874f ;  
    	       	float BASLANGIC_NOKTASI_DUSEY=26.929134f ;
    	       	float ETIKET_GENISLIK=63.212598f;
    	       	float ETIKET_YUKSEKLIK=34.015748f;
    	       	float ETIKET_YATAY_ARALIK=9.92126f;
    	       	float ETIKET_DUSEY_ARALIK=5.669291f;
    	       	float GUNCEL_KONUM_YATAY = 0.0F;
    	       	float GUNCEL_KONUM_DUSEY = 0.0F;
    	       	int ETIKET_SUTUN_ADEDI = 8;
    	       	int ETIKET_SATIR_ADEDI = 20;
    	       	GUNCEL_KONUM_YATAY = BASLANGIC_NOKTASI_YATAY;
    	       	GUNCEL_KONUM_DUSEY = BASLANGIC_NOKTASI_DUSEY;

    	        for(int i=0; i < ETIKET_SATIR_ADEDI; i++)
    	        {     	        System.out.println(i);

    	        	  for(int j=0; j < ETIKET_SUTUN_ADEDI; j++)
    	    	        { 
    	      	        System.out.println(j);

    	        	String qrCodeData = myList.get((8*i)+j);
    	        
    	       Image img2 = Image.getInstance("C:\\Users\\User\\eclipse-workspace\\modular-case\\qrcode-generator\\src\\QRcodes\\"+qrCodeData+".png");
  	        img2.scaleToFit(ETIKET_GENISLIK,ETIKET_YUKSEKLIK);
    	        img2.setAbsolutePosition(GUNCEL_KONUM_YATAY, GUNCEL_KONUM_DUSEY);
    	        document.add(img2);
    	       	GUNCEL_KONUM_YATAY = GUNCEL_KONUM_YATAY + ETIKET_GENISLIK + ETIKET_YATAY_ARALIK;
    	       	}
    	        		GUNCEL_KONUM_YATAY = BASLANGIC_NOKTASI_YATAY;
    	       	GUNCEL_KONUM_DUSEY = GUNCEL_KONUM_DUSEY + ETIKET_YUKSEKLIK + ETIKET_DUSEY_ARALIK;


    	      
    	        }
    	        
    	        document.close();
    	        System.out.println("Done");
    	        
    	   }
    	
    }

