package com.myotter;

public class UserInfoProcessor extends OtterEventProcessor {
	public UserInfoProcessor() {
		super(new String[] { "user_name", "password", "pay_password",
				"realname", "realname_status", "realname_time", "real_count",
				"last_full_time", "id_number", "user_sex", "user_age", "qq",
				"user_phone", "taobao_account", "email", "wechat_account",
				"education", "marital_status", "present_address",
				"present_address_distinct", "present_latitude",
				"present_longitude", "present_period", "company_name",
				"company_address", "company_address_distinct",
				"company_longitude", "company_latitude", "company_phone",
				"company_period", "first_contact_name", "first_contact_phone",
				"frist_contact_relation", "second_contact_name",
				"second_contact_phone", "second_contact_relation",
				"create_time", "create_ip", "update_time", "status",
				"invite_userid", "is_save", "head_portrait", "idcard_img_z",
				"idcard_img_f", "customer_type", "amount_min", "amount_max",
				"amount_available", "amount_addsum", "js_amount_time",
				"equipment_number", "csjy", "user_from", "new_flag",
				"province", "tg", "tg_flag", "td_status", "td_verify_time",
				"td_verify_next_time", "td_task_id", "client_type",
				"brower_type", "user_race", "race", "work_industry" });
	}
}