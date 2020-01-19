package com.myotter;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.otter.node.extend.processor.AbstractEventProcessor;
import com.alibaba.otter.shared.etl.model.EventColumn;
import com.alibaba.otter.shared.etl.model.EventData;
import com.alibaba.otter.shared.etl.model.EventType;

/**
 * ͨ��otterͬ����,�����������ֶΣ�����ͬ��ʧ��
 * 
 * @author weihui
 *
 */
public class OtterEventProcessor extends AbstractEventProcessor {

	public OtterEventProcessor() {

	}

	public OtterEventProcessor(String[] replaceColumnArr) {
		if (replaceColumnArr != null) {
			Set<String> set = new HashSet<String>();
			for (String columnName : replaceColumnArr) {
				set.add(columnName);
			}
			this.replaceColumnList = set;
		}
	}

	private EventColumn key;// Դ������ID

	private Map<String, EventColumn> map = new HashMap<String, EventColumn>();// ������

	private String typeName = "project_name";// �������Ĭ��project_name

	private Set<String> replaceColumnList;// �Զ���ͬ���ֶ�

	private void init(EventData eventData) {
		key = eventData.getKeys().get(0);

		for (EventColumn column : eventData.getColumns()) {
			map.put(column.getColumnName(), column);
		}
	}

	@Override
	public boolean process(EventData eventData) {
		System.out.println("db=" + eventData.getSchemaName() + ",table="
				+ eventData.getTableName() + ",event="
				+ eventData.getEventType());
		if (eventData.getEventType() == EventType.INSERT
				|| eventData.getEventType() == EventType.UPDATE
				|| eventData.getEventType() == EventType.DELETE) {

			init(eventData);

			replaceKey(eventData);

			replaceCols(eventData);
			return true;
		} else {
			return false;
		}
	}

	private void replaceKey(EventData eventData) {
		EventColumn projectNameColumn = new EventColumn();
		String typeValue = map.get(typeName).getColumnValue();
		System.out.println(key.getColumnName() + "=" + key.getColumnValue()
				+ "," + typeName + "=" + typeValue);
		projectNameColumn.setColumnValue(typeValue);
		projectNameColumn.setColumnType(Types.VARCHAR);
		projectNameColumn.setColumnName(typeName);
		projectNameColumn.setKey(true);

		List<EventColumn> keys = new ArrayList<EventColumn>();
		keys.add(key);
		keys.add(projectNameColumn);
		eventData.setKeys(keys);
		eventData.setOldKeys(keys);
	}

	private void replaceCols(EventData eventData) {
		if (replaceColumnList == null || replaceColumnList.isEmpty()) {// û���Զ���ͬ���ֶΣ�Ĭ��ͬ�������ֶ�
			replaceColumnList = map.keySet();
		}
		List<EventColumn> cols = new ArrayList<EventColumn>();
		for (String columnName : replaceColumnList) {
			EventColumn column = map.get(columnName);
			if (typeName.equals(column.getColumnName())) {// �ų�����ֶΣ���Ϊ������������Ѿ����滻���ֶ�
				continue;
			}
			if (column != null) {
				cols.add(column);
			}
		}
		eventData.setColumns(cols);
	}
}