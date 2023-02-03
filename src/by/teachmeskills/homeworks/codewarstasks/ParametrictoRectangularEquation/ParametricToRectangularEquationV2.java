package by.teachmeskills.homeworks.codewarstasks.ParametrictoRectangularEquation;
import java.util.Scanner;

public class ParametricToRectangularEquationV2 {
    /*
     * Уменьшенная версия задания на уравнения
     * */

    public static int findNOK(int num1,int num2)
    {
        int ost=1;
        int NOD=0;
        int div1=num1;
        int div2=num2;
        while(ost>0)
        {
            ost=div1%div2;
            NOD=div2;
            div1=div2;
            div2=ost;

        }
        return (num1*num2)/NOD;


    }

    public static String fixStrings(String str1,String str2)
    {
        int startInd1 = str1.indexOf('=');
        int endInd1 = str1.indexOf('t');
        if(str1.charAt(startInd1+2)=='-')
            startInd1++;
        startInd1+=2;
        endInd1--;
        if(str1.charAt(startInd1)=='t')
        {
            StringBuffer temp = new StringBuffer(str1);
            temp.insert(startInd1,'1');
            str1=temp.toString();
            endInd1+=1;
        }
        int n1=Integer.parseInt(str1.substring(startInd1,endInd1+1));

        int startInd2 = str2.indexOf('=');
        int endInd2 = str2.indexOf('t');
        if(str2.charAt(startInd2+2)=='-')
            startInd2++;
        startInd2+=2;
        endInd2--;
        if(str2.charAt(startInd2)=='t')
        {
            StringBuffer temp = new StringBuffer(str2);
            temp.insert(startInd2,'1');
            str2=temp.toString();
            endInd2+=1;
        }
        int n2=Integer.parseInt(str2.substring(startInd2,endInd2+1));


        int NOK = findNOK(n1,n2);
        int firstMultiplier=NOK/n1;
        int secondMultiplier=NOK/n2;

        StringBuffer firstBuffer=new StringBuffer(str1);
        StringBuffer secondBuffer=new StringBuffer(str2);

        n1=n1*firstMultiplier;
        n2=n2*secondMultiplier;
        firstBuffer.delete(startInd1,endInd1+1);
        firstBuffer.insert(startInd1,n1);
        secondBuffer.delete(startInd2,endInd2+1);
        secondBuffer.insert(startInd2,n2);

        firstBuffer.insert(0,firstMultiplier);
        secondBuffer.insert(0,secondMultiplier);

        startInd1 = firstBuffer.lastIndexOf(" ")+1;
        startInd2 = secondBuffer.lastIndexOf(" ")+1;
        n1=Integer.parseInt(firstBuffer.substring(startInd1,firstBuffer.length()));
        n2=Integer.parseInt(secondBuffer.substring(startInd2,secondBuffer.length()));
        n1=n1*firstMultiplier;
        n2=n2*secondMultiplier;
        firstBuffer.delete(startInd1,firstBuffer.length());
        firstBuffer.insert(startInd1,n1);
        secondBuffer.delete(startInd2,secondBuffer.length());
        secondBuffer.insert(startInd2,n2);

        String sign=" ";
        if((firstBuffer.charAt(firstBuffer.indexOf("=")+2)!='-' && secondBuffer.charAt(secondBuffer.indexOf("=")+2)!=
                '-')|| (firstBuffer.charAt(firstBuffer.indexOf("=")+2)=='-' &&
                secondBuffer.charAt(secondBuffer.indexOf("=")+2)=='-'))
            sign = " - ";
        else
        if(firstBuffer.charAt(firstBuffer.indexOf("=")+2)=='-' && secondBuffer.charAt(secondBuffer.indexOf("=")+2)!=
                '-')
            sign = " + ";
        else
        if(firstBuffer.charAt(firstBuffer.indexOf("=")+2)!='-' &&
                secondBuffer.charAt(secondBuffer.indexOf("=")+2)=='-')
            sign = " + ";

        String res="";
        startInd1=0;
        endInd1=firstBuffer.indexOf(" ")-1;
        startInd2=0;
        endInd2=secondBuffer.indexOf(" ")-1;
        res= firstBuffer.toString().substring(startInd1,endInd1+1) + sign +
                secondBuffer.toString().substring(startInd2,endInd2+1)+ " = ";

        if(firstBuffer.charAt(firstBuffer.lastIndexOf(" ")-1)=='-')
            n1=-n1;
        if(secondBuffer.charAt(secondBuffer.lastIndexOf(" ")-1)=='-')
            n2=-n2;
        if(sign==" - ")
            res=res+Integer.toString(n1-n2);
        else
            res=res+Integer.toString(n1+n2);


        if(res.charAt(res.indexOf('y')-1)=='1' && res.charAt(res.indexOf('y')-2)==' ')
        {
            StringBuffer temp = new StringBuffer(res);
            temp.delete(temp.indexOf("y")-1,temp.indexOf("y"));
            res=temp.toString();
        }

        if(res.startsWith("1x"))
        {
            StringBuffer temp = new StringBuffer(res);
            temp.delete(temp.indexOf("x")-1,temp.indexOf("x"));
            res=temp.toString();
        }
        return res;


    }

    public static void main(String[] args) {
        System.out.print("Введите уравнение 1\n");
        Scanner in = new Scanner(System.in);
        String inStr1 = in.nextLine();
        System.out.print("Введите уравнение 2\n");
        String inStr2 = in.nextLine();

        System.out.println(fixStrings(inStr1,inStr2));
    }


}
