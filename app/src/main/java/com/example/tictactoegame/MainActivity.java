package com.example.tictactoegame;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

        import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Initilizing buttons
        Button sq1 = (Button)findViewById(R.id.square1);
        Button sq2 = (Button)findViewById(R.id.square2);
        Button sq3 = (Button)findViewById(R.id.square3);
        Button sq4 = (Button)findViewById(R.id.square4);
        Button sq5 = (Button)findViewById(R.id.square5);
        Button sq6 = (Button)findViewById(R.id.square6);
        Button sq7 = (Button)findViewById(R.id.square7);
        Button sq8 = (Button)findViewById(R.id.square8);
        Button sq9 = (Button)findViewById(R.id.square9);
        Button newGame = (Button)findViewById(R.id.newgame_id);



        //Setting Player status as . Player 1 goes first automatically
        TextView playerStatus = (TextView) findViewById(R.id.infoLabel);
        playerStatus.setText("Player 1's Turn");


        //Square 1 setting X or O onClick depending on player
        sq1.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view){

                if(playerStatus.getText() =="Player 1's Turn") {
                    sq1.setText("X");
                    playerStatus.setText("Player 2's Turn");
                }
               else if (playerStatus.getText() =="Player 2's Turn"){
                    sq1.setText("O");
                    playerStatus.setText("Player 1's Turn");
                }

            }

        });
        //Square 2 setting X or O onClick depending on player
        sq2.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view){

                if(playerStatus.getText() =="Player 1's Turn") {
                    sq2.setText("X");
                    playerStatus.setText("Player 2's Turn");
                }
                else if (playerStatus.getText() =="Player 2's Turn"){
                    sq2.setText("O");
                    playerStatus.setText("Player 1's Turn");
                }

            }

        });
        //Square 3 setting X or O onClick depending on player
        sq3.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view){

                if(playerStatus.getText() =="Player 1's Turn") {
                    sq3.setText("X");
                    playerStatus.setText("Player 2's Turn");
                }
                else if (playerStatus.getText() =="Player 2's Turn"){
                    sq3.setText("O");
                    playerStatus.setText("Player 1's Turn");
                }

            }

        });
        //Square 4 setting X or O onClick depending on player
        sq4.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view){

                if(playerStatus.getText() =="Player 1's Turn") {
                    sq4.setText("X");
                    playerStatus.setText("Player 2's Turn");
                }
                else if (playerStatus.getText() =="Player 2's Turn"){
                    sq4.setText("O");
                    playerStatus.setText("Player 1's Turn");
                }

            }

        });
        //Square 5 setting X or O onClick depending on player
        sq5.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view){

                if(playerStatus.getText() =="Player 1's Turn") {
                    sq5.setText("X");
                    playerStatus.setText("Player 2's Turn");
                }
                else if (playerStatus.getText() =="Player 2's Turn"){
                    sq5.setText("O");
                    playerStatus.setText("Player 1's Turn");
                }

            }

        });
        //Square 6 setting X or O onClick depending on player
        sq6.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view){

                if(playerStatus.getText() =="Player 1's Turn") {
                    sq6.setText("X");
                    playerStatus.setText("Player 2's Turn");
                }
                else if (playerStatus.getText() =="Player 2's Turn"){
                    sq6.setText("O");
                    playerStatus.setText("Player 1's Turn");
                }

            }

        });
        //Square 7 setting X or O onClick depending on player
        sq7.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view){

                if(playerStatus.getText() =="Player 1's Turn") {
                    sq7.setText("X");
                    playerStatus.setText("Player 2's Turn");
                }
                else if (playerStatus.getText() =="Player 2's Turn"){
                    sq7.setText("O");
                    playerStatus.setText("Player 1's Turn");
                }

            }

        });
        //Square 8 setting X or O onClick depending on player
        sq8.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view){

                if(playerStatus.getText() =="Player 1's Turn") {
                    sq8.setText("X");
                    playerStatus.setText("Player 2's Turn");
                }
                else if (playerStatus.getText() =="Player 2's Turn"){
                    sq8.setText("O");
                    playerStatus.setText("Player 1's Turn");
                }

            }

        });
        //Square 9 setting X or O onClick depending on player
        sq9.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view){

                if(playerStatus.getText() =="Player 1's Turn") {
                    sq9.setText("X");
                    playerStatus.setText("Player 2's Turn");
                }
                else if (playerStatus.getText() =="Player 2's Turn"){
                    sq9.setText("O");
                    playerStatus.setText("Player 1's Turn");
                }

            }

        });

        //Resetting the game
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view){

                sq1.setText("");
                sq2.setText("");
                sq3.setText("");
                sq4.setText("");
                sq5.setText("");
                sq6.setText("");
                sq7.setText("");
                sq8.setText("");
                sq9.setText("");

                playerStatus.setText("Player 1's Turn");

            }

        });
    }



}