package org.kettlesolutions.plugin.step.helloworld;

import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.core.row.RowDataUtil;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;
import org.pentaho.di.trans.step.BaseStep;
import org.pentaho.di.trans.step.StepDataInterface;
import org.pentaho.di.trans.step.StepInterface;
import org.pentaho.di.trans.step.StepMeta;
import org.pentaho.di.trans.step.StepMetaInterface;
/**
 * BaseStep�������Ѿ�ʵ���˽ӿ���ĺܶ෽��������ֻҪ������Ҫ�޸ĵķ������ɡ�
 * @author Administrator
 *
 */
public class HelloworldStep extends BaseStep implements StepInterface {
	/**
	 * ��Ĺ��캯��ͨ��ֱ�ӰѲ������ݸ�BaseStep���ࡣ�ɸ�����ķ������������Ȼ�����ֱ��
	 * ʹ������transMeta�����Ķ���
	 * @param stepMeta
	 * @param stepDataInterface
	 * @param copyNr
	 * @param transMeta
	 * @param trans
	 */
	public HelloworldStep(StepMeta stepMeta, StepDataInterface stepDataInterface,
			int copyNr, TransMeta transMeta, Trans trans) {
		super(stepMeta, stepDataInterface, copyNr, transMeta, trans);
		// TODO Auto-generated constructor stub
	}

	
	public boolean processRow(StepMetaInterface smi, StepDataInterface sdi) throws KettleException {

		HelloworldStepMeta meta  = (HelloworldStepMeta) smi;
		HelloworldStepData data = (HelloworldStepData) sdi;
		/**
		 * getRow()��������һ�������ȡһ�����ݡ����û�и���Ҫ��ȡ�������У���������ͻ᷵��null��
		 * ���ǰ��Ĳ��費�ܼ�ʱ�ṩ���ݣ���������ͻ�������ֱ���п��õ������С��������������ٶȾͻή�ͣ�Ҳ��Ӱ��
		 * ����������ٶȡ�
		 */
		Object[] row = getRow();
		if (row==null) {
			/**
			 * setOutputDone()��������֪ͨ�����Ĳ��裬�������Ѿ�û����������С���һ���������
			 * �ٵ���getRow()�����ͻ᷵��null,ת��Ҳ���ٵ���processRow()������
			 */
			setOutputDone();
			return false;
		}
		
		if (first) {
			first=false;
			/**
			 * �������Ͽ��ǣ�getRow()�������ṩ�����е�Ԫ���ݣ�ֻ�ṩ�ϸ�������������ݡ�����ʹ��getInputRowMeta()����
			��ȡԪ���ݣ�Ԫ����ֻ��ȡһ�μ��ɣ�������first��������ȡԪ���ݡ�
			   ���Ҫ�����ݴ�����һ�����裬Ҫʹ��putRow()����������������ݣ���Ҫ���RowMetaInterfaceԪ���ݡ�
			   ��һ��ʹ��clone()�����������е�Ԫ���ݽṹ���Ƹ�����С�����е�Ԫ���ݽṹ���������еĻ���������һ���ֶΣ���
			   ��������е�Ԫ���ݽṹֻ�ܹ���һ�Σ���Ϊ������������еĽṹ����һ���ģ�������������Ժ�Ԫ���ݽṹ�Ͳ����ٱ仯��
			   ��������е�Ԫ���ݽṹ��first������ﹹ�졣first��һ���ڲ���Ա��first�������Ĵ���ֻ�ڴ����һ������ʱִ�С�
			   �����������һ�У����������������һ���ֶΡ�
			 */
			data.outputRowMeta = getInputRowMeta().clone();
			meta.getFields(data.outputRowMeta, getStepname(), null, null, this);
		}
		/**
		 * ����Ĵ��룬������д��������������ܽǶȿ��ǣ�������ʵ�־���Java���顣Ϊ�˿������㣬����ʹ��RowDataUtil���ṩ
		 * ��һЩ��̬�������������ݡ�ʹ��RowDatautil��̬�����������ݣ�������������ܡ�
		 */
		String value = "Hello, world!";
		
		Object[] outputRow = RowDataUtil.addValueData(row, getInputRowMeta().size(), value);
		
		putRow(data.outputRowMeta, outputRow);
		
		return true;
	}
}



