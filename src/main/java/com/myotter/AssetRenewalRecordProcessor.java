package com.myotter;

public class AssetRenewalRecordProcessor extends OtterEventProcessor {
	public AssetRenewalRecordProcessor() {
		super(new String[] { "user_id", "asset_repayment_id",
				"repayment_principal", "sum_fee", "repayment_interest",
				"plan_late_fee", "renewal_fee", "old_repayment_time",
				"renewal_day", "updated_at", "status", "money_amount",
				"repayment_time", "created_at", "order_id", "renewal_type",
				"renewal_kind", "order_time", "back_order_id", "return_money" });
	}
}