package com.myotter;

public class AssetRepaymentProcessor extends OtterEventProcessor {
	public AssetRepaymentProcessor() {
		super(new String[] { "user_id", "asset_order_id", "repayment_amount",
				"repaymented_amount", "repayment_principal",
				"repayment_interest", "plan_late_fee", "true_late_fee",
				"late_fee_apr", "credit_repayment_time", "period",
				"repayment_time", "repayment_real_time", "late_fee_start_time",
				"interest_update_time", "late_day", "created_at", "updated_at",
				"auto_debit_fail_times", "renewal_count", "status",
				"collection", "repayment_no", "grant_time",
				"first_repayment_time" });

	}
}