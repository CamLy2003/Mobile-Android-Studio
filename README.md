# Firebase Authentication App

A simple Android app that uses Firebase Authentication to perform user login and registration with email and password.

## Description

This app allows users to register and log in to the app using their Firebase account credentials. After a successful registration, users can log in using their credentials. Firebase Authentication is used to manage users and authenticate accounts.

The app has two main features:
1. **Registration**: Allows users to create an account using an email and password.
2. **Login**: Users can log in using the credentials they registered with.

Once a user successfully logs in, they are navigated to the main screen, where they can continue using the app.

## Key Features

- User registration with Firebase Authentication.
- User login with Firebase Authentication.
- Error handling when users enter incorrect information or if the email already exists.

## Firebase Configuration

1. Create a Firebase project on the [Firebase Console](https://console.firebase.google.com/).
2. Enable Firebase Authentication in the Firebase Console.
3. Add the `google-services.json` file to the `app/` directory of your Android project.
4. Set up your Android app with Firebase by following the steps in the [official Firebase guide](https://firebase.google.com/docs/android/setup).

## Screenshots

Here are some screenshots of the app:

| Main Screen            | Create Account          | Account Created       | Login Success         |
|------------------------|-------------------------|-----------------------|-----------------------|
| ![image](https://github.com/user-attachments/assets/b2e58c3d-22cf-49ca-9f77-bd7fd19b51d6) | ![image](https://github.com/user-attachments/assets/2e96d93f-27b1-4334-bbca-b7125090cfaf) | ![image](https://github.com/user-attachments/assets/04eab280-cefd-4d84-8489-7b974cf77b24)  | ![image](https://github.com/user-attachments/assets/5febe1e3-3113-4d72-9850-a2a212f5ead4)
 |

### Descriptions of Screens:
1. **Main Screen**: The screen users see after logging in, where they can access the main functionality of the app.
2. **Create Account**: The screen where users enter their email and password to register a new account.
3. **Account Created**: A success message confirming that the account has been created.
4. **Login Success**: The screen show after a user successfully logs in.





