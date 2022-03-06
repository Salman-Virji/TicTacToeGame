package com.example.tictactoegame;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.core.content.ContextCompat;

        import android.graphics.Color;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    // Declaring buttons and information about particular player turn.
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    TextView info;
    Button newgame;

    // Declaration of two players
    int player_0 = 0;
    int player_x = 1;

    // Setting Player status as active. Player 1 goes first automatically
    int active_player = player_0;  // Initially it is player_0

    // Storing of temporary values in the array for future checking of changes
    int[] posfill = {-1, -1, -1, -1 ,-1, -1, -1, -1, -1};

    boolean isgameactive = true;  // Checking either game is active or not and initially it will be active

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        info = findViewById(R.id.infoLabel);
        info.setText("Player 1's Turn");

        // Initilizing buttons
        btn1 = findViewById(R.id.square1);
        btn2 = findViewById(R.id.square2);
        btn3 = findViewById(R.id.square3);
        btn4 = findViewById(R.id.square4);
        btn5 = findViewById(R.id.square5);
        btn6 = findViewById(R.id.square6);
        btn7 = findViewById(R.id.square7);
        btn8 = findViewById(R.id.square8);
        btn9 = findViewById(R.id.square9);
        newgame = findViewById(R.id.newgame_id);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

        //Resetting the game
        newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newgame();
            }
        });

    }

    // Implementation of "Resetting the game" functionality
    private void newgame() {
        active_player = player_0;
        info.setText("Player 0's turn");
        posfill = new int[]{-1, -1, -1, -1 ,-1, -1, -1, -1, -1};
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        btn1.setBackgroundColor(android.R.drawable.btn_default);
       // btn1.setBackgroundResource(android.R.drawable.btn_default);
        btn2.setBackgroundColor(android.R.drawable.btn_default);
        btn3.setBackgroundColor(android.R.drawable.btn_default);
        btn4.setBackgroundColor(android.R.drawable.btn_default);
        btn5.setBackgroundColor(android.R.drawable.btn_default);
        btn6.setBackgroundColor(android.R.drawable.btn_default);
        btn7.setBackgroundColor(android.R.drawable.btn_default);
        btn8.setBackgroundColor(android.R.drawable.btn_default);
        btn9.setBackgroundColor(android.R.drawable.btn_default);

        isgameactive = true;
    }

    @Override
    public void onClick(View v) {

        if(!isgameactive)
            return;

        // Detecting the current clicked button by using the id from the view object
        Button clickedBtn = findViewById(v.getId());

        int clickedTag = Integer.parseInt(v.getTag().toString());

        if(posfill[clickedTag] != -1)
        {
            return;
        }

        posfill[clickedTag] = active_player;
        // Checking which player's turn and switching to the next player after clicking on square button
        if(active_player == player_0)
        {
            clickedBtn.setText("0");
            active_player = player_x;
            info.setText("Player X's turn");
        }
        else
        {
            clickedBtn.setText("X");
            active_player = player_0;
            info.setText("Player 0's turn");
        }
        // Detecting the Winner
        findWinnigPlayer();
    }

    // Implementation of Winning Player functionality
    private void findWinnigPlayer() {
        // Storing the winning position in two dimensional array
        int[][] winningPos = {{0,1,2}, {3,4,5},{6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};

        // Iterating through the array to check the Winning position
        for(int i=0;i<8;i++)
        {
            int val0 = winningPos[i][0];
            int val1 = winningPos[i][1];
            int val2 = winningPos[i][2];

            if(posfill[val0] == posfill[val1] && posfill[val1] == posfill[val2])
            {
                if(posfill[val0] != -1)
                {

                // Now Winner is declared
                    isgameactive = false;
                    // Checking the Winner

                    winnerColor();
                    if(posfill[val0] == player_0)
                    {

                        info.setText("0's Player is Winner!");
                    }
                    else
                    {
                        info.setText("X's Player is Winner!");
                    }



                }
            }
            //Game is a draw
            else if (btn1.getText() !="" && btn2.getText() !="" &&btn3.getText() !="" &&btn4.getText() !=""
                    &&btn5.getText() !=""&&btn6.getText() !=""&&btn7.getText() !=""&&btn8.getText() !=""&&btn9.getText() !="")
            {
                info.setText("Game is a draw!");
            }
        }
    }

    public void winnerColor(){
        // Rows
        //Change color for winning blocks first row all X
        if(btn1.getText() == "X" && btn2.getText() == "X" && btn3.getText() == "X")
        {
            btn1.setBackgroundColor(Color.parseColor("#228B22"));
            btn2.setBackgroundColor(Color.parseColor("#228B22"));
            btn3.setBackgroundColor(Color.parseColor("#228B22"));
        }
        //Change color for winning blocks 2nd row all X
        else if(btn4.getText() == "X" && btn5.getText() == "X" && btn6.getText() == "X")
        {
            btn4.setBackgroundColor(Color.parseColor("#228B22"));
            btn5.setBackgroundColor(Color.parseColor("#228B22"));
            btn6.setBackgroundColor(Color.parseColor("#228B22"));
        }
        //Change color for winning blocks 3rd row all X
        else if(btn7.getText() == "X" && btn8.getText() == "X" && btn9.getText() == "X")
        {
            btn7.setBackgroundColor(Color.parseColor("#228B22"));
            btn8.setBackgroundColor(Color.parseColor("#228B22"));
            btn9.setBackgroundColor(Color.parseColor("#228B22"));
        }

        //Change color for winning blocks first row all O
        else if(btn1.getText() == "0" && btn2.getText() == "0" && btn3.getText() == "0")
        {
            btn1.setBackgroundColor(Color.parseColor("#228B22"));
            btn2.setBackgroundColor(Color.parseColor("#228B22"));
            btn3.setBackgroundColor(Color.parseColor("#228B22"));
        }
        //Change color for winning blocks 2nd row all O
        else if(btn4.getText() == "0" && btn5.getText() == "0" && btn6.getText() == "0")
        {
            btn4.setBackgroundColor(Color.parseColor("#228B22"));
            btn5.setBackgroundColor(Color.parseColor("#228B22"));
            btn6.setBackgroundColor(Color.parseColor("#228B22"));
        }
        //Change color for winning blocks 3rd row all O
        else if(btn7.getText() == "0" && btn8.getText() == "0" && btn9.getText() == "0")
        {
            btn7.setBackgroundColor(Color.parseColor("#228B22"));
            btn8.setBackgroundColor(Color.parseColor("#228B22"));
            btn9.setBackgroundColor(Color.parseColor("#228B22"));
        }

        //Columns
        //Change color for winning blocks first column all X
        else if(btn1.getText() == "X" && btn4.getText() == "X" && btn7.getText() == "X")
        {
            btn1.setBackgroundColor(Color.parseColor("#228B22"));
            btn4.setBackgroundColor(Color.parseColor("#228B22"));
            btn7.setBackgroundColor(Color.parseColor("#228B22"));
        }
        //Change color for winning blocks 2nd column all X
        else if(btn2.getText() == "X" && btn5.getText() == "X" && btn8.getText() == "X")
        {
            btn2.setBackgroundColor(Color.parseColor("#228B22"));
            btn5.setBackgroundColor(Color.parseColor("#228B22"));
            btn8.setBackgroundColor(Color.parseColor("#228B22"));
        }
        //Change color for winning blocks 3nd column all X
        else if(btn3.getText() == "X" && btn6.getText() == "X" && btn9.getText() == "X")
        {
            btn3.setBackgroundColor(Color.parseColor("#228B22"));
            btn6.setBackgroundColor(Color.parseColor("#228B22"));
            btn9.setBackgroundColor(Color.parseColor("#228B22"));
        }
        //Change color for winning blocks first column all 0
        else if(btn1.getText() == "0" && btn4.getText() == "0" && btn7.getText() == "0")
        {
            btn1.setBackgroundColor(Color.parseColor("#228B22"));
            btn4.setBackgroundColor(Color.parseColor("#228B22"));
            btn7.setBackgroundColor(Color.parseColor("#228B22"));
        }
        //Change color for winning blocks 2nd column all O
        else if(btn2.getText() == "0" && btn5.getText() == "0" && btn8.getText() == "0")
        {
            btn2.setBackgroundColor(Color.parseColor("#228B22"));
            btn5.setBackgroundColor(Color.parseColor("#228B22"));
            btn8.setBackgroundColor(Color.parseColor("#228B22"));
        }
        //Change color for winning blocks 3nd column all O
        else if(btn3.getText() == "0" && btn6.getText() == "0" && btn9.getText() == "0")
        {
            btn3.setBackgroundColor(Color.parseColor("#228B22"));
            btn6.setBackgroundColor(Color.parseColor("#228B22"));
            btn9.setBackgroundColor(Color.parseColor("#228B22"));
        }
        //Diagonal
        //bottom left to top right= 0
        else if(btn7.getText() == "0" && btn5.getText() == "0" && btn3.getText() == "0")
        {
            btn7.setBackgroundColor(Color.parseColor("#228B22"));
            btn5.setBackgroundColor(Color.parseColor("#228B22"));
            btn3.setBackgroundColor(Color.parseColor("#228B22"));
        }
        //bottom right to top left= 0
        else if(btn9.getText() == "0" && btn5.getText() == "0" && btn1.getText() == "0")
        {
            btn9.setBackgroundColor(Color.parseColor("#228B22"));
            btn5.setBackgroundColor(Color.parseColor("#228B22"));
            btn1.setBackgroundColor(Color.parseColor("#228B22"));
        }

        //bottom left to top right= X
        else if(btn7.getText() == "X" && btn5.getText() == "X" && btn3.getText() == "X")
        {
            btn7.setBackgroundColor(Color.parseColor("#228B22"));
            btn5.setBackgroundColor(Color.parseColor("#228B22"));
            btn3.setBackgroundColor(Color.parseColor("#228B22"));
        }
        //bottom right to top left= X
        else if(btn9.getText() == "X" && btn5.getText() == "X" && btn1.getText() == "X")
        {
            btn9.setBackgroundColor(Color.parseColor("#228B22"));
            btn5.setBackgroundColor(Color.parseColor("#228B22"));
            btn1.setBackgroundColor(Color.parseColor("#228B22"));
        }

    }
}
