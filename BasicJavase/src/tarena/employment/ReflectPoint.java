package tarena.employment;

/**�ص�
 	���౻ReflectTest.java��ʹ�ã����ڲ���hashCod.
 	java�ڴ�й©���⡣
 */
import java.util.Date;

public class ReflectPoint {
	private int x;
	public int y;
	public ReflectPoint(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final ReflectPoint other = (ReflectPoint) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
		public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}	
}