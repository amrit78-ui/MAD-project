# Firebase Setup Guide

Follow these steps to seamlessly integrate Firebase into your `DailyQuotesApp`:

## 1. Create a Firebase Project
1. Go to the [Firebase Console](https://console.firebase.google.com/).
2. Click **Add Project** and name it "Daily Quotes App".
3. Disable Google Analytics (optional, for a simpler setup).
4. Click **Create Project**.

## 2. Register Your Android App
1. On the Firebase Dashboard, click the **Android icon**.
2. For **Android package name**, enter exactly: `com.dailyquotes.app`.
3. (Optional) Provide a nickname like "Daily Quotes Android".
4. Click **Register App**.

## 3. Download google-services.json
1. Download the `google-services.json` file provided by Firebase.
2. Move this file into your `DailyQuotesApp/app` directory. The structure should look like:
   `DailyQuotesApp/app/google-services.json`
3. Click **Next** through the rest of the steps in Firebase to finish setup.

## 4. Enable Authentication
1. On the left sidebar of the Firebase Console, go to **Build -> Authentication**.
2. Click **Get Started**.
3. Under the **Sign-in method** tab, click **Email/Password**.
4. Enable the first toggle (**Email/Password**) and save. *Do NOT enable Email link (passwordless sign-in) for this project.*

## 5. Sync Project
Dependencies are already configured in the `build.gradle.kts` files you received. Just ensure your `google-services.json` is correctly placed and hit **Sync Project with Gradle Files** in Android Studio!
