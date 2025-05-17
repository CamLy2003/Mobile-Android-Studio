# Mobile-Android-Studio
Weekly Report on Android Studio Programming at University. This is a **practical course** on Android Studio programming.  

## Student Information
- **MSSV:** 21200374
- **Name:** Mai Thị Cẩm Ly

## Weekly Assignments

# 1. Student ListView App

## Description  
This project is a **Student ListView App** that displays student information in a custom `ListView`. Each item in the list shows an avatar, full name, and student ID (MSSV). When a student item is double-clicked, the app opens a detailed view of that student. All student data is stored locally using **SQLite**.

## Features  
- Custom `ListView` displaying:
  - Avatar (`ImageView`)
  - Full name (`TextView`)
  - Student ID - MSSV (`TextView`)
- **Double-click** interaction to view detailed student information.
- Data is **persistently stored** using `SQLite` database.
- Simple, clean UI optimized for readability and interaction.

## Methodology  
- **Layout:** Designed a custom layout XML for each list item containing an `ImageView` for the avatar and two `TextView` elements for name and MSSV. Used `ListView` in the main layout to show the full list.
- **Database:** Implemented local storage using `SQLite`. Created a database with fields for avatar (image path or URI), name, and MSSV. Used `SQLiteOpenHelper`for database operations.

- **Adapter:** Built a custom adapter to bind database records to the `ListView`, displaying all student data in a clean format.
- **Interaction:** Implemented double-click detection on list items. On double-click, the app uses `Intent` to navigate to a new `Activity`, which shows detailed student information.
![image](https://github.com/user-attachments/assets/49e6b872-a721-4f46-a532-d5739dcf8d83)
