package com.gedo.sendrecive;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Reciever extends Activity {
	TextView na, sa;
	int salaryOfEmployee, netSalary;
	Button backNetSalary;

	public void backMethod(View view) {

		// calculate Net Salary
		if (salaryOfEmployee <= 2000) {
			netSalary = salaryOfEmployee;
		} else if (salaryOfEmployee > 2000 || salaryOfEmployee <= 4000) {

			netSalary = salaryOfEmployee - (salaryOfEmployee * 10 / 100);

		} else if (salaryOfEmployee > 4000) {

			netSalary = salaryOfEmployee - (salaryOfEmployee * 20 / 100);

		}
		Intent i = new Intent();
		i.putExtra("valueOfSalary", netSalary);
		setResult(RESULT_OK, i);
		// Close This Activity to go back to the caller activity
		finish();

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reciever);
		na = (TextView) findViewById(R.id.nameEmp);
		sa = (TextView) findViewById(R.id.salemp);
		backNetSalary = (Button) findViewById(R.id.btnBack);

		Intent reciev = this.getIntent();

		// Receiving data from first Activity and show it in TextView

		na.setText(reciev.getStringExtra("name"));
		sa.setText(reciev.getStringExtra("salary"));
		salaryOfEmployee = Integer.parseInt(reciev.getStringExtra("salary"));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reciever, menu);
		return true;
	}

}
