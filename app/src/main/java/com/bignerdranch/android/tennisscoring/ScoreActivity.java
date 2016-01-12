package com.bignerdranch.android.tennisscoring;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


/**
 * This activity keeps track of the basketball score for 2 teams.
 */
public class ScoreActivity extends AppCompatActivity {

    // Tracks the points for player 1
    int pointPlayer1 = 0;

    // Tracks the points for player 2
    int pointPlayer2 = 0;


    // tracks the games for both players
    int gamePlayer1 = 0;
    int gamePlayer2 = 0;

    // tracks games for set bothe players
    int gameSet1Player1=0;
    int gameSet2Player1=0;
    int gameSet1Player2=0;
    int gameSet2Player2=0;

    // Tracks set
    int setTracker = 1;
    // tracks set won by eachplayer
    int setPlayer1 = 0;
    int setPlayer2 = 0;
    //serve tracker- gonna be used for stat tracking
    boolean serverTracker = false;

    //stats keeper for both players
    Stats player1Stats = new Stats();
    Stats player2Stats = new Stats();

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("pointPlayer1", pointPlayer1);
        savedInstanceState.putInt("pointPlayer2", pointPlayer2);
        savedInstanceState.putInt("gamePlayer1", gamePlayer1);
        savedInstanceState.putInt("gamePlayer2", gamePlayer2);
        savedInstanceState.putInt("setTracker", setTracker);
        savedInstanceState.putInt("setPlayer1", setPlayer1);
        savedInstanceState.putInt("setPlayer2", setPlayer2);
        savedInstanceState.putInt("gameSet1Player1", gameSet1Player1);
        savedInstanceState.putInt("gameSet2Player1", gameSet2Player1);
        savedInstanceState.putInt("gameSet1Player2", gameSet1Player2);
        savedInstanceState.putInt("gameSet2Player2", gameSet2Player2);

        savedInstanceState.putSerializable("player1Stats", player1Stats);
        savedInstanceState.putSerializable("player2Stats", player2Stats);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            pointPlayer1 = savedInstanceState.getInt("pointPlayer1");
            pointPlayer2 = savedInstanceState.getInt("pointPlayer2");
            gamePlayer1 = savedInstanceState.getInt("gamePlayer1");
            gamePlayer2 = savedInstanceState.getInt("gamePlayer2");
            setTracker = savedInstanceState.getInt("setTracker");
            setPlayer1 = savedInstanceState.getInt("setPlayer1");
            setPlayer2 = savedInstanceState.getInt("setPlayer2");
            gameSet1Player1= savedInstanceState.getInt("gameSet1Player1");
            gameSet2Player1= savedInstanceState.getInt("gameSet2Player1");
            gameSet1Player2= savedInstanceState.getInt("gameSet1Player2");
            gameSet2Player2= savedInstanceState.getInt("gameSet2Player2");
            player1Stats = (Stats) savedInstanceState.getSerializable("player1Stats");
            player2Stats = (Stats) savedInstanceState.getSerializable("player2Stats");

        }
        setContentView(R.layout.activity_main);
        if(setTracker == 2){

            TextView gameView = (TextView) findViewById(R.id.player_1_game_1);
            gameView.setText(String.valueOf(gameSet1Player1));
            TextView gameView2 = (TextView) findViewById(R.id.player_2_game_1);
            gameView2.setText(String.valueOf(gameSet1Player2));

        }
        if(setTracker == 3){
            TextView gameView = (TextView) findViewById(R.id.player_1_game_1);
            gameView.setText(String.valueOf(gameSet1Player1));
            TextView gameView2 = (TextView) findViewById(R.id.player_2_game_1);
            gameView2.setText(String.valueOf(gameSet1Player2));

            TextView gameView3 = (TextView) findViewById(R.id.player_1_game_2);
            gameView3.setText(String.valueOf(gameSet2Player1));
            TextView gameView4 = (TextView) findViewById(R.id.player_2_game_2);
            gameView4.setText(String.valueOf(gameSet2Player2));

        }
  //      if(setPlayer1 != 2 || setPlayer2 != 2) {
            if (gamePlayer1 != 0 || gamePlayer2 != 0) {
                displayGameForPlayer2();
                displayGameForPlayer1();
            }
        displayPointForPlayer1();
        displayPointForPlayer2();
  //      }
        String jamesbond = "hi";
        String jamesBond = "hello";
        String s = jamesBond + jamesbond;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //  getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimpSlifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void pointPlayer1(View v) {

        if (setPlayer1 == 2 || setPlayer2 == 2) {
            displayEndOfGame(v);
            return;
        }
        if (gamePlayer1 == 6 && gamePlayer2 == 6 && pointPlayer1 < 7) { // tiebreak handling

            pointPlayer1 = pointPlayer1 + 1;
        } else if (gamePlayer1 == 6 && gamePlayer2 == 6 && pointPlayer1 >= 7 && pointPlayer2 >= pointPlayer1) {
            pointPlayer1 = pointPlayer1 + 1;

        } else if (gamePlayer1 == 6 && gamePlayer2 == 6 && pointPlayer1 >= 7 && pointPlayer1 == pointPlayer2 + 1) {
            gamePlayer1(v);
            resetPoint(v);
            if(setPlayer1 != 2 && setPlayer2 != 2) {
                setTracker++;
                resetGame(v);
                setPlayer1++;
            }
            return;
        } else if (gamePlayer1 == 7 | (gamePlayer1 == 6 && gamePlayer2 < 5)) {

            resetPoint(v);
            if(setPlayer1 != 2 && setPlayer2 != 2) {
                setTracker++;
                resetGame(v);
                setPlayer1++;
            }

        } /*else if (pointPlayer1 == 7 && pointPlayer2 < 6) {

            gamePlayer1(v);
            resetPoint(v);
            resetGame(v);
            setTracker++;

            return;
            */ else if (pointPlayer1 < 30) {
            pointPlayer1 = pointPlayer1 + 15;
        } else if (pointPlayer1 == 30) {
            pointPlayer1 = pointPlayer1 + 10;
        }
        // advantage handle
        else if (pointPlayer1 >= 40 && pointPlayer1 > pointPlayer2) {
            gamePlayer1(v);
            if (gamePlayer1 == 6 && gamePlayer2 < 5) {

                resetPoint(v);
                if(setPlayer1 != 2 && setPlayer2 != 2) {
                    setTracker++;
                    setPlayer1++;
                    resetGame(v);
                }
            } else
                resetPoint(v);


        }
        // deuce handling
        else if (pointPlayer1 >= 40 && pointPlayer1 <= pointPlayer2) {
            pointPlayer1 = pointPlayer1 + 1;
        }

        displayPointForPlayer1();
    }


    public void pointPlayer2(View v) {
        if (setPlayer1 == 2 || setPlayer2 == 2) {
            displayEndOfGame(v);
            return;
        }
        if (gamePlayer1 == 6 && gamePlayer2 == 6 && pointPlayer2 < 7) { // tiebreak handling

            pointPlayer2 = pointPlayer2 + 1;
        } else if (gamePlayer1 == 6 && gamePlayer2 == 6 && pointPlayer2 >= 7 && pointPlayer1 >= pointPlayer2) {
            pointPlayer2 = pointPlayer2 + 1;

        } else if (gamePlayer1 == 6 && gamePlayer2 == 6 && pointPlayer2 >= 7 && pointPlayer2 == pointPlayer1 + 1) {
            gamePlayer2(v);
            resetPoint(v);
            if(setPlayer1 != 2 && setPlayer2 != 2) {
                setTracker++;
                resetGame(v);
                setPlayer2++;
            }
            return;
        } else if (gamePlayer2 == 7 | (gamePlayer2 == 6 && gamePlayer1 < 5)) {

            resetPoint(v);
            if(setPlayer1 != 2 && setPlayer2 != 2) {
                setTracker++;
                resetGame(v);
                setPlayer2++;
            }


//        } else if (pointPlayer2 == 7 && pointPlayer1 < 6) {
//
//            gamePlayer1(v);
//
//            resetPoint(v);
//            resetGame(v);
//            setTracker++;
//
//            return;
//
        } else if (pointPlayer2 < 30) {
            pointPlayer2 = pointPlayer2 + 15;
        } else if (pointPlayer2 == 30) {
            pointPlayer2 = pointPlayer2 + 10;
        }
        //advantage handle
        else if (pointPlayer2 >= 40 && pointPlayer2 > pointPlayer1) {
            gamePlayer2(v);
            if (gamePlayer1 == 6 && gamePlayer2 == 6 && pointPlayer2 < 7) {   // need a cheat for 7
                resetPoint(v);
                if(setPlayer1 != 2 && setPlayer2 != 2) {
                    setTracker++;
                    setPlayer2++;
                    resetGame(v);
                }

            } else {
                resetPoint(v);
            }

        }
        // deuce handling
        else if (pointPlayer2 >= 40 && pointPlayer2 <= pointPlayer1) {
            pointPlayer2 = pointPlayer2 + 1;
        }
        displayPointForPlayer2();
    }

    /**
     * Increase the number of games won by player 1
     */
    public void gamePlayer1(View v) {
        gamePlayer1 = gamePlayer1 + 1;
        if(setTracker == 1){
            gameSet1Player1 = gamePlayer1;
        }
        else if(setTracker == 2){
            gameSet2Player1 = gamePlayer1;
        }


    }

    /**
     * Increase the number of games won by player 1
     */
    public void gamePlayer2(View v) {
        gamePlayer2 = gamePlayer2 + 1;
        if(setTracker == 1){
            gameSet1Player2 = gamePlayer2;
        }
        else if(setTracker == 2){
            gameSet2Player2 = gamePlayer2;
        }

    }


    /**
     * Increase the score for Team B by 1 point.
     */


    /**
     * resets the games for both players
     */

    public void resetGame(View v) {
        gamePlayer1 = 0;
        gamePlayer2 = 0;
        displayGameForPlayer1();
        displayGameForPlayer2();


    }

    /**
     * Resets the points for both teams back to 0.
     */
    public void resetPoint(View v) {

        pointPlayer1 = 0;
        pointPlayer2 = 0;
        displayPointForPlayer1();
        displayPointForPlayer2();
        displayGameForPlayer1();
        displayGameForPlayer2();
    }

    /**
     * Displays the point for player 1.
     */
    public void displayPointForPlayer1() {
        TextView pointView = (TextView) findViewById(R.id.player_1_point);
        TextView pointViewB = (TextView) findViewById(R.id.player_2_point);
        if (pointPlayer1 >= 40 && pointPlayer2 >= 40 && pointPlayer1 > pointPlayer2) {
            pointView.setText("AD");
            pointViewB.setText("");

        } else if (pointPlayer1 == pointPlayer2 && pointPlayer1 >= 40) {
            pointView.setText("40");
            pointViewB.setText("40");

        } else {

            pointView.setText(String.valueOf(pointPlayer1));
        }
    }

    /**
     * Displays the point for Player 2.
     */
    public void displayPointForPlayer2() {
        TextView pointView = (TextView) findViewById(R.id.player_2_point);
        TextView pointViewB = (TextView) findViewById(R.id.player_1_point);
        if (pointPlayer1 >= 40 && pointPlayer2 >= 40 && pointPlayer2 > pointPlayer1) {
            pointView.setText("AD");
            pointViewB.setText("");
        } else if (pointPlayer1 == pointPlayer2 && pointPlayer2 >= 40) {
            pointView.setText("40");
            pointViewB.setText("40");

        } else {
            pointView.setText(String.valueOf(pointPlayer2));
        }
    }

    /**
     * Displays the game for Player 1
     */
    public void displayGameForPlayer1() {
        if(setPlayer1 == 2 | setPlayer2 == 2){
            return;
        }
        if (setTracker == 1) {
            TextView gameView = (TextView) findViewById(R.id.player_1_game_1);
            gameView.setText(String.valueOf(gamePlayer1));
        } else if (setTracker == 2) {
            TextView gameView = (TextView) findViewById(R.id.player_1_game_2);
            gameView.setText(String.valueOf(gamePlayer1));

        } else if (setTracker == 3) {
            TextView gameView = (TextView) findViewById(R.id.player_1_game_3);
            gameView.setText(String.valueOf(gamePlayer1));

        }
    }

    /**
     * Displays the game for Player 2
     */
    public void displayGameForPlayer2() {
        if(setPlayer1 == 2 | setPlayer2 == 2){
            return;
        }

        if (setTracker == 1) {
            TextView gameView = (TextView) findViewById(R.id.player_2_game_1);
            gameView.setText(String.valueOf(gamePlayer2));
        } else if (setTracker == 2) {
            TextView gameView = (TextView) findViewById(R.id.player_2_game_2);
            gameView.setText(String.valueOf(gamePlayer2));

        } else if (setTracker == 3) {
            TextView gameView = (TextView) findViewById(R.id.player_2_game_3);
            gameView.setText(String.valueOf(gamePlayer2));

        }

    }

    /**
     * starts a new  match - doesnt work yet
     */

    public void resetMatch(View v) {
        setTracker = 1;
        setPlayer1 = 0;
        setPlayer2 = 0;
        player1Stats = new Stats();
        player2Stats = new Stats();

        TextView gameView1 = (TextView) findViewById(R.id.player_2_game_3);
        gameView1.setText("");
        TextView endMatch = (TextView) findViewById(R.id.toast);
        endMatch.setText("");

        TextView gameView2 = (TextView) findViewById(R.id.player_2_game_2);
        gameView2.setText(String.valueOf(""));

        TextView gameView3 = (TextView) findViewById(R.id.player_2_game_1);
        gameView3.setText(String.valueOf(""));

        TextView gameView4 = (TextView) findViewById(R.id.player_1_game_1);
        gameView4.setText("");

        TextView gameView5 = (TextView) findViewById(R.id.player_1_game_2);
        gameView5.setText(String.valueOf(""));

        TextView gameView6 = (TextView) findViewById(R.id.player_1_game_3);
        gameView6.setText(String.valueOf(""));


        resetGame(v);
        resetPoint(v);

    }

    public void displayEndOfGame(View v) {
        TextView gameView = (TextView) findViewById(R.id.toast);
        if (setPlayer1 > setPlayer2) {
            gameView.setText("Player 1 beat Player 2: "+ setPlayer1+"-" + setPlayer2);
        } else {

            gameView.setText("Player 2 beat Player 1: "+ setPlayer2+ "-" + setPlayer1);
            gameView.setText("Player 2 beat Player 1: "+ setPlayer2+ "-" + setPlayer1);
        }


    }

    /* stats tracking starts here*/

    public void winnerPlayer1(View v) {
        player1Stats.setWinner(player1Stats.getWinner() + 1);
        pointPlayer1(v);
    }

    public void acePlayer1(View v) {
        player1Stats.setAce(player1Stats.getAce() + 1);
        pointPlayer1(v);
    }

    public void forcedErrorPlayer1(View v) {
        player1Stats.setForcedError(player1Stats.getForcedError() + 1);
        pointPlayer2(v);
    }

    public void unforcedErrorPlayer1(View v) {
        player1Stats.setUnforcedError(player1Stats.getUnforcedError() + 1);
        pointPlayer2(v);
    }

    public void faultPlayer1(View v) {
        player1Stats.setFault(player1Stats.getFault() + 1);

    }

    public void dFaultPlayer1(View v) {
        player1Stats.setDoubleFault(player1Stats.getDoubleFault() + 1);
        pointPlayer2(v);
    }

    public void winnerPlayer2(View v) {
        player2Stats.setWinner(player2Stats.getWinner() + 1);
        pointPlayer2(v);
    }

    public void acePlayer2(View v) {
        player2Stats.setAce(player2Stats.getAce() + 1);
        pointPlayer2(v);
    }

    public void forcedErrorPlayer2(View v) {
        player2Stats.setForcedError(player2Stats.getForcedError() + 1);
        pointPlayer1(v);
    }

    public void unforcedErrorPlayer2(View v) {
        player2Stats.setUnforcedError(player2Stats.getUnforcedError() + 1);
        pointPlayer1(v);
    }

    public void faultPlayer2(View v) {
        player2Stats.setFault(player2Stats.getFault() + 1);

    }

    public void dFaultPlayer2(View v) {
        player2Stats.setDoubleFault(player2Stats.getDoubleFault() + 1);
        pointPlayer1(v);
    }

    public void matchStats(View v) {

        Intent intent = new Intent(this, StatsActivity.class);
        intent.putExtra("player1Stats", player1Stats);
        intent.putExtra("player2Stats", player2Stats);
        startActivity(intent);
    }

}