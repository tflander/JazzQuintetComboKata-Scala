Concurrency Challenge:  Jazz Quintet
===============

Write a program in your favorite language to simulate a jam session with trumpet, saxophone, piano,
bass, and drums.  Each of the five musicians are autonomous, and must interact with the other 
musicians.  The two major tasks in the jam session are to pick a song, then take turns soloing 
in the song.  This cycle repeats.

Da Rules:

- Each of the three musicians run in a separate thread.  The five threads must interact as
  independent entities.
- Musicians must unanimously agree on a song before they start playing.
- Each musician has a set of known songs that they are willing to play.
- A musician will always agree to play a song from their known song list.
- A musician will never agree to play a song that they don't know (unlike real life).

Picking a song:
- A musician will politely wait 100-300 milliseconds for another musician to suggest a song.
- If multiple musicans have suggestions (thread race), the other musicians will respond to all suggestions.
- When one musician says "no", the process of selecting a song starts over.
- When all musicians say "yes" to a song, the process of taking turns for soloing starts
- For simplicity, there is no need to process counting off a song, playing the head, and so forth.  We only care about soloing.

The solos:
- The trumpet player plays the first solo.
- The soloist plays a solo of a random length of 8, 16, or 32 bars.  Let's assume a bar is 20 milliseconds.
- After the solo, the soloist nods to the next musician to take their solo.  The next musician will not know beforehand how many bars the previous soloist will play.
- Solos are always in this order: Trumpet, saxophone, piano, bass, and drums.
- After the drum solo, the musicians end the song and begin the process of choosing the next one.

Other stuffis:
- The program ends after a set number of songs are played (programmer's choice)
- As with jazz, these rules should be understood, but can be broken by the programmer.

