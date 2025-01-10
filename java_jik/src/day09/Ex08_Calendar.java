package day09;

import java.util.Calendar;

public class Ex08_Calendar {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		
		System.out.println(c.get(Calendar.YEAR) + "년");
		System.out.println(c.get(Calendar.MONTH) + 1 + "월");
		System.out.println(c.get(Calendar.DAY_OF_MONTH) + "일");
		System.out.println(c.get(Calendar.HOUR_OF_DAY) + "시");
		int date = c.get(Calendar.DAY_OF_WEEK);//일월화수목금토
		switch(date) {
		case 1:	System.out.println("일요일");	break;
		case 2:	System.out.println("월요일");	break;
		case 3:	System.out.println("화요일");	break;
		case 4:	System.out.println("수요일");	break;
		case 5:	System.out.println("목요일");	break;
		case 6:	System.out.println("금요일");	break;
		case 7:	System.out.println("토요일");	break;
		}

	}

}
