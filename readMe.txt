JavaFX CV Builder — Overview

This project is a simple JavaFX application that allows users to create a CV through a form and instantly preview it as a formatted document using an embedded HTML viewer. The interface is built with FXML and styled with CSS to keep the layout clean and responsive. Users can enter personal details, education, experience, and skills, and the preview updates in real time. This makes the application easy to use while demonstrating core JavaFX concepts such as UI components, event handling, and WebView rendering.

Database and Core Functionality

The application also integrates a SQLite database to save, load, update, and delete CV records. Each CV is stored as a single JSON string, which keeps the database structure simple and flexible. ObservableList is used so that the saved CV list updates automatically in the interface, and all database operations run in background threads to ensure the UI never freezes. This project combines JavaFX, database connectivity, JSON handling, and concurrency to create a smooth, modern CV builder experience.