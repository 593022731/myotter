# myotter


```java

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
 * 通用otter同步类,必须存在马甲字段，否则同步失败
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

	private EventColumn key;// 源表主键ID

	private Map<String, EventColumn> map = new HashMap<String, EventColumn>();// 所有列

	private String typeName = "project_name";// 马甲名，默认project_name

	private Set<String> replaceColumnList;// 自定义同步字段

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
		if (replaceColumnList == null || replaceColumnList.isEmpty()) {// 没有自定义同步字段，默认同步所有字段
			replaceColumnList = map.keySet();
		}
		List<EventColumn> cols = new ArrayList<EventColumn>();
		for (String columnName : replaceColumnList) {
			EventColumn column = map.get(columnName);
			if (typeName.equals(column.getColumnName())) {// 排除马甲字段，因为变成联合主键已经会替换此字段
				continue;
			}
			if (column != null) {
				cols.add(column);
			}
		}
		eventData.setColumns(cols);
	}
}
```

demo

```java
package com.myotter;

public class AssetBorrowOrderProcessor extends OtterEventProcessor {
	public AssetBorrowOrderProcessor() {
		super(new String[] { "user_id", "out_trade_no", "order_type",
				"money_amount", "apr", "loan_interests", "into_money",
				"loan_method", "loan_term", "operator_name", "created_at",
				"updated_at", "order_time", "loan_time", "loan_end_time",
				"late_fee_apr", "receive_card_id", "debit_card_id",
				"verify_trial_time", "verify_trial_remark",
				"verify_trial_user", "verify_review_time",
				"verify_review_remark", "verify_review_user",
				"verify_loan_time", "verify_loan_remark", "verify_loan_user",
				"capital_type", "reason_remark", "credit_lv",
				"is_hit_risk_rule", "auto_risk_check_status", "customer_type",
				"yurref", "serial_no", "id_number", "user_phone", "realname",
				"card_no", "bank_number", "bank_iscmb", "status", "pay_remark",
				"pay_status", "client_type", "auto_version", "auto_result",
				"auto_explain", "auto_flag", "auto_loan_flag",
				"review_back_user_id", "review_back_user_name",
				"review_status", "distribute_time" });
	}
}
```

```java
package com.myotter;

public class RiskBlackUserProcessor extends OtterEventProcessor {
}
```
