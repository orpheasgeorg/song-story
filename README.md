# Song Story

A Spring Boot web application that tells the story behind a song. The user searches for a song by title, artist, or album, the application retrieves song data from the Genius API, and then uses Groq AI to generate a narrative about the song's meaning, background, or story.

## Live Demo

- Web UI: [https://song-story.onrender.com](https://song-story-1iq8.onrender.com)

> The first request may take 30-60 seconds as the server spins up on the free tier.

## How It Works

1. User searches for a song by title, artist name, or album
2. Application fetches song data from the **Genius API**
3. The retrieved data is passed to **Groq AI** (LLM)
4. Groq generates a compelling story or background about the song

## Tech Stack

- Java 17 + Spring Boot 3.3.5
- Genius API (song metadata and lyrics)
- Groq AI (story generation)
- HTML, CSS, JavaScript (AI-generated frontend)
- Maven
- Docker (containerization)

## Features

- Search for songs by title, artist, or album
- AI-generated story for each song
- RESTful API architecture
