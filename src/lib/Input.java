/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


/**
 *
 * @author tranh
 */
public class Input {
    
    public static Scanner sc = new Scanner(System.in);
    public static final String PHONE = "[\\d]{10,12}";
    
    //Functions handling as double
    public static double input_Double(String msg, String error){
        boolean flag = true;
        double temp = 0;
        do {            
            try {
                System.out.print(msg);
                temp = Double.parseDouble(sc.nextLine().trim());
                flag = true;
            } catch (Exception e) {
                System.out.println(error);
                flag = false;
            }
        } while (flag == false);
        return temp;
    }
    
    //Functions handling as double betwen min and max
    public static double input_Double_min_max(String msg, String error,int min, int max){
        boolean flag = true;
        double temp = 0;
        do {            
            try {
                System.out.print(msg);
                temp = Double.parseDouble(sc.nextLine().trim());
                if(temp > max || temp< min) throw new Exception();
                flag = true;
            } catch (Exception e) {
                System.out.println(error);
                flag = false;
            }
        } while (flag == false);
        return temp;
    }
    
    public static int input_int(String msg, String error){
        boolean flag = true;
        int temp = 0;
        do {            
            try {
                System.out.print(msg);
                temp = Integer.parseInt(sc.nextLine().trim());                
                flag = true;
            } catch (Exception e) {
                System.out.println(error);
                flag = false;
            }
        } while (flag == false);
        return temp;
    }
    
    public static int input_Int_min_max(String msg, String error,int min, int max){
        boolean flag = true;
        int temp = 0;
        do {            
            try {
                System.out.print(msg);
                temp = Integer.parseInt(sc.nextLine().trim());
                if(temp > max || temp< min) throw new Exception();
                flag = true;
            } catch (Exception e) {
                System.out.println(error);
                flag = false;
            }
        } while (flag == false);
        return temp;
    }
    
    public static int input_Int_min(String msg, String error, int min){
        boolean flag = true;
        int temp = 0;
        do {            
            try {
                System.out.print(msg);
                temp = Integer.parseInt(sc.nextLine().trim());
                if(temp< min) throw new Exception();
                flag = true;
            } catch (Exception e) {
                System.out.println(error);
                flag = false;
            }
        } while (flag == false);
        return temp;
    }
    
    public static int input_Int_max(String msg, String error, int max){
        boolean flag = true;
        int temp = 0;
        do {            
            try {
                System.out.print(msg);
                temp = Integer.parseInt(sc.nextLine().trim());
                if(temp > max) throw new Exception();
                flag = true;
            } catch (Exception e) {
                System.out.println(error);
                flag = false;
            }
        } while (flag == false);
        return temp;
    }
    
    public static float input_Float_min_max(String msg, String error,int min, int max){
        boolean flag = true;
        float temp = 0;
        do {            
            try {
                System.out.print(msg);
                temp = sc.nextFloat();
                if(temp > max || temp< min) throw new Exception();
                flag = true;
            } catch (Exception e) {
                System.out.println(error);
                flag = false;
            }
        } while (flag == false);
        return temp;
    }
    
    public static String input_String(String msg){
        System.out.print(msg);
        String tmp =sc.nextLine().trim();
        return tmp;
    }
    
    public static String input_String(String msg, String error){
        boolean check = true;
        String temp = "";
        do {            
            try {
                System.out.print(msg);
                temp = sc.nextLine().trim();
                if (temp.equalsIgnoreCase("") || temp.matches("\\s+")) throw new Exception();
                check = true;
            } catch (Exception e) {
                System.out.println(error);                
            }
        } while (check == false);
        return temp;
    }
    
    public static String input_String_pattern(String msg, String error, ArrayList<String> khuon){
        boolean check = false;
        String temp = "";
        do {            
            try {
                System.out.print(msg);
                temp = sc.nextLine();
                
                for (String acc : khuon) {
                    if(acc.equalsIgnoreCase(temp) == true) check = true;
                }
                
                if(check == false) throw new Exception();
            } catch (Exception e) {
                System.out.println(error);
            }
        } while (check == false);
        return temp;
    }
    
    public static String input_String_regex(String msg, String error, ArrayList<String> khuon){
        boolean check = true;
        String temp = "";
        
        do { 
            check = true;
            try {
                System.out.print(msg);
                temp = sc.nextLine();
                
                for (String acc : khuon) {
                    if(acc.equalsIgnoreCase(temp) == true) check = false;
                }
                
                if(check == false) throw new Exception();
            } catch (Exception e) {
                System.out.println(error);
            }
        } while (check == false);
        return temp;
    }
    
    public static Boolean input_Boolean(String msg, String error){
        boolean flag = true;
        boolean temp = false;
        do {            
            try {
                System.out.print(msg);
                temp = sc.nextBoolean();
                flag = true;
            } catch (Exception e) {
                System.out.println(error);
                flag = false;
            }
        } while (flag == false);
        return temp;
    }
    
    public static String updateString(String welcome, String oldData) {
        String result = "";
        System.out.print(welcome);
        String tmp = sc.nextLine();
        if (!tmp.isEmpty()) {
            result = tmp;            
        } else {
            result = oldData;
        }
        return result;
    }
    
    public static String updateStringPattern(String welcome, String error,String regex, String oldData) {
        String result = "";
        boolean ok;
        System.out.print(welcome);
        String tmp = sc.nextLine().trim();
        if (!tmp.isEmpty()) {
            do {                
                result = tmp;
                ok = result.matches(regex);
                if(!ok) System.out.println(error);
            } while (!ok);
        } else {
            result = oldData;
        }
        return result;
    }
    
    public static int update_int(String welcome, String error, int min, int max, int oldDate){
        boolean check = true;
        int number = oldDate;
        do {
            try {
                System.out.print(welcome);
                String tmp = sc.nextLine();
                
                if (tmp.isEmpty()) {
                    check = true;
                } else {
                    number = Integer.parseInt(tmp);
                    check = false;
                }
            } catch (Exception e) {
                System.out.println(error);
            }
        } while (check || number > max || number < min);
        
        return number;
    }
    
   public static double update_Double(String welcome, String error, double min, double max, double oldDate){
       boolean check = true;
       double number = oldDate;
       do {           
           try {
               System.out.print(welcome);
               String tmp = sc.nextLine();
               
               if(tmp.isEmpty()) check = false;
               else{
                   number = Double.parseDouble(tmp);
                   check = false;
               }
           } catch (Exception e) {
               System.out.println(error);
           }
       } while (check || number > max || number < min);
       return number;
   }
   
   public static boolean update_boolean(String enterNewData, String error, boolean oldData) {
        boolean bool = oldData;
        do {
            try {                
                System.out.print(enterNewData);
                String tmp = sc.nextLine().trim();
                tmp = tmp.toLowerCase();
                if ((tmp.equals("true") == true || tmp.equals("false") == true)) {
                    bool = Boolean.parseBoolean(tmp);
                    return bool;
                }
                if (tmp.isEmpty()) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println(error);
            }
        } while(true);
        return bool;
   }
   
   public static boolean yes_no(String confirm) {  
        while(true){
            String test1 = Input.input_String(confirm);
            if (test1.equalsIgnoreCase("Y")) {
                return true;
            }else if(test1.equalsIgnoreCase("N")){
                return false;
            }else{
                System.out.println("Invalid input !");
            }  
        }
    }
   
    public static boolean yes_no(String confirm, String correct, String incorrect) {  
        while(true){
            String test1 = Input.input_String(confirm);
            if (test1.equalsIgnoreCase(correct)) {
                return true;
            }else if(test1.equalsIgnoreCase(incorrect)){
                return false;
            }else{
                System.out.println("Invalid input !");
            }  
        }
    }
   
   //PHONE
   public static boolean isNumberic(String StrNum){
       if(StrNum == null) return false;
       try {
           double d = Double.parseDouble(StrNum);
       } catch (Exception e) {
           return false;
       }
       return true;
   }
   
   public static String check_phone_number(String msg, String error){
       boolean check = false;
       String temp = "";
       do {           
           try {
               System.out.print(msg);
               temp = sc.nextLine().trim();
               
               if(temp.equalsIgnoreCase("") || temp.matches("\\s+") || temp.length() < 10 || temp.length() > 12 ||isNumberic(temp) == false){
                   throw new Exception();
               }
               check = true;
           } catch (Exception e) {
               System.out.println(error);
           }
       } while (check == false);
       return temp;
   }
   
   public static String read_pattern(String msg, String error, String regex){
       String S;
       boolean OK;
       do {           
           System.out.print(msg);
           S = sc.nextLine().trim();
           OK = S.matches(regex);
           if(!OK) System.out.println(error);
       } while (!OK);
       return S;
   }
   
   public static String read_pattern_null(String msg, String error, String regex){
       String S;
       boolean OK;
       do {           
           System.out.print(msg);
           S = sc.nextLine().trim();
           if(S.isEmpty() == true) return "";
           OK = S.matches(regex);
           if(!OK) System.out.println(error);
       } while (!OK);
       return S;
   }
   
   public static String check_phone_number_null(String msg, String error){
       boolean check = false;
        String temp = "";
        do {
            try {             
                System.out.print(msg);
                temp = sc.nextLine().trim();
                if(temp.isEmpty() == true){
                    return "";
                }
                if ( temp.equalsIgnoreCase("") || temp.matches("\\s+") || temp.length() > 12 || temp.length() < 10 || isNumberic(temp) == false) {
                    throw new Exception();
                }
                check = true;
            } catch (Exception e) {
                System.out.println(error);
            }
        } while (check == false);
        return temp;
   }
   
   /*DATE*/
    public static final int DMY = 0;
    public static final int MDY = 1;
    public static final int YMD = 2;
    public static boolean isLeap(int y){
        boolean result = false;
        if ((y%400==0) || (y%4==0) && (y%100!=0)) result=true;
        return result;
    }
    
    public static boolean valid(int y, int m, int d){
        if(y<0 || m<0 || m>12 || d<0 || d>31) return false;
        int maxD=31;
        if(m==4 || m==6 || m==9 || m==11) maxD = 30;
        else if(m==2){
            if(isLeap(y)) maxD=29;
            else maxD = 28;
        }
        return d<=maxD;
    }
    
    public static Date toDate(int y, int m, int d){
        if(!valid(y,m,d)) return null;
        Calendar cal = Calendar.getInstance();
        cal.set(y, m-1, d);
        return cal.getTime();
    }
    
    public static Date toDate(String dateStr, int dateFormat){
        int dIndex, mIndex, yIndex;
        switch(dateFormat){
            case YMD:
                yIndex = 0;
                mIndex = 1;
                dIndex = 2;
                break;
            case MDY:
                yIndex = 2;
                mIndex = 0;
                dIndex = 1;
                break;
            case DMY:
                yIndex = 2;
                mIndex = 1;
                dIndex = 0;
                break;
            default: return null;
        }
        String[]parts = dateStr.split("[/-]");
        
        if(parts.length != 3) return null;
        
        int d = Integer.parseInt(parts[dIndex]);
        int m = Integer.parseInt(parts[mIndex]);
        int y = Integer.parseInt(parts[yIndex]);
        return toDate(y, m, d);
    }
    
    public static Date readDMY(String message){
        Date d;
        String S;
        do{
            Scanner sc = new Scanner(System.in);
            System.out.print(message + "[m/d/y]: ");
            S = sc.nextLine().trim();
            d= toDate(S,MDY);
            if(d==null) System.out.println("Invalid date!");
        }while(d==null);
        return d;
    }
    
    public static Date readDMY_null(String message){
        Date d;
        String S;
        do{
            Scanner sc = new Scanner(System.in);
            System.out.print(message + "[d/m/y]: ");
            S = sc.nextLine().trim();
            if(S.isEmpty() == true){
                return null;
            }
            d= toDate(S,DMY);
            if(d==null) System.out.println("Invalid date!");
        }while(d==null);
        return d;
    }
     
    public static String strDMY(Date d){
        String S = "";
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        return S + (c.get(Calendar.DATE) + "-" + (c.get(Calendar.MONTH)+1) + "-" + (c.get(Calendar.YEAR)));
    }

}
