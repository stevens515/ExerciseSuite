package org.kettlesolutions.plugin.step.helloworld;

import java.util.List;
import java.util.Map;

import org.pentaho.di.core.CheckResult;
import org.pentaho.di.core.CheckResultInterface;
import org.pentaho.di.core.Const;
import org.pentaho.di.core.Counter;
import org.pentaho.di.core.annotations.Step;
import org.pentaho.di.core.database.DatabaseMeta;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.core.exception.KettleStepException;
import org.pentaho.di.core.exception.KettleXMLException;
import org.pentaho.di.core.row.RowMetaInterface;
import org.pentaho.di.core.row.ValueMeta;
import org.pentaho.di.core.row.ValueMetaInterface;
import org.pentaho.di.core.variables.VariableSpace;
import org.pentaho.di.core.xml.XMLHandler;
import org.pentaho.di.i18n.BaseMessages;
import org.pentaho.di.repository.ObjectId;
import org.pentaho.di.repository.Repository;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;
import org.pentaho.di.trans.step.BaseStepMeta;
import org.pentaho.di.trans.step.StepDataInterface;
import org.pentaho.di.trans.step.StepInterface;
import org.pentaho.di.trans.step.StepMeta;
import org.pentaho.di.trans.step.StepMetaInterface;
import org.w3c.dom.Node;

@Step(
		id="Helloworld",
		name="name",
		description="description",
		categoryDescription="categoryDescription", 
		image="org/kettlesolutions/plugin/step/helloworld/HelloWorld.png",
		i18nPackageName="org.kettlesolutions.plugin.step.helloworld"
) 
public class HelloworldStepMeta extends BaseStepMeta implements StepMetaInterface {
	/**
	 * PKG����˵����messages����λ�ã���messages�����и��ֹ��ʻ�����Դ�ļ���
	 * �ڱ��º��澭��Ҫ������BaseMessages.getString()���������Ǹ�������Ĺ��ʻ�
	 * ���ã��Ӳ�ͬ���ļ��л�ȡ���֡�PKG����ͨ��λ��������Ϸ��������ʻ�ͼ�ι���ʹ�ã�
	 * ͨ�����ʻ�ͼ�ι��ߣ����ʻ���Ա���Ա༭��ͬ�Ĺ��ʻ���Դ�ļ����������ǻ��ںܶ�Kettle
	 * �����￴�������Ľṹ��
	 */
	private static Class<?> PKG = HelloworldStep.class; //for i18n
	public enum Tag {//field_name���ڱ����û�������ֶ��������桰Hello��world��"�ַ������ֶ�����
		field_name,
	};
	
	private String fieldName;
	
	/**
	 * @return the fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * @param fieldName the fieldName to set
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/**
	 * checks parameters, adds result to List<CheckResultInterface>
	 * used in Action > Verify transformation
	 * ��֤�û��Ƿ��ڶԻ������������ֶ�����������֤�����ӵ�����ת��ʱ���ֵ������б�������
	 * Ҫ�����û����������ѡ�����ֻ�����׳����ѡ�
	 */
	public void check(List<CheckResultInterface> remarks, TransMeta transMeta, StepMeta stepMeta, 
			RowMetaInterface prev, String input[], String output[], RowMetaInterface info) {
		
		if (Const.isEmpty(fieldName)) {
			CheckResultInterface error = new CheckResult(
				CheckResult.TYPE_RESULT_ERROR, 
				BaseMessages.getString(PKG, "HelloworldMeta.CHECK_ERR_NO_FIELD"), 
				stepMeta
			);
			remarks.add(error);
		} else {
			CheckResultInterface ok = new CheckResult(
				CheckResult.TYPE_RESULT_OK, 
				BaseMessages.getString(PKG, "HelloworldMeta.CHECK_OK_FIELD"), 
				stepMeta
			);
			remarks.add(ok);//����֤�����ӵ�����ת��ʱ���ֵ������б��
		}
	}

	/**
	 *	creates a new instance of the step (factory)
	 * getStep��getStepData��getDialogClassName()�����ṩ����������������������ӿ�֮�������
	 ����ӿ��ﻹ�����˼���������˵�����ĸ��ӿ���ν�ϵ�һ��
	String getDialogClassName():��������ʵ����StepDialogInterace�ӿڵĶԻ���������֡���������������
				��null������������ʵ����StepMetaInterface�ӿڵ���������Ͱ������Զ����ɶԻ���������֡�
	StepInterface getStep():����һ��ʵ����StepInterface�ӿڵ��ࡣ
	StepInterface getStepData():����һ��ʵ����StepDataInterface�ӿڵ��ࡣ

	 */
	public StepInterface getStep(StepMeta stepMeta, StepDataInterface stepDataInterface,
			int copyNr, TransMeta transMeta, Trans trans) {
		return new HelloworldStep(stepMeta, stepDataInterface, copyNr, transMeta, trans);
	}

	/**
	 * creates new instance of the step data (factory)
	 * getStep��getStepData��getDialogClassName()�����ṩ����������������������ӿ�֮�������
	 */
	public StepDataInterface getStepData() {
		return new HelloworldStepData();
	}
	/**
	 * getStep��getStepData��getDialogClassName()�����ṩ����������������������ӿ�֮�������
	 */
	@Override
	public String getDialogClassName() {
		return HelloworldStepDialog.class.getName();
	}

	/**
	 * deserialize from xml 
	 * databases = list of available connections
	 * counters = list of sequence steps
	 * 
	 * ������ĸ�����loadXML()��getXML()��readRep()��saveRep()��Ԫ���ݱ��浽XML�ļ�����Դ���
	 * ���ߴ�XML�ļ�����Դ���ȡԪ���ݡ����浽�ļ��ķ�����������XStream��http://xstream.codehaus.org����
	 * ����XML���л�������
	 */
	public void loadXML(Node stepDomNode, List<DatabaseMeta> databases,
			Map<String, Counter> sequenceCounters) throws KettleXMLException {
		fieldName = XMLHandler.getTagValue(stepDomNode, Tag.field_name.name());
	}
	
	/**
	 * @Override
	 */
	public String getXML() throws KettleException {
		StringBuilder xml = new StringBuilder();
		xml.append(XMLHandler.addTagValue(Tag.field_name.name(), fieldName));
		return xml.toString();
	}
	
	/**
	 * De-serialize from repository (see loadXML)
	 */
	public void readRep(Repository repository, ObjectId stepIdInRepository,
			List<DatabaseMeta> databases, Map<String, Counter> sequenceCounters)
			throws KettleException {
		fieldName = repository.getStepAttributeString(stepIdInRepository, Tag.field_name.name());
	}

	/**
	 * serialize to repository
	 */
	public void saveRep(Repository repository, ObjectId idOfTransformation, ObjectId idOfStep)
			throws KettleException {
		repository.saveStepAttribute(idOfTransformation, idOfStep, Tag.field_name.name(), fieldName);
	}
	
	
	/**
	 * initiailize parameters to default
	 */
	public void setDefault() {
		fieldName = "helloField";
	}

	/**
	 * getFields()�����ǳ���Ҫ����Ϊ����������������еĽṹ�����������Ҫ�޸�inputRowMeta����ʹ��������
	 * �����ʽƥ�䡣Spoon�ͺ���Ĳ��趼��Ҫ֪���������Ҫ�����Щ�ֶΡ������һ�ַ��������Ը������RowMetaInterface����
	 * ���һ��ValueMetaInterface������ValueMetaInterface���������õ���ϢԽ��ϸԽ�ã��������õ���Ϣ�����������͡����ȡ�
	 * ���ȡ���ʽ���룬�ȵȡ���ӵ��ֶ�����Ԫ��ϢԽ�࣬�������ɵ�SQL��Խ׼ȷ��
	 */
	@Override
	public void getFields(RowMetaInterface inputRowMeta, String name,
			RowMetaInterface[] info, StepMeta nextStep, VariableSpace space)
			throws KettleStepException {
		String realFieldName = space.environmentSubstitute(fieldName);
		//ֵ��Ԫ����ʹ��ValueMetaInterface�ӿ��������������һ���ֶΡ�����ӿ��ﶨ�����ֶε����֡��������͡����ȡ����ȣ��ȵȡ�������������ڴ���һ��ValueMetaInterface����
		ValueMetaInterface field = new ValueMeta(realFieldName, ValueMetaInterface.TYPE_STRING);
		field.setOrigin(name);		
		inputRowMeta.addValueMeta(field);
	}
}

