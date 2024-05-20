# MVVM Compose Structure with Laravel Concepts and Room Database

This repository provides a structured template for building Android applications using the MVVM (Model-View-ViewModel) architecture with Jetpack Compose. It also integrates concepts from Laravel, such as component items and clean routing, to enhance development efficiency and maintainability. Additionally, Room Database with SQLite is utilized for local data persistence, along with user preferences management.

## Features

- **MVVM Architecture**: Organizes code into Model, View, and ViewModel layers for better separation of concerns and maintainability.
- **Jetpack Compose**: Utilizes the modern UI toolkit for building native Android UIs.
- **Laravel Concepts Integration**: Adopts Laravel concepts like component items and clean routing to streamline development.
- **Room Database**: Provides local data persistence using Room Database with SQLite.
- **User Preferences Management**: Includes functionality for saving and managing user preferences.

## Structure

The project follows a structured approach:

- **Model**: Contains data models and entities.
- **View**: Includes Composable UI components.
- **ViewModel**: Houses the business logic and interacts with repositories.
- **Repository**: Manages data operations, serving as a bridge between ViewModel and data sources.
- **Database**: Defines the Room Database and its components.
- **Utils**: Contains utility classes and helper functions.

## Libraries

This template comes pre-configured with the following libraries:

- **Navigation Component**  
  Manages and navigates between different composable screens within an Android app using a single activity.
  > Doc:
  > - [Navigation Component Overview](https://developer.android.com/jetpack/androidx/releases/navigation)
  > - [Using the Navigation Component with Compose](https://developer.android.com/jetpack/compose/navigation)

- **ViewModel**  
  Provides a way to manage UI-related data in a lifecycle-conscious manner, allowing data to survive configuration changes like screen rotations.
  > Doc:
  > - [ViewModel Overview](https://developer.android.com/topic/libraries/architecture/viewmodel)
  > - [Guide to ViewModels](https://developer.android.com/codelabs/android-lifecycle#5)

- **Room Database**  
  An abstraction layer over SQLite that simplifies database access while harnessing the full power of SQLite. It supports compile-time verification of SQL queries and can seamlessly integrate with LiveData and Flow.
  > Doc:
  > - [Room Database Overview](https://developer.android.com/training/data-storage/room)
  > - [Room with a View - Codelab](https://developer.android.com/codelabs/android-room-with-a-view)

- **Datastore**  
  A data storage solution that provides an easy-to-use and strongly typed API for storing key-value pairs and typed objects. It is a replacement for SharedPreferences and supports both synchronous and asynchronous data operations.
  > Doc:
  > - [Datastore Overview](https://developer.android.com/topic/libraries/architecture/datastore)
  > - [Preferences Datastore](https://developer.android.com/codelabs/android-proto-datastore#0)

- **LiveData**  
  A lifecycle-aware data holder class that allows UI components to observe LiveData objects, ensuring that they only update the UI when the data is in an active lifecycle state.
  > Doc:
  > - [LiveData Overview](https://developer.android.com/topic/libraries/architecture/livedata)
  > - [Use LiveData with ViewModel](https://developer.android.com/codelabs/android-lifecycles#6)

- **Retrofit**  
  A type-safe HTTP client for Android and Java that simplifies the process of consuming RESTful web services by allowing the definition of APIs as Java interfaces.
  > Doc:
  > - [Retrofit Overview](https://square.github.io/retrofit/)
  > - [Getting Started with Retrofit](https://square.github.io/retrofit/#getting-started)

- **Moshi**  
  A modern JSON library for Android and Java that makes it easy to parse JSON into Java objects and vice versa, supporting Kotlin and annotation-based parsing.
  > Doc:
  > - [Moshi Overview](https://github.com/square/moshi)
  > - [Moshi: A Modern JSON Library for Android and Java](https://medium.com/square-corner-blog/announcing-moshi-a-modern-json-library-for-android-and-java-93c9e8a96d2c)

- **Coil**  
  An image loading library for Android backed by Kotlin Coroutines. It is designed to be fast, lightweight, and easy to use with a focus on modern development practices.
  > Doc:
  > - [Coil Overview](https://coil-kt.github.io/coil/)
  > - [Using Coil in your Android App](https://coil-kt.github.io/coil/getting_started/)

- **Work Runtime**  
  Provides an API for scheduling and managing deferrable, guaranteed background work, such as tasks that need to run even if the app exits or the device restarts.
  > Doc:
  > - [WorkManager Overview](https://developer.android.com/topic/libraries/architecture/workmanager)
  > - [WorkManager Basics](https://developer.android.com/codelabs/android-workmanager#0)

## Usage

To use this template:

1. Clone the repository.
2. Customize the project structure and replace placeholder code with your application logic.
3. Add dependencies and libraries as needed for your project.
4. Build and run the application on your Android device or emulator.

## Contributing

Contributions are welcome! Feel free to submit bug reports, feature requests, or pull requests to help improve this template.

## License

This project is licensed under the [MIT License](LICENSE).
