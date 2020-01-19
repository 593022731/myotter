package com.myotter;

public class MmanUserLoanProcessor extends OtterEventProcessor {
	public MmanUserLoanProcessor() {
		super(new String[] { "user_id", "loan_py_id", "loan_money",
				"loan_rate", "loan_penalty", "loan_penalty_rate",
				"loan_start_time", "loan_end_time", "loan_status",
				"create_time", "update_time", "del_flag" });
	}
}