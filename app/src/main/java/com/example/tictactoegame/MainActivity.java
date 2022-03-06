package com.example.tictactoegame;

        import androidx.appcompat.app.AppCompatActivity;

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
        }
    }
}
