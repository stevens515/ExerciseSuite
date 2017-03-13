package basic.day12;

public class ShopDemo {

	public static void main(String[] args) {
		Shop<Pet> petShop = new Shop<Pet>(new Pet("����"));
		Shop<Food> foodShop = new Shop<Food>(new Food("���"));
//		Shop<Food> foodShop = new Shop<Food>(new Food("����"));//����
		Pet dog = petShop.buy();
		System.out.println(dog.name);
		Food food  = foodShop.buy();
		System.out.println(food.type);//���
		Shop<Object> shop = new Shop<Object>(new Food("���"));//�������
		Shop s = new Shop(new Food("����"));//��д���ͣ�Ĭ�ϵ���object,�������о���
		
	}

}
class Shop <P>{			// p = product
	P p;
	public Shop(P p){
		this.p = p;
	}
	public P buy(){
		return p;
	}
}
class Pet{
	String name;
	public Pet(String name){
		this.name = name;
	}
}
class Food{
	String type;
	public Food(String type){
		this.type = type;
	}
}