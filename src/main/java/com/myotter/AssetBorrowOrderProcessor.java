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