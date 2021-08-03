package sg.edu.tp.musicstream;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FindLyricsActivity extends AppCompatActivity {
    EditText editArtist, editSong;
    Button findLyrics;
    TextView displayLyrics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.lyrics_finder);

        editArtist = findViewById(R.id.editArtist);
        editSong = findViewById(R.id.editSong);
        findLyrics = findViewById(R.id.findLyrics);
        displayLyrics = findViewById(R.id.displayLyrics);

        findLyrics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputArtistName = editArtist.getText().toString().trim();
                String inputSongName = editSong.getText().toString().trim();

                if (TextUtils.isEmpty(inputArtistName)) {
                    editArtist.setError("This fill is required to find Lyrics");
                } else if (TextUtils.isEmpty(inputSongName)) {
                    editSong.setError("This fill is required to find Lyrics");
                } else if (inputArtistName.equals("Michael Buble")) {
                    if (inputSongName.equals("The Way You Look Tonight")) {
                        displayLyrics.setText("Some day, when I'm awfully low When the world is cold I will feel a glow just thinking of you and the way you look tonight You're lovely, with your smile so warm And your cheeks so soft There is nothing for me but to love you And the way you look tonight With each word your tenderness grows Tearing my fears apart And that laugh that wrinkles your nose Touches my foolish heart Yes you're lovely, never, ever change Keep that breathless charm Won't you please arrange it? 'Cause I love you Just the way you look tonight With each word your tenderness grows Tearing my fears apart And that laugh that wrinkles your nose Touches my foolish heart Yes you're lovely, never, ever change Keep that breathless charm Won't you please arrange it? 'Cause I love you Just the way you look tonight Just the way you look tonight Darling Just the way you look tonight");
                    }
                } else if (inputArtistName.equals("Michael Jackson")) {
                    if (inputSongName.equals("Billie Jean")) {
                        displayLyrics.setText("She was more like a beauty queen from a movie scene I said don't mind, but what do you mean, I am the one Who will dance on the floor in the round? She said I am the one, who will dance on the floor in the round She told me her name was Billie Jean, as she caused a scene Then every head turned with eyes that dreamed of being the one Who will dance on the floor in the round People always told me be careful of what you do And don't go around breaking young girls' hearts And mother always told me be careful of who you love And be careful of what you do 'cause the lie becomes the truth Billie Jean is not my lover She's just a girl who claims that I am the one But the kid is not my son She says I am the one, but the kid is not my son For forty days and forty nights The law was on her side But who can stand when she's in demand Her schemes and plans 'Cause we danced on the floor in the round So take my strong advice, just remember to always think twice (Do think twice, do think twice) She told my baby we'd danced 'til three, then she looked at me Then showed a photo my baby cried his eyes were like mine (oh, no) 'Cause we danced on the floor in the round, baby People always told me be careful of what you do And don't go around breaking young girls' hearts She came and stood right by me Just the smell of sweet perfume This happened much too soon She called me to her room Billie Jean is not my lover She's just a girl who claims that I am the one But the kid is not my son Billie Jean is not my lover She's just a girl who claims that I am the one But the kid is not my son She says I am the one, but the kid is not my son She says I am the one, but the kid is not my son Billie Jean is not my lover She's just a girl who claims that I am the one But the kid is not my son She says I am the one, but the kid is not my son She says I am the one You know what you did, (she says he is my son) breaking my heart babe She says I am the one Billie Jean is not my lover Billie Jean is not my lover Billie Jean is not my lover Billie Jean is not my lover (don't Billie Jean) Billie Jean is not my lover Billie Jean is not my lover");
                    }
                } else if (inputArtistName.equals("Ed Sheeran")) {
                    if (inputSongName.equals("Photograph")) {
                        displayLyrics.setText("Loving can hurt Loving can hurt sometimes But it's the only thing that I know When it gets hard You know it can get hard sometimes It is the only thing that makes us feel alive We keep this love in a photograph We made these memories for ourselves Where our eyes are never closing Hearts are never broken And time's forever frozen still So you can keep me Inside the pocket of your ripped jeans Holding me closer 'til our eyes meet You won't ever be alone Wait for me to come home Loving can heal Loving can mend your soul And it's the only thing that I know (know) I swear it will get easier Remember that with every peace of ya And it's the only thing we take with us when we die We keep this love in this photograph We made these memories for ourselves Where our eyes were never closing Hearts were never broken And time's forever frozen still So you can keep me Inside the pocket of your ripped jeans Holding me closer 'til our eyes meet You won't ever be alone And if you hurt me Well that's okay baby, only words bleed Inside these pages you just hold me And I won't ever let you go Wait for me to come home Wait for me to come home Wait for me to come home Wait for me to come home You can fit me Inside the necklace you bought When you were sixteen Next to your heartbeat where I should be Keep it deep within your soul And if you hurt me Well that's okay baby, only words bleed Inside these pages you just hold me (hold me) And I won't ever let you go When I'm away I will remember how you kissed me Under the lamppost back on Sixth street Hearing you whisper through the phone Wait for me to come homeWait for me to come home");
                    }
                } else if (inputArtistName.equals("Oasis")) {
                    if (inputSongName.equals("Wonderwall")) {
                        displayLyrics.setText("Today is gonna be the day That they're gonna throw it back to you By now you should've somehow Realized what you gotta do I don't believe that anybody Feels the way I do about you now Backbeat, the word is on the street That the fire in your heart is out I'm sure you've heard it all before But you never really had a doubt I don't believe that anybody Feels the way I do about you now And all the roads we have to walk are winding And all the lights that lead us there are blinding There are many things that I Would like to say to you but I don't know how Because maybe You're gonna be the one that saves me And after all You're my wonderwall Today was gonna be the day But they'll never throw it back to you By now you should've somehow Realized what you're not to do I don't believe that anybody Feels the way I do about you now And all the roads that lead you there were winding And all the lights that light the way are blinding There are many things that I Would like to say to you but I don't know how I said maybe You're gonna be the one that saves me And after all You're my wonderwall I said maybe (I said maybe) You're gonna be the one that saves me And after all You're my wonderwall I said maybe (I said maybe) You're gonna be the one that saves me (saves me) You're gonna be the one that saves me (that saves me) You're gonna be the one that saves me (that saves me)");
                    }
                } else if (inputArtistName.equals("The Chainsmokers")) {
                    if (inputSongName.equals("Something Just Like This")) {
                        displayLyrics.setText("I've been reading books of old The legends and the myths Achilles and his gold Hercules and his gifts Spider-Man's control And Batman with his fists And clearly I don't see myself upon that list But she said, where'd you wanna go? How much you wanna risk? I'm not lookin' for somebody With some superhuman gifts Some superhero Some fairy-tale bliss Just something I can turn to Somebody I can kiss I want something just like this Doo-doo-doo, doo-doo-doo Doo-doo-doo, doo-doo Doo-doo-doo, doo-doo-doo Oh, I want something just like this Doo-doo-doo, doo-doo-doo Doo-doo-doo, doo-doo Doo-doo-doo, doo-doo-doo Oh, I want something just like this I want something just like this I've been reading books of old The legends and the myths The testaments they told The moon and its eclipse And Superman unrolls A suit before he lifts But I'm not the kind of person that it fits She said, where'd you wanna go? How much you wanna risk? I'm not lookin' for somebody With some superhuman gifts Some superhero Some fairy-tale bliss Just something I can turn to Somebody I can miss I want something just like this I want something just like this Oh, I want something just like this Doo-doo-doo, doo-doo-doo Doo-doo-doo, doo-doo Doo-doo-doo, doo-doo-doo Oh, I want something just like this Doo-doo-doo, doo-doo-doo Doo-doo-doo, doo-doo Doo-doo-doo, doo-doo-doo Where'd you wanna go? How much you wanna risk? I'm not lookin' for somebody With some superhuman gifts Some superhero Some fairy-tale bliss Just something I can turn to Somebody I can kiss I want something just like this Oh, I want something just like this Oh, I want something just like this Oh, I want something just like this");
                    }else if (inputSongName.equals("Closer")) {
                        displayLyrics.setText("Hey, I was doing just fine before I met you I drink too much, and that's an issue, but I'm okay Hey, you tell your friends it was nice to meet them But I hope I never see them again I know it breaks your heart Moved to the city in a broke-down car, and Four years, no calls Now you're looking pretty in a hotel bar, and I-I-I can't stop No, I-I-I can't stop So, baby, pull me closer In the back seat of your Rover That I know you can't afford Bite that tattoo on your shoulder Pull the sheets right off the corner Of that mattress that you stole From your roommate back in Boulder We ain't ever getting older We ain't ever getting older We ain't ever getting older You look as good as the day I met you I forget just why I left you, I was insane Stay and play that Blink-182 song That we beat to death in Tucson, okay I know it breaks your heart Moved to the city in a broke-down car, and Four years, no call Now I'm looking pretty in a hotel bar, and I-I-I can't stop No, I-I-I can't stop So, baby, pull me closer In the back seat of your Rover That I know you can't afford Bite that tattoo on your shoulder Pull the sheets right off the corner Of that mattress that you stole From your roommate back in Boulder We ain't ever getting older We ain't ever getting older We ain't ever getting older So, baby, pull me closer In the back seat of your Rover That I know you can't afford Bite that tattoo on your shoulder Pull the sheets right off the corner Of that mattress that you stole From your roommate back in Boulder We ain't ever getting older We ain't ever getting older No, we ain't ever getting older We ain't ever getting older No, we ain't ever getting older We ain't ever getting older We ain't ever getting older We ain't ever getting older No, we ain't ever getting older We ain't ever getting older No, we ain't ever getting older");
                    }
                }else if (inputArtistName.equals("Bruno Mars")) {
                    if (inputSongName.equals("Count On Me")) {
                        displayLyrics.setText("Oh-oh If you ever find yourself stuck in the middle of the sea I'll sail the world to find you If you ever find yourself lost in the dark and you can't see I'll be the light to guide you We'll find out what we're made of When we are called to help our friends in need You can count on me like one, two, three I'll be there And I know when I need it, I can count on you like four, three, two And you'll be there 'Cause that's what friends are supposed to do, oh, yeah Ooh-ooh-ooh-ooh Ooh-ooh-ooh-ooh, ooh, yeah, yeah If you tossin' and you're turnin' and you just can't fall asleep I'll sing a song beside you And if you ever forget how much you really mean to me Every day I will remind you, oh We'll find out what we're made of When we are called to help our friends in need You can count on me like one, two, three I'll be there And I know when I need it, I can count on you like four, three, two And you'll be there 'Cause that's what friends are supposed to do, oh, yeah Ooh-ooh-ooh-ooh Ooh-ooh-ooh-ooh, ooh, yeah, yeah You'll always have my shoulder when you cry I'll never let go, never say goodbye You know... You can count on me like one, two, three I'll be there And I know when I need it I can count on you like four, three, two And you'll be there 'Cause that's what friends are supposed to do, oh, yeah Ooh-ooh-ooh-ooh Ooh-ooh-ooh-ooh, ooh You can count on me 'cause I can count on you");
                    }
                } else if (inputArtistName.equals("Adele")) {
                    if (inputSongName.equals("Rolling in the Deep")) {
                        displayLyrics.setText("There's a fire starting in my heart Reaching a fever pitch and it's bringing me out the dark Finally, I can see you crystal clear Go ahead and sell me out and I'll lay your ship bare See how I'll leave with every piece of you Don't underestimate the things that I will do There's a fire starting in my heart Reaching a fever pitch and it's bring me out the dark The scars of your love remind me of us They keep me thinking that we almost had it all The scars of your love, they leave me breathless I can't help feeling We could have had it all (You're gonna wish you never had met me) Rolling in the deep (Tears are gonna fall, rolling in the deep) You had my heart inside of your hands (You're gonna wish you never had met me) And you played it to the beat (Tears are gonna fall, rolling in the deep) Baby, I have no story to be told But I've heard one on you and I'm gonna make your head burn Think of me in the depths of your despair Make a home down there as mine sure won't be shared The scars of your love remind me of us (Tears are gonna fall, rolling in the deep) They keep me thinking that we almost had it all (You're gonna wish you never had met me) The scars of your love, they leave me breathless (Tears are gonna fall, rolling in the deep) I can't help feeling We could have had it all (You're gonna wish you never had met me) Rolling in the deep (Tears are gonna fall, rolling in the deep) You had my heart inside of your hands (You're gonna wish you never had met me) And you played it to the beat (Tears are gonna fall, rolling in the deep) Could have had it all Rolling in the deep You had my heart inside of your hands But you played it with a beating Throw your soul through every open door Count your blessings to find what you look for Turn my sorrow into treasured gold You'll pay me back in kind and reap just what you've sown We could have had it all (Tears are gonna fall, rolling in the deep) We could have had it all (You're gonna wish you never had met me) It all, it all, it all (Tears are gonna fall, rolling in the deep) We could have had it all (You're gonna wish you never had met me) Rolling in the deep (Tears are gonna fall, rolling in the deep) You had my heart inside of your hands (You're gonna wish you never had met me) And you played it to the beat (Tears are gonna fall, rolling in the deep) We could have had it all (You're gonna wish you never had met me) Rolling in the deep (Tears are gonna fall, rolling in the deep) You had my heart inside of your hands (You're gonna wish you never had met me) But you played it You played it You played it You played it to the beat");
                    }

                } else {
                    Toast.makeText(FindLyricsActivity.this, "Lyrics is not found. Please try entering songs from the Homepage", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }
}
//  (Due to API Website server is down, i decided to create my own "static" lyrics finder)
//  (There are several ways to create a static lyrics finder, but i decided to go for this as i'm more familiar with it - for example we can do a lyric collection like the )
//  (to make this codes, I apply what i have learnt when doing Firebase Auth)
/*findLyrics.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        String url = "https://api.lyrics.ovh/v1/" + editArtist.getText().toString() + "/" + editSong.getText().toString();
        url.replace(" ", "20%");


        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

        //Requesting json data from given url
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,
        null, new Response.Listener<JSONObject>() {
@Override
public void onResponse(JSONObject response) {
        //getting result in response (variable)
        try {
        displayLyrics.setText(response.getString("lyrics"));
        } catch (JSONException e) {
        e.printStackTrace();

        }

        }
        }, new Response.ErrorListener() {
@Override
public void onErrorResponse(VolleyError error) {
        //if any error occurs then this code will execute
        Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_SHORT).show();

        }
        });

        requestQueue.add(jsonObjectRequest);

        }
        });
        */