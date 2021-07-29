package sg.edu.tp.musicstream;

public class SongCollection {

    Song songs[] = new Song[8];

    public SongCollection() {
        Song theWayYouLookTonight = new Song("S1001",
                "The Way You Look Tonight",
                "Michael Buble",
                "https://p.scdn.co/mp3-preview/a5b8972e764025020625bbf9c1c2bbb06e394a60?cid=2afe87a64b0042dabf51f37318616965",
                4.66,
                R.drawable.michael_buble_collection,
                "michael_buble_collection"); /* this coverArt is just here to match with AppUtil to operate the playlist function
                                                        the playlist use this line of code to get it image */
        Song billieJean = new Song("S1002",
                "Billie Jean",
                "Michael Jackson",
                "https://p.scdn.co/mp3-preview/4eb779428d40d579f14d12a9daf98fc66c7d0be4?cid=2afe87a64b0042dabf51f37318616965",
                4.9,
                R.drawable.billie_jean,
                "billie_jean");

        Song photograph = new Song("S1003",
                "Photograph",
                "Ed Sheeran",
                "https://p.scdn.co/mp3-preview/097c7b735ceb410943cbd507a6e1dfda272fd8a8?cid=2afe87a64b0042dabf51f37318616965",
                4.32,
                R.drawable.photograph,
                "photograph");

        Song wonderwall = new Song("S1004",
                "Wonderwall",
                "Oasis",
                "https://p.scdn.co/mp3-preview/fbdb1dfd98d6d51d968bd42b9d667c9f3b7ffb9b?cid=2afe87a64b0042dabf51f37318616965",
                4.33,
                R.drawable.wonder_wall,
                "wonder_wall");

        Song somethingJustLikeThis = new Song("S1005",
                "Something Just Like This",
                "The Chainsmoker",
                "https://p.scdn.co/mp3-preview/ab1cd059a9ac76478e2892f390036b9568c69a4f?cid=2afe87a64b0042dabf51f37318616965",
                4.13,
                R.drawable.something_just_like_this,
                "something_just_like_this");

        Song closer = new Song("S1006",
                "Closer",
                "The Chainsmoker",
                "https://p.scdn.co/mp3-preview/8d3df1c64907cb183bff5a127b1525b530992afb?cid=2afe87a64b0042dabf51f37318616965",
                4.08,
                R.drawable.closer,
                "closer");

        Song countOnMe = new Song("S1007",
                "Count On Me",
                "Bruno Mars",
                "https://p.scdn.co/mp3-preview/84464b2b96398cae75e0924bdf693a44727338b8?cid=2afe87a64b0042dabf51f37318616965",
                3.29,
                R.drawable.count_on_me,
                "count_on_me");

        Song rollingInTheDeep = new Song("S1008",
                "Rolling in the Deep",
                "Adele",
                "https://p.scdn.co/mp3-preview/cdbe20caa60a0fbdbb3d16f79eac4b4e4ba07268?cid=2afe87a64b0042dabf51f37318616965",
                3.8,
                R.drawable.rolling_in_the_deep,
                "rolling_in_the_deep");



        songs[0] = theWayYouLookTonight;
        songs[1] = billieJean;
        songs[2] = photograph;
        songs[3] = wonderwall;
        songs[4] = somethingJustLikeThis;
        songs[5] = closer;
        songs[6] = countOnMe;
        songs[7] = rollingInTheDeep;

    }

    public Song getCurrentSong(int currentSongId) {
        return songs[currentSongId];
    }

    public int searchSongById(String id) {
        for (int index = 0; index < songs.length; index++) {
            Song tempSong = songs[index];
            if (tempSong.getId().equals(id)) {
                return index;
            }
        }
        return -1;
    }

    public int getNextSong(int currentSongIndex) {
        if (currentSongIndex >= songs.length - 1) {
            return currentSongIndex;
        } else {
            return currentSongIndex + 1;
        }
    }

    public int getPrevSong(int currentSongIndex) {
        if (currentSongIndex <= 0) {
            return currentSongIndex;
        } else {
            return currentSongIndex - 1;
        }
    }
    public Song searchById(String id){
        Song tempSong = null;
        for (int i = 0; i < songs.length; i++) {
            tempSong = songs[i];
            String tempId = tempSong.getId();
            if (tempId.equals(id)){
                return tempSong;
            }
        }
        return tempSong;
    } /*This set of code taken from Mr Andrew Tan to make a functionable playlist cuz public Song is
    declared in the MainActivity and so this set of code does not affect my PlaySongActivity cuz i
    didn't call it there*/

}


