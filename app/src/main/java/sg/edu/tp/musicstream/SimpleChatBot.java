package sg.edu.tp.musicstream;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class SimpleChatBot extends AppCompatActivity {
    ScrollView scrollView;
    Button partOne, partTwo, partThree, partFour, exitBtn;
    View botSpeaking, botAnswering;
    TextView botGuideToFAQ, botReplyToFAQ;
    //Credit to myself


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.activity_chat_bot_application);
        scrollView = findViewById(R.id.scroll);
        partOne = findViewById(R.id.partOne);
        partTwo = findViewById(R.id.partTwo);
        partThree = findViewById(R.id.partThree);
        partFour = findViewById(R.id.partFour);
        botSpeaking = findViewById(R.id.botSpeaking);
        botAnswering = findViewById(R.id.botAnswering);
        botGuideToFAQ = findViewById(R.id.botGuideToFAQ);
        botReplyToFAQ = findViewById(R.id.botReplytoFAQ);
        exitBtn = findViewById(R.id.exitBtn);

        partOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.fullScroll(View.FOCUS_DOWN);
                botGuideToFAQ.setVisibility(View.VISIBLE);
                botSpeaking.setVisibility(View.VISIBLE);
                partOne.setVisibility(View.INVISIBLE);
                partTwo.setVisibility(View.INVISIBLE);
                partThree.setVisibility(View.INVISIBLE);
                partFour.setVisibility(View.INVISIBLE);
                botAnswering.setVisibility(View.VISIBLE);
                botReplyToFAQ.setVisibility(View.VISIBLE);
                exitBtn.setVisibility(View.VISIBLE);

                botReplyToFAQ.setText("Go to the homepage and press the green plus button, doing this automatically add song to your default playlist");
                Toast.makeText(SimpleChatBot.this, "You Have Clicked on Part 1", Toast.LENGTH_SHORT).show();
            }
        });

        partTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.fullScroll(View.FOCUS_DOWN);
                botGuideToFAQ.setVisibility(View.VISIBLE);
                botSpeaking.setVisibility(View.VISIBLE);
                partOne.setVisibility(View.INVISIBLE);
                partTwo.setVisibility(View.INVISIBLE);
                partThree.setVisibility(View.INVISIBLE);
                partFour.setVisibility(View.INVISIBLE);
                botAnswering.setVisibility(View.VISIBLE);
                botReplyToFAQ.setVisibility(View.VISIBLE);
                exitBtn.setVisibility(View.VISIBLE);

                botReplyToFAQ.setText("Go to Homepage and Click on any song image, from there you can press the play pause button to on/off the Music player");
                Toast.makeText(SimpleChatBot.this, "You Have Clicked on Part 2", Toast.LENGTH_SHORT).show();
            }
        });

        partThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.fullScroll(View.FOCUS_DOWN);
                botGuideToFAQ.setVisibility(View.VISIBLE);
                botSpeaking.setVisibility(View.VISIBLE);
                partOne.setVisibility(View.INVISIBLE);
                partTwo.setVisibility(View.INVISIBLE);
                partThree.setVisibility(View.INVISIBLE);
                partFour.setVisibility(View.INVISIBLE);
                botAnswering.setVisibility(View.VISIBLE);
                botReplyToFAQ.setVisibility(View.VISIBLE);
                exitBtn.setVisibility(View.VISIBLE);

                botReplyToFAQ.setText("Hah guess what, our company too poor to hire world class programmer, there's no way to restore your deleted playlist. (Actually you can just move to different screen and go back to the playlist screen your playlist will still be there)");
                Toast.makeText(SimpleChatBot.this, "You Have Clicked on Part 3", Toast.LENGTH_SHORT).show();
            }
        });

        partFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.fullScroll(View.FOCUS_DOWN);
                botGuideToFAQ.setVisibility(View.VISIBLE);
                botSpeaking.setVisibility(View.VISIBLE);
                partOne.setVisibility(View.INVISIBLE);
                partTwo.setVisibility(View.INVISIBLE);
                partThree.setVisibility(View.INVISIBLE);
                partFour.setVisibility(View.INVISIBLE);
                botAnswering.setVisibility(View.VISIBLE);
                botReplyToFAQ.setVisibility(View.VISIBLE);
                exitBtn.setVisibility(View.VISIBLE);

                botReplyToFAQ.setText("Logout from the app and tap on (Forgot Password) Enter your email, if you have forgotten your email too please contact our Help desk at +65 9657 9912 (This is a fake phone number don't prank call)");
                Toast.makeText(SimpleChatBot.this, "You Have Clicked on Part 4", Toast.LENGTH_SHORT).show();
            }
        });

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.fullScroll(View.FOCUS_UP);
                botGuideToFAQ.setVisibility(View.VISIBLE);
                botSpeaking.setVisibility(View.VISIBLE);
                partOne.setVisibility(View.VISIBLE);
                partTwo.setVisibility(View.VISIBLE);
                partThree.setVisibility(View.VISIBLE);
                partFour.setVisibility(View.VISIBLE);
                botAnswering.setVisibility(View.INVISIBLE);
                botReplyToFAQ.setVisibility(View.INVISIBLE);
                exitBtn.setVisibility(View.INVISIBLE);

                Toast.makeText(SimpleChatBot.this, "You Have Clicked on Exit", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
