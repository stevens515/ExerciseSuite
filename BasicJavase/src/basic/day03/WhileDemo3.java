package basic.day03;

public class WhileDemo3 {
		/**
		 * �˿�
		 */
	static String[] cards	= {"����A","����3","����4","����5","����6","����7","����8","����9",
			"����10","����J","����Q","����K","����A"};
	static String[] names = {"����","�ŷ�","�ŷ�"};
		public static void main(String[] args) {
			int i = 0;
			while(i<13){
				String card = cards[i];
				String name = names[i++%3];
				System.out.println(name+":"+card+"");
				if(i%3==0){
					System.out.println();
				}
			}

		}

	}
	/*
	 * i	i<54	i++%3	i%3==0
	 * 0	true	0		false
	 * 1	true	1		false
	 * 2	true	2		true
	 * 3	true	0		false
	 * 4	true	1		false
	 * 5	true	2		false
	 * 6	true	0		true
	 * 7	true	1		false
	 * 8	true	2		false
	 * 9	true	0		true
	 * ....
	 * 53	true	2		true
	 * 54	false
	 */
