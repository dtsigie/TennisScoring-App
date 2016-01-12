package com.bignerdranch.android.tennisscoring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class StatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_stat);
        Intent intent = getIntent();
        Stats player1Stats = (Stats) intent.getSerializableExtra("player1Stats");
        Stats player2Stats = (Stats) intent.getSerializableExtra("player2Stats");
        TextView winner1 = (TextView) findViewById(R.id.winner1);
        winner1.setText(String.valueOf(player1Stats.getWinner()));

        TextView winner2 = (TextView) findViewById(R.id.winner2);
        winner2.setText(String.valueOf(player2Stats.getWinner()));

        TextView ace1 = (TextView) findViewById(R.id.ac1);
        ace1.setText(String.valueOf(player1Stats.getAce()));

        TextView ace2 = (TextView) findViewById(R.id.ace2);
        ace2.setText(String.valueOf(player2Stats.getAce()));

        TextView unforcedEr1 = (TextView) findViewById(R.id.unforcedError1);
        unforcedEr1.setText(String.valueOf(player1Stats.getUnforcedError()));

        TextView unforcedEr2 = (TextView) findViewById(R.id.unforcedError2);
        unforcedEr2.setText(String.valueOf(player2Stats.getUnforcedError()));

        TextView forcedEr1 = (TextView) findViewById(R.id.forcedError1);
        forcedEr1.setText(String.valueOf(player1Stats.getForcedError()));

        TextView forcedEr2 = (TextView) findViewById(R.id.forcedError2);
        forcedEr2.setText(String.valueOf(player2Stats.getForcedError()));

        TextView doubleFault = (TextView) findViewById(R.id.doubleFault1);
        doubleFault.setText(String.valueOf(player1Stats.getForcedError()));

        TextView doubleFault2 = (TextView) findViewById(R.id.doubleFault2);
        doubleFault2.setText(String.valueOf(player2Stats.getForcedError()));

        TextView fault1 = (TextView) findViewById(R.id.fault1);
        fault1.setText(String.valueOf(player1Stats.getFault()));

        TextView fault2 = (TextView) findViewById(R.id.fault2);
        fault2.setText(String.valueOf(player2Stats.getFault()));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    //    getMenuInflater().inflate(R.menu.menu_stats, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
