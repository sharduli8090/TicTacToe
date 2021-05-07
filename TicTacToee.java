import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//TIC TAC TOEE CLASS IMPLEMENTING ACTION LISTENER CLASS
public class TicTacToee implements ActionListener{

    //CREATING INSTANCE FOR RANDOM CLASS
    Random random = new Random();

    //CREATING INSTANCE FOR JFRAME CLASS
    JFrame frame = new JFrame();

    //CREATING INSTANCE FOR JPANEL CLASS
    JPanel panel = new JPanel();

    //CREATING INSTANCE FOR JPANEL CLASS
    JPanel title_panel = new JPanel();

    //CREATING INSTANCE FOR JPANEL CLASS
    JPanel button_panel = new JPanel();

    //CREATING INSTANCE FOR JLABEL CLASS
    JLabel textfield = new JLabel();

    //CREATING ARRAY OF JBUTTON CLASS
    JButton[] buttons = new JButton[9];

    //DECLARING A BOOLEAN VARIABLE FOR PLAYER TURNS
    boolean player1_turn;

    //CONSTRUCTOR
    TicTacToee(){

        //OPERATIONS FOR FRAME

        //FOR EXIT
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       //SETTING THE SIZE OF FRAME
       frame.setSize(800,800);

       //SETTING THE BACKGROUND COLOR FOR CONTENT PANE
       frame.getContentPane().setBackground(new Color(50,50,50));

       //SETTING THE LAYOUT OF THE FRAME CHANGEABLE
       frame.setLayout(new BorderLayout());

       //SETTING THE VISIBILITY OF THE TO TRUE
       frame.setVisible(true);

       //OPERATIONS FOR TEXTFIELD

        //SETTING THE BACKGROUND COLOR FOR TEXT FIELD
       textfield.setBackground(new Color(25,25,25));

       //SETTING THE FOREGROUND COLOR FOR TEXT FIELD
       textfield.setForeground(new Color(25,255,0));

       //SETTING THE FONT STYLE AND SIZE OF THE TEXT FIELD
       textfield.setFont(new Font("SanSerif" , Font.BOLD , 75));

       //ALIGNING THE TEXTFIELD TO CENTER
       textfield.setHorizontalAlignment(JLabel.CENTER);

       //SETTING THE TEXT OF TEXT FIELD
       textfield.setText("TIC TAC TOE");

       //MAKING THE TEXT FIELD OPAQUE
       textfield.setOpaque(true);

       //OPERATIONS FOR TITLE

        //SETTING THE LAYOUT OF THE TITLE PANEL
       title_panel.setLayout(new BorderLayout());

       //SETTING THE BOUNDS OF TITLE PANEL
       title_panel.setBounds(0,0,800,100);

       //OPERATIONS OF BUTTON PANEL

        //SETTING THE LAYOUT OF BUTTON PANEL
       button_panel.setLayout(new GridLayout(3,3));

       //SETTING THEE BACKGROUND COLOR OF BUTTON PANEL
       //button_panel.setBackground(new Color(150,150,150));

        //LOOPING THROUGH 9 BUTTONS
        for(int i=0;i<9;i++){

            //CREATING EACH BUTTON AS THE INSTANCE OF JBUTTON
            buttons[i] = new JButton();

            //ADDING EACH BUTTON TO THE BUTTON PANEL
            button_panel.add(buttons[i]);

            //SETTING THE FONT STYLE AND SIZE OF EACH BUTTON
            buttons[i].setFont(new Font("MV Boli" , Font.BOLD,120));

            //DISABLING THE FOCUSABILITY OF EACH BUTTON
            buttons[i].setFocusable(false);

            //ADDING ACTION LISTENER TO EACH BUTTON
            buttons[i].addActionListener(this);

        }

        //ADDING TEXTFIELD TO TITLE PANEL
       title_panel.add(textfield);

        //ADDING TITLE PANEL TO THE NORTH OF THE FRAME
       frame.add(title_panel,BorderLayout.NORTH);

       //ADDING BUTTON PANEL TO THE FRAME
       frame.add(button_panel);

       //TRAVERSING THROUGH 9 BUTTONS
       for(int i=0;i<9;i++){

           //DISABLING EACH BUTTON
           buttons[i].setEnabled(false);

       }

       //CALLING THE FIRST TURN METHOD
       firstTurn();

        }

    //OVERRIDING THE METHOD
    @Override
    public  void actionPerformed(ActionEvent e){

        //TRAVERSING THROUGH 9 BUTTONS
        for(int i=0;i<9;i++){

            //IF THE INPUT IS ON ANY OF THE BUTTONS
            if(e.getSource() == buttons[i]){

                //IF THE TURN IS OF PLAYER ONE
                if(player1_turn){

                    //IF THE TEXT ON BUTTON IS EMPTY
                    if(buttons[i].getText() == ""){

                        //SETTING THE FOREGROUND COLOR OF PARTICULAR BUTTON
                        buttons[i].setForeground(new Color(255,0,0));

                        //SETTING THE TEXT OF BUTTON AS X
                        buttons[i].setText("X");

                        //DISABLING THE TURN OF PLAYER ONE
                        player1_turn=false;

                        //SETTING THE TEXT FIELD TEXT TO O TURN
                        textfield.setText("O turn");

                        //CALLING THE CHECK METHOD
                        check();

                     }
                }

                //IF ALL THE BUTTONS ARE OCCUPIED AND NOBODY WON
                if(((buttons[0].getText() == "X") || (buttons[0].getText() == "O")) && ((buttons[1].getText() == "X") || (buttons[1].getText() == "O")) && ((buttons[2].getText() == "X") || (buttons[2].getText() == "O")) && ((buttons[3].getText() == "X") || (buttons[3].getText() == "O")) && ((buttons[4].getText() == "X") || (buttons[4].getText() == "O")) && ((buttons[5].getText() == "X") || (buttons[5].getText() == "O")) && ((buttons[6].getText() == "X") || (buttons[6].getText() == "O")) && ((buttons[7].getText() == "X") || (buttons[7].getText() == "O")) && ((buttons[8].getText() == "X") || (buttons[8].getText() == "O")))
                {
                    //TRAVERSING THROUGH THE 9 BUTTONS
                    for(int j=0;j<9;j++){

                        //DISABLING EACH BUTTON
                        buttons[j].setEnabled(false);

                        //SETTING THE BACKGROUND COLOR OF EACH BUTTON TO RED
                        buttons[j].setBackground(Color.red);

                        //SETTING THE TEXT IN TEXT FIELD TO NOBODY WON
                        textfield.setText("Nobody Won");

                    }
                }

                //ELSE THE TURN IS OF PLAYER TWO
                else{

                    //IF THE TEXT ON BUTTON IS EQUAL TO EMPTY
                    if(buttons[i].getText() == ""){

                        //SETTING THE FOREGROUND COLOR OF PARTICULAR BUTTON
                        buttons[i].setForeground(new Color(0,0,255));

                        //SETTING THE TEXT OF BUTTON  AS O
                        buttons[i].setText("O");

                        //DISABLING THE TURN OF PLAYER TWO
                        player1_turn=true;

                        //SETTING THE TEXT OF TEXT FIELD AS X TURN
                        textfield.setText("X turn");

                        //CALLING THE CHECK METHOD
                        check();

                    }
                }
            }
        }
    }

    //FIRST TURN METHOD
    public void firstTurn() {

        //DISPLAYING THE TITLE TIC TAC TOE FOR 3 SECONDS
        //USED TRY CATCH FOR EXCEPTION
        try {

            Thread.sleep(3000);

        }

        catch(InterruptedException e){

            e.printStackTrace();

        }

        //TRAVERSING THROUGH 9 BUTTONS
        for(int i=0;i<9;i++){

            //ENABLING EACH BUTTON
            buttons[i].setEnabled(true);

        }

        //IF RANDOM INTEGER IS EQUAL TO 0
        if(random.nextInt(2) == 0){

            //SET THE PLAYER ONE TURN
            player1_turn = true;

            //SETTING THE TEXT ON TEXT FIELD AS X TURN
            textfield.setText("X turn");

        }

        //ELSE
        else{

            //SET THE PLAYER TWO TURN
            player1_turn = false;

            //SETTING TEXT ON TEXT FIELD TO O TURN
            textfield.setText("O turn");

        }
    }

    //CHECK METHOD
    public void check(){

        //FOR X

        //HORIZONTAL COMBINATIONS

        //IF THE TEXT ON BUTTON  0 , 1 , 2 IS EQUAL
        if((buttons[0].getText() == "X") && (buttons[1].getText() == "X") && (buttons[2].getText() == "X")){

            //CALLING XWINS METHOD
            xWins(0,1,2);

        }

        //IF THE TEXT ON BUTTON  3 , 4 , 5 IS EQUAL
        if((buttons[3].getText() == "X") && (buttons[4].getText() == "X") && (buttons[5].getText() == "X")){

            //CALLING XWINS METHOD
            xWins(3,4,5);

        }

        //IF THE TEXT ON BUTTON  6 , 7 , 8 IS EQUAL
        if((buttons[6].getText() == "X") && (buttons[7].getText() == "X") && (buttons[8].getText() == "X")){

            //CALLING XWINS METHOD
            xWins(6,7,8);

        }

        //VERTICAL COMBINATIONS

        //IF THE TEXT ON BUTTON  0 , 3 , 6 IS EQUAL
        if((buttons[0].getText() == "X") && (buttons[3].getText() == "X") && (buttons[6].getText() == "X")){

            //CALLING XWINS METHOD
            xWins(0,3,6);

        }

        //IF THE TEXT ON BUTTON  1 , 4 , 7 IS EQUAL
        if((buttons[1].getText() == "X") && (buttons[4].getText() == "X") && (buttons[7].getText() == "X")){

            //CALLING XWINS METHOD
            xWins(1,4,7);

        }

        //IF THE TEXT ON BUTTON  2 , 5 , 8 IS EQUAL
        if((buttons[2].getText() == "X") && (buttons[5].getText() == "X") && (buttons[8].getText() == "X")){

            //CALLING XWINS METHOD
            xWins(2,5,8);

        }

        //DIAGONAL COMBINATIONS

        //IF THE TEXT ON BUTTON  0 , 4 , 8 IS EQUAL
        if((buttons[0].getText() == "X") && (buttons[4].getText() == "X") && (buttons[8].getText() == "X")){

            //CALLING XWINS METHOD
            xWins(0,4,8);

        }

        //IF THE TEXT ON BUTTON  2 , 4 , 6 IS EQUAL
        if((buttons[2].getText() == "X") && (buttons[4].getText() == "X") && (buttons[6].getText() == "X")){

            //CALLING XWINS METHOD
            xWins(2,4,6);

        }

        //FOR O

        //HORIZONTAL COMBINATIONS

        //IF THE TEXT ON BUTTON  0 , 1 , 2 IS EQUAL
        if((buttons[0].getText() == "O") && (buttons[1].getText() == "O") && (buttons[2].getText() == "O")){

            //CALLING OWINS METHOD
            oWins(0,1,2);

        }

        //IF THE TEXT ON BUTTON  3 , 4 , 5 IS EQUAL
        if((buttons[3].getText() == "O") && (buttons[4].getText() == "O") && (buttons[5].getText() == "O")){

            //CALLING OWINS METHOD
            oWins(3,4,5);

        }

        //IF THE TEXT ON BUTTON  6 , 7 , 8 IS EQUAL
        if((buttons[6].getText() == "O") && (buttons[7].getText() == "O") && (buttons[8].getText() == "O")){

            //CALLING OWINS METHOD
            oWins(6,7,8);

        }

        //VERTICAL COMBINATIONS

        //IF THE TEXT ON BUTTON  0 , 3 , 6 IS EQUAL
        if((buttons[0].getText() == "O") && (buttons[3].getText() == "O") && (buttons[6].getText() == "O")){

            //CALLING OWINS METHOD
            oWins(0,3,6);

        }

        //IF THE TEXT ON BUTTON  1 , 4 , 7 IS EQUAL
        if((buttons[1].getText() == "O") && (buttons[4].getText() == "O") && (buttons[7].getText() == "O")){

            //CALLING OWINS METHOD
            oWins(1,4,7);

        }

        //IF THE TEXT ON BUTTON  2 , 5 , 8 IS EQUAL
        if((buttons[2].getText() == "O") && (buttons[5].getText() == "O") && (buttons[8].getText() == "O")){

            //CALLING OWINS METHOD
            oWins(2,5,8);

        }

        //DIAGONAL COMBINATIONS

        //IF THE TEXT ON BUTTON  0 , 4 , 8 IS EQUAL
        if((buttons[0].getText() == "O") && (buttons[4].getText() == "O") && (buttons[8].getText() == "O")){

            //CALLING OWINS METHOD
            oWins(0,4,8);

        }

        //IF THE TEXT ON BUTTON  2 , 4 , 6 IS EQUAL
        if((buttons[2].getText() == "O") && (buttons[4].getText() == "O") && (buttons[6].getText() == "O")){

            //CALLING OWINS METHOD
            oWins(2,4,6);

        }
    }

    //XWIN METHOD WITH PARAMETER OF 3 INTEGERS
    public void xWins(int a, int b, int c){

        //SETTING THE BACKGROUND COLOR OF BUTTON AT INDEX A TO GREEN
        buttons[a].setBackground(Color.GREEN);

        //SETTING THE BACKGROUND COLOR OF BUTTON AT INDEX B TO GREEN
        buttons[b].setBackground(Color.GREEN);

        //SETTING THE BACKGROUND COLOR OF BUTTON AT INDEX C TO GREEN
        buttons[c].setBackground(Color.GREEN);

        //TRAVERSING THROUGH THE 9 BUTTONS
        for(int i=0;i<9;i++){

            //DISABLING EACH BUTTON
            buttons[i].setEnabled(false);

        }

        //SETTING THE TEXT FIELD TO X WINS
        textfield.setText("X Wins");

    }

    //OWIN METHOD WITH PARAMETER OF 3 INTEGERS
    public void oWins(int a, int b, int c){

        //SETTING THE BACKGROUND COLOR OF BUTTON AT INDEX A TO GREEN
        buttons[a].setBackground(Color.GREEN);

        //SETTING THE BACKGROUND COLOR OF BUTTON AT INDEX B TO GREEN
        buttons[b].setBackground(Color.GREEN);

        //SETTING THE BACKGROUND COLOR OF BUTTON AT INDEX C TO GREEN
        buttons[c].setBackground(Color.GREEN);

        //TRAVERSING THROUGH THE 9 BUTTONS
        for(int i=0;i<9;i++){

            //DISABLING EACH BUTTON
            buttons[i].setEnabled(false);

        }

        //SETTING THE TEXT FIELD TO O WINS
        textfield.setText("O Wins");

    }
}
