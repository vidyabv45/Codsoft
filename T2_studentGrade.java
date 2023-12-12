package codsoft;
import java.util.*;
public class stu 
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the marks obtained in each subject : ");
		int s1=in.nextInt();
		int s2=in.nextInt();
		int s3=in.nextInt();
		int s4=in.nextInt();
		int s5=in.nextInt();
		int s6=in.nextInt();
		float sum=s1+s2+s3+s4+s5+s6;
		float avg= sum/6;
		String gra;
		if(avg>=80)
			gra="Distniction";
		else
			if(avg<80&&avg>=65)
				gra="First class";
			else
				if(avg<65&&avg>=50)
					gra="Second class";
				else
					if(avg<50&&avg>=35)
						gra="Pass";
					else
						gra="Fail";
		System.out.println("The Total marks is "+sum);
		System.out.println("The Average percentage is "+avg);
		System.out.println("The Grade obtained is "+gra);
	}
}
				

