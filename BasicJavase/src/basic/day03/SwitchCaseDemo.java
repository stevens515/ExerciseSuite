package basic.day03;

public class SwitchCaseDemo {

	/**
	 * switch Demo
	 */
	public static void main(String[] args) {
		int score = 100;
		String level;
		switch(score/10){
		case 10:
		 case 9:
			level= "��";break;
		case 8:
			level="��";	break;
		case 7:
			level="��"; break;
		default:	
			level="������"; break;
		}
	
		System.out.println(level);

	}

}
