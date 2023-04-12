# My Music Player Project

## Proposal
I am planning to make a music player that completes different tasks for a user. 
People who want to listen to any kinds of songs are going to use this application. 
This project is of interest to me as I enjoy listen to music in my free time and even when I am studying. 
Thus, it would be a fun project for me if I can create my own music player and 
understand how it works. 

## Tasks of a music player:
- *plays* songs for the users
- *saves* the playlist that the users have created
- *finds* a song when the user searches for it in the search bar

## User Stories:
- As a user, I want to be able to *add* a song to my playlist.
- As a user, I want to be able to *add* multiple songs to my playlist.
- As a user, I want to be able to *remove* a song from my playlist.
- As a user, I want to be able to *search* a song from my playlist.
- As a user, when I quit the music player, I want to be given the option to *save* the playlist that I have created. 
- As a user, when I start the music player, I want to be given the option to *load* the playlist that I have created.

## Instructions for Graders
- You can generate the first requires action related to adding a song to a playlist by selecting "0" button next to the 
song item that you want on the same row. Then, the song item would appear in the text area. 
- You can generate the second requires action related to removing a song from a playlist by "X" button next to the
  song item that you want on the same row. Then, the corresponding song will be removed from the list of songs. 
- You can locate my visual component by images added to each button that represents each song item. 
- You can reload the state of my application by selecting "load" menu after setting your username and 
pressing "OK" button, which redirects you to the selection page and text area that displays the playlist. 

## Phase 4: Task 2
- Sample of the events that occur when the program runs:
- Logged events:
Tue Apr 11 21:49:02 PDT 2023
song added - Low by Sza

Tue Apr 11 21:49:07 PDT 2023
song added - Perfect by Ed Sheeran

Tue Apr 11 21:49:09 PDT 2023
song removed - Perfect by Ed Sheeran

Tue Apr 11 21:49:11 PDT 2023
song added - Anti Hero by Taylor Swift

Tue Apr 11 21:49:12 PDT 2023
song added - Die For You by The Weeknd

## Phase 4: Task 3
- If I had to refactor the codes, I would try to reduce duplication when adding buttons or boxes. Thus, I would make a 
method that can add arrange and display all the buttons and boxes that I want to add. 
I would also refactor the removeSong method and findSong method from PlayList class since both methods have the same 
logic, which is finding the song based on the title of the song and if it matches, the methods bring the desired result. 
Thus, I can make a new method called changePlayList that takes title as a parameter and returns the boolean value if it 
is true. Since removeSong method does more than finding a song, additional implementations can be added for this part. 
