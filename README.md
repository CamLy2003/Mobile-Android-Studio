# Mobile-Android-Studio
Weekly Report on Android Studio Programming at University. This is a **practical course** on Android Studio programming.  

## Student Information
- **MSSV:** 21200374
- **Name:** Mai Thị Cẩm Ly

## Weekly Assignments

# 1. Type of food

## Description
This assignment involved creating an Android application to display a list of fruits with their respective calorie counts and images. The application uses a ListView to display items such as fruits, accompanied by their calories and an image for each fruit. The layout also includes a decorative box at the top with fruit emojis to enhance the UI.

## Features
- Fruit List: A list of fruits displayed with their respective calorie counts.
- Images: Each fruit is accompanied by a corresponding image.
- Text Formatting: The fruit names and calorie counts are displayed in a single text field, with calorie counts aligned to the right.
- Custom List View: Customizes the default ListView adapter to include both text and images, with formatting for a clean and visually appealing layout.

## Methodology
- Data Storage: Fruits and their calories are stored in arrays. Each fruit name, calorie count, and image reference are handled separately for easy customization.
- Text Styling: Used SpannableString for aligning text and setting a custom margin for the calorie counts to improve readability.
- Image Handling: Drawable objects are used for each fruit image, which are displayed next to the fruit names.
- UI Design: Designed the layout using a LinearLayout, organizing the fruit list and a styled note section. The list items are dynamically populated using a custom ArrayAdapter.

## 📱 Screenshots

| ![UI1](https://github.com/user-attachments/assets/772c026f-50fe-48ad-b5b8-e91c387128d8) | ![UI2](https://github.com/user-attachments/assets/8c584c0c-f9c3-4fb8-a5d7-a1335a42fd1e) |
|:--:|:--:|
| Screen 1 | Screen 2 |

# 2. List type of Social Media

## Description
This Android application displays a list of social media platforms along with icons, names, and the year since they were founded. It uses a ListView and SimpleAdapter to bind the data to the view, creating a simple yet effective interface for displaying social media information. The list includes the following platforms: Facebook, Instagram, Twitter, Telegram, LinkedIn, and Email, each accompanied by its corresponding logo and founding year.

## Features
- Icon Display: Each social media platform is represented by its icon.
- Text Information: The name of the social media platform and the year it was founded are displayed alongside the icons.
- Dynamic List: The list is populated dynamically using an array of data, making it easy to update with additional social media platforms in the future.
- Interactive Layout: The layout uses a LinearLayout to organize the image and text elements horizontally, and another nested LinearLayout for text details vertically.

## Methodology
1. Data Representation:
- Arrays icons, names, and since represent the icons, names, and founding years of social media platforms.
- The icons are stored as resource IDs (R.drawable), while names and founding years are stored as strings.

2. Adapter Setup:
- A SimpleAdapter is used to bind the data to the ListView.
- A HashMap is created for each item to hold the icon, title, and "since" information.
- SimpleAdapter is configured with a custom layout (activity_second.xml) that specifies how the data should be displayed.

3. UI Layout:
- The layout for each item in the list is defined using a LinearLayout with a horizontal orientation. This layout contains an ImageView for the icon and a nested LinearLayout for the title and founding year.
- View Binding:
- The SimpleAdapter binds the data to the respective views in the layout using the keys "icon", "title", and "since", which correspond to the ImageView and TextViews in the layout.

4. Activity Setup:
- The onCreate() method initializes the ListView, populates the data, and sets the adapter to display the list of social media platforms.

![image](https://github.com/user-attachments/assets/fa19eadf-68dc-49a3-b177-ab2837f66861)

