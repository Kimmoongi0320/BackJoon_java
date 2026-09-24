import java.util.*;

class Solution {

    class Music {
        String title;
        String melody;
        int length;

        public Music(String[] musicInfo) {
            String[] start = musicInfo[0].split(":");
            String[] end = musicInfo[1].split(":");

            String title = musicInfo[2];
            String melody = convert(musicInfo[3]);

            int length =
                (Integer.parseInt(end[0]) - Integer.parseInt(start[0])) * 60
                + (Integer.parseInt(end[1]) - Integer.parseInt(start[1]));

            this.title = title;
            this.length = length;

            if (length <= melody.length()) {
                this.melody = melody.substring(0, length);
            } else {
                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < length; i++) {
                    sb.append(melody.charAt(i % melody.length()));
                }

                this.melody = sb.toString();
            }
        }
    }

    private String convert(String melody) {
        return melody
                .replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a")
                .replace("B#", "b");
    }

    public String solution(String m, String[] musicinfos) {

        m = convert(m);

        Music[] musics = new Music[musicinfos.length];

        for (int i = 0; i < musicinfos.length; i++) {
            musics[i] = new Music(musicinfos[i].split(","));
        }

        Arrays.sort(musics, (a, b) -> b.length - a.length);

        for (int i = 0; i < musics.length; i++) {

            String musicMelody = musics[i].melody;

            if (musicMelody.length() < m.length()) {
                continue;
            }

            for (int k = 0;
                 k <= musicMelody.length() - m.length();
                 k++) {

                boolean correct = true;

                for (int j = 0; j < m.length(); j++) {
                    if (musicMelody.charAt(k + j) != m.charAt(j)) {
                        correct = false;
                        break;
                    }
                }

                if (correct) {
                    return musics[i].title;
                }
            }
        }

        return "(None)";
    }

}