package tarena.test;

import org.junit.Assert;
import org.junit.Test;

import tarena.util.TaxUtil;

public class TestTaxUtil {
	@Test
	public void test1(){
		//ʵ�ʽ��
		double actual = TaxUtil.tax(1000);
		//�������
		double expected = 0;
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void test2(){
		//ʵ�ʽ��
		double actual = TaxUtil.tax(3000);
		//�������
		double expected = 0;
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void test3(){
		//ʵ�ʽ��
		double actual = TaxUtil.tax(6000);
		//�������
		double expected = 90;
		Assert.assertEquals(expected, actual);
	}
	
	
}
