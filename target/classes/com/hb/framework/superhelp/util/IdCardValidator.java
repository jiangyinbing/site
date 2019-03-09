/**
 * 
 */
package com.hb.framework.superhelp.util;

/**
 * @author 产品组 Nov 28, 2015 
 * 
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

public class IdCardValidator {
    protected String[][] codeAndCity = new String[][]{{"11", "北京"}, {"12", "天津"}, {"13", "河北"}, {"14", "山西"}, {"15", "内蒙古"}, {"21", "辽宁"}, {"22", "吉林"}, {"23", "黑龙江"}, {"31", "上海"}, {"32", "江苏"}, {"33", "浙江"}, {"34", "安徽"}, {"35", "福建"}, {"36", "江西"}, {"37", "山东"}, {"41", "河南"}, {"42", "湖北"}, {"43", "湖南"}, {"44", "广东"}, {"45", "广西"}, {"46", "海南"}, {"50", "重庆"}, {"51", "四川"}, {"52", "贵州"}, {"53", "云南"}, {"54", "西藏"}, {"61", "陕西"}, {"62", "甘肃"}, {"63", "青海"}, {"64", "宁夏"}, {"65", "新疆"}, {"71", "台湾"}, {"81", "香港"}, {"82", "澳门"}, {"91", "国外"}};
    private String[] cityCode = new String[]{"11", "12", "13", "14", "15", "21", "22", "23", "31", "32", "33", "34", "35", "36", "37", "41", "42", "43", "44", "45", "46", "50", "51", "52", "53", "54", "61", "62", "63", "64", "65", "71", "81", "82", "91"};
    private int[] power = new int[]{7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
    private String[] verifyCode = new String[]{"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};

    public IdCardValidator() {
    }

    public boolean isValidatedAllIdcard(String idcard) {
        if(idcard.length() == 15) {
            idcard = this.convertIdcarBy15bit(idcard);
        }

        return this.isValidate18Idcard(idcard);
    }

    public boolean isValidate18Idcard(String idcard) {
        if(idcard.length() != 18) {
            return false;
        } else {
            String idcard17 = idcard.substring(0, 17);
            String idcard18Code = idcard.substring(17, 18);
            Object c = null;
            String checkCode = "";
            if(this.isDigital(idcard17)) {
                char[] c1 = idcard17.toCharArray();
                if(null != c1) {
                    int[] bit = new int[idcard17.length()];
                    bit = this.converCharToInt(c1);
                    boolean sum17 = false;
                    int sum171 = this.getPowerSum(bit);
                    checkCode = this.getCheckCodeBySum(sum171);
                    if(null == checkCode) {
                        return false;
                    }

                    if(!idcard18Code.equalsIgnoreCase(checkCode)) {
                        return false;
                    }
                }

                return true;
            } else {
                return false;
            }
        }
    }

    public boolean isValidate15Idcard(String idcard) {
        if(idcard.length() != 15) {
            return false;
        } else if(!this.isDigital(idcard)) {
            return false;
        } else {
            String provinceid = idcard.substring(0, 2);
            String birthday = idcard.substring(6, 12);
            int year = Integer.parseInt(idcard.substring(6, 8));
            int month = Integer.parseInt(idcard.substring(8, 10));
            int day = Integer.parseInt(idcard.substring(10, 12));
            boolean flag = false;
            String[] birthdate = this.cityCode;
            int curDay = birthdate.length;

            int curYear;
            for(curYear = 0; curYear < curDay; ++curYear) {
                String year2bit = birthdate[curYear];
                if(year2bit.equals(provinceid)) {
                    flag = true;
                    break;
                }
            }

            if(!flag) {
                return false;
            } else {
                Date var14 = null;

                try {
                    var14 = (new SimpleDateFormat("yyMMdd")).parse(birthday);
                } catch (ParseException var13) {
                    var13.printStackTrace();
                }

                if(var14 != null && !(new Date()).before(var14)) {
                    GregorianCalendar var15 = new GregorianCalendar();
                    curYear = var15.get(1);
                    int var16 = Integer.parseInt(String.valueOf(curYear).substring(2));
                    if(year < 50 && year > var16) {
                        return false;
                    } else if(month >= 1 && month <= 12) {
                        boolean mflag = false;
                        var15.setTime(var14);
                        switch(month) {
                        case 1:
                        case 3:
                        case 5:
                        case 7:
                        case 8:
                        case 10:
                        case 12:
                            mflag = day >= 1 && day <= 31;
                            break;
                        case 2:
                            if(var15.isLeapYear(var15.get(1))) {
                                mflag = day >= 1 && day <= 29;
                            } else {
                                mflag = day >= 1 && day <= 28;
                            }
                            break;
                        case 4:
                        case 6:
                        case 9:
                        case 11:
                            mflag = day >= 1 && day <= 30;
                        }

                        return mflag;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
    }

    public String convertIdcarBy15bit(String idcard) {
        String idcard17 = null;
        if(idcard.length() != 15) {
            return null;
        } else if(this.isDigital(idcard)) {
            String birthday = idcard.substring(6, 12);
            Date birthdate = null;

            try {
                birthdate = (new SimpleDateFormat("yyMMdd")).parse(birthday);
            } catch (ParseException var11) {
                var11.printStackTrace();
            }

            Calendar cday = Calendar.getInstance();
            cday.setTime(birthdate);
            String year = String.valueOf(cday.get(1));
            idcard17 = idcard.substring(0, 6) + year + idcard.substring(8);
            char[] c = idcard17.toCharArray();
            String checkCode = "";
            if(null != c) {
                int[] bit = new int[idcard17.length()];
                bit = this.converCharToInt(c);
                boolean sum17 = false;
                int sum171 = this.getPowerSum(bit);
                checkCode = this.getCheckCodeBySum(sum171);
                if(null == checkCode) {
                    return null;
                }

                idcard17 = idcard17 + checkCode;
            }

            return idcard17;
        } else {
            return null;
        }
    }

    public boolean isIdcard(String idcard) {
        return idcard != null && !"".equals(idcard)?Pattern.matches("(^\\d{15}$)|(\\d{17}(?:\\d|x|X)$)", idcard):false;
    }

    public boolean is15Idcard(String idcard) {
        return idcard != null && !"".equals(idcard)?Pattern.matches("^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$", idcard):false;
    }

    public boolean is18Idcard(String idcard) {
        return Pattern.matches("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([\\d|x|X]{1})$", idcard);
    }

    public boolean isDigital(String str) {
        return str != null && !"".equals(str)?str.matches("^[0-9]*$"):false;
    }

    public int getPowerSum(int[] bit) {
        int sum = 0;
        if(this.power.length != bit.length) {
            return sum;
        } else {
            for(int i = 0; i < bit.length; ++i) {
                for(int j = 0; j < this.power.length; ++j) {
                    if(i == j) {
                        sum += bit[i] * this.power[j];
                    }
                }
            }

            return sum;
        }
    }

    public String getCheckCodeBySum(int sum17) {
        String checkCode = null;
        switch(sum17 % 11) {
        case 0:
            checkCode = "1";
            break;
        case 1:
            checkCode = "0";
            break;
        case 2:
            checkCode = "x";
            break;
        case 3:
            checkCode = "9";
            break;
        case 4:
            checkCode = "8";
            break;
        case 5:
            checkCode = "7";
            break;
        case 6:
            checkCode = "6";
            break;
        case 7:
            checkCode = "5";
            break;
        case 8:
            checkCode = "4";
            break;
        case 9:
            checkCode = "3";
            break;
        case 10:
            checkCode = "2";
        }

        return checkCode;
    }

    public int[] converCharToInt(char[] c) throws NumberFormatException {
        int[] a = new int[c.length];
        int k = 0;
        char[] arr$ = c;
        int len$ = c.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            char temp = arr$[i$];
            a[k++] = Integer.parseInt(String.valueOf(temp));
        }

        return a;
    }

    public static void main(String[] args) throws Exception {
        String idcard18 = "500383198704159290";
        IdCardValidator iv = new IdCardValidator();
        boolean flag = false;
        flag = iv.isValidate18Idcard(idcard18);
        System.out.println(flag);
        System.out.println(iv.isValidatedAllIdcard(idcard18));
    }
}
