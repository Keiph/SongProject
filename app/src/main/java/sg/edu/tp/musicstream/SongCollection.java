package sg.edu.tp.musicstream;

public class SongCollection {
    Song popularSongs[] = new Song[2];

    Song songs[] = new Song[4];

    public SongCollection(){
        Song theWayYouLookTonight = new Song("S1001",
                "The Way You Look Tonight",
                "Michael Buble",
                "https://p.scdn.co/mp3-preview/a5b8972e764025020625bbf9c1c2bbb06e394a60?cid=2afe87a64b0042dabf51f37318616965",
                4.66,
                R.drawable.michael_buble_collection);

        Song billieJean = new Song("S1002",
                "Billie Jean",
                "Michael Jackson",
                "https://p.scdn.co/mp3-preview/4eb779428d40d579f14d12a9daf98fc66c7d0be4?cid=2afe87a64b0042dabf51f37318616965",
                4.9,
                R.drawable.billie_jean);

        Song photograph = new Song("S1003",
                "Photograph",
                "Ed Sheeran",
                "https://p.scdn.co/mp3-preview/097c7b735ceb410943cbd507a6e1dfda272fd8a8?cid=2afe87a64b0042dabf51f37318616965",
                4.32,
                R.drawable.photograph);

        Song wonderwall = new Song("S1004",
                "Wonderwall",
                "Oasis",
                "https://p.scdn.co/mp3-preview/fbdb1dfd98d6d51d968bd42b9d667c9f3b7ffb9b?cid=2afe87a64b0042dabf51f37318616965",
                4.33,
                R.drawable.wonder_wall);
        Song somethingJustLikeThat = new Song("S1005",
                "Something Just Like That",
                "The Chainsmoker",
                "https://p.scdn.co/mp3-preview/ab1cd059a9ac76478e2892f390036b9568c69a4f?cid=2afe87a64b0042dabf51f37318616965",
                4.13,
                R.drawable.something_just_like_this);

        Song closer = new Song("S1006",
                "Closer",
                "The Chainsmoker",
                "https://p.scdn.co/mp3-preview/8d3df1c64907cb183bff5a127b1525b530992afb?cid=2afe87a64b0042dabf51f37318616965",
                4.08,
                R.drawable.closer);



        songs[0] = theWayYouLookTonight;
        songs[1] = billieJean;
        songs[2] = photograph;
        songs[3] = wonderwall;
        popularSongs[0]=somethingJustLikeThat;
        popularSongs[1]=closer;

    }

    public Song getCurrentSong(int currentSongId){
        return songs[currentSongId] ;
    }

    public int searchSongById(String id){
        for(int index=0; index < songs.length; index++){
            Song tempSong = songs[index];
            if(tempSong.getId().equals(id)){
                return index;
            }
        }
        return -1;
    }

    public int getNextSong(int currentSongIndex){
        if (currentSongIndex >= songs.length-1){
            return currentSongIndex;
        }
        else{
            return currentSongIndex +1;
        }
    }

    public int getPrevSong(int currentSongIndex){
        if (currentSongIndex <= 0){
            return currentSongIndex;
        }
        else{
            return currentSongIndex-1;
        }
    }

}


